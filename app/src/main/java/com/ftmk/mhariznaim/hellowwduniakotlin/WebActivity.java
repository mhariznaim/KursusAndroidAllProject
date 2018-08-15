package com.ftmk.mhariznaim.hellowwduniakotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView webViewUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webViewUs = findViewById(R.id.webView1);

        webViewUs.loadUrl("http://ftmk.utem.edu.my/web/index.php/about/staff-directory/staff-directory-department-of-software-engineering/");
        webViewUs.getSettings().setJavaScriptEnabled(true);
        webViewUs.setWebViewClient(new WebViewClient(){
            @Override

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webViewUs.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onBackPressed() {
        if(webViewUs.canGoBack())
        {
            webViewUs.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}
