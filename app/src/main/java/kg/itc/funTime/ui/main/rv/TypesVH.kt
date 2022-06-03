package kg.itc.funTime.ui.main.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.itc.funTime.R
import kg.itc.funTime.data.models.TypesEntity
import kg.itc.funTime.databinding.RecyclerEntertainmentBinding

class TypesVH(private val binding : RecyclerEntertainmentBinding): RecyclerView.ViewHolder(binding.root) {

    var objectId = ""
    fun bind(item: TypesEntity) {
        with(binding){
            entertainmentType.text = item.name
            count.text = item.count
            objectId = item.objectId
        }
    }

    companion object{
        fun create(parent: ViewGroup, listener: TypesAdapter.Listener):TypesVH{
            val vw = LayoutInflater.from(parent.context).
            inflate(R.layout.recycler_entertainment,parent,false)

            val binding = RecyclerEntertainmentBinding.bind(vw)
            return TypesVH(binding).apply {
                itemView.setOnClickListener{
                    listener.onClick(objectId)
                }
            }
        }
    }
}