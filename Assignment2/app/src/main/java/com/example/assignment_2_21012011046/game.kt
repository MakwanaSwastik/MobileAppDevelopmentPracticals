package com.example.assignment_2_21012011046

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class game : AppCompatActivity() {

    private val grid = Array(9) { 0 }
    private var p1: Int = 1 // Player 1 is X
    private var p2: Int = 2 // Player 2 is O
    private var currentPlayer = p1 // Start with Player 1
    private var gameOver = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val button: MaterialButton= findViewById(R.id.home)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val winText: TextView = findViewById(R.id.win)

        val resetButton: MaterialButton = findViewById(R.id.resetButton)
        resetButton.setOnClickListener {
            // Reset the game
            resetGame()
        }
        for (i in 0 until 9) {
            val imageViewId = resources.getIdentifier("imageView$i", "id", packageName)
            val imageView: ImageView = findViewById(imageViewId)
            imageView.setOnClickListener {
                if (!gameOver && grid[i] == 0) {
                    if (currentPlayer == p1) {
                        imageView.setImageResource(R.drawable.x)
                        grid[i] = p1
                        currentPlayer = p2
                    } else {
                        imageView.setImageResource(R.drawable.o)
                        grid[i] = p2
                        currentPlayer = p1
                    }

                    val winner = checkWinner()
                    if (winner != 0) {
                        gameOver = true
                        if (winner == p1) {
                            winText.text = "Player X wins!"
                        } else if (winner == p2) {
                            winText.text = "Player O wins!"
                        } else {
                            winText.text = "It's Tie Restart Again."
                        }
                    }
                }
            }
        }
    }

    private fun checkWinner(): Int {
        val winningCombination = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8),
            intArrayOf(0, 3, 6),
            intArrayOf(1, 4, 7),
            intArrayOf(2, 5, 8),
            intArrayOf(0, 4, 8),
            intArrayOf(2, 4, 6)
        )

        for (combination in winningCombination) {
            if (grid[combination[0]] == grid[combination[1]] && grid[combination[1]] == grid[combination[2]] && grid[combination[0]] != 0) {
                return grid[combination[0]]
            }
        }

        if (grid.all { it != 0 }) {
            return 3 // A draw
        }

        return 0
    }

    private fun resetGame() {
        for (i in 0 until 9) {
            val imageViewId = resources.getIdentifier("imageView$i", "id", packageName)
            val imageView: ImageView = findViewById(imageViewId)
            imageView.setImageResource(0) // Clear the image
            grid[i] = 0
        }

        gameOver = false
        currentPlayer = p1
        val winText: TextView = findViewById(R.id.win)
        winText.text = "Status"
    }
}