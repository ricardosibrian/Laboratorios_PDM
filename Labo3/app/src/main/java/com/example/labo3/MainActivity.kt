package com.example.labo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var fiveCents: ImageView
    private lateinit var tenCents: ImageView
    private lateinit var quarter: ImageView
    private lateinit var dollar: ImageView
    private lateinit var moneyText: TextView

    // data element
    private var moneyCount:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fiveCents = findViewById(R.id.imageView)
        tenCents = findViewById(R.id.imageView2)
        quarter = findViewById(R.id.imageView3)
        dollar = findViewById(R.id.imageView4)
        moneyText = findViewById(R.id.textView2)

        fiveCents.setOnClickListener {
            moneyCount = moneyCount + 0.05
            moneyCount = (moneyCount * 10000).roundToInt().toDouble() / 10000
            moneyText.text = "$" + moneyCount.toString()
        }

        tenCents.setOnClickListener {
            moneyCount = moneyCount + 0.10
            moneyCount = (moneyCount * 10000).roundToInt().toDouble() / 10000
            moneyText.text = "$" + moneyCount.toString()
        }

        quarter.setOnClickListener {
            moneyCount = moneyCount + 0.25
            moneyCount = (moneyCount * 10000).roundToInt().toDouble() / 10000
            moneyText.text = "$" + moneyCount.toString()
        }

        dollar.setOnClickListener {
            moneyCount = moneyCount + 1
            moneyCount = (moneyCount * 10000).roundToInt().toDouble() / 10000
            moneyText.text = "$" + moneyCount.toString()
        }
    }
}