package co.edu.ufps.criaderoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterNotificacion(var context:Context?,
                          private val dataSet : ArrayList<NotificacionEntity>, recurso: Int
) : RecyclerView.Adapter<AdapterNotificacion.NotificacionViewHolder>() {

    class NotificacionViewHolder(view:View) : RecyclerView.ViewHolder(view){

        val id : TextView
        val titulo : TextView
        val descripcion : TextView

        init {
            id = view.findViewById(R.id.id4)
            titulo = view.findViewById(R.id.titulo4)
            descripcion = view.findViewById(R.id.descripcion4)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificacionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_notificacion, parent,false)
        return NotificacionViewHolder(view);
    }

    override fun onBindViewHolder(holder: NotificacionViewHolder, position: Int) {
        holder.id.text = dataSet[position].id;
        holder.titulo.text = dataSet[position].titulo
        holder.descripcion.text = dataSet[position].descripcion;

    }

    override fun getItemCount() = dataSet.size
}