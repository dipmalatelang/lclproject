package com.example.lcl.view.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.lcl.MainActivity;
import com.example.lcl.R;
import com.example.lcl.data.login.LoginResponse;
import com.example.lcl.databinding.ActivityLoginBinding;
import com.example.lcl.network.ApiClient;
import com.example.lcl.util.SharedPref;
import com.example.lcl.view.HomeScreen_Activity;

import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityLoginBinding binding;
    private static final String TAG = "LoginActivity";
    private SharedPref sharedPref;

    ImageView imageView;
    TextView textView;
    int count = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.btnLogin.setOnClickListener(this);
        binding.pbLogin.hide();
        sharedPref = SharedPref.getInstance();
        /*Login front*/
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        imageView.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            public void onSwipeTop() {
            }

            public void onSwipeRight() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img);
                    count = 1;
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img);
                    count = 0;
                }
            }

            public void onSwipeLeft() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img);
                    count = 1;
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img);
                    count = 0;
                }
            }

            public void onSwipeBottom() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img);
                    count = 1;
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img);
                    count = 0;
                }
            }

        });
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
                if(response.body() != null){
                    if(response.body().getStatus()){
                        sharedPref.addString("user_role",response.body().getRole());
                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                        Intent mIntent = new Intent(LoginActivity.this, HomeScreen_Activity.class);
                        startActivity(mIntent);
                    }
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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
                sharedPref.clearAll();
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