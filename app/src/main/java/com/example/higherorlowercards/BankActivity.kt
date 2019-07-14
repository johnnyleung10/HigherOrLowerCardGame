package com.example.higherorlowercards

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bank.*
import kotlinx.android.synthetic.main.activity_bank.textBalance
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class BankActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)

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
            Log.d("returnMessage", "returning bank balance of ${stringBuilder.toString()}")
            return(stringBuilder.toString())
        }

        //Change bank balance
        fun setBankBalance(amount: String){
            val fileOutputStream: FileOutputStream
            try {
                fileOutputStream = openFileOutput("BankBalance.txt", Context.MODE_PRIVATE)
                fileOutputStream.write(amount.toByteArray())
                Log.d("Amount", "Bank balance set to $amount")
            }catch (e: Exception){
                e.printStackTrace()
            }
            textBalance.text = "Balance: $" +("%.2f".format(amount.toDouble()))
        }

        //Returns date of daily claim's last use
        fun getLastUsed():String {
            var fileInputStream: FileInputStream? = null
            fileInputStream = openFileInput("LastClaim.txt")
            var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }
            Log.d("returnMessage", "returning last claim of ${stringBuilder.toString()}")
            return(stringBuilder.toString())
        }

        //Change bank balance
        fun setLastUsed(date: String){
            val fileOutputStream: FileOutputStream
            try {
                fileOutputStream = openFileOutput("LastClaim.txt", Context.MODE_PRIVATE)
                fileOutputStream.write(date.toByteArray())
                Log.d("Amount", "Bank balance set to $date")
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        //Variable setup
        var BANK_BALANCE = getBankBalance().toDouble()
        textBalance.text = "Balance: $" +("%.2f".format(getBankBalance().toDouble()))

        try{
            getLastUsed()
        }catch (e: Exception){
            writeToFile("LastClaim.txt", "none")
        }


        buttonClaim.setOnClickListener{
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.BASIC_ISO_DATE
            val formatted = current.format(formatter)

            if (formatted.toString()==getLastUsed()) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Claim Unsuccessful")
                builder.setMessage("You have already claimed your free $50 dollars today. Come back tomorrow!")
                builder.show()
            }
            else {
                BANK_BALANCE += 50.00
                setBankBalance(BANK_BALANCE.toString())
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Claim Successful")
                builder.setMessage("Here is your free $50. Come back tomorrow!")
                builder.show()
                setLastUsed(formatted)
            }
        }

        buttonBack.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }







    }
}


