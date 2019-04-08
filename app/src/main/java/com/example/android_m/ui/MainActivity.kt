package com.example.android_m.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.android_m.R
import com.example.android_m.data.AndroidImageAssets

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



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
    }
}
