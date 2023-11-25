package com.example.parcial2prueba

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val listadoFrutas = mutableListOf<DetailFruit>()

    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvFrutas)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(listadoFrutas)
        recyclerView.adapter = adapter

        adapter.onItemClickListener = { fruit ->
            val nutritions = getNutritions((fruit))
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("Fruit", fruit)
            intent.putExtra("nutritions",nutritions)
            startActivity(intent)

        }

        getListOfFruits()
    }

    private fun getNutritions(DetailFruit:DetailFruit) : Nutritions {
        return DetailFruit.nutritions
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getListOfFruits() {
      CoroutineScope(Dispatchers.IO).launch{
          val call = getRetrofit().create(ApiService::class.java).getFruits("fruit/all")
          val response = call.body()

          runOnUiThread {
              if (call.isSuccessful) {

                  response?.map {fruit ->
                    listadoFrutas.add(
                        fruit
                    )
                  }
                  adapter.notifyDataSetChanged()
              }
          }
      }
    }



    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        const val BASE_URL= "https://fruityvice.com/api/"
    }

}