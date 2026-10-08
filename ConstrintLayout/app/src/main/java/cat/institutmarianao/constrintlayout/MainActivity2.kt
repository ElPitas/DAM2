package cat.institutmarianao.constrintlayout

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        var boton = findViewById<Button>(R.id.forwardButton)
        var backButton = findViewById<Button>(R.id.goBackButton)
        var to2 = findViewById<TextView>(R.id.to2)
        var subject2 = findViewById<TextView>(R.id.subject2)
        var message2 = findViewById<TextView>(R.id.message2)

        val toText = intent.getStringExtra("To")
        val subjectText = intent.getStringExtra("Subject")
        val messageText = intent.getStringExtra("Message")

        to2.text = toText
        subject2.text = subjectText
        message2.text = messageText



        backButton.setOnClickListener {

            finish()
        }
        boton.setOnClickListener {
            val newIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, toText) // recipients
                putExtra(Intent.EXTRA_SUBJECT,subjectText)
                putExtra(Intent.EXTRA_TEXT, messageText)
            }

            startActivity(Intent.createChooser(newIntent, "Enviar correo"))
        }
    }
}