package miguel.mendosa.bibliotecasimagenes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI() {
        findViewById<MaterialButton>(R.id.btnGlide).setOnClickListener {
            startActivity(Intent(this, GlideActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.btnPicasso).setOnClickListener {
            startActivity(Intent(this, PicassoActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.btnFresco).setOnClickListener {
            startActivity(Intent(this, FrescoActivity::class.java))
        }
    }
}