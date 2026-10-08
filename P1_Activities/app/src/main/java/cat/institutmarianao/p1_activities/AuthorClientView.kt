package cat.institutmarianao.p1_activities

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AuthorClientView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_client_view)

        val buttonBack = findViewById<Button>(R.id.backButton)
        buttonBack.setOnClickListener {
            finish()
        }
    }


}