package cat.institutmarianao.lordoftherings

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //-------------------- CONSTANTS ---------------------------------
        val nameText = findViewById<EditText>(R.id.nombreText)
        val nextButton = findViewById<Button>(R.id.button)

        //------------------- CHANGES BUTTON VISIBILITY ------------------
        buttonVisibility(nameText, nextButton)
        //------------------- ONCLICK LISTENER PROPERTY ------------------
        buttonListener(nextButton, nameText)

    }

    private fun buttonListener(nextButton: Button, nameText: EditText) {
        nextButton.setOnClickListener {
            var name = nameText.text.toString().trim();
            intent = Intent(this, WelcomeActivity::class.java).apply {
                putExtra("name", name)
            }
            startActivity(intent)
        }
    }

    private fun buttonVisibility(nameText: EditText, nextButton: Button) {
        nameText.doOnTextChanged { text, _, _, _ ->
            if (text.isNullOrEmpty() || !text.matches(Regex("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))) {
                nextButton.visibility = View.GONE
            } else {
                nextButton.visibility = View.VISIBLE
            }
        }
    }
}