package com.example.taskmaster

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class TareasActivity : AppCompatActivity() {

    private lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tareas)

        textToSpeech = TextToSpeech(this) { status ->

            if (status == TextToSpeech.SUCCESS) {

                textToSpeech.language = Locale("es", "ES")

                val btnHablar = findViewById<Button>(R.id.btnHablar)

                btnHablar.setOnClickListener {

                    textToSpeech.speak(
                        "Organiza tus tareas del día",
                        TextToSpeech.QUEUE_FLUSH,
                        null,
                        "mensaje_tareas"
                    )
                }
            }
        }
    }

    override fun onDestroy() {

        if (::textToSpeech.isInitialized) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }

        super.onDestroy()
    }
}

