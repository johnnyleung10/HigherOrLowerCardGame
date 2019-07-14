package com.example.higherorlowercards

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bank.*
import kotlinx.android.synthetic.main.activity_card_game_solo.*
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import kotlin.math.roundToInt

class CardGameActivitySolo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_game_solo)



        //Initialize Program with set variables and functions

        //Before rounding
        var betInitial: Double

        //After rounding
        var betFinal = 0

        //Create and display first card
        var firstCard = CardCreator.cardMaker()
        when (CardCreator.cardNum(firstCard)){
            1 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.aced))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.acec))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.aceh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.aces))
                }
            }
            2 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.twod))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.twoc))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.twoh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.twos))
                }
            }
            3 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.threed))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.threec))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.threeh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.threes))
                }
            }
            4 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.fourd))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.fourc))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.fourh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.fours))
                }
            }
            5 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.fived))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.fivec))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.fiveh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.fives))
                }
            }
            6 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.sixd))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.sixc))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.sixh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.sixs))
                }
            }
            7 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.sevend))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.sevenc))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.sevenh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.sevens))
                }
            }
            8 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.eightd))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.eightc))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.eighth))
                    "spades" -> (imageCard1.setImageResource(R.drawable.eights))
                }
            }
            9 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.nined))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.ninec))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.nineh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.nines))
                }
            }
            10 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.tend))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.tenc))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.tenh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.tens))
                }
            }
            11 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.jackd))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.jackc))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.jackh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.jacks))
                }
            }
            12 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.queend))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.queenc))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.queenh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.queens))
                }
            }
            13 -> {
                when(CardCreator.cardSuit(firstCard)){
                    "diamonds" -> (imageCard1.setImageResource(R.drawable.kingd))
                    "clubs" -> (imageCard1.setImageResource(R.drawable.kingc))
                    "hearts" -> (imageCard1.setImageResource(R.drawable.kingh))
                    "spades" -> (imageCard1.setImageResource(R.drawable.kings))
                }
            }

        }

        //Reset game to beginning
        fun resetGame(){

            //Redistribute first card
            firstCard = CardCreator.cardMaker()

            when (CardCreator.cardNum(firstCard)){
                1 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.aced))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.acec))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.aceh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.aces))
                    }
                }
                2 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.twod))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.twoc))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.twoh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.twos))
                    }
                }
                3 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.threed))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.threec))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.threeh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.threes))
                    }
                }
                4 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.fourd))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.fourc))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.fourh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.fours))
                    }
                }
                5 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.fived))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.fivec))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.fiveh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.fives))
                    }
                }
                6 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.sixd))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.sixc))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.sixh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.sixs))
                    }
                }
                7 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.sevend))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.sevenc))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.sevenh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.sevens))
                    }
                }
                8 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.eightd))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.eightc))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.eighth))
                        "spades" -> (imageCard1.setImageResource(R.drawable.eights))
                    }
                }
                9 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.nined))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.ninec))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.nineh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.nines))
                    }
                }
                10 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.tend))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.tenc))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.tenh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.tens))
                    }
                }
                11 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.jackd))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.jackc))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.jackh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.jacks))
                    }
                }
                12 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.queend))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.queenc))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.queenh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.queens))
                    }
                }
                13 -> {
                    when(CardCreator.cardSuit(firstCard)){
                        "diamonds" -> (imageCard1.setImageResource(R.drawable.kingd))
                        "clubs" -> (imageCard1.setImageResource(R.drawable.kingc))
                        "hearts" -> (imageCard1.setImageResource(R.drawable.kingh))
                        "spades" -> (imageCard1.setImageResource(R.drawable.kings))
                    }
                }
            }
            //Empty spot for second card
            imageCard2.setImageResource(0)

            //Set seekbar back to 0
            seekBarBet.progress = 0

            //Reset bet text
            textBetVal.text = "Bet Amount: $0.00"
        }

        //Creates a screen if guessed incorrectly
        fun incorrectWindow(hiLow: String, value: String){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Incorrect!")
            builder.setMessage("The next card was actually $hiLow, you have lost $$value.00.")

            builder.setOnDismissListener {
                resetGame()
            }

            builder.show()
        }

        //Creates a screen if guessed correctly
        fun correctWindow(hiLow: String, value: String){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Correct!")
            builder.setMessage("The next card was $hiLow, you have earned $$value.00.")

            builder.setOnDismissListener {
                resetGame()
            }

            builder.show()
        }

        //Returns current bank balance
        fun getBankBalance():String {
            var fileInputStream: FileInputStream? = null
            fileInputStream = openFileInput("BankBalance.txt")
            var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }
            d("returnMessage", "returning bank balance of $stringBuilder")
            return(stringBuilder.toString())
        }

        //Change bank balance
        fun setBankBalance(amount: String){
            val fileOutputStream: FileOutputStream
            try {
                fileOutputStream = openFileOutput("BankBalance.txt", Context.MODE_PRIVATE)
                fileOutputStream.write(amount.toByteArray())
                d("Amount", "Bank balance set to $amount")
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        //Set initial bank balance
        textCurrentBalance.text = "Balance: $" +("%.2f".format(getBankBalance().toDouble()))

        //Check to see if user has any money
        fun checkUserBalance() {
            if (getBankBalance().toDouble() == 0.0) {
                seekBarBet.isEnabled = false

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Out of funds!")
                builder.setMessage("You are out of funds, visit the bank to get more money.")
                builder.show()

            }


        }

        checkUserBalance()

        //Button lower functions
        buttonLower.setOnClickListener {
            var secondCard = CardCreator.cardMaker()

            while (secondCard == firstCard){
                secondCard = CardCreator.cardMaker()
            }

            when (CardCreator.cardNum(secondCard)){
                1 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.aced))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.acec))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.aceh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.aces))
                    }
                }
                2 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.twod))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.twoc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.twoh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.twos))
                    }
                }
                3 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.threed))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.threec))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.threeh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.threes))
                    }
                }
                4 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.fourd))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.fourc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.fourh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.fours))
                    }
                }
                5 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.fived))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.fivec))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.fiveh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.fives))
                    }
                }
                6 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.sixd))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.sixc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.sixh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.sixs))
                    }
                }
                7 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.sevend))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.sevenc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.sevenh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.sevens))
                    }
                }
                8 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.eightd))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.eightc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.eighth))
                        "spades" -> (imageCard2.setImageResource(R.drawable.eights))
                    }
                }
                9 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.nined))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.ninec))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.nineh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.nines))
                    }
                }
                10 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.tend))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.tenc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.tenh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.tens))
                    }
                }
                11 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.jackd))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.jackc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.jackh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.jacks))
                    }
                }
                12 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.queend))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.queenc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.queenh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.queens))
                    }
                }
                13 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.kingd))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.kingc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.kingh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.kings))
                    }
                }
            }

            if (CardCreator.isSmaller(secondCard, firstCard)){
                //Correct
                correctWindow("lower", betFinal.toString())
                var BANK_BALANCE = getBankBalance().toDouble()
                BANK_BALANCE += betFinal
                setBankBalance(BANK_BALANCE.toString())
            }

            else {
                //Incorrect
                incorrectWindow("higher", betFinal.toString())
                var BANK_BALANCE = getBankBalance().toDouble()
                BANK_BALANCE -= betFinal
                setBankBalance(BANK_BALANCE.toString())
                checkUserBalance()
            }

            //Change Bank Balance
            textCurrentBalance.text = "Balance: $" +("%.2f".format(getBankBalance().toDouble()))


        }

        //Button higher functions
        buttonHigher.setOnClickListener{
            var secondCard = CardCreator.cardMaker()


            while (secondCard == firstCard){
                secondCard = CardCreator.cardMaker()
            }

            when (CardCreator.cardNum(secondCard)){
                1 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.aced))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.acec))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.aceh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.aces))
                    }
                }
                2 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.twod))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.twoc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.twoh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.twos))
                    }
                }
                3 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.threed))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.threec))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.threeh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.threes))
                    }
                }
                4 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.fourd))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.fourc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.fourh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.fours))
                    }
                }
                5 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.fived))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.fivec))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.fiveh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.fives))
                    }
                }
                6 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.sixd))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.sixc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.sixh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.sixs))
                    }
                }
                7 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.sevend))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.sevenc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.sevenh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.sevens))
                    }
                }
                8 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.eightd))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.eightc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.eighth))
                        "spades" -> (imageCard2.setImageResource(R.drawable.eights))
                    }
                }
                9 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.nined))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.ninec))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.nineh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.nines))
                    }
                }
                10 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.tend))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.tenc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.tenh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.tens))
                    }
                }
                11 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.jackd))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.jackc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.jackh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.jacks))
                    }
                }
                12 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.queend))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.queenc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.queenh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.queens))
                    }
                }
                13 -> {
                    when(CardCreator.cardSuit(secondCard)){
                        "diamonds" -> (imageCard2.setImageResource(R.drawable.kingd))
                        "clubs" -> (imageCard2.setImageResource(R.drawable.kingc))
                        "hearts" -> (imageCard2.setImageResource(R.drawable.kingh))
                        "spades" -> (imageCard2.setImageResource(R.drawable.kings))
                    }
                }
            }

            if (CardCreator.isLarger(secondCard, firstCard)){
                //Correct
                correctWindow("higher", betFinal.toString())
                var BANK_BALANCE = getBankBalance().toDouble()
                BANK_BALANCE += betFinal
                setBankBalance(BANK_BALANCE.toString())
            }

            else {
                //Incorrect
                incorrectWindow("lower", betFinal.toString())
                var BANK_BALANCE = getBankBalance().toDouble()
                BANK_BALANCE -= betFinal
                setBankBalance(BANK_BALANCE.toString())
                checkUserBalance()
            }

            //Change Bank Balance
            textCurrentBalance.text = "Balance: $" +("%.2f".format(getBankBalance().toDouble()))
        }

        //Seekbar functions
        seekBarBet.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b : Boolean){
                d("Progress", (i/100.0).toString())

                betInitial = (i/100.0) * getBankBalance().toDouble()

                betFinal = betInitial.roundToInt()

                textBetVal.text = "Bet Amount: $" +betFinal +".00"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(this@CardGameActivitySolo, "Bet of $" +betFinal +".00 is made.", Toast.LENGTH_SHORT).show()
            }
        })

        //Return to MainActivity
        buttonBackToMain.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }


    }

}





