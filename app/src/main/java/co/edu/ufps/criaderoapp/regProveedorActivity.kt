package co.edu.ufps.criaderoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase

class regProveedorActivity : AppCompatActivity() {

    lateinit var id : TextInputEditText
    lateinit var codigo : TextInputEditText
    lateinit var nombre : TextInputEditText
    lateinit var direccion : TextInputEditText
    lateinit var responsable : TextInputEditText
    lateinit var contacto : TextInputEditText
    lateinit var guardar : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_proveedor)
        id=findViewById(R.id.idPro)
        codigo=findViewById(R.id.codigOPro)
        nombre=findViewById(R.id.nombrePro)
        direccion=findViewById(R.id.direccionPro)
        responsable=findViewById(R.id.responsablePro)
        contacto=findViewById(R.id.contactoPro)
        guardar=findViewById(R.id.registrarPro)
        guardar.setOnClickListener{
            registrarProveedor();
        }
    }

    fun registrarProveedor(){
        val dataBase = FirebaseDatabase.getInstance()
        val myRef = dataBase.reference
        val proveedor = ProveedorEntity(myRef.push().key.toString(),
                codigo.toString(),
                nombre.toString(),
                direccion.toString(),
                responsable.toString(),
                contacto.toString()

        )

        myRef.child("proveedores").child(proveedor.id).setValue(proveedor)
        finish()
    }
}