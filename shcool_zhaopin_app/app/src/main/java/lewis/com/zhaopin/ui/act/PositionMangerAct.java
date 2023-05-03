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
import butterknife.OnClick;
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.ComResult;
import lewis.com.zhaopin.bean.CompanyInfo;
import lewis.com.zhaopin.bean.PositionList;
import lewis.com.zhaopin.utils.ACache;
import lewis.com.zhaopin.utils.Contance;
import lewis.com.zhaopin.utils.SimpleAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2021/4/13.
 */

public class PositionMangerAct extends BaseActivity{
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private SimpleAdapter<PositionList.DataBean> adapter;
    private List<PositionList.DataBean> beanList=new ArrayList<>();
    private CompanyInfo.DataBean compbean;

    @Override
    public int intiLayout() {
        return R.layout.act_postion_manger;
    }

    @Override
    public void initView() {
        compbean = (CompanyInfo.DataBean) ACache.get(this).getAsObject("compbean");
        tvTitle.setText("职位管理");
        tvRight.setText("添加");
        ivBack.setVisibility(View.VISIBLE);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //给列表绑定adapter并渲染数据

        //给列表绑定adapter并渲染数据
        adapter = new SimpleAdapter<PositionList.DataBean>(R.layout.item_book, beanList, new SimpleAdapter.ConVert<PositionList.DataBean>() {
            @Override
            public void convert(final BaseViewHolder helper, final PositionList.DataBean dataBean) {

                helper.setText(R.id.tv_name,"职位名称："+dataBean.name);
                helper.setText(R.id.tv_bianhao,"职位要求："+dataBean.dec);
                helper.setText(R.id.tv_money,"薪资："+dataBean.money);
                helper.setText(R.id.tv_time,""+dataBean.time);

                helper.setText(R.id.tv_jianjie,"简介："+dataBean.jianjie);
                helper.getView(R.id.tv_look).setVisibility(View.VISIBLE);
                helper.getView(R.id.tv_look).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle=new Bundle();
                        bundle.putString("pid",dataBean.id+"");
                        jumpAct(LookJlAct.class,bundle);
                    }
                });

            }
        });
        recycler.setAdapter(adapter);

        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            public AlertDialog dialog;

            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, final int position) {
                AlertDialog.Builder builder=new AlertDialog.Builder(PositionMangerAct.this);
                builder.setTitle("确定删除吗？");
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        del(beanList.get(position).id+"");
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
                jumpAct(PubPositionAct.class,bundle);
            }
        });
    }

    //获取数据
    private void getdata() {
        beanList.clear();
        OkHttpUtils
                .post()
                .url(Contance.getAllPositionByAppCid)
                .addParams("cid",compbean.id+"")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final PositionList comResult = new Gson().fromJson(response, PositionList.class);
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
    private void del(String id){
        OkHttpUtils
                .post()
                .url(Contance.delPosition)
                .addParams("id", id)


                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss",e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ComResult result = new Gson().fromJson(response, ComResult.class);
                        if (result!=null){
                            toast(result.getMsg());

                            getdata();

                        }
                    }
                });
    }


    @Override
    public void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        getdata();
    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                jumpAct(PubPositionAct.class);
                break;
        }
    }
}
