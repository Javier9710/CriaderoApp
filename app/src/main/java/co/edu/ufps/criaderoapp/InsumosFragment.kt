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
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InsumosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InsumosFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var contenedorInsumos : RecyclerView
    lateinit var adapterInsumo: AdapterInsumo

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
        val view : View = inflater.inflate(R.layout.fragment_insumos, container, false)
        contenedorInsumos = view.findViewById(R.id.contenedorInsumos)
        var linearLayout = LinearLayoutManager(context)
        linearLayout.orientation = LinearLayoutManager.VERTICAL
        contenedorInsumos.layoutManager = linearLayout
        adapterInsumo = AdapterInsumo(context, cargarDatosFireBase(), R.id.insumo)
        contenedorInsumos.adapter = adapterInsumo
        return view
    }

    private fun cargarDatos(): ArrayList<InsumoEntity> {

        val insumos : ArrayList<InsumoEntity> = java.util.ArrayList<InsumoEntity>();
        insumos.add(InsumoEntity("1", "comida", "10", "agroIndustria"))

        insumos.add(InsumoEntity("2", "comida1", "11", "agroIndustria1"))

        insumos.add(InsumoEntity("3", "comida2", "22", "agroIndustria2"))

        return insumos;
    }

    fun cargarDatosFireBase(): ArrayList<InsumoEntity> {

        val insumos = ArrayList<InsumoEntity>()
        val dataBase : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = dataBase.getReference()
        myRef.child("insumos").addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    insumos.clear()
                    for (data in snapshot.children) {
                        val insumo = data.getValue(InsumoEntity::class.java)
                        insumos.add(insumo as InsumoEntity)
                        adapterInsumo.notifyDataSetChanged()
                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {

                Log.w("InsumosFragment", "Carga cancelada", error.toException())
            }

        })

        return insumos
    }




            companion object {
            /**
             * Use this factory method to create a new instance of
             * this fragment using the provided parameters.
             *
             * @param param1 Parameter 1.
             * @param param2 Parameter 2.
             * @return A new instance of fragment InsumosFragment.
             */
            // TODO: Rename and change types and number of parameters
            @JvmStatic
            fun newInstance(param1: String, param2: String) =
                    InsumosFragment().apply {
                        arguments = Bundle().apply {
                            putString(ARG_PARAM1, param1)
                            putString(ARG_PARAM2, param2)
                        }
                    }
        }

}