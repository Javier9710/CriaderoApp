package co.edu.ufps.criaderoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterProveedor(var context:Context?,
                    private val dataSet : ArrayList<ProveedorEntity>, recurso: Int
) : RecyclerView.Adapter<AdapterProveedor.ProveedorViewHolder>() {

    class ProveedorViewHolder(view:View) : RecyclerView.ViewHolder(view){

        val id : TextView
        val codigo  : TextView
        val nombre : TextView
        val direccion : TextView
        val responsable : TextView

        init {
            id = view.findViewById(R.id.id2)
            codigo = view.findViewById(R.id.codigo2)
            nombre = view.findViewById(R.id.nombre2)
            direccion = view.findViewById(R.id.direccion2)
            responsable = view.findViewById(R.id.responsable2)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProveedorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_proveedor, parent,false)
        return ProveedorViewHolder(view);
    }

    override fun onBindViewHolder(holder: ProveedorViewHolder, position: Int) {
        holder.id.text = dataSet[position].id;
        holder.codigo.text = dataSet[position].codigo;
        holder.nombre.text = dataSet[position].nombre;
        holder.direccion.text = dataSet[position].direccion;
        holder.responsable.text = dataSet[position].responsable;

    }

    override fun getItemCount() = dataSet.size
}