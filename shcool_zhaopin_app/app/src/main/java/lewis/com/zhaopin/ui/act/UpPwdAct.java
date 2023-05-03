package lewis.com.zhaopin.ui.act;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.OnClick;

import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.ComResult;
import lewis.com.zhaopin.utils.Contance;
import okhttp3.Call;

/**
 * Created by Administrator on 2020/4/21.
 */

public class UpPwdAct extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;

    @BindView(R.id.et_old)
    EditText et_old;
    @BindView(R.id.et_new)
    EditText et_new;
    private String npwd;
    private String opwd;
    @Override
    public int intiLayout() {
        return R.layout.act_up_pwd;
    }

    @Override
    public void initView() {
        tvTitle.setText("修改密码");
        tvRight.setText("确定");
        ivBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //返回
                finish();
                break;
            case R.id.tv_right:

                npwd =et_new.getText().toString();
                opwd =et_old.getText().toString();

                //修改按钮事件
                if (TextUtils.isEmpty(npwd)){
                    toast("请输入");
                    return;
                }  if (TextUtils.isEmpty(opwd)){
                toast("请输入");
                return;
            }
                if (!opwd.equals(userbean.pwd)){
                    toast("原密码不正确");
                    return;
                }
                upInfo();
                break;

        }
    }
    //更新用户信息
    private void upInfo(){

        OkHttpUtils
                .post()
                .url(Contance.upPwd)
                .addParams("id", userbean.id+"")

                .addParams("pwd", npwd)


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
                            finish();
                            jumpAct(LoginActivity.class);

                        }
                    }
                });




    }
}
