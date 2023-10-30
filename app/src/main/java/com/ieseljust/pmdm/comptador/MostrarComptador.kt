package com.ieseljust.pmdm.comptador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MostrarComptador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_comptador)


        val comptador:Int? = intent.getIntExtra("comptador", 0)

        val comptadorTextView=findViewById<TextView>(R.id.textViewMostraComptador)
        comptadorTextView.setText(comptador.toString())

        val btClose=findViewById<Button>(R.id.btClose)
        btClose.setOnClickListener{
            finish()
        }

    }
}