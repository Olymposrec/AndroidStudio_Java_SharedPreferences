package com.melihakkose.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Lateinit sonra initialize edicem demek
    lateinit var sharedPreferences:SharedPreferences

    var agePreferences:Int?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //INITIALIZE
         sharedPreferences= this.getSharedPreferences("com.melihakkose.storingdata",
            Context.MODE_PRIVATE)

          agePreferences=sharedPreferences.getInt("myAge",0)

        if(agePreferences==0){
            textView.text="Your Age:"
        }else{
            textView.text="Your Age: $agePreferences "
        }

    }

    fun save(view: View){

        //SharedPreferences -> Kucuk veriler kaydedilirken kullanilir. (Cok az veri ile hizli calisir)
        //MODE_PRIVATE olusturulan uygulama icerisinden cagiriliyor



        val age=editTextAge.text.toString().toIntOrNull()
        if(age!=null){
            textView.text="Your Age: "+ age
            sharedPreferences.edit().putInt("myAge",age).apply()
        }else{
            textView.text="Your Age: Required!"
        }

    }

    fun delete(view:View){
        agePreferences=sharedPreferences.getInt("myAge",0)

        if(agePreferences!=0){
            sharedPreferences.edit().remove("myAge").apply()
            textView.text="Your Age: "
        }

    }
}