package vcmsa.nika.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val tvScore: TextView = findViewById(R.id.tvScore)
        val btnReview: Button = findViewById(R.id.btnReview)
        val btnExit: Button = findViewById(R.id.btnExit)

        val score = intent.getIntExtra("SCORE", 0)

        tvScore.text = "Your score: $score / 5"

        val feedback = when {
            score >= 3 -> "Great job!"
            score >= 1 -> "Keep practicing!"
            else -> "Better luck next time!"
        }

        tvScore.append("\n$feedback")

        btnReview.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}
