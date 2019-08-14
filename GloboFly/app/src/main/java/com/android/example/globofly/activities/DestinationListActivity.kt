package com.android.example.globofly.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.example.globofly.R
import com.android.example.globofly.helpers.DestinationAdapter
import com.android.example.globofly.helpers.SampleData
import com.android.example.globofly.models.Destination
import com.android.example.globofly.services.DestinationService
import com.android.example.globofly.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_destiny_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinationListActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_destiny_list)

		setSupportActionBar(toolbar)
		toolbar.title = title

		fab.setOnClickListener {
			val intent = Intent(this@DestinationListActivity, DestinationCreateActivity::class.java)
			startActivity(intent)
		}
	}

	override fun onResume() {
		super.onResume()

		loadDestinations()
	}

	/*private fun loadDestinations() {

        // To be replaced by retrofit code
		destiny_recycler_view.adapter = DestinationAdapter(SampleData.DESTINATIONS)
    }*/

	private fun loadDestinations() {

		val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
		val requestCall = destinationService.getDestinationList("India")

		requestCall.enqueue(object: Callback<List<Destination>> {
			override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
				val destinationList = response.body()!!
				destiny_recycler_view.adapter = DestinationAdapter(destinationList)
			}

			override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
				Log.i(this.toString(),t.message)
				Toast.makeText(this@DestinationListActivity,t.message.toString(),Toast.LENGTH_SHORT).show()
			}

		})

	}
}
