package lewis.com.zhaopin.ui.act;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.JianLiList;
import lewis.com.zhaopin.utils.Contance;
import lewis.com.zhaopin.utils.SimpleAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2020/4/22.
 */

public class MyJianliAct extends BaseActivity{
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tv_right;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<JianLiList.DataBean> beanList=new ArrayList<>();

    private SimpleAdapter<JianLiList.DataBean> adapter;

    @Override
    public int intiLayout() {
        return R.layout.act_my_tzjl;
    }

    @Override
    public void initView() {
        tvTitle.setText("我的简历");

        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_right.setText("添加");
        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpAct(AddJianLiAct.class);
            }
        });
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //给列表绑定adapter并渲染数据
        adapter = new SimpleAdapter<JianLiList.DataBean>(R.layout.item_jianli, beanList, new SimpleAdapter.ConVert<JianLiList.DataBean>() {
            @Override
            public void convert(final BaseViewHolder helper, JianLiList.DataBean dataBean) {

                    helper.setText(R.id.tv_name,dataBean.name);
                    helper.setText(R.id.tv_dec,"期望职位："+dataBean.position+"-----期望薪资："+dataBean.moeny);
                ImageView view = helper.getView(R.id.iv);
                Glide.with(MyJianliAct.this).load(dataBean.getImg()).into(view);


            }
        });
        recycler.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MyJianliAct.this,PositionDetialAct.class);
                intent.putExtra("id",beanList.get(position).id);
                setResult(12,intent);
                finish();

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

    //获取数据
    private void getdata(){
        beanList.clear();
        OkHttpUtils
                .post()
                .url(Contance.getMyJianli)
                .addParams("uid",userbean.id+"")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss",e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final JianLiList comResult = new Gson().fromJson(response, JianLiList.class);
                        if (comResult!=null&&comResult.data!=null){
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

}
