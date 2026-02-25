package com.aula2.aula01_25_02

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "-> onCreate: App iniciado")

        val tvMensagem: TextView = findViewById(R.id.tvMensagem)
        val btnMudar: Button = findViewById(R.id.btnMudar)
        Log.d(TAG, "-> Views encontradas com sucesso")

        val cores = arrayOf(
            R.color.black,
            R.color.blue,
            R.color.green,
            R.color.red
        )

        var cliques = 0;
        var indice = 0

        btnMudar.setOnClickListener {
            cliques++
            tvMensagem.text = "Você clicou $cliques vez(es)"
            Log.i(TAG, "-> Botão clicado! Total: $cliques")

            indice = (indice + 1 ) % cores.size
            val corAtual = cores[indice]
            findViewById<LinearLayout>(R.id.main).setBackgroundColor(getColor(corAtual))

            if (corAtual == 2131034145) {
                tvMensagem.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
            else {
                tvMensagem.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "-> onStart: Tela Visivel")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "-> onResume: App em Foco")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "-> onPause: Perdeu foco")
    }
}