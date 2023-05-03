package lewis.com.zhaopin.ui.frg;

import android.app.AlertDialog;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseFragment;
import lewis.com.zhaopin.bean.TiziList;
import lewis.com.zhaopin.ui.act.PubTzAct;
import lewis.com.zhaopin.utils.Contance;
import lewis.com.zhaopin.utils.SimpleAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2019/12/11.
 */
//
public class SheQuFrg extends BaseFragment {
    //初始化控件
    @BindView(R.id.tv_title)
    TextView tvTitle;
  @BindView(R.id.tv_right)
    TextView tv_right;
 @BindView(R.id.tv_search)
    TextView tv_search;

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<TiziList.DataBean> beanList=new ArrayList<>();

    private SimpleAdapter<TiziList.DataBean> adapter;
    private AlertDialog alertDialog;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.frg_home1, container, false);
    }


    @Override
    public void initData() {
        super.initData();
        tv_search.setVisibility(View.GONE);
        tvTitle.setText("论坛帖子");
        tv_right.setText("发帖");
        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               jumpAct(PubTzAct.class);
            }
        });

        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        //给列表绑定adapter并渲染数据
        adapter = new SimpleAdapter<TiziList.DataBean>(R.layout.item_tiezi, beanList, new SimpleAdapter.ConVert<TiziList.DataBean>() {
            @Override
            public void convert(final BaseViewHolder helper, TiziList.DataBean dataBean) {
                ImageView view = helper.getView(R.id.iv);
                Glide.with(mActivity).load(dataBean.uimg).into(view);
                helper.setText(R.id.tv_name,"发帖人："+dataBean.uname);
                helper.setText(R.id.tv_content,""+dataBean.content);
                helper.setText(R.id.tv_title,""+dataBean.title);
                helper.setText(R.id.tv_time,""+dataBean.time);



            }
        });
        recycler.setAdapter(adapter);


    }


    //获取数据
    private void getdata(){
        beanList.clear();
        OkHttpUtils
                .post()
                .url(Contance.getAllLuntanApp)

                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss",e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final TiziList comResult = new Gson().fromJson(response, TiziList.class);
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


    @Override
    public void onResume() {
        super.onResume();
        getdata();

    }

}
