package lewis.com.zhaopin.ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoxiaoxing.phoenix.compress.picture.internal.PictureCompressor;
import com.guoxiaoxing.phoenix.core.PhoenixOption;
import com.guoxiaoxing.phoenix.core.model.MediaEntity;
import com.guoxiaoxing.phoenix.core.model.MimeType;
import com.guoxiaoxing.phoenix.picker.Phoenix;
import com.video.player.lib.manager.VideoPlayerManager;
import com.video.player.lib.manager.VideoWindowManager;
import com.video.player.lib.view.VideoPlayerTrackView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.ComResult;
import lewis.com.zhaopin.bean.RJianliList;
import lewis.com.zhaopin.utils.Contance;
import okhttp3.Call;

/**
 * Created by Administrator on 2020/4/26.
 */

public class JianLiDetialAct extends BaseActivity {
    private ImageView iv_back;
    private TextView tv_title;

    private CircleImageView iv_head;
    private TextView tv_name;
    private TextView tv_sex;
    private TextView tv_age;
    private TextView tv_xueli;
    private TextView tv_school;
    private TextView tv_jingyan;
    private TextView tv_phone;
    private TextView tv_address;
    private TextView tv_moeny;
    private TextView tv_position;
    private TextView tv_jingli;

    private VideoPlayerTrackView video_track;

    ArrayList<String>xuelilist=new ArrayList<String>();



    @Override
    public int intiLayout() {
        return R.layout.act_jianli_d;
    }

    @Override
    public void initView() {
        Bundle extras = getIntent().getExtras();
        RJianliList.DataBean bean = (RJianliList.DataBean) extras.getSerializable("bean");
        RJianliList.DataBean.JianliBean jianli = bean.jianli;
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iv_back.setVisibility(View.VISIBLE);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("简历详情");

        iv_head = (CircleImageView) findViewById(R.id.iv_head);
        Glide.with(this).load(jianli.img).into(iv_head);
        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(jianli.name);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_sex.setText(jianli.sex);
        tv_age = (TextView) findViewById(R.id.tv_age);
        tv_age.setText(jianli.age+"");
        tv_xueli =  findViewById(R.id.tv_xueli);
        tv_xueli.setText(jianli.xueli);
        tv_school = (TextView) findViewById(R.id.tv_school);

        tv_school.setText(jianli.school);
        tv_jingyan = (TextView) findViewById(R.id.tv_jingyan);
        tv_jingyan.setText(jianli.jingyan);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_phone.setText(jianli.phone);
        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_address.setText(jianli.address);
        tv_moeny = (TextView) findViewById(R.id.tv_moeny);
        tv_moeny.setText(jianli.moeny);
        tv_position = (TextView) findViewById(R.id.tv_position);
        tv_position.setText(jianli.phone);
        tv_jingli = (TextView) findViewById(R.id.tv_jingli);
        tv_jingli.setText(jianli.jingli);
        video_track =  findViewById(R.id.video_track);

        video_track.startPlayVideo(jianli.pingjia, "视频介绍");

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        VideoPlayerManager.getInstance().onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();
        VideoPlayerManager.getInstance().onPause();
    }

    @Override
    public void onBackPressed() {
        //尝试弹射返回
        if (VideoPlayerManager.getInstance().isBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        VideoPlayerManager.getInstance().onDestroy();
        //如果你的Activity是MainActivity并且你开启过悬浮窗口播放器，则还需要对其释放
        VideoWindowManager.getInstance().onDestroy();
    }
}
