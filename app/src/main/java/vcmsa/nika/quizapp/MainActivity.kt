package vcmsa.nika.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.btnStartQuiz)

        startButton.setOnClickListener {
            // Start QuizActivity when the button is clicked
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}
