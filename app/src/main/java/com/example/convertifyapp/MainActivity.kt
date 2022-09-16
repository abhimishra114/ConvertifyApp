package com.example.convertifyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup1: RadioGroup = findViewById(R.id.radio_group_1)
        val radioGroup2: RadioGroup = findViewById(R.id.radio_group_2)
        val enterText: TextView = findViewById(R.id.enter_textView)
        val inputText: EditText = findViewById(R.id.edit_text)
        val outputText: TextView = findViewById(R.id.textView_2)
        var output:TextView = findViewById(R.id.output)
        val convert:Button = findViewById(R.id.convert_button)
        val reset:Button = findViewById(R.id.reset_button)

        // This changes the input textview and the input format according to the radio button selected
        radioGroup1.setOnCheckedChangeListener { _, i ->
            var rb: RadioButton = findViewById(i)
            if (rb.id == R.id.binary_1){
                enterText.text = "Enter Binary Number: "
                inputText.setInputType(InputType.TYPE_CLASS_NUMBER)
            }
            if (rb.id == R.id.decimal_1){
                enterText.text = "Enter Decimal Number: "
                inputText.setInputType(InputType.TYPE_CLASS_NUMBER)
            }
            if (rb.id == R.id.octal_1){
                enterText.text = "Enter Octal Number: "
                inputText.setInputType(InputType.TYPE_CLASS_NUMBER)
            }
            if (rb.id == R.id.hex_1){
                enterText.text = "Enter Hexadecimal Number: "
                inputText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS)
            }
        }
        // This changes the output text view according to the radio button selected
        radioGroup2.setOnCheckedChangeListener { _, i ->
            var rb: RadioButton = findViewById(i)
            if (rb.id == R.id.binary_2){
                outputText.text = "Binary: "
            }
            if (rb.id == R.id.decimal_2){
                outputText.text = "Decimal: "
            }
            if (rb.id == R.id.octal_2){
                outputText.text = "Octal: "
            }
            if (rb.id == R.id.hex_2){
                outputText.text = "Hexadecimal: "
            }
        }
        // initialising buttons of the left side
        var fb1:RadioButton = findViewById(R.id.binary_1)
        var fb2:RadioButton = findViewById(R.id.decimal_1)
        var fb3:RadioButton = findViewById(R.id.octal_1)
        var fb4:RadioButton = findViewById(R.id.hex_1)

        // initialising buttons of the right side
        var tb1:RadioButton = findViewById(R.id.binary_2)
        var tb2:RadioButton = findViewById(R.id.decimal_2)
        var tb3:RadioButton = findViewById(R.id.octal_2)
        var tb4:RadioButton = findViewById(R.id.hex_2)

        // This code gives functionality to the reset button
        reset.setOnClickListener {
            fb1.isChecked = false
            fb2.isChecked = false
            fb3.isChecked = false
            fb4.isChecked = false

            tb1.isChecked = false
            tb2.isChecked = false
            tb3.isChecked = false
            tb4.isChecked = false

            enterText.text = ""
            outputText.text = ""
            inputText.setText("")

        }
    }
    // This function checks the string is in Hexadecimal form or not
    fun isHex(string:String): Boolean{
        val n = string.length
        for(i in 0 until n){
            val ch = string[i]
            if ((ch < '0' || ch > '9')
                && (ch < 'A' || ch > 'F')){
                return false
            }
        }
        return true
    }
    // This function checks if the string is in binary form or not
    fun isBinary(string: String): Boolean{
        val n = string.length
        for (i in 0 until n){
            val ch = string[i]
            if(ch != '0' && ch != '1'){
                return false
            }
        }
        return true
    }
    // This function checks if the string is in Octal form or not
    fun isOctal(string: String): Boolean{
        val n = string.length
        for (i in 0 until n){
            val ch = string[i]
            if(ch > '7'){
                return false
            }
        }
        return true
    }
    // This function checks if the string is in binary form or not
    fun isDecimal(string: String): Boolean{
        val n = string.length
        for (i in 0 until n){
            val ch = string[i]
            if(ch in '9'..'0'){
                return false
            }
        }
        return true
    }
    // binary to decimal conversion
    fun binaryToDecimal(str:String):String{
        val i = Integer.parseInt(str,2)
        return Integer.toString(i)
    }
    // binary to hexadecimal
    fun binaryToHexadecimal(str:String):String{
        val i = Integer.parseInt(binaryToDecimal(str))
        return Integer.toHexString(i).uppercase()
    }
    // binary to octal
    fun binaryToOctal(str:String):String{
        val i = Integer.parseInt(binaryToDecimal(str))
        return Integer.toOctalString(i)
    }
    // decimal to binary
    fun decimalToBinary(str:String):String{
        val i = Integer.parseInt(str)
        return Integer.toBinaryString(i)
    }
    // decimal to octal
    fun decimalToOctal(str: String):String{
        val i = Integer.parseInt(str)
        return Integer.toOctalString(i)
    }
    // decimal to hexadecimal
    fun decimalToHexadecimal(str:String):String{
        val i = Integer.parseInt(str)
        return Integer.toHexString(i).uppercase()
    }

}