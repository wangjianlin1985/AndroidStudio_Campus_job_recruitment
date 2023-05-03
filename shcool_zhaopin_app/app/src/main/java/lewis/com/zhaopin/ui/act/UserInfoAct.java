package lewis.com.zhaopin.ui.act;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoxiaoxing.phoenix.compress.picture.internal.PictureCompressor;
import com.guoxiaoxing.phoenix.core.PhoenixOption;
import com.guoxiaoxing.phoenix.core.listener.ImageLoader;
import com.guoxiaoxing.phoenix.core.model.MediaEntity;
import com.guoxiaoxing.phoenix.core.model.MimeType;
import com.guoxiaoxing.phoenix.picker.Phoenix;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.ComResult;
import lewis.com.zhaopin.bean.Login;
import lewis.com.zhaopin.utils.ACache;
import lewis.com.zhaopin.utils.Contance;
import okhttp3.Call;

/**
 * Created by Administrator on 2019/12/11.
 */
//个人信息
public class UserInfoAct extends BaseActivity {
    //初始化控件
    //初始化控件
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.tv_account)
    TextView tvAccount;
    @BindView(R.id.tv_name)
    TextView tv_name;


    private String head_pic="";
    private String banji;
    private String xueyaun;
    private String phone;
    private String sex;

    @Override
    public int intiLayout() {
        return R.layout.act_userinfo;
    }

    @Override
    public void initView() {
        Phoenix.config()
                .imageLoader(new ImageLoader() {
                    @Override
                    public void loadImage(Context mContext, ImageView imageView
                            , String imagePath, int type) {
                        Glide.with(mContext)
                                .load(imagePath)
                                .into(imageView);
                    }
                });
        tvTitle.setText("个人信息");
        tvRight.setText("修改");
        ivBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {
        getInfo();
    }



    @OnClick({R.id.iv_back, R.id.tv_right, R.id.iv_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //返回
                finish();
                break;
            case R.id.tv_right:

                name =tv_name.getText().toString();


                //修改按钮事件
                if (TextUtils.isEmpty(head_pic)){
                    toast("请选择头像");
                    return;
                }  if (TextUtils.isEmpty(name)){
                toast("请输入姓名");
                return;
            }
                upInfo();
                break;
            case R.id.iv_head:
                //选择头像
                Phoenix.with()
                        .theme(PhoenixOption.THEME_DEFAULT)// 主题
                        .fileType(MimeType.ofImage())//显示的文件类型图片、视频、图片和视频
                        .maxPickNumber(1)// 最大选择数量
                        .minPickNumber(0)// 最小选择数量
                        .spanCount(4)// 每行显示个数
                        .enablePreview(true)// 是否开启预览
                        .enableCamera(true)// 是否开启拍照
                        .enableAnimation(true)// 选择界面图片点击效果
                        .enableCompress(true)// 是否开启压缩
                        .compressPictureFilterSize(1024)//多少kb以下的图片不压缩
                        .compressVideoFilterSize(2018)//多少kb以下的视频不压缩
                        .thumbnailHeight(160)// 选择界面图片高度
                        .thumbnailWidth(160)// 选择界面图片宽度
                        .enableClickSound(false)// 是否开启点击声音

                        .mediaFilterSize(10000)//显示多少kb以下的图片/视频，默认为0，表示不限制
                        //如果是在Activity里使用就传Activity，如果是在Fragment里使用就传Fragment
                        .start(UserInfoAct.this, PhoenixOption.TYPE_PICK_MEDIA, 100);
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){
            List<MediaEntity> result = Phoenix.result(data);
            MediaEntity entity = result.get(0);
            String localPath = entity.getLocalPath();
            File file = new File(localPath);
            Glide.with(UserInfoAct.this).load(localPath).into(ivHead);
            try {
                File compressFIle = PictureCompressor.with(UserInfoAct.this)
                        .savePath(UserInfoAct.this.getCacheDir().getAbsolutePath())
                        .load(file)
                        .get();
                if (compressFIle != null) {
                    String compressPath = compressFIle.getAbsolutePath();
                    upLoad(compressPath);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private String name;
    //查询用户信息
    private void getInfo(){
        OkHttpUtils
                .post()
                .url(Contance.getUserInfo)
                .addParams("id", userbean.id+"")

                .build()
                .execute(new StringCallback() {


                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss",e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final Login login = new Gson().fromJson(response, Login.class);
                        if (login!=null&&login.data!=null){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //渲染用户信息到页面
                                    Login.DataBean data = login.data;
                                    tvAccount.setText(data.account);
                                    tv_name.setText(data.name);


                                    Glide.with(UserInfoAct.this).load(data.img).into(ivHead);
                                    head_pic=data.img;


                                }
                            });

                        }
                    }
                });

    }
    //更新用户信息
    private void upInfo(){

        OkHttpUtils
                .post()
                .url(Contance.upUserInfo)
                .addParams("id", userbean.id+"")
                .addParams("img", head_pic)
                .addParams("name", name)

                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss",e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ComResult comResult = new Gson().fromJson(response, ComResult.class);
                        if (comResult!=null){
                            toast(comResult.msg);
                            userbean.img=head_pic;
                            userbean.name=name;

                            ACache.get(UserInfoAct.this).put("userbean",userbean);

                        }
                    }
                });




    }
    //上传头像
    private void upLoad(String path){
        File file = new File(path);
        OkHttpUtils
                .post()
                .url(Contance.UpLoadPic)
                .addFile("file", file.getName(),file).

                build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                ComResult comResult = new Gson().fromJson(response, ComResult.class);
                if (comResult!=null){

                    head_pic=Contance.BaseUrl+"/"+comResult.data;



                }
            }
        });

    }
}
