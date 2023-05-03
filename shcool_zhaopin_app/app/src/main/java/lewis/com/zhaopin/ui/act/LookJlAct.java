package lewis.com.zhaopin.ui.act;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.ComResult;
import lewis.com.zhaopin.bean.CompanyInfo;
import lewis.com.zhaopin.bean.MyToudiList;
import lewis.com.zhaopin.bean.PositionList;
import lewis.com.zhaopin.bean.RJianliList;
import lewis.com.zhaopin.utils.Contance;
import lewis.com.zhaopin.utils.SimpleAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2021/4/13.
 */

public class LookJlAct extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private String pid;
    private List<RJianliList.DataBean> beanList=new ArrayList<>();

    private SimpleAdapter<RJianliList.DataBean> adapter;
    @Override
    public int intiLayout() {
        return R.layout.act_look_jl;
    }

    @Override
    public void initView() {
        Bundle extras = getIntent().getExtras();
        pid = extras.getString("pid");
        tvTitle.setText("收到的简历");
        ivBack.setVisibility(View.VISIBLE);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        //给列表绑定adapter并渲染数据
        adapter = new SimpleAdapter<RJianliList.DataBean>(R.layout.item_jl, beanList, new SimpleAdapter.ConVert<RJianliList.DataBean>() {
            @Override
            public void convert(final BaseViewHolder helper, RJianliList.DataBean dataBean) {

                helper.setText(R.id.tv_account,"姓名："+dataBean.jianli.name);
                helper.setText(R.id.tv_time,"期望职位："+dataBean.jianli.position);

                helper.setText(R.id.tv_status,""+dataBean.toudi.status);


            }
        });
        recycler.setAdapter(adapter);


        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            public AlertDialog dialog;

            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, final int position) {
                AlertDialog.Builder builder=new AlertDialog.Builder(LookJlAct.this);
                builder.setTitle("请处理");
                builder.setNegativeButton("发送面试邀请", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        upStatus(beanList.get(position).toudi.id,"已邀请");
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("拒绝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        upStatus(beanList.get(position).toudi.id,"已拒绝");
                        dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();
                return false;
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("bean",beanList.get(position));
                jumpAct(JianLiDetialAct.class,bundle);
            }
        });
    }

    @Override
    public void initData() {
        getdata();
    }

    //获取数据
    private void getdata() {
        beanList.clear();
        OkHttpUtils
                .post()
                .url(Contance.getToudibyP)
                .addParams("pid",pid+"")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final RJianliList comResult = new Gson().fromJson(response, RJianliList.class);
                        if (comResult != null && comResult.data != null) {
                            new Handler().post(new Runnable() {
                                @Override
                                public void run() {
                                    beanList.addAll(comResult.data);
                                    adapter.notifyDataSetChanged();
                                }
                            });


                        }
                    }
                });
    }
    //获取数据
    private void upStatus(Integer id,String status) {

        OkHttpUtils
                .post()
                .url(Contance.upStatus)
                .addParams("id",id+"")
                .addParams("status",status)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final ComResult comResult = new Gson().fromJson(response, ComResult.class);
                        if (comResult != null) {
                           toast(comResult.msg);
                           getdata();


                        }
                    }
                });
    }
    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
