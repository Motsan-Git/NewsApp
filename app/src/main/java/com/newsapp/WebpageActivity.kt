package com.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.core.view.isVisible

class WebpageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webpage)
        val webView=findViewById<WebView>(R.id.webView)
        webView.loadUrl(intent.getStringExtra("url")!!)
        webView.setInitialScale(125)




    }
}
