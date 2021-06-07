package co.edu.ufps.criaderoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [regInsumoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class regInsumoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var nombre : TextInputEditText
    lateinit var cantidad : TextInputEditText
    lateinit var proveedor : TextInputEditText
    lateinit var id : TextInputEditText
    lateinit var guardar : Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_reg_insumo, container, false)
        id=view.findViewById(R.id.idInsumo)
        nombre=view.findViewById(R.id.nombreInsumo)
        proveedor=view.findViewById(R.id.proveedorInsumo)
        cantidad=view.findViewById(R.id.cantidadInsumo)
        guardar=view.findViewById(R.id.registrarInsumo)
        guardar.setOnClickListener{
            registrarInsumo();
        }
        return view
    }

    fun registrarInsumo(){
        val dataBase = FirebaseDatabase.getInstance()
        val myRef = dataBase.reference
        val insumo = InsumoEntity(myRef.push().key.toString(),
                nombre.text.toString(),
                cantidad.text.toString(),
                proveedor.text.toString()

        )

        myRef.child("insumos").child(insumo.id).setValue(insumo)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment regInsumoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            regInsumoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                }
            }
    }
}