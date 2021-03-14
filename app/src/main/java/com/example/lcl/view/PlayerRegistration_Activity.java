package com.example.lcl.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lcl.R;
import com.example.lcl.data.DefaultResponse;
import com.example.lcl.data.login.LoginResponse;
import com.example.lcl.data.registerplayer.RegisterPlayerModel;
import com.example.lcl.databinding.ActivityPlayerRegistrationBinding;
import com.example.lcl.network.ApiClient;
import com.example.lcl.view.login.LoginActivity;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerRegistration_Activity extends AppCompatActivity implements View.OnClickListener{

    private RegisterPlayerModel model;
    private ActivityPlayerRegistrationBinding binding;
    private static final String TAG = "PlayerRegistration_Acti";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player_registration_);
    }

    private void performServerCallToRegister(RegisterPlayerModel model){
        binding.pbRegister.show();
        ApiClient.create().registerPlayer(model)
                .enqueue(registrationCallback);
    }

    private final Callback<DefaultResponse> registrationCallback = new Callback<DefaultResponse>() {
        @Override
        public void onResponse(@NotNull Call<DefaultResponse> call, Response<DefaultResponse> response) {
            binding.pbRegister.hide();
            if (response.isSuccessful()) {
                Log.d(TAG, "onResponse: " + response.body().getMessage());
                Toast.makeText(PlayerRegistration_Activity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                Log.e(TAG, "onResponse: something went wrong");
            }
        }

        @Override
        public void onFailure(@NotNull Call<DefaultResponse> call, Throwable t) {
            binding.pbRegister.hide();
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };

    private RegisterPlayerModel fillPlayerData(){
//                "pNumber":"M7",
//                "pPassword":"1234",
//                "firstName":"Virat",
//                "middleName":"",
//                "lastName":"Kohli",
//                "mobile":"",
//                "email":"",
//                "photo":"http://vegfruits.devfoster.com/playersphoto/",
//                "born":"25-12-2000",
//                "age":"21",
//                "hieght":"",
//                "category":"B",
//                "roles":"Batting",
//                "batingStyle":"Left Handed Bat",
//                "bowlingStyle":"Left-arm orthodox",
//                "basePrice":200000,
//                "soldPrice":0,
//                "purchaseByTeam":"",
//                "areaFrom":"Borivali",
//                "buildingName":"OM Parshwanath",
//                "playerDescription":"Ravikant is a reliable batsman and a more than useful left-arm spinner for Tiger. He made everyone sit up and take notice when he was one of the stand-out players in the 2004 Under-19 World Cup by performing consistently with bat and ball. When the Zimbabwean players strike happened in 2020, Williams was widely expected to be given a call to the national side. His father, Colin Williams, however refused to send his son, suggesting that let him concentrate on studies.",
//                "registeredAt":"2021-03-13 07:54:55.283",
//                "isActive":1,
//                "isDisplayable":1,
//                "remark":""
        model.setpNumber("");
        model.setpPassword("");
        model.setFirstName("");
        model.setMiddleName("");
        model.setLastName("");
        model.setMobile("");
        model.setEmail("");
        model.setPhoto("");
        model.setBorn("");
        model.setAge("");
        model.setHieght("");
        model.setCategory("");
        model.setRoles("");
        model.setBatingStyle("");
        model.setBowlingStyle("");
        model.setBasePrice(0);
        model.setSoldPrice(0);
        model.setPurchaseByTeam("");
        model.setAreaFrom("");
        model.setBuildingName("");
        model.setPlayerDescription("");
        model.setRegisteredAt("");
        model.setIsActive(0);
        model.setIsDisplayable(0);
        model.setRemark("");

        return model;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_add_player){
            performServerCallToRegister(fillPlayerData());
        }
    }
}