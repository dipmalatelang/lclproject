package com.example.lcl.view.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.lcl.R;
import com.example.lcl.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity  {
    ActivityLoginBinding binding;
    String userid ,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userid  =binding.etUserid.getText().toString().trim();
                password =binding.etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(userid)) {
                    binding.etUserid.setError(getString(R.string.field_can_not_be_empty_tag));
                } else if (TextUtils.isEmpty(password)) {
                    binding.etPassword.setError(getString(R.string.field_can_not_be_empty_tag));
                }
                else {
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }


}