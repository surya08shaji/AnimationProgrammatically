package com.example.animexample

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun startAnimation(view: View){
        var dest = 0f
        val aniView:ImageView = findViewById<ImageView>(R.id.image)

        when(view.id) {
            R.id.zoomIn ->{
                dest = 360f
                if (aniView.rotation == 360f){
                    dest = 0f
                }
                val animation1 = ObjectAnimator.ofFloat(
                    aniView,"rotation", dest
                )
                animation1.duration = 2000
                animation1.start()
            }
            R.id.blink ->{
                val fade = ScaleAnimation(0f,1f,0f,1f,
                    Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,
                    0.5f)
                fade.duration = 1000
                fade.fillAfter = true
                aniView.startAnimation(fade)
            }

            R.id.zoomOut -> {
                dest = 1f
                if (aniView.alpha > 0){
                    dest = 0f
                }
                val animation2 = ObjectAnimator.ofFloat(
                    aniView,"alpha",dest
                )
                animation2.duration = 2000
                animation2.start()
            }

            R.id.fade -> {
                val fadeOut = ObjectAnimator.ofFloat(
                    aniView,"alpha",
                    0f
                )
                fadeOut.duration = 2000
                val mover = ObjectAnimator.ofFloat(
                    aniView,"translationX",
                    -500f,0f
                )
                mover.duration = 2000
                val fadeIn = ObjectAnimator.ofFloat(
                    aniView,"alpha",
                    0f,1f
                )
                fadeIn.duration = 2000
                val animatorSet = AnimatorSet()
                animatorSet.play(mover).with(fadeIn).after(fadeOut)
                animatorSet.start()
            }
            else ->{

            }
        }
    }
}

