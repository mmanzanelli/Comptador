package com.ieseljust.pmdm.comptador


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ieseljust.pmdm.comptador.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var comptador=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Referencia al TextView
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)

        // Inicialitzem el TextView amb el comptador a 0
        textViewContador.setText(comptador.toString())

        // Referencia al botón
        val btAdd=findViewById<Button>(R.id.btAdd)
        val btSub=findViewById<Button>(R.id.btSub)
        val btReset= findViewById<Button>(R.id.reset)

        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        btAdd.setOnClickListener {
            comptador++
            textViewContador.setText(comptador.toString())
        }
        btSub.setOnClickListener{
            comptador--
            textViewContador.setText(comptador.toString())
        }
        btReset.setOnClickListener{
            comptador = 0
            textViewContador.setText(comptador.toString())
        }

        val btNewActivity=findViewById<Button>(R.id.btNewActivity)


        btNewActivity.setOnClickListener{
            val intent = Intent(baseContext, MostrarComptador::class.java)
            intent.putExtra("comptador", comptador)
            startActivity(intent)
        }
       /* val comptador:Int? = intent.getIntExtra("comptador", 0)

        val comptadorTextView=findViewById<TextView>(R.id.textViewMostraComptador)
        comptadorTextView.setText(comptador.toString())*/

    }


    override fun onSaveInstanceState(estat: Bundle) {
        super.onSaveInstanceState(estat)
        // Codi per a guardar l'estat
        estat.putInt("comptador", comptador)
    }

    override fun onRestoreInstanceState(estat: Bundle) {
        super.onRestoreInstanceState(estat)
        // Codi per a guardar l'estat
        comptador=estat.getInt("comptador")

        val textViewCompador =findViewById<TextView>(R.id.textViewComptador);
        textViewCompador.text=comptador.toString()
    }
}