package com.dam2.modelomvvc

// para no usar findViewById
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instanciamos el ViewModel
        // nomenclatura que necesita utilizar jvm 1.8
        // se configura en project structure -> Modules -> Target Compatibillity
        val miModelo by viewModels<MyViewModel>()
        val texto = findViewById<TextView>(R.id.textRonda)
        texto.text = miModelo.ronda.value.toString()


        // observamos cambios en ronda y actualizamos textView
        miModelo.ronda.observe(this, {
                nuevaRonda -> textRonda.text = nuevaRonda.toString()
        })

        sumarRonda.setOnClickListener {

            miModelo.sumarRonda()

        }
    }
}