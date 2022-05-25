package com.example.bitcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Task 2
        val result = findViewById(R.id.textView_Result) as TextView

//        Task 3
        val addButton = findViewById(R.id.button_Add) as Button
        val subButton = findViewById(R.id.button_Sub) as Button
        val mulButton = findViewById(R.id.button_Mul) as Button
        val divButton = findViewById(R.id.button_Div) as Button
        val andButton = findViewById(R.id.button_AND) as Button
        val orButton = findViewById(R.id.button_OR) as Button
        val xorButton = findViewById(R.id.button_XOR) as Button
        val lsButton = findViewById(R.id.button_LS) as Button
        val rsButton = findViewById(R.id.button_RS) as Button

        fun findls(num1 : Long , num2 : Long):String{
            if(num2 > 2147483647){
                return "-1"
            } else {
                return (num1 shl (num2.toInt())).toString()
            }
        }

        fun findrs(num1 : Long , num2 : Long):String{
            if(num2 > 2147483647){
                return "-1"
            } else {
                return (num1 shr (num2.toInt())).toString()
            }
        }

//        Task 4
        addButton.setOnClickListener( View.OnClickListener {
                view -> result.text = (getInputNum1() + getInputNum2()).toString()
        } )

        subButton.setOnClickListener( View.OnClickListener {
                view -> result.text = (getInputNum1() - getInputNum2()).toString()
        } )

        mulButton.setOnClickListener( View.OnClickListener {
                view -> result.text = (getInputNum1() * getInputNum2()).toString()
        } )

        divButton.setOnClickListener( View.OnClickListener {
                view -> result.text = (getInputNum1() / getInputNum2()).toString()
        } )

        andButton.setOnClickListener( View.OnClickListener {
                view -> result.text = (getInputNum1() and getInputNum2()).toString()
        } )

        orButton.setOnClickListener( View.OnClickListener {
                view -> result.text = (getInputNum1() or getInputNum2()).toString()
        } )

        xorButton.setOnClickListener( View.OnClickListener {
                view -> result.text = (getInputNum1() xor getInputNum2()).toString()
        } )

        lsButton.setOnClickListener( View.OnClickListener {
                view ->  result.text = findls(getInputNum1(), getInputNum2())
        }
        )

        rsButton.setOnClickListener( View.OnClickListener {
                view -> result.text = findrs(getInputNum1(), getInputNum2())
        } )

    }

    //    Task 1
    fun getInputNum1():Long {
        val num1 = findViewById(R.id.Num1_Box) as EditText
        return num1.text.toString().toLong()
    }

    fun getInputNum2():Long {
        val num2 = findViewById(R.id.Num2_Box) as EditText
        return num2.text.toString().toLong()
    }

}