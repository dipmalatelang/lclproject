package com.example.lcl.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lcl.R;
import com.example.lcl.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
}