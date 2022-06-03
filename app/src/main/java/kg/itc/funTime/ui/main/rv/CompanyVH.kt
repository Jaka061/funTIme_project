package kg.itc.funTime.ui.main.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.itc.funTime.R
import kg.itc.funTime.data.models.CompanyEntity
import kg.itc.funTime.databinding.RecyclerCompanyBinding

class CompanyVH(private val binding : RecyclerCompanyBinding): RecyclerView.ViewHolder(binding.root) {

    var objectId = ""

    fun bind(item: CompanyEntity) {
        with(binding){
            // пока отображаю толко эти данные , позже доделаю recycle_company полноценно
            companyName.text = item.name
            region.text = item.region
            objectId = item.objectId

            favoriteImg.setOnClickListener {
                Glide.with(itemView.context).load(R.drawable.ic_favorite_black).into(favoriteImg)
            }
        }
    }

    companion object{
        fun create(parent: ViewGroup, listener: CompanyAdapter.Listener):CompanyVH{
            val vw = LayoutInflater.from(parent.context).
            inflate(R.layout.recycler_company,parent,false)

            val binding = RecyclerCompanyBinding.bind(vw)
            return CompanyVH(binding).apply {
                itemView.setOnClickListener{
                    listener.onClick(objectId)
                }
            }

        }
    }
}
