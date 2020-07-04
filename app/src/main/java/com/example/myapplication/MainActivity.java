package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.api.LoginService;
import com.example.myapplication.dialog.LoadingDialog;
import com.example.myapplication.model.User;
import com.example.myapplication.util.PrefUtil;

import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvDaftar;
    private LoginService loginService;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (isSessionLogin()) {
            MainActivity2.start(this);
            MainActivity.this.finish();
        }

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
//        tvDaftar = (TextView) findViewById(R.id.tv_daftar);
        btnLogin = (Button) findViewById(R.id.btn_login);

//        tvDaftar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, DaftarActivity.class);
//                startActivity(intent);
//            }
//        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAct();
            }
        });
    }

    void loginAct() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email cannot be empty!");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password cannot be empty");
            return;
        }
        final LoadingDialog loadingDialog = new LoadingDialog(MainActivity.this);
        loadingDialog.startLoadingDialog();
        loginService = new LoginService(this);
        loginService.doLogin(email, password, new Callback() {
            @Override
            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                User user = (User) response.body();

                if (user != null) {
                    if (!user.isError()) {
                        PrefUtil.putUser(MainActivity.this, PrefUtil.USER_SESSION, user);
//                        Toast.makeText(MainActivity.this, user.getData().getNama(),Toast.LENGTH_SHORT).show();
                        MainActivity2.start(MainActivity.this);
                        MainActivity.this.finish();
                    }
                    loadingDialog.dismissDialog();
                    Toast.makeText(MainActivity.this, user.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred!", Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();
                loadingDialog.dismissDialog();
            }

        });
    }

    boolean isSessionLogin() {
        return PrefUtil.getUser(this, PrefUtil.USER_SESSION) != null;
    }
}