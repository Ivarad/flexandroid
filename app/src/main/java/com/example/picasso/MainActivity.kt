package com.example.picasso

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.picasso.ItemOfList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.itemlist.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

       var listflex : MutableList<ItemOfList> = mutableListOf<ItemOfList>()
    private val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        load.setOnClickListener{

            listflex.clear()

            for(count in 1..5)
            {
               run("https://aws.random.cat/meow")
            }

            while (true)
            {
                if(listflex.size == 5)
                {
                    Thread.sleep(1000)
                    break
                }
            }

            var adapter = Adapter(listflex.toList())

            val recyclerView = findViewById<RecyclerView>(R.id.fleximgrecv)
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.setHasFixedSize(true)

            recyclerView.adapter = adapter

        }


    }

    private fun run(url:String){
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body()?.string()
                val jsonImage = (JSONObject(json).get("file")).toString()
                listflex.add(ItemOfList(jsonImage.toString()))

            }

        })
    }
}
