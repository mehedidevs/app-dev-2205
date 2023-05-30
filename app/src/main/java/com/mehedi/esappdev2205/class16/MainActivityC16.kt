package com.mehedi.esappdev2205.class16

import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.mehedi.esappdev2205.R
import com.mehedi.esappdev2205.databinding.ActivityMainC16Binding

class MainActivityC16 : AppCompatActivity() {

    lateinit var binding: ActivityMainC16Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainC16Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (isOnline()) {
            binding.webView.loadUrl("https://evaly.com.bd/")
            binding.webView.settings.javaScriptEnabled = true
            binding.webView.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    binding.webView.visibility = View.GONE
                    binding.loadingBar.visibility = View.VISIBLE
                }
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.webView.visibility = View.VISIBLE
                    binding.loadingBar.visibility = View.GONE
                }
            }
        } else {
            binding.noNetworkTxt.visibility = View.VISIBLE
            binding.webView.visibility = View.GONE
            binding.loadingBar.visibility = View.GONE
       }


    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    fun isOnline(): Boolean {

        val sysService = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfo: NetworkInfo? = sysService.activeNetworkInfo

        return networkInfo?.isConnected ?: false


    }

}