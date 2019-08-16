package com.android.example.kotlinweb.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.example.kotlinweb.R
import io.github.zoha131.scienceview.ScienceView
import kotlinx.android.synthetic.main.fragment_science_view.*

class ScienceViewFragment : Fragment() {

    lateinit var scienceView: ScienceView<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_science_view, container, false)
        scienceView = view.findViewById(R.id.scienceView)

        //scienceView.loadUrl("https://www.google.com")

        return view
    }

    override fun onResume() {
        super.onResume()
        scienceView.addCSS(R.raw.style)

        scienceView.setModel { model ->
                            """
                <form>
                  <h1>ScinceView</h1>
                  <label>
                    <input type="radio" name="opinion"/>
                    <i></i>
                    <span>$model</span>
                  </label>
                  <label>
                    <input type="radio" name="opinion"/>
                    <i></i>
                    <span>$model</span>
                  </label>
                </form>
                            """.trimIndent()
        }

        scienceView.setScienceClickListener { tag, data ->
            Log.d("JSCLICKLISTENER", "$tag $data")
        }

        button.setOnClickListener {
            scienceView.setData("${'$'}${'$'}\\\\ce{x Na(NH4)HPO4 ->[\\\\Delta] (NaPO3)_x + x NH3 ^ + x H2O}${'$'}${'$'}")
        }
    }


}
