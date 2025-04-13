package br.com.lucasaraujo.trabalhopratico01

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SelecionarUsuarioActivity : AppCompatActivity() {

    private lateinit var imgUser01: ImageView
    private lateinit var imgUser02: ImageView
    private lateinit var imgUser03: ImageView
    private lateinit var imgUser04: ImageView
    private lateinit var imgUser05: ImageView
    private lateinit var imgUser06: ImageView
    private lateinit var imgUser07: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selecionar_usuario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imgUser01 = findViewById(R.id.imageView01)
        imgUser02 = findViewById(R.id.imageView02)
        imgUser03 = findViewById(R.id.imageView03)
        imgUser04 = findViewById(R.id.imageView04)
        imgUser05 = findViewById(R.id.imageView05)
        imgUser06 = findViewById(R.id.imageView06)
        imgUser07 = findViewById(R.id.imageView07)

        setClickListeners(imgUser01)
        setClickListeners(imgUser02)
        setClickListeners(imgUser03)
        setClickListeners(imgUser04)
        setClickListeners(imgUser05)
        setClickListeners(imgUser06)
        setClickListeners(imgUser07)
    }

    private fun setClickListeners(imgUser: ImageView) {
        var i = Intent(applicationContext, HomeActivity::class.java)

        imgUser.setOnClickListener {
            startActivity(i)
        }
    }
}