package br.com.lucasaraujo.trabalhopratico01

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetalhesActivity : AppCompatActivity() {
    private lateinit var imgVoltar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var intentSelecionarUsuario = Intent(this, SelecionarUsuarioActivity::class.java)
        var intentHome = Intent(this, HomeActivity::class.java)

        val bnv = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bnv.menu.getItem(0).isChecked = false
        bnv.selectedItemId = View.NO_ID
        bnv.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    startActivity(intentHome)
                    true
                }
                R.id.menu_search -> {
                    // TODO
                    false
                }
                R.id.menu_profile -> {
                    startActivity(intentSelecionarUsuario)
                    true
                }
                else -> false
            }
        }

        imgVoltar = findViewById(R.id.imageViewVoltar)

        imgVoltar.setOnClickListener {
            startActivity(intentHome)
        }

    }
}