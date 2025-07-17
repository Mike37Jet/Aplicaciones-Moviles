package miguel.mendosa.bibliotecasimagenes

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.google.android.material.button.MaterialButton
import androidx.core.net.toUri

class FrescoActivity : AppCompatActivity() {

    private lateinit var draweeView: SimpleDraweeView
    private val sampleImages = listOf(
        "https://picsum.photos/800/600?random=9",
        "https://picsum.photos/800/600?random=10",
        "https://picsum.photos/800/600?random=11",
        "https://picsum.photos/800/600?random=12"
    )
    private var currentImageUrl = "" // Para almacenar la URL actual

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fresco)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Fresco - Demostración"

        setupUI()
        loadDefaultImage()
    }

    private fun setupUI() {
        draweeView = findViewById(R.id.draweeView)

        findViewById<MaterialButton>(R.id.btnLoadImage).setOnClickListener {
            loadRandomImage()
        }

        findViewById<MaterialButton>(R.id.btnProgressive).setOnClickListener {
            loadProgressiveImage()
        }

        findViewById<MaterialButton>(R.id.btnAutoRotate).setOnClickListener {
            loadImageWithAutoRotate()
        }

        findViewById<MaterialButton>(R.id.btnLocalResource).setOnClickListener {
            loadLocalResource()
        }

        findViewById<MaterialButton>(R.id.btnClearCache).setOnClickListener {
            clearImageCache()
        }
    }

    private fun loadDefaultImage() {
        currentImageUrl = sampleImages[0]
        draweeView.setImageURI(currentImageUrl)
    }

    private fun loadRandomImage() {
        currentImageUrl = sampleImages.random()
        draweeView.setImageURI(currentImageUrl)
    }

    private fun loadProgressiveImage() {
        // Usa una imagen JPEG progresiva de internet para que funcione
        val progressiveImageUrl = "https://picsum.photos/800/600?random=progressive"

        val request = ImageRequestBuilder
            .newBuilderWithSource(Uri.parse(progressiveImageUrl))
            .setProgressiveRenderingEnabled(true)
            .build()

        val controller = Fresco.newDraweeControllerBuilder()
            .setImageRequest(request)
            .setOldController(draweeView.controller)
            .build()

        draweeView.controller = controller
    }

    private fun loadImageWithAutoRotate() {
        // Usa la imagen actual con auto-rotación habilitada
        val request = ImageRequestBuilder
            .newBuilderWithSource(Uri.parse(currentImageUrl))
            .setAutoRotateEnabled(true)
            .build()

        val controller = Fresco.newDraweeControllerBuilder()
            .setImageRequest(request)
            .setOldController(draweeView.controller)
            .build()

        draweeView.controller = controller
    }

    private fun loadLocalResource() {
        // Formato correcto para recursos locales
        val uri = "res:///${R.drawable.software}".toUri()
        draweeView.setImageURI(uri)
    }


    private fun clearImageCache() {
        Fresco.getImagePipeline().clearCaches()
        draweeView.setImageURI(currentImageUrl)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}