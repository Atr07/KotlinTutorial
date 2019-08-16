package com.android.example.kotlinweb.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient

import com.android.example.kotlinweb.R
import kotlinx.android.synthetic.main.fragment_web_view.*
import kotlinx.android.synthetic.main.fragment_web_view.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class WebViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_web_view, container, false)
        val settings = view.webView.settings
        settings.javaScriptEnabled = true

        view.webView.webViewClient = WebViewClient()
        view.webView.loadUrl("https://www.google.com")

        return view
    }


}
