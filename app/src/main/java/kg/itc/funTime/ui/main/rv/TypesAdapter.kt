package kg.itc.funTime.ui.main.rv

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.itc.funTime.data.models.TypesEntity

class TypesAdapter(private val listener: Listener) : RecyclerView.Adapter<TypesVH>() {

    private var list = arrayListOf<TypesEntity>()

    fun setData(list: List<TypesEntity>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
        Log.e("setData","Ok")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesVH {
        return TypesVH.create(parent,listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TypesVH, position: Int) {
        val item = list[position]
        Log.e("Type adapter","Ok - $position")
        holder.bind(item)
    }

    interface Listener{
        fun onClick(index: String)
    }

}