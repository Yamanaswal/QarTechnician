package com.app.qartechnician.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.qartechnician.R;
import com.app.qartechnician.utils.Constants;

public class TermsConditionActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    Toolbar toolbar;
    ImageView back_button;
    TextView bar_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_condition);
        setIds();
        setData();
    }

    private void setIds() {
        toolbar = findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        webView = findViewById(R.id.terms_conditions_webView);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.terms_and_conditions);
        setSupportActionBar(toolbar);

        //setting WebView
        webView.loadUrl("https://ripenapps.com/");
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
        }
    }
}
