package com.miftahuraziz.bottomnavandfragment

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin: Button = findViewById(R.id.btn_login)
        val etEmail: EditText = findViewById(R.id.et_email)
        val etPassword: EditText = findViewById(R.id.et_password)
//        btnLogin.setOnClickListener(this)
        val email = etEmail.text
        val password = etPassword.text

        btnLogin.setOnClickListener {
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Masukkan Email dan Password", Toast.LENGTH_SHORT).show()
            }
            else {
//                if(email.equals("miftahur") || password.equals("123")) {
                val moveIntent = Intent(this@MainActivity, FragmentActivity::class.java)
//                moveIntent.putExtra("EXTRA_EMAIL", "$email")
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                startActivity(moveIntent)
                finish()
//                }
            }
        }
    }
}