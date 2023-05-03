package lewis.com.zhaopin.ui.act;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import lewis.com.zhaopin.MainActivity;
import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.CompanyInfo;
import lewis.com.zhaopin.bean.Login;
import lewis.com.zhaopin.utils.ACache;
import lewis.com.zhaopin.utils.Contance;
import okhttp3.Call;

//登录页面
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    //初始话控件
    private RadioButton rb1;
    private RadioButton rb2;
    private EditText et_account;
    private EditText et_pwd;
    private TextView tv_reg;
    private Button bt_Login;
    private String type;


    @Override
    public int intiLayout() {
        return R.layout.act_login;
    }

    @Override
    public void initView() {

        et_account = (EditText) findViewById(R.id.et_account);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        tv_reg = (TextView) findViewById(R.id.tv_reg);
        bt_Login = (Button) findViewById(R.id.bt_Login);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        bt_Login.setOnClickListener(this);
        tv_reg.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_Login:
                submit();
                break;
            case R.id.tv_reg:
                startActivity(new Intent(LoginActivity.this, RegActivity.class));
                break;
        }
    }

    private void submit() {
        // validate
        String account = et_account.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd = et_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

//        getdata();
        // TODO validate success, do something
        if (rb1.isChecked()){
            type="0";//老师
        } if (rb2.isChecked()){
            type="1";//学生
        }
        if (!rb1.isChecked()&&!rb2.isChecked()){
            toast("请选择身份");
            return;
        }
        login(account, pwd,type);



    }
    //登录接口

    private void login(final String account, final String pwd, final String type) {
        OkHttpUtils
                .post()
                .url(type.equals("0")?Contance.companyLogin:Contance.Login)
                .addParams("account", account)
                .addParams("pwd", pwd)

                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if (type.equals("0")){
                            CompanyInfo login = new Gson().fromJson(response, CompanyInfo.class);
                            if (login != null && login.data != null) {

                                toast("登陆成功");
                                ACache.get(LoginActivity.this).put("compbean", login.data);
                                jumpAct(CompMainActivity.class);
                                ACache.get(LoginActivity.this).put("type", "0");

                                finish();


                            } else {
                                toast("账号或密码不正确");
                            }
                        }else {
                            Login login = new Gson().fromJson(response, Login.class);
                            if (login != null && login.data != null) {

                                toast("登陆成功");
                                ACache.get(LoginActivity.this).put("userbean", login.data);
                                jumpAct(MainActivity.class);
                                ACache.get(LoginActivity.this).put("type", "1");

                                finish();


                            } else {
                                toast("账号或密码不正确");
                            }
                        }

                    }
                });

    }



}
