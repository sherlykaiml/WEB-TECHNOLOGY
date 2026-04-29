package com.example.fontcolorapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        button.setOnClickListener {

            // Change font style
            textView.setTypeface(null, Typeface.BOLD_ITALIC)

            // Change text color
            textView.setTextColor(Color.BLUE)

            // Show Toast message
            Toast.makeText(
                this,
                "Font and Color Changed!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
