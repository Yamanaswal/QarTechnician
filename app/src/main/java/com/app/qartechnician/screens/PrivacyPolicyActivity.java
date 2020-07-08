package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.qartechnician.R;
import com.app.qartechnician.utils.Constants;

public class PrivacyPolicyActivity extends AppCompatActivity implements View.OnClickListener {


    Toolbar toolbar;
    TextView bar_text;
    ImageView back_button;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        setIds();
        setData();
    }

    private void setIds() {
        toolbar = findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        webView = findViewById(R.id.privacy_webView);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.privacy_policy);
        setSupportActionBar(toolbar);

        webView.loadUrl("https://ripenapps.com/");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra(Constants.BACK_KEY, "back_key");
                startActivity(intent);
                break;
        }
    }
}
