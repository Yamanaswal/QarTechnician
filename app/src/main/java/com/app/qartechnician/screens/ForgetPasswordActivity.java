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
import com.app.qartechnician.utils.CommonUtils;

public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    ImageView back_button;
    EditText email_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        setData();
    }

    private void setData() {
        findViewById(R.id.forget_password_btn).setOnClickListener(this);
        findViewById(R.id.back_button).setOnClickListener(this);
        toolbar = findViewById(R.id.toolbar);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
        email_edit_text = findViewById(R.id.email_edit_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forget_password_btn:
                String email = email_edit_text.getText().toString();
                if (email.isEmpty()) {
                    email_edit_text.setError("Empty Field! Enter Email Address");
                } else if (!CommonUtils.isEmailValid(email)) {
                    email_edit_text.setError("Please enter a valid email address");
                } else {
                    Toast.makeText(this, "Verification link send to given mail!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.back_button:
                startActivity(new Intent(ForgetPasswordActivity.this, LoginActivity.class));
                finish();
                break;
        }
    }
}
