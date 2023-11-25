package com.example.parcial2prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val nutrition: Unit
    get() = Unit

class DetailActivity : AppCompatActivity() {

    private  lateinit var tvNombreFruta: TextView
    private lateinit var tvCalorias2 : TextView
    private lateinit var tvGrasas2 : TextView
    private lateinit var tvAzucar2 : TextView
    private lateinit var tvCarbohidratos2 : TextView
    private lateinit var tvProteinas2 : TextView
    private lateinit var ivFruta : ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val fruta = intent.getParcelableExtra<DetailFruit>("Fruit")
        val nutricion = intent.getParcelableExtra<Nutritions>("nutritions")


        tvNombreFruta= findViewById(R.id.tvNombreFruta)
        tvCalorias2= findViewById(R.id.tvCalorias2)
        tvGrasas2= findViewById(R.id.tvGrasas2)
        tvAzucar2= findViewById(R.id.tvAzucar2)
        tvCarbohidratos2= findViewById(R.id.tvCarbohidratos2)
        tvProteinas2= findViewById(R.id.tvProteinas2)
        ivFruta= findViewById(R.id.ivFruta)



        tvNombreFruta.text = fruta?.name
        tvCalorias2.text = nutricion?.calories.toString()
        tvGrasas2.text = nutricion?.fat.toString()
        tvAzucar2.text = nutricion?.sugar.toString()
        tvCarbohidratos2.text = nutricion?.carbohydrates.toString()
        tvProteinas2.text = nutricion?.protein.toString()

        if(fruta?.name != null){
            Glide.with(this).load(imagenesDetail(fruta.name)).into(ivFruta)
        }



    }

   private fun imagenesDetail (frutaNombre : String ) : String{

       val imagenDefault: String = "https://freepngimg.com/thumb/pear/2-2-pear-png-pic.png"
       val imagenPersimmon: String = "https://pngimg.com/uploads/persimmon/persimmon_PNG86234.png"
       val imagenStrawberry: String = "https://i.pinimg.com/736x/28/3e/53/283e53880ea4fd483c4968d89b143866.jpg"
       val imagenBanana: String = "https://freepngimg.com/thumb/banana/33867-8-banana.png"
       val imagenTomato: String = "https://freepngimg.com/thumb/tomato/57-tomato-png-image.png"

       when (frutaNombre){
           "Persimmon" -> return imagenPersimmon
           "Strawberry" -> return imagenStrawberry
           "Banana" -> return imagenBanana
           "Tomato" -> return imagenTomato
           else -> return imagenDefault

       }




   }








}