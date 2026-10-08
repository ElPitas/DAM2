package cat.institutmarianao.myfirebaseapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import kotlin.jvm.java



class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val createUserButton = findViewById<Button>(R.id.createUserButton)



        loginButton.setOnClickListener {
            loginForm(emailEditText, passwordEditText)
        }
        createUserButton.setOnClickListener {
            createUserForm(emailEditText, passwordEditText)
        }
    }


    private fun loginForm(emailEditText: EditText, passwordEditText: EditText) {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        login(email, password)
    }
    private fun createUserForm(emailEditText: EditText, passwordEditText: EditText){
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        createUser(email, password)
    }


    private fun createUser(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "User successfully created!", Toast.LENGTH_SHORT).show()
                    login(email,password)
                } else {
                    Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                this, "Email and password required", Toast.LENGTH_SHORT
            ).show()
            return
        }


        // * Firebase login * //
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        this,
                        "Welcome ${FirebaseAuth.getInstance().currentUser?.email}",
                        Toast.LENGTH_SHORT
                    ).show()
                    val mail = Intent(this, ClientsActivity::class.java).apply {
                        putExtra("mail", email)
                    }

                    startActivity(mail)
                } else {
                    Toast.makeText(
                        this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}