package com.example.android_m.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.android_m.R
import java.util.ArrayList

class BodyPartFragment : Fragment() {

    init {

    }

    var mImagesIds : List<Int>? = null
    var mListIndex : Int = 0
    val LOG_TAG_BODY_FRAGMENT_PART = "BodyFragmentPart"
    val IMAGE_ID_LIST = "images_ids"
    val LIST_INDEX = "image_id"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_body_part, container, false)
        val imageView = rootView.findViewById<ImageView>(R.id.body_part_image_view)

        imageView.setImageResource(mImagesIds!![mListIndex])

        if (mImagesIds != null) {
            imageView.setOnClickListener {
                if (mListIndex < mImagesIds!!.size - 1) {
                    mListIndex++
                } else {
                    mListIndex = 0
                }
                imageView.setImageResource(mImagesIds!![mListIndex])
            }
        } else {
            Log.i(LOG_TAG_BODY_FRAGMENT_PART, "ImagesIds is null, dude!")
        }
        return rootView
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, mImagesIds as ArrayList<Int>?)
        outState.putInt(LIST_INDEX, mListIndex)
    }

}