//this is for About_us in the app
package com.example.a1405264.sun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Contact_us extends Fragment {

private WebView mWebView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.activity_home,container,false);
        //    return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_home, container, false);
       //this is to open the link
        // Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com"));
        //startActivity(browserIntent);
        // Enable Javascript
        mWebView=(WebView)view.findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://www.kiit.ac.in/placement/index.html");
    return view;
    }
}

