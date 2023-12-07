package by.vjacheslavkovalenko.radionewark

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//https://streamer.radionewark.com/
    //две нижеидущие строчки-для другого приложения, с двумя радиостанциями
   // private lateinit var ButtonAstronomy: Button
    //private lateinit var ButtonRadionewark: Button

    private lateinit var buttonPlay: Button
    private lateinit var buttonPause: Button
   // private lateinit var ButtonAbout: Button

    private lateinit var mediaPlayer: MediaPlayer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlay = findViewById(R.id.buttonPlay)
        buttonPause = findViewById(R.id.buttonPause)


        RadioLaInolvidable()

    }

    private fun RadioLaInolvidable() {

        val url = "https://streamer.radionewark.com/";

        mediaPlayer = MediaPlayer()

        mediaPlayer.setDataSource(url)
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayer.prepareAsync()

        mediaPlayer.setOnPreparedListener {

            setOnClickListeners(this)
        }
    }

    private fun setOnClickListeners(context: Context) {
        buttonPlay.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(context, "Запуск радиостанции || Play... ", Toast.LENGTH_SHORT).show()
        }

        buttonPause.setOnClickListener {
            mediaPlayer.pause()
            Toast.makeText(context, "Пауза...", Toast.LENGTH_SHORT).show()
        }


    }
}