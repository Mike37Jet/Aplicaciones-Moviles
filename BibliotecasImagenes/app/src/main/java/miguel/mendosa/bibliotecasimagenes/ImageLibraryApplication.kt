package miguel.mendosa.bibliotecasimagenes

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class ImageLibraryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Inicializar Fresco
        Fresco.initialize(this)
    }
}