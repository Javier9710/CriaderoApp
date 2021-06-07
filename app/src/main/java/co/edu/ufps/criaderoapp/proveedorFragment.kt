package co.edu.ufps.criaderoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [proveedorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class proveedorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var contenedorProveedores : RecyclerView
    lateinit var adapterProveedor: AdapterProveedor

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
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_proveedor, container, false)
        contenedorProveedores = view.findViewById(R.id.contenedorProveedores)
        var linearLayout = LinearLayoutManager(context)
        linearLayout.orientation = LinearLayoutManager.VERTICAL
        contenedorProveedores.layoutManager = linearLayout
        adapterProveedor = AdapterProveedor(context, cargarDatosFireBase(), R.id.Proveedor)
        contenedorProveedores.adapter = adapterProveedor
        return view
    }

    private fun cargarDatos(): ArrayList<ProveedorEntity> {

        val proveedores : ArrayList<ProveedorEntity> = java.util.ArrayList<ProveedorEntity>();
        proveedores.add(ProveedorEntity("1", "222" ,"Industria", "cll1.0#1", "javier", "123123"))

        proveedores.add(ProveedorEntity("2", "111", "AgroP", "av8.#21", "camilo", "1312321"))

        return proveedores;
    }

    fun cargarDatosFireBase(): ArrayList<ProveedorEntity> {

        val proveedores = ArrayList<ProveedorEntity>()
        val dataBase : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = dataBase.getReference()
        myRef.child("proveedores").addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    proveedores.clear()
                    for (data in snapshot.children) {
                        val proveedor = data.getValue(ProveedorEntity::class.java)
                        proveedores.add(proveedor as ProveedorEntity)
                        adapterProveedor.notifyDataSetChanged()
                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {

                Log.w("ProveedorFragment", "Carga cancelada", error.toException())
            }

        })

        return proveedores
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment proveedorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            proveedorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}