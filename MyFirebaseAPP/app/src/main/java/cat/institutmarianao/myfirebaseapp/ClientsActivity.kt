package cat.institutmarianao.myfirebaseapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.firestore.firestore
import com.google.firebase.Firebase


class ClientsActivity : AppCompatActivity() {
    private val db = Firebase.firestore

    private lateinit var recyclerView: RecyclerView
    private lateinit var clientAdapter: ClientAdapter
    private val clientList = mutableListOf<Client>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clients)

        // Set up RecyclerView
        recyclerView = findViewById(R.id.clientsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // The ClientAdapter get each element from the clientList and place it in the element layout (item_client)
        clientAdapter = ClientAdapter(clientList)
        recyclerView.adapter = clientAdapter

        // Load data from Firestore
        loadClientsFromFirestore()



        val logoutButton = findViewById<Button>(R.id.logoutButton)
        val newEntryButton = findViewById<Button>(R.id.newEntryButton)

        val name = findViewById<EditText>(R.id.name)
        val age = findViewById<EditText>(R.id.age)

        val bundle = intent.extras
        val mailText = bundle?.getString("mail").toString()

        logoutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
        }


        newEntryButton.setOnClickListener {
            val client = hashMapOf(
                "name" to name.getText().toString(),
                "email" to mailText,
                "age" to age.getText().toString().toIntOrNull()
            )

            db.collection("clients")
                .document(mailText)
                .set(client)
                .addOnSuccessListener {
                    Log.d("Firestore", "Document saved with ID: ${mailText}")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Error adding document", e)
                }
        }


    }

    private fun loadClientsFromFirestore() {
        // * Firestore get all documents from collection * //
        db.collection("clients").get().addOnSuccessListener { result ->
            clientList.clear() // clear list before get new data
            for (document in result) {
                val client = document.toObject(Client::class.java)
                clientList.add(client)
            }
            clientAdapter.notifyDataSetChanged() // refresh UI
        }.addOnFailureListener { exception ->
            Log.w("Firestore", "Error getting documents.", exception)
        }
    }


}