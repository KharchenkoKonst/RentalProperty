package com.example.rentalproperty.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rentalproperty.databinding.AdvertisementItemBinding
import com.example.rentalproperty.presentation.model.AdvertisementModel

class AdvertisementsPreviewAdapter :
    RecyclerView.Adapter<AdvertisementsPreviewAdapter.AdvertisementItemViewHolder>() {

    var advertisementsList = listOf<AdvertisementModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AdvertisementItemViewHolder(
        AdvertisementItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: AdvertisementItemViewHolder, position: Int) {
        holder.bind(advertisementsList[position])
    }

    override fun getItemCount() = advertisementsList.size


    inner class AdvertisementItemViewHolder(private val binding: AdvertisementItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: AdvertisementModel) {
            with(binding){
                price.text = model.pricePerMoth
                address.text = "${model.region}. ${model.address}"
            }
        }
    }
}