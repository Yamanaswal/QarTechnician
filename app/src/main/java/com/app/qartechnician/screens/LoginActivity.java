package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.qartechnician.R;
import com.app.qartechnician.models.log_in_model.log_in_request.LogInEmailRequest;
import com.app.qartechnician.models.log_in_model.log_in_response.LogInEmailResponse;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email_edit_text, password_edit_text;
    Toolbar toolbar;
    ImageView back_button;
    boolean isEmailValid, isPasswordValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setData();
    }

    private void setData() {
        //setting Ids
        setIds();
    }

    private void setIds() {
        findViewById(R.id.log_in_button).setOnClickListener(this);
        findViewById(R.id.forget_password).setOnClickListener(this);
        email_edit_text = findViewById(R.id.email_edit_text);
        password_edit_text = findViewById(R.id.password_edit_text);
        toolbar = findViewById(R.id.toolbar);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_in_button:
                loginByEmail();
                break;

            case R.id.forget_password:
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
                finish();
                break;

            case R.id.back_button:
                startActivity(new Intent(LoginActivity.this, SelectPreferencesActivity.class));
                finish();
                break;
        }
    }

    private void loginByEmail() {
        //check validations
        if (CommonUtils.isNetworkAvailable(this)) {
            SetValidation(email_edit_text, password_edit_text);
        } else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }

    }

    public void SetValidation(EditText email, EditText password) {
        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            email.setError("Empty Field! Please enter a email address");
            isEmailValid = false;
        } else if (!CommonUtils.isEmailValid(email.getText().toString())) {
            email.setError("Email is not valid");
            isEmailValid = false;
        } else {
            isEmailValid = true;
        }

        // Check for a valid password.
        if (password.getText().toString().isEmpty()) {
            password.setError("Empty Field! Please enter a password");
            isPasswordValid = false;
        } else if (!CommonUtils.isValidPassword(password.getText().toString())) {
            password.setError("Please enter a minimum password of 5 characters");
            isPasswordValid = false;
        } else {
            isPasswordValid = true;
        }

        if (isEmailValid && isPasswordValid) {
            Toast.makeText(getApplicationContext(), "Login Verified! please wait", Toast.LENGTH_SHORT).show();
            hitApiLogin();
        } else {
            Toast.makeText(this, "In-Valid Information", Toast.LENGTH_SHORT).show();
        }
    }

    private void hitApiLogin() {
        LogInEmailRequest logInEmailRequest = new LogInEmailRequest();
        logInEmailRequest.setEmail(email_edit_text.getText().toString());
        logInEmailRequest.setPassword(password_edit_text.getText().toString());
        logInEmailRequest.setLoginAs(Preferences.getPreference(LoginActivity.this, PrefEntities.LOGIN_AS));

        new APIUtility().login(LoginActivity.this, true, logInEmailRequest, new APIUtility.APIResponseListener<LogInEmailResponse>() {
            @Override
            public void onReceiveResponse(LogInEmailResponse response) {
                if (response != null) {
                    Preferences.setPreference(LoginActivity.this, PrefEntities.USER, response.getCode());
                    Preferences.setPreference(LoginActivity.this, PrefEntities.ACCESS_TOKEN, response.getData().getToken());
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Code: " + response.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStatusFailed(LogInEmailResponse response) {
                Toast.makeText(LoginActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                CommonUtils.alert(LoginActivity.this, getString(R.string.somethingwentwrong));
            }
        });
    }

}
