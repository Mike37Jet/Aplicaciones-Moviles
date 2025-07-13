package miguel.mendosa.bibliotecasimagenes

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import jp.wasabeef.picasso.transformations.GrayscaleTransformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

class PicassoActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private var sampleImages = listOf(
        "https://picsum.photos/id/1/800/600",
        "https://picsum.photos/id/10/800/600",
        "https://picsum.photos/id/100/800/600",
        "https://picsum.photos/id/200/800/600",
        "https://picsum.photos/id/300/800/600",
        "https://picsum.photos/id/400/800/600",
        "https://picsum.photos/id/500/800/600",
        "https://picsum.photos/id/600/800/600",
        "https://picsum.photos/id/700/800/600",
        "https://picsum.photos/id/800/800/600",
        "https://picsum.photos/id/25/800/600",
        "https://picsum.photos/id/50/800/600",
        "https://picsum.photos/id/75/800/600",
        "https://picsum.photos/id/125/800/600",
        "https://picsum.photos/id/150/800/600",
        "https://picsum.photos/id/175/800/600",
        "https://picsum.photos/id/250/800/600",
        "https://picsum.photos/id/275/800/600",
    )
    private var currentImageUrl = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Picasso - Demostración"

        setupUI()
        loadDefaultImage()
    }

    private fun setupUI() {
        imageView = findViewById(R.id.imageView)

        findViewById<MaterialButton>(R.id.btnLoadImage).setOnClickListener {
            loadRandomImage()
        }

        findViewById<MaterialButton>(R.id.btnCircleTransform).setOnClickListener {
            applyCircleTransform()
        }

        findViewById<MaterialButton>(R.id.btnRoundedCorners).setOnClickListener {
            applyRoundedCorners()
        }

        findViewById<MaterialButton>(R.id.btnBlurEffect).setOnClickListener {
            applyBlurEffect()
        }

        findViewById<MaterialButton>(R.id.btnGrayscale).setOnClickListener {
            applyGrayscale()
        }

        findViewById<MaterialButton>(R.id.btnResize).setOnClickListener {
            applyResize()
        }
    }

    private fun loadDefaultImage() {
        currentImageUrl = sampleImages[0]
        loadImageWithoutTransformation(currentImageUrl)
    }

    private fun loadRandomImage() {
        currentImageUrl = sampleImages.random()
        loadImageWithoutTransformation(currentImageUrl)
    }

    private fun loadImageWithoutTransformation(currentImageUrl: String) {
        Picasso.get()
            .load(currentImageUrl)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) // Evitar cacheo
            .networkPolicy(NetworkPolicy.NO_CACHE) // Evitar cacheo de red
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .into(imageView)
    }

    private fun applyCircleTransform() {
        if (currentImageUrl.isNotEmpty()) {
            Picasso.get()
                .load(currentImageUrl)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) // Evitar cacheo
                .networkPolicy(NetworkPolicy.NO_CACHE) // Evitar cacheo de red
                .transform(CropCircleTransformation())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(imageView)
        }
    }

    private fun applyRoundedCorners() {
        if (currentImageUrl.isNotEmpty()) {
            Picasso.get()
                .load(currentImageUrl)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) // Evitar cacheo
                .networkPolicy(NetworkPolicy.NO_CACHE) // Evitar cacheo de red
                .transform(RoundedCornersTransformation(150, 0))
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(imageView)
        }
    }

    private fun applyBlurEffect() {
        if (currentImageUrl.isNotEmpty()) {
            Picasso.get()
                .load(currentImageUrl)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) // Evitar cacheo
                .networkPolicy(NetworkPolicy.NO_CACHE) // Evitar cacheo de red
                .transform(BlurTransformation(this, 25, 3))
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(imageView)
        }
    }

    private fun applyGrayscale() {
        if (currentImageUrl.isNotEmpty()) {
            Picasso.get()
                .load(currentImageUrl)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) // Evitar cacheo
                .networkPolicy(NetworkPolicy.NO_CACHE) // Evitar cacheo de red
                .transform(GrayscaleTransformation())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(imageView)
        }
    }

    private fun applyResize() {
        if (currentImageUrl.isNotEmpty()) {
            Picasso.get()
                .load(currentImageUrl)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) // Evitar cacheo
                .networkPolicy(NetworkPolicy.NO_CACHE) // Evitar cacheo de red
                .resize(400, 300)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(imageView)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}