package com.example.belajar

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.belajar.databinding.FragmentWebViewCaraPembayaranBinding
import com.example.belajar.databinding.FragmentWebViewFormulirBinding

class WebViewCaraPembayaran : Fragment() {

    private var _binding: FragmentWebViewCaraPembayaranBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWebViewCaraPembayaranBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myWebView: WebView = view.findViewById(R.id.WebViewCaraPembayaran)
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }
        }
        val webSetting: WebSettings = myWebView.settings
        webSetting.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()

        myWebView.canGoBack()
        myWebView.setOnKeyListener(View.OnKeyListener { v , keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK

                && event.action == MotionEvent.ACTION_UP
                && myWebView.canGoBack()){
                myWebView.goBack()
                return@OnKeyListener true
            }
            false
        })
        myWebView.loadUrl("https://midtrans.com/id/blog/cara-bayar-virtual-account-bni#:~:text=Untuk%20melakukan%20pembayaran%20virtual%20account%20lewat%20ATM%20BNI%2C,sudah%20sesuai%2C%20lanjutkan%20transaksi%20dan%20simpan%20bukti%20transfer")
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.allowContentAccess = true
        myWebView.settings.domStorageEnabled = true
        myWebView.settings.useWideViewPort = true
    }
}