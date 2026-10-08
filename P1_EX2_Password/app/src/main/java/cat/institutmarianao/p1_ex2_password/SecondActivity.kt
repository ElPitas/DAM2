package cat.institutmarianao.p1_ex2_password

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textoInicio = findViewById<TextView>(R.id.welcomeText)

        textoInicio.text = "Welcome " + intent.extras?.getString("username")
    }
}