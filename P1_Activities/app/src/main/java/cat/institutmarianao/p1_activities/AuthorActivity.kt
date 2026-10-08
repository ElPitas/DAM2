package cat.institutmarianao.p1_activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AuthorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_layout)

        val authButton = findViewById<Button>(R.id.AuthButton)

        authButton.setOnClickListener {
            startActivity(Intent(this, AuthorClientView::class.java))
        }
    }
}