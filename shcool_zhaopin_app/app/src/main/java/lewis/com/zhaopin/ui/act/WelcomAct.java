package lewis.com.zhaopin.ui.act;

import android.content.Intent;
import android.text.TextUtils;
import android.view.WindowManager;

import lewis.com.zhaopin.MainActivity;
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.CompanyInfo;
import lewis.com.zhaopin.bean.Login;
import lewis.com.zhaopin.utils.ACache;

//欢迎页面
public class WelcomAct extends BaseActivity {
    @Override
    public int intiLayout() {
        return R.layout.act_wel;
    }

    @Override
    public void initView() {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                //判断是否登录
                String type = ACache.get(WelcomAct.this).getAsString("type");

                if (TextUtils.isEmpty(type)){
                    //跳转登录
                    Intent intent = new Intent(WelcomAct.this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    //跳转首页
                    if (type.equals("0")){
                        Intent intent= new Intent(WelcomAct.this,CompMainActivity.class);
                        startActivity(intent);
                    }else {
                        Intent intent= new Intent(WelcomAct.this,MainActivity.class);
                        startActivity(intent);
                    }



                }

                finish();
            }
        },2000);
    }

    @Override
    public void initData() {

    }
}
