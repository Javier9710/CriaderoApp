package co.edu.ufps.criaderoapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun entraEstanques(view: View) {
        val intent = Intent(this, EstanqueActivity::class.java);
        startActivity(intent);
    }

    fun entraProveedor(view: View) {
        val intent = Intent(this, ProveedorActivity::class.java);
        startActivity(intent);
    }

    fun entraInsumos(view: View) {
        val intent = Intent(this, InsumoActivity::class.java);
        startActivity(intent);
    }




}