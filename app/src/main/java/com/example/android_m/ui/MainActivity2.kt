package com.example.android_m.ui

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.android_m.R
import com.example.android_m.data.AndroidImageAssets
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_master_list.*

class MainActivity2 : AppCompatActivity(), MasterListFragment.OnImageClickListener{

    var headIndex = 0
    var bodyIndex = 0
    var legIndex = 0
    var isTwoPane = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if(findViewById<ConstraintLayout>(R.id.android_me_layout) != null){
            isTwoPane = true

            btnNext.visibility = View.GONE
            images_grid_view.numColumns = 2

            if (savedInstanceState == null) {

                var indexHead = intent.getIntExtra("headIndex",0)
                var indexBody = intent.getIntExtra("bodyIndex",0)
                var indexLeg = intent.getIntExtra("legIndex",0)

                var fragmentManager = supportFragmentManager

                var headFragment = BodyPartFragment()
                headFragment.mImagesIds = AndroidImageAssets.heads
                headFragment.mListIndex = indexHead

                fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit()

                var bodyFragment = BodyPartFragment()
                bodyFragment.mImagesIds = AndroidImageAssets.body
                bodyFragment.mListIndex = indexBody

                fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit()

                var legFragment = BodyPartFragment()
                legFragment.mImagesIds = AndroidImageAssets.legs
                legFragment.mListIndex = indexLeg

                fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit()
            }

        }else{
            isTwoPane = false
        }
    }

    override fun onImageSelected(position: Int) {
        var bodyPartNumber = position/12
        val listIndex = position - 12 * bodyPartNumber

        if(isTwoPane){
            var bodyPartFragment = BodyPartFragment()
            var fragmentManager = supportFragmentManager

            when(bodyPartNumber){
                0 -> {
                    bodyPartFragment.mImagesIds = AndroidImageAssets.heads
                    bodyPartFragment.mListIndex = listIndex
                    fragmentManager.beginTransaction()
                        .replace(R.id.head_container, bodyPartFragment)
                        .commit()
                }
                1 -> {
                    bodyPartFragment.mImagesIds = AndroidImageAssets.body
                    bodyPartFragment.mListIndex = listIndex
                    fragmentManager.beginTransaction()
                        .replace(R.id.body_container, bodyPartFragment)
                        .commit()
                }
                2 -> {
                    bodyPartFragment.mImagesIds = AndroidImageAssets.legs
                    bodyPartFragment.mListIndex = listIndex
                    fragmentManager.beginTransaction()
                        .replace(R.id.leg_container, bodyPartFragment)
                        .commit()
                }
            }
        }else{

            when(bodyPartNumber){
                0 -> headIndex = listIndex
                1-> bodyIndex = listIndex
                2 -> legIndex = listIndex
            }

            var bundle = Bundle()

            bundle.putInt("headIndex", headIndex)
            bundle.putInt("bodyIndex", bodyIndex)
            bundle.putInt("legIndex", legIndex)

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtras(bundle)

            btnNext.setOnClickListener {
                startActivity(intent)
            }
        }
    }

}