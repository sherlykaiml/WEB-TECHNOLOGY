package com.example.emailsenderapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var subject: EditText
    private lateinit var message: EditText
    private lateinit var sendBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.email)
        subject = findViewById(R.id.subject)
        message = findViewById(R.id.message)
        sendBtn = findViewById(R.id.sendBtn)

        sendBtn.setOnClickListener {

            val emailText = email.text.toString().trim()
            val subjectText = subject.text.toString().trim()
            val messageText = message.text.toString().trim()

            if (emailText.isEmpty() || subjectText.isEmpty() || messageText.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(emailText))
                putExtra(Intent.EXTRA_SUBJECT, subjectText)
                putExtra(Intent.EXTRA_TEXT, messageText)
            }

            startActivity(Intent.createChooser(intent, "Send Email"))
        }
    }
}
