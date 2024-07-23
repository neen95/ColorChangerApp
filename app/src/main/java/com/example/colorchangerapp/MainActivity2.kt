package com.example.colorchangerapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val btnChangeColor = findViewById<Button>(R.id.btnChangeColor)
        val rootView = findViewById<View>(R.id.rootView)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        btnChangeColor.setOnClickListener {
            val color = when (spinner.selectedItem.toString()) {
                "Red" -> Color.RED
                "Green" -> Color.GREEN
                "Blue" -> Color.BLUE
                else -> Color.WHITE
            }
            rootView.setBackgroundColor(color)
        }

        // Retrieve the message from the intent
        val message = intent.getStringExtra("message")
        message?.let {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}
