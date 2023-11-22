package com.example.homework11.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework11.data.ImageModel
import com.example.homework11.databinding.RvImagesItemBinding

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    private var listOfImages: List<ImageModel> = emptyList()
    var onItemClick: (ImageModel) -> Unit = {}

    inner class ImageViewHolder(private var binding: RvImagesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ImageModel) {
            binding.apply {
                ivPhoto.setImageResource(model.image)
                ivPhoto.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            RvImagesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfImages.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(listOfImages[position])
    }

    fun submitList(newList: List<ImageModel>) {
        val diffResult = DiffUtil.calculateDiff(ImagesDiffUtil(listOfImages, newList))
        this.listOfImages = newList
        diffResult.dispatchUpdatesTo(this)
    }
}