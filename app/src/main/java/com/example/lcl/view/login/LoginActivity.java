package com.example.lcl.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.lcl.MainActivity;
import com.example.lcl.R;
import com.example.lcl.data.login.LoginResponse;
import com.example.lcl.databinding.ActivityLoginBinding;
import com.example.lcl.network.ApiClient;
import com.example.lcl.util.Helpers;

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
        return !binding.editTextName.getText().toString().isEmpty() &&
                !binding.editTextPassword.getText().toString().isEmpty();
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
                if(response.body().getStatus()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
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
                        binding.editTextName.getText().toString().trim(),
                        binding.editTextPassword.getText().toString().trim()
                );
            } else {
                Toast.makeText(this, "Invalid or empty fields", Toast.LENGTH_SHORT).show();
            }
        }
    }
}