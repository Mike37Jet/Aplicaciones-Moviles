package miguel.mendosa.ejemplo1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val TAG = "MainActivity4"
class MainActivity4 : AppCompatActivity() {
    private lateinit var buttonPricing: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main4)
        buttonPricing = findViewById(R.id.buttonPricing)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        buttonPricing.setOnClickListener {
            Log.i(TAG, "Button Pricing clicked" + getString(R.string.buttonPricing_message))
            Toast.makeText(this, getString(R.string.buttonPricing_message), Toast.LENGTH_SHORT).show()
        }
    }
    fun buttonBuyNowOnClic(view: View) {
        Toast.makeText(this, "Compra realizada", Toast.LENGTH_SHORT).show()
    }
}