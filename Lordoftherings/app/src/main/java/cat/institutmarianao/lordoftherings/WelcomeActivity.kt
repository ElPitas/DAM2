package cat.institutmarianao.lordoftherings

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {

    //-------------------- CONSTANTS---------------------------------------
    val username = intent.extras?.getString("name")
    val lowername = username?.lowercase()?.trim()
    val nameMarker = findViewById<TextView>(R.id.nameMarker)
    val pointMarker = findViewById<TextView>(R.id.pointMarker)
    val logoutButton = findViewById<Button>(R.id.logoutButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        //-------------------- VARIABLES -----------------------------------------
        var points = "0"
        val diccionario = mapOf(
            "gandalf" to 315,
            "frodo" to 222,
            "saruman" to 489,
        )
        if(lowername in diccionario){
            points = diccionario.get(lowername).toString()
        }

        nameMarker.text = "Welcome, my Lord " + username
        pointMarker.text = "Your score is " + points

        logOut(logoutButton)

    }

    private fun logOut(logoutButton: Button) {
        logoutButton.setOnClickListener {
            finish()
        }
    }
}