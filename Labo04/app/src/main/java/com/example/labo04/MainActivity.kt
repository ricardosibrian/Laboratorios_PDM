package com.example.labo04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.labo04.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var number: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()

        supportActionBar!!.hide()
    }

    private fun bind(){
        name = findViewById(R.id.name_value)
        email = findViewById(R.id.email_value)
        number = findViewById(R.id.number_value)
        button = findViewById(R.id.button_save)
    }

    private fun addListener() {
    button.setOnClickListener() {
        var namePass = ""
        var emailPass = ""
        var numberPass = ""
        namePass = name.text.toString()
        emailPass = email.text.toString()
        numberPass = number.text.toString()

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("name", namePass)
        intent.putExtra("email", emailPass)
        intent.putExtra("number", numberPass)
        startActivity(intent)
    }
    }

}