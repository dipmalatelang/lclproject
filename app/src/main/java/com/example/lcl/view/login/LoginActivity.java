package com.example.lcl.view.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lcl.R;
import com.example.lcl.data.login.LoginResponse;
import com.example.lcl.data.teams.TeamListResponse;
import com.example.lcl.databinding.ActivityLoginBinding;
import com.example.lcl.network.ApiClient;
import com.example.lcl.view.teamlist.TeamListActivity;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityLoginBinding binding;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.btnLogin.setOnClickListener(this);
        binding.pbLogin.hide();
    }

    private boolean validateFields(){
        return !binding.etUserid.getText().toString().isEmpty() &&
                !binding.etPassword.getText().toString().isEmpty();
    }

    private void performServerCallToLogin(String id, String password){
        binding.pbLogin.show();
        ApiClient.create().attemptLogin(id, password)
                .enqueue(loginCallback);
    }

    private final Callback<LoginResponse> loginCallback = new Callback<LoginResponse>() {
        @Override
        public void onResponse(@NotNull Call<LoginResponse> call, Response<LoginResponse> response) {
            binding.pbLogin.hide();
            if (response.isSuccessful()) {
                Log.d(TAG, "onResponse: " + response.body().getMessage());
                Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                Log.e(TAG, "onResponse: something went wrong");
            }
        }

        @Override
        public void onFailure(@NotNull Call<LoginResponse> call, Throwable t) {
            binding.pbLogin.hide();
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_Login){
            if(validateFields()){
                performServerCallToLogin(
                        binding.etUserid.getText().toString().trim(),
                        binding.etPassword.getText().toString().trim()
                );
            } else {
                Toast.makeText(this, "Invalid or empty fields", Toast.LENGTH_SHORT).show();
            }
        }
    }
}