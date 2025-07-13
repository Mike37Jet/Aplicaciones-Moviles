package miguel.mendosa.bibliotecasimagenes

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.button.MaterialButton
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.GrayscaleTransformation

class GlideActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private val sampleImages = listOf(
        "https://picsum.photos/800/600?random=1",
        "https://picsum.photos/800/600?random=2",
        "https://picsum.photos/800/600?random=3",
        "https://picsum.photos/800/600?random=4"
    )
    private var currentImageUrl = "" // Para almacenar la URL actual

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Glide - Demostración"

        setupUI()
        loadDefaultImage()
    }

    private fun setupUI() {
        imageView = findViewById(R.id.imageView)

        findViewById<MaterialButton>(R.id.btnLoadImage).setOnClickListener {
            loadRandomImage()
        }

        findViewById<MaterialButton>(R.id.btnCircleTransform).setOnClickListener {
            loadImageWithCircleTransform()
        }

        findViewById<MaterialButton>(R.id.btnRoundedCorners).setOnClickListener {
            loadImageWithRoundedCorners()
        }

        findViewById<MaterialButton>(R.id.btnBlurEffect).setOnClickListener {
            loadImageWithBlur()
        }

        findViewById<MaterialButton>(R.id.btnGrayscale).setOnClickListener {
            loadImageWithGrayscale()
        }
    }

    private fun loadDefaultImage() {
        currentImageUrl = sampleImages[0]
        Glide.with(this)
            .load(currentImageUrl)
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .into(imageView)
    }

    private fun loadRandomImage() {
        currentImageUrl = sampleImages.random()
        Glide.with(this)
            .load(currentImageUrl)
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    }

    private fun loadImageWithCircleTransform() {
        Glide.with(this)
            .load(currentImageUrl)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .into(imageView)
    }

    private fun loadImageWithRoundedCorners() {
        // Usar un radio más grande y convertir dp a píxeles
        val radiusInDp = 150 // Radio más grande
        val radiusInPx = (radiusInDp * resources.displayMetrics.density).toInt()

        Glide.with(this)
            .load(currentImageUrl)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(radiusInPx)))
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .into(imageView)
    }

    private fun loadImageWithBlur() {
        Glide.with(this)
            .load(currentImageUrl)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3)))
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .into(imageView)
    }

    private fun loadImageWithGrayscale() {
        Glide.with(this)
            .load(currentImageUrl)
            .apply(RequestOptions.bitmapTransform(GrayscaleTransformation()))
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .into(imageView)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}