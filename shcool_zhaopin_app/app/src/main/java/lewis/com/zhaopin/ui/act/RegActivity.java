package lewis.com.zhaopin.ui.act;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import lewis.com.zhaopin.R;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.bean.ComResult;
import lewis.com.zhaopin.utils.Contance;
import okhttp3.Call;
//注册页面
public class RegActivity extends BaseActivity implements View.OnClickListener {


    private EditText et_account;
    private EditText et_pwd;
    private EditText et_pwd_once;
    private Button bt_Login;
    private RadioButton rb1;
    private RadioButton rb2;
    private String type;


    @Override
    public int intiLayout() {
        return R.layout.act_reg;
    }

    @Override
    public void initView() {

        et_account = (EditText) findViewById(R.id.et_account);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        et_pwd_once = (EditText) findViewById(R.id.et_pwd_once);
        bt_Login = (Button) findViewById(R.id.bt_Login);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        bt_Login.setOnClickListener(this);
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
        }
    }

    private void submit() {
        // validate
        String account = et_account.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd = et_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String once = et_pwd_once.getText().toString().trim();
        if (TextUtils.isEmpty(once)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!pwd.equals(once)) {
            Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something
        if (rb1.isChecked()){
            type="0";
        } if (rb2.isChecked()){
            type="1";
        }
        if (!rb1.isChecked()&&!rb2.isChecked()){
            toast("请选择身份");
            return;
        }
        reg(account,pwd,type);
    }
//注册接口操作
    private void reg(final String account, final String pwd,String type) {
        OkHttpUtils
                .post()
                .url(type.equals("0")?Contance.companyReg:Contance.Reg)
                .addParams("account", account)
                .addParams("pwd", pwd)


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
                            finish();
                        }
                    }
                });


    }


}
