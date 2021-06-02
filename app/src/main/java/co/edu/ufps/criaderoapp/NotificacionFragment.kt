package co.edu.ufps.criaderoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [proveedorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotificacionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var contenedorNotificaciones : RecyclerView
    lateinit var adapterNotificaciones: AdapterNotificacion

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
        val view : View = inflater.inflate(R.layout.fragment_notificacion, container, false)
        contenedorNotificaciones = view.findViewById(R.id.contenedorNotificaciones)
        var linearLayout = LinearLayoutManager(context)
        linearLayout.orientation = LinearLayoutManager.VERTICAL
        contenedorNotificaciones.layoutManager = linearLayout
        adapterNotificaciones = AdapterNotificacion(context, cargarDatos(), R.id.cardNoti)
        contenedorNotificaciones.adapter = adapterNotificaciones
        return view
    }

    private fun cargarDatos(): ArrayList<NotificacionEntity> {

        val Notificaciones : ArrayList<NotificacionEntity> = java.util.ArrayList<NotificacionEntity>();
        Notificaciones.add(NotificacionEntity("1", "Alimentacion Retardada" ,"Alimentacion Retardada Estanque E0001"))

        Notificaciones.add(NotificacionEntity("2", "Falta de Stock Minimo" ,"Pocas unidades de vitaminaE"))

        Notificaciones.add(NotificacionEntity("3", "Cambio de Agua" ,"Se Cumplio el tiempo limite E0005"))
        return Notificaciones;
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