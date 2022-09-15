package com.example.convertifyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

}