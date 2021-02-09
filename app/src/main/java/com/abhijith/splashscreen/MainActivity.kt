package com.abhijith.splashscreen

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val tv:TextView by lazy {
        findViewById(R.id.tv)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        val animationHide = AnimationUtils.loadAnimation(this, R.anim.hide);
        animationBounce.duration = 650
        animationHide.duration = 250
        animationHide.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                tv.visibility = View.GONE
                exitReveal()
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
        animationBounce.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                tv.startAnimation(animationHide)

            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
        tv.startAnimation(animationBounce)
    }

    fun exitReveal() {
        val myView: View = findViewById(R.id.splash_screen)
        myView.post {
            val cx: Int = myView.measuredWidth / 2
//            val cy: Int = myView.measuredHeight-(myView.width/2)
            val cy: Int = myView.measuredHeight-80
            val initialRadius: Int = myView.height
            val anim = ViewAnimationUtils.createCircularReveal(
                myView,
                cx,
                cy,
                initialRadius.toFloat(),
                0f
            )

            anim.interpolator= AccelerateDecelerateInterpolator()
            anim.duration = 500
            anim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    myView.visibility = View.INVISIBLE
//                    val centerx: Int = cx
//                    val centery: Int = myView.measuredHeight - 80
//                    val initialRadiusNew: Int = myView.width / 2
//                    val anim2 = ViewAnimationUtils.createCircularReveal(
//                        myView,
//                        centerx,
//                        centery,
//                        initialRadiusNew.toFloat(),
//                        0f
//                    )
//                    anim2.start()
                }

            })
            anim.start()
        }
    }

}