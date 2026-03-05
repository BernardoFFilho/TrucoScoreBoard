package br.edu.ifsp.scl.sc3037291.trucoscoreboard

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvScoreA: TextView
    private lateinit var tvScoreB: TextView
    private lateinit var btnAddOneA: Button
    private lateinit var btnAddThreeA: Button
    private lateinit var btnAddOneB: Button
    private lateinit var btnAddThreeB: Button
    private lateinit var btnRestart: Button

    private var scoreA = 0
    private var scoreB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvScoreA = findViewById(R.id.tvScoreA)
        tvScoreB = findViewById(R.id.tvScoreB)
        btnAddOneA = findViewById(R.id.btnAddOneA)
        btnAddThreeA = findViewById(R.id.btnAddThreeA)
        btnAddOneB = findViewById(R.id.btnAddOneB)
        btnAddThreeB = findViewById(R.id.btnAddThreeB)
        btnRestart = findViewById(R.id.btnRestart)

        btnAddOneA.setOnClickListener { addPoints(teamA = true, points = 1) }
        btnAddThreeA.setOnClickListener { addPoints(teamA = true, points = 3) }
        btnAddOneB.setOnClickListener { addPoints(teamA = false, points = 1) }
        btnAddThreeB.setOnClickListener { addPoints(teamA = false, points = 3) }
        btnRestart.setOnClickListener { restartGame() }
    }

    private fun addPoints(teamA: Boolean, points: Int) {
        if (teamA) {
            scoreA = minOf(scoreA + points, 12)
        } else {
            scoreB = minOf(scoreB + points, 12)
        }

        updateScoreUI()
        checkGameState()
    }

    private fun updateScoreUI() {
        tvScoreA.text = scoreA.toString()
        tvScoreB.text = scoreB.toString()
    }

    private fun checkGameState() {
        when {
            scoreA >= 12 -> showGameOverDialog("Equipe A")
            scoreB >= 12 -> showGameOverDialog("Equipe B")
            scoreA == 11 -> showMaoDe11Dialog("Equipe A")
            scoreB == 11 -> showMaoDe11Dialog("Equipe B")
        }
    }

    private fun showMaoDe11Dialog(team: String) {
        AlertDialog.Builder(this)
            .setTitle("Mão de 11!")
            .setMessage("$team está na mão de 11!")
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showGameOverDialog(winner: String) {
        AlertDialog.Builder(this)
            .setTitle("Fim de Jogo!")
            .setMessage("$winner venceu a partida!")
            .setPositiveButton("Reiniciar") { _, _ -> restartGame() }
            .setCancelable(false)
            .show()

        disableButtons()
    }

    private fun disableButtons() {
        btnAddOneA.isEnabled = false
        btnAddThreeA.isEnabled = false
        btnAddOneB.isEnabled = false
        btnAddThreeB.isEnabled = false
    }

    private fun restartGame() {
        scoreA = 0
        scoreB = 0
        updateScoreUI()
        enableButtons()
    }

    private fun enableButtons() {
        btnAddOneA.isEnabled = true
        btnAddThreeA.isEnabled = true
        btnAddOneB.isEnabled = true
        btnAddThreeB.isEnabled = true
    }
}