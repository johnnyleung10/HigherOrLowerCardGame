package com.example.higherorlowercards


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Writes data to the file
        fun writeToFile(file:String, data:String) {
            val fileOutputStream: FileOutputStream
            try {
                fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                fileOutputStream.write(data.toByteArray())
            } catch (e: Exception) {
                e.printStackTrace()
            }
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
            d("returnMessage", "returning bank balance of ${stringBuilder.toString()}")
            return(stringBuilder.toString())
        }

        //Change bank balance
        fun setBankBalance(amount: String){
            val fileOutputStream:FileOutputStream
            try {
                fileOutputStream = openFileOutput("BankBalance.txt", Context.MODE_PRIVATE)
                fileOutputStream.write(amount.toByteArray())
                d("Amount", "Bank balance set to $amount")
            }catch (e: Exception){
                e.printStackTrace()
            }
            textBalance.text = "Balance: $" +("%.2f".format(amount.toDouble()))
        }

        //Set up game with base variables
        try{
            d("Setup", "Balance Updated.")
            textBalance.text = "Balance: $" +("%.2f".format(getBankBalance().toDouble()))
        }catch (e:Exception){
            d("Exception", "Exception needed, set base values to $100.00")
            writeToFile("BankBalance.txt", "100.0")
        }



        buttonPlay.setOnClickListener {
            startActivity(Intent(this, CardGameActivitySolo::class.java))
        }

        buttonBank.setOnClickListener {
            startActivity(Intent(this, BankActivity::class.java))
        }
    }
}
