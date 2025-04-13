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

class HomeActivity : AppCompatActivity() {

    private lateinit var imgVoltar: ImageView
    private lateinit var imgBannerPrincipal: ImageView
    private lateinit var imgOriginais01: ImageView
    private lateinit var imgOriginais02: ImageView
    private lateinit var imgOriginais03: ImageView
    private lateinit var imgRecomendados01: ImageView
    private lateinit var imgRecomendados02: ImageView
    private lateinit var imgRecomendados03: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var intentSelecionarUsuario = Intent(this, SelecionarUsuarioActivity::class.java)
        var intentDetalhes = Intent(this, DetalhesActivity::class.java)

        val bnv = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bnv.menu.getItem(0).isChecked = false
        bnv.selectedItemId = View.NO_ID
        bnv.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
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
        imgBannerPrincipal = findViewById(R.id.imageViewBannerPrincipal)
        imgOriginais01 = findViewById(R.id.imageViewOriginais01)
        imgOriginais02 = findViewById(R.id.imageViewOriginais02)
        imgOriginais03 = findViewById(R.id.imageViewOriginais03)
        imgRecomendados01 = findViewById(R.id.imageViewRecomendados01)
        imgRecomendados02 = findViewById(R.id.imageViewRecomendados02)
        imgRecomendados03 = findViewById(R.id.imageViewRecomendados03)

        setImageViewClickListener(imgVoltar, intentSelecionarUsuario)
        setImageViewClickListener(imgBannerPrincipal, intentDetalhes)
        setImageViewClickListener(imgOriginais01, intentDetalhes)
        setImageViewClickListener(imgOriginais02, intentDetalhes)
        setImageViewClickListener(imgOriginais03, intentDetalhes)
        setImageViewClickListener(imgRecomendados01, intentDetalhes)
        setImageViewClickListener(imgRecomendados02, intentDetalhes)
        setImageViewClickListener(imgRecomendados03, intentDetalhes)

    }

    private fun setImageViewClickListener(imgView: ImageView, intent: Intent) {
        imgView.setOnClickListener {
            startActivity(intent)
        }
    }
}