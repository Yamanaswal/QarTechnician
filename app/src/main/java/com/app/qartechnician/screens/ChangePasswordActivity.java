package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.qartechnician.R;
import com.app.qartechnician.models.change_password.change_password_request.ChangePasswordRequest;
import com.app.qartechnician.models.change_password.change_password_response.ChangePasswordResponse;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.Constants;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView bar_text;
    ImageView back_button;
    EditText old_password,new_password,confirm_password;
    Button change_password_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        setIds();
        setData();
    }

    private void setIds() {
        toolbar = findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
        old_password = findViewById(R.id.old_password);
        new_password = findViewById(R.id.new_password);
        confirm_password = findViewById(R.id.confirm_password);
        change_password_button = findViewById(R.id.change_password_button);
        change_password_button.setOnClickListener(this);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.change_password);
        setSupportActionBar(toolbar);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra(Constants.BACK_KEY, "back_key");
                startActivity(intent);
                finish();
                break;

            case R.id.change_password_button:
                changePasswordApi();
                break;
        }
    }

    private void changePasswordApi() {
        String oldPassword = old_password.getText().toString();
        String newPassword = new_password.getText().toString();
        String confirmPassword = confirm_password.getText().toString();

        if(oldPassword.isEmpty()){
            old_password.setError("Field Empty! Enter Old Password");
        }
        else if(newPassword.isEmpty()){
            new_password.setError("Field Empty! Enter New Password");
        }
        else if(confirmPassword.isEmpty()){
            new_password.setError("Field Empty! Enter Confirm Password");
        }else {
            ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
            changePasswordRequest.setNewPassword(Integer.parseInt(newPassword));
            changePasswordRequest.setOldPassword(Integer.parseInt(oldPassword));
            changePasswordRequest.setLoginAs(Preferences.getPreference(this,PrefEntities.LOGIN_AS));
            new APIUtility().changePassword(this, true, Preferences.getPreference(this, PrefEntities.ACCESS_TOKEN), changePasswordRequest, new APIUtility.APIResponseListener<ChangePasswordResponse>() {
                @Override
                public void onReceiveResponse(ChangePasswordResponse response) {
                    Toast.makeText(ChangePasswordActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onStatusFailed(ChangePasswordResponse response) {
                    Toast.makeText(ChangePasswordActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure() {
                    CommonUtils.alert(ChangePasswordActivity.this, getString(R.string.somethingwentwrong));
                }
            });
        }
    }
}
