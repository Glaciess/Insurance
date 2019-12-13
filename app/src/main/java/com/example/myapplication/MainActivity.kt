package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.myapplication.R.layout.activity_main)
        val btn = findViewById<View>(com.example.myapplication.R.id.Calculate)
        val btn2 = findViewById<View>(com.example.myapplication.R.id.reset)



        btn2.setOnClickListener() {
            AgeSpinner.setSelection(0)
            GenderGroup.clearCheck()
            checkBox.setChecked(false)
        }

        btn.setOnClickListener(){

            val mySpinner = findViewById(R.id.AgeSpinner) as Spinner;
            val itemText = mySpinner.selectedItem as String

            fun agepricecal(): Int {
                if(itemText.equals("Less than 17")){
                    return 60
                }
                else if(itemText.equals("17 - 25")){
                    return 70 +(if(Male.isChecked) 50 else 0)
                    + (if(checkBox.isChecked) 100 else 0)
                }
                else if(itemText.equals("26 - 30")){
                    return 80+(if(Male.isChecked) 100 else 0)
                    + (if(checkBox.isChecked) 150 else 0)
                }
                else if(itemText.equals("31 - 40")){
                    return 120+(if(Male.isChecked) 150 else 0)
                    + (if(checkBox.isChecked) 200 else 0)
                }
                else if(itemText.equals("41 - 55")) {
                    return 150+(if(Male.isChecked) 200 else 0)
                    + (if(checkBox.isChecked) 250 else 0)
                }
                else {
                    return 150+(if(Male.isChecked) 200 else 0)
                    + (if(checkBox.isChecked) 300 else 0)
                }
            }

            val totalcost = agepricecal().toDouble()
            TotalPremium.text = "RM %.2f".format(totalcost)



        }
    }

}

