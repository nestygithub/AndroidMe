package com.chiki.androidme.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chiki.androidme.adapters.BodyPartAdapter
import com.chiki.androidme.data.BodyPart

//Adapts a list of BodyParts the a recycler view
@BindingAdapter("bindPhotos")
fun bindPhotos(recyclerView: RecyclerView,bodyParts:List<BodyPart>?){
    bodyParts?.let{
        val adapter = recyclerView.adapter as BodyPartAdapter
        adapter.submitList(it)
    }
}


//Know how to set the image resource to an image view with a given BodyPart
@BindingAdapter("bindBodyPartImage")
fun bindBodyPartImage(imageView: ImageView, bodyPart: BodyPart?){
    bodyPart?.let {
        imageView.setImageResource(bodyPart.imageId)
    }
}