package com.newsapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.newsapp.R

class WebpageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webpage)
        val webView=findViewById<WebView>(R.id.webView)
        webView.loadUrl(intent.getStringExtra("url")!!)
        webView.setInitialScale(125)




    }
}
