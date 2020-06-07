package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view:View){
        val buttonSelected = view as Button
        var cellId = 0
        when (buttonSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9

        }
        startGame(buttonSelected, cellId)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var active = 1

    private fun startGame(buttonSelected: Button, cellId: Int) {
        if(active == 1){
            buttonSelected.text = "X"
            buttonSelected.setBackgroundColor(Color.parseColor("#009191"))
            player1.add(cellId)
            active = 2
        }
        else {
            buttonSelected.text = "O"
            buttonSelected.setBackgroundColor(Color.parseColor("#ff9320"))
            player2.add(cellId)
            active = 1
        }

        buttonSelected.isEnabled = false
        checkWinner()

    }

    private fun checkWinner() {
        var winner = -1
        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        //col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        //row 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        if(winner != -1 ){
            if(winner == 1){
                Toast.makeText(this , "Player 1 won the game" , Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this , "Player 2 won the game" , Toast.LENGTH_LONG).show()

            }
        }
    }
}
