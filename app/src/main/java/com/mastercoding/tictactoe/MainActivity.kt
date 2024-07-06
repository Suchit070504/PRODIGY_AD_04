package com.mastercoding.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var player = "p1"

    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button
    private lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        btnReset = findViewById(R.id.btnReset)

        b1.setOnClickListener { buttonClick(b1) }
        b2.setOnClickListener { buttonClick(b2) }
        b3.setOnClickListener { buttonClick(b3) }
        b4.setOnClickListener { buttonClick(b4) }
        b5.setOnClickListener { buttonClick(b5) }
        b6.setOnClickListener { buttonClick(b6) }
        b7.setOnClickListener { buttonClick(b7) }
        b8.setOnClickListener { buttonClick(b8) }
        b9.setOnClickListener { buttonClick(b9) }
        btnReset.setOnClickListener { reset() }
    }

    private fun reset() {
        b1.text = ""
        b2.text = ""
        b3.text = ""
        b4.text = ""
        b5.text = ""
        b6.text = ""
        b7.text = ""
        b8.text = ""
        b9.text = ""

        enableButtons()
    }

    private fun enableButtons() {
        b1.isEnabled = true
        b2.isEnabled = true
        b3.isEnabled = true
        b4.isEnabled = true
        b5.isEnabled = true
        b6.isEnabled = true
        b7.isEnabled = true
        b8.isEnabled = true
        b9.isEnabled = true
    }

    private fun disableButtons() {
        b1.isEnabled = false
        b2.isEnabled = false
        b3.isEnabled = false
        b4.isEnabled = false
        b5.isEnabled = false
        b6.isEnabled = false
        b7.isEnabled = false
        b8.isEnabled = false
        b9.isEnabled = false
    }

    private fun buttonClick(btn: Button) {
        if (btn.text == "") {
            if (player == "p1") {
                player = "p2"
                btn.text = "X"
            } else {
                player = "p1"
                btn.text = "O"
            }
        }
        checkWin()
    }

    private fun checkWin() {
        val winningCombinations = arrayOf(
            arrayOf(b1, b2, b3), // Row 1
            arrayOf(b4, b5, b6), // Row 2
            arrayOf(b7, b8, b9), // Row 3
            arrayOf(b1, b4, b7), // Column 1
            arrayOf(b2, b5, b8), // Column 2
            arrayOf(b3, b6, b9), // Column 3
            arrayOf(b1, b5, b9), // Diagonal 1
            arrayOf(b3, b5, b7)  // Diagonal 2
        )

        for (combination in winningCombinations) {
            if (combination[0].text == combination[1].text &&
                combination[1].text == combination[2].text &&
                combination[0].text.isNotEmpty()
            ) {
                toast("${combination[0].text} won the game")
                disableButtons()
                return
            }
        }
    }

    private fun toast(msg: String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }
}
