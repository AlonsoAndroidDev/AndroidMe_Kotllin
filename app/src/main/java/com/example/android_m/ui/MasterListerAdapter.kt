package com.example.android_m.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class MasterListerAdapter(private val context: Context, val imagesIds : List<Int>) : BaseAdapter() {

    private  var mContext: Context = context
    private  var mImagesId: List<Int> = imagesIds

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var imageView: ImageView

        if(convertView == null){
            imageView = ImageView(mContext)
            imageView.adjustViewBounds = true
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8,8,8,8)
        }else{
            imageView = convertView as ImageView
        }

        imageView.setImageResource(mImagesId[position])
        return imageView
    }

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = imagesIds.size

}