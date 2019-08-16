package com.android.example.kotlinweb

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.*
import android.widget.TextView
import com.android.example.kotlinweb.fragments.WebViewFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        snack_btn.setOnClickListener {
            val snack = Snackbar.make(it, "Hello Kotlin", Snackbar.LENGTH_LONG)
            // change action button text color
            snack.setActionTextColor(R.color.action_text_snack)

            // snackbar background color
            snack.view.setBackgroundColor(R.color.background_text_snack)

            val textView = snack.view.findViewById(R.id.snackbar_text) as TextView
            // change Snackbar text color
            textView.setTextColor(R.color.text_snack)

            snack.setAction("DISMISS", View.OnClickListener {
                Log.i("MainActivity", "Dismiss Clicked")
            })
            snack.show()
        }
    }

    override fun onBackPressed() {
        if (web_linearlayout.visibility == GONE)   {
            super.onBackPressed()
        } else {
            web_linearlayout.visibility = GONE
        }

    }
}
