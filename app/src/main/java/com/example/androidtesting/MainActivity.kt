package com.example.androidtesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editTextName: EditText
    lateinit var editTextTextEmailAddress: EditText
    lateinit var editTextPassword: EditText
    lateinit var editTextConfirmPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        button = findViewById(R.id.button)
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)
        editTextPassword = findViewById(R.id.editTextTextPassword)
        editTextConfirmPassword = findViewById(R.id.editTextTextPassword2)
        editTextName = findViewById(R.id.editTextTextPersonName2)
        button.setOnClickListener {
            validateRegistrationDetails(
                editTextName.text.toString(),
                editTextTextEmailAddress.text.toString(),
                editTextPassword.text.toString(),
                editTextConfirmPassword.text.toString()
            )
        }
    }

    companion object
    {
        fun validateRegistrationDetails(
            name: String,
            emailAddress: String,
            password: String,
            confirmPassword: String
        ): Boolean {
            if (name == null || name.isEmpty()|| name.length < 6) {
                return false
            }
            val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$"

            val pat: Pattern = Pattern.compile(emailRegex)
            if (emailAddress == null ||emailAddress.isEmpty())
                return false
            else if (!pat.matcher(emailAddress).matches())
                return false
            if (password == null||password.isEmpty() || password.length < 8) {
                return false
            }
            if (confirmPassword == null||confirmPassword.isEmpty() || confirmPassword != password) {
                return false
            }
            return true
        }
    }


}