package cat.institutmarianao.p1_ex2_password

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val errorMessage = findViewById<TextView>(R.id.errorMessage)

        loginButton.setOnClickListener {
            val username = findViewById<EditText>(R.id.username).text.toString()
            val password = findViewById<EditText>(R.id.password).text.toString().trim()

            if(("abc123") == password){
                intent = Intent(this, SecondActivity::class.java).apply {
                    intent.putExtra("username", username)
                }
                startActivity(intent)
            }else{
                errorMessage.visibility = View.VISIBLE
            }
        }


    }
}