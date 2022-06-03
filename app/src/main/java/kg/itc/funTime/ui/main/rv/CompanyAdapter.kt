package kg.itc.funTime.ui.main.rv

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.itc.funTime.data.models.CompanyEntity

class CompanyAdapter(private val listener:Listener) : RecyclerView.Adapter<CompanyVH>() {
    private var list = arrayListOf<CompanyEntity>()

    fun setData(list: List<CompanyEntity>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
        Log.e("setData-comp","Ok")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyVH {
        return CompanyVH.create(parent,listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface Listener{
        fun onClick(index: String)
    }

    override fun onBindViewHolder(holder: CompanyVH, position: Int) {
        val item = list[position]
        Log.e("Company adapter","Ok - $position")
        holder.bind(item)
    }
}