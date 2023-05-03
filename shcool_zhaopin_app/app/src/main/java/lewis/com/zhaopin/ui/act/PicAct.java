package lewis.com.zhaopin.ui.act;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.utils.PieChart;
import lewis.com.zhaopin.utils.PieChartBean;

/**
 * Created by Administrator on 2021/4/14.
 */

public class PicAct extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.piechat)
    PieChart piechat;
    private List<PieChartBean> list=new ArrayList<>();
    @Override
    public int intiLayout() {
        return R.layout.act_pic;
    }

    @Override
    public void initView() {
        tvTitle.setText("统计视图");
        ivBack.setVisibility(View.VISIBLE);
        list.add(new PieChartBean("java工程师-30%",30f,R.color.color_black_1));
        list.add(new PieChartBean("android工程师-20%",20f,R.color.colorPrimary));
        list.add(new PieChartBean("ios工程师-10%",10f,R.color.redTab));
        list.add(new PieChartBean("python工程师-10%",10f,R.color.green));
        list.add(new PieChartBean("php工程师-10%",15f,R.color.blue));
        list.add(new PieChartBean("设计师-10%",10f,R.color.colorPrimaryDark));
        list.add(new PieChartBean("其他-10%",5f,R.color.editor_line_space));
        piechat.setDate(list);
    }

    @Override
    public void initData() {

    }



    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

        }
    }
}
