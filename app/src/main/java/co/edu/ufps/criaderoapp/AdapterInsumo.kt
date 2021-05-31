package co.edu.ufps.criaderoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterInsumo(var context:Context?,
        private val dataSet : ArrayList<InsumoEntity>, recurso: Int
) : RecyclerView.Adapter<AdapterInsumo.InusmoViewHolder>() {

    class InusmoViewHolder(view:View) : RecyclerView.ViewHolder(view){

        val id : TextView
        val nombre : TextView
        val cantidad : TextView
        val proveedor : TextView

        init {
            id = view.findViewById(R.id.id)
            nombre = view.findViewById(R.id.nombre)
            cantidad = view.findViewById(R.id.cantidad)
            proveedor = view.findViewById(R.id.proveedor)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InusmoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_insumo, parent,false)
        return InusmoViewHolder(view);
    }

    override fun onBindViewHolder(holder: InusmoViewHolder, position: Int) {
        holder.id.text = dataSet[position].id;
        holder.nombre.text = dataSet[position].nombre;
        holder.cantidad.text = dataSet[position].cantidad;
        holder.proveedor.text = dataSet[position].proveedor;

    }

    override fun getItemCount() = dataSet.size
}