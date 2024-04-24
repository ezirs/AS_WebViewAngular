package com.yorickyoranda.webviewangular;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    protected WebView _webView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _webView = (WebView) findViewById(R.id.webView1);

        WebViewClient webViewClient =  new WebViewClient();
        _webView.setWebViewClient(webViewClient);

        WebChromeClient webChromeClient = new WebChromeClient();
        _webView.setWebChromeClient(webChromeClient);

        WebSettings webSettings = _webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        WebAppInterface webAppInterface = new WebAppInterface(this, MainActivity.this);
        _webView.addJavascriptInterface(webAppInterface, "Android");

        String url = "https://stmikpontianak.net/011100862/angular011100862";
        _webView.loadUrl(url);
    }
}