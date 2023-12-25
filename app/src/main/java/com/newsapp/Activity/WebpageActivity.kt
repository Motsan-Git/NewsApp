package com.newsapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.core.view.isVisible
import com.newsapp.R

class WebpageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webpage)
        val progressBar2 = findViewById<ProgressBar>(R.id.progressBar2)
        progressBar2.isVisible = true
        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(intent.getStringExtra("url")!!)
        webView.setInitialScale(100)
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished (view: WebView,url: String) {
                progressBar2.isVisible = false
            }
        }
    }
}
