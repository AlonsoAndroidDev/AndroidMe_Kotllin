package com.example.android_m.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import com.example.android_m.R
import com.example.android_m.data.AndroidImageAssets
import java.lang.ClassCastException
import java.lang.Exception

class MasterListFragment : Fragment(){

    init {

    }

    var mCallback : OnImageClickListener? = null

    interface OnImageClickListener {
        fun onImageSelected(position: Int)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_master_list, container, false)
        val gridView = rootView.findViewById<GridView>(R.id.images_grid_view)

        val imagesIds = AndroidImageAssets.heads + AndroidImageAssets.body + AndroidImageAssets.legs
        val adapter = MasterListerAdapter(context!!, imagesIds)

        gridView.adapter = adapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            mCallback?.onImageSelected(position) }
        return rootView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        try {
            mCallback = context as OnImageClickListener
        }catch (ex : Exception){
            throw ClassCastException(context!!.toString() + " must implement OnImageClickListener")

        }
    }
}