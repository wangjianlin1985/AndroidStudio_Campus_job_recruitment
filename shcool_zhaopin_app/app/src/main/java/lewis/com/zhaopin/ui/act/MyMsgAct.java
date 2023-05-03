package lewis.com.zhaopin.ui.act;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.MyToudiList;
import lewis.com.zhaopin.utils.Contance;
import lewis.com.zhaopin.utils.SimpleAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2020/4/22.
 */

public class MyMsgAct extends BaseActivity{
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tv_right;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<MyToudiList.DataBean> beanList=new ArrayList<>();

    private SimpleAdapter<MyToudiList.DataBean> adapter;

    @Override
    public int intiLayout() {
        return R.layout.act_my_tzjl;
    }

    @Override
    public void initView() {
        tvTitle.setText("我的消息");

        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //给列表绑定adapter并渲染数据
        adapter = new SimpleAdapter<MyToudiList.DataBean>(R.layout.item_msg, beanList, new SimpleAdapter.ConVert<MyToudiList.DataBean>() {
            @Override
            public void convert(final BaseViewHolder helper, MyToudiList.DataBean dataBean) {

                helper.setText(R.id.tv_reson,"您投递的职位名称："+dataBean.name);

                helper.setText(R.id.tv_status,""+dataBean.status);


            }
        });
        recycler.setAdapter(adapter);




    }

    @Override
    public void initData() {
        getdata();

    }
    //获取数据
    private void getdata(){
        beanList.clear();
        OkHttpUtils
                .post()
                .url(Contance.getMyToudi)
                .addParams("uid",userbean.id+"")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss",e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final MyToudiList comResult = new Gson().fromJson(response, MyToudiList.class);
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
