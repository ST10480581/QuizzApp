package vcmsa.nika.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "The Earth is flat",
        "Albert Einstein developed the theory of relativity",
        "The Great Wall of China is visible from space",
        "The Titanic sank in 1912"
    )

    private val answers = arrayOf(true, false, true, false, true)
    private var currentQuestionIndex = 0
    private var score = 0

    private lateinit var tvQuizQuestion: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var rbtnTrue: RadioButton
    private lateinit var rbtnFalse: RadioButton
    private lateinit var btnNextQuestion: Button
    private lateinit var rbtngQuizAnswers: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Initialize views
        tvQuizQuestion = findViewById(R.id.tvQuizQuestion)
        tvFeedback = findViewById(R.id.tvFeedback)
        rbtnTrue = findViewById(R.id.rbtnTrue)
        rbtnFalse = findViewById(R.id.rbtnFalse)
        btnNextQuestion = findViewById(R.id.btnNextQuestion)
        rbtngQuizAnswers = findViewById(R.id.rbtngQuizAnswers)

        // Display the first question
        tvQuizQuestion.text = questions[currentQuestionIndex]
        tvFeedback.text = "" // Clear feedback initially

        // Disable Next button until an answer is selected
        btnNextQuestion.isEnabled = false

        // Set listeners for the radio buttons (True/False)
        rbtnTrue.setOnClickListener {
            checkAnswer(true)
        }

        rbtnFalse.setOnClickListener {
            checkAnswer(false)
        }

        // Set listener for the Next button
        btnNextQuestion.setOnClickListener {
            nextQuestion()
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        // Get the correct answer for the current question
        val correctAnswer = answers[currentQuestionIndex]

        // Check if the answer is correct
        if (userAnswer == correctAnswer) {
            score++
            tvFeedback.text = "Correct!"
        } else {
            tvFeedback.text = "Incorrect"
        }

        // Disable radio buttons after selection
        rbtnTrue.isEnabled = false
        rbtnFalse.isEnabled = false

        // Enable Next button after an answer is selected
        btnNextQuestion.isEnabled = true
    }

    private fun nextQuestion() {
        currentQuestionIndex++

        if (currentQuestionIndex < questions.size) {
            tvQuizQuestion.text = questions[currentQuestionIndex]
            tvFeedback.text = ""

            rbtnTrue.isEnabled = true
            rbtnFalse.isEnabled = true

            btnNextQuestion.isEnabled = false

            rbtngQuizAnswers.clearCheck()
        } else {
            navigateToScoreScreen()
        }
    }

    private fun navigateToScoreScreen() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("SCORE", score)
        startActivity(intent)
        finish()
    }
}


