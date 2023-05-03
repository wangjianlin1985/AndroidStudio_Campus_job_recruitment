package lewis.com.zhaopin.ui.act;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.PositionList;
import lewis.com.zhaopin.utils.Contance;
import lewis.com.zhaopin.utils.SimpleAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2020/4/26.
 */

public class SearchAct extends BaseActivity{
    //初始化控件
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.tv_search)
    TextView tv_search;
    @BindView(R.id.et)
    EditText et;
    private List<PositionList.DataBean> beanList=new ArrayList<>();

    private SimpleAdapter<PositionList.DataBean> adapter;
    private String key;

    @Override
    public int intiLayout() {
        return R.layout.act_search;
    }

    @Override
    public void initView() {
        iv_back.setVisibility(View.VISIBLE);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key = et.getText().toString();
                if (TextUtils.isEmpty(key)){
                    toast("请输入");
                    return;
                }
                getdata();

            }
        });


        tvTitle.setText("搜索");


        recycler.setLayoutManager(new LinearLayoutManager(this));
        //给列表绑定adapter并渲染数据
        adapter = new SimpleAdapter<PositionList.DataBean>(R.layout.item_book, beanList, new SimpleAdapter.ConVert<PositionList.DataBean>() {
            @Override
            public void convert(final BaseViewHolder helper, PositionList.DataBean dataBean) {

                helper.setText(R.id.tv_name,"职位名称："+dataBean.name);
                helper.setText(R.id.tv_bianhao,"职位要求："+dataBean.dec);
                helper.setText(R.id.tv_bianhao,"薪资："+dataBean.money);
                helper.setText(R.id.tv_bianhao,""+dataBean.time);



            }
        });
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("bean",beanList.get(position));
                jumpAct(PositionDetialAct.class,bundle);
            }
        });
    }

    @Override
    public void initData() {

    }

    //获取数据
    private void getdata(){
        beanList.clear();
        OkHttpUtils
                .post()
                .url(Contance.getAllPositionByKey)
                .addParams("key",key)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss",e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final PositionList comResult = new Gson().fromJson(response, PositionList.class);
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
