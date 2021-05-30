package com.example.lotto

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}


        val lotteryNumbers = arrayListOf(number1, number2, number3, number4, number5, number6)

        val countDownTimer = object : CountDownTimer(3000, 100) {
            override fun onFinish() {
            }

            override fun onTick(p0: Long) {
                lotteryNumbers.forEach {
                    val randomNumber = (Math.random() * 45 + 1).toInt()
                    it.text = "$randomNumber"
                }
            }
        }
        lotteryButton.setOnClickListener{
            if (lotteryButton.isAnimating){
                lotteryButton.cancelAnimation()
                countDownTimer.cancel()
            } else {
                lotteryButton.playAnimation()
                countDownTimer.start()
            }
        }
    }
}
