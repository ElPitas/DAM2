package cat.institutmarianao.constrintlayout

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var boton = findViewById<Button>(R.id.button)
        var to = findViewById<EditText>(R.id.email)
        var subject = findViewById<EditText>(R.id.subject)
        var message = findViewById<EditText>(R.id.message)

        boton.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("To", to.getText().toString());
                putExtra("Subject", subject.getText().toString());
                putExtra("Message", message.getText().toString());
            }
            startActivity(intent)


        }

    }

}