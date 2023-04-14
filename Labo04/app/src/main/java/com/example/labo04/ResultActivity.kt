package com.example.labo04

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity: AppCompatActivity() {

    private lateinit var name1: TextView
    private lateinit var email1: TextView
    private lateinit var number1: TextView
    private lateinit var button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        bind()
        addListener()

        supportActionBar!!.hide()

                val name = intent.getStringExtra("name").toString()
                val email = intent.getStringExtra("email").toString()
                val number = intent.getStringExtra("number").toString()

        name1.text = name
        email1.text = email
        number1.text = number

    }

    private fun bind(){
        name1 = findViewById(R.id.name_view)
        email1 = findViewById(R.id.email_view)
        number1 = findViewById(R.id.number_view)
        button1 = findViewById(R.id.button_share)
    }

    private fun addListener() {
        button1.setOnClickListener { share()}
    }



    private fun share() {
        val name = name1.text
        val email = email1.text
        val phone = number1.text
        val intent = Intent().apply{
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,"${name} \n${email}\n${phone}")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(intent, null)
        startActivity(shareIntent)
        }

}