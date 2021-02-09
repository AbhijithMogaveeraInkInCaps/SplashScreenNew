//package com.abhijith.splashscreen
//
//import android.R
//import android.annotation.TargetApi
//import android.content.Context
//import android.os.Build
//import android.os.Bundle
//import android.util.AttributeSet
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//
//
//class CustomImageView(context: Context?, attrs: AttributeSet?) : ImageView(context, attrs) {
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view: View = inflater.inflate(R.layout.fragment_map_list, container, false)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            view.addOnLayoutChangeListener(object : OnLayoutChangeListener() {
//                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//                override fun onLayoutChange(
//                    v: View,
//                    left: Int,
//                    top: Int,
//                    right: Int,
//                    bottom: Int,
//                    oldLeft: Int,
//                    oldTop: Int,
//                    oldRight: Int,
//                    oldBottom: Int
//                ) {
//                    v.removeOnLayoutChangeListener(this)
//                    toggleInformationView(view)
//                }
//            })
//        }
//        return view
//    }
//}