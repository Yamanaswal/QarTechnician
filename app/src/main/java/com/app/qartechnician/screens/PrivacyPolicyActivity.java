package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.qartechnician.R;
import com.app.qartechnician.models.terms_privacy_about_us.terms_privacy_about_response.TermsPrivacyAboutUsResponse;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.Constants;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

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

        //setting WebView
        new APIUtility().termsPrivacyAboutUs(this,
                true,
                Preferences.getPreference(this, PrefEntities.ACCESS_TOKEN), "privacyandpolicy",
                Preferences.getPreference(this, PrefEntities.LOGIN_AS), new APIUtility.APIResponseListener<TermsPrivacyAboutUsResponse>() {
                    @Override
                    public void onReceiveResponse(TermsPrivacyAboutUsResponse response) {
                        webView.getSettings().getJavaScriptEnabled();
                        webView.loadDataWithBaseURL("", response.getData().getDescription(), "text/html", "UTF-8", "");
                    }

                    @Override
                    public void onStatusFailed(TermsPrivacyAboutUsResponse response) {
                        Toast.makeText(PrivacyPolicyActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure() {
                        CommonUtils.alert(PrivacyPolicyActivity.this, getString(R.string.somethingwentwrong));
                    }
                });
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
