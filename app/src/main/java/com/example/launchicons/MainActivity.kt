package com.example.launchicons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getNum = findViewById<EditText>(R.id.txtNum)
        val rbUSDtoEuro = findViewById<RadioButton>(R.id.idUSDtoEuro)
        val rbEurotoUSD = findViewById<RadioButton>(R.id.idEurotoUSD)
        val result = findViewById<TextView>(R.id.idResult)
        val convert = findViewById<Button>(R.id.idButton)
        var final = 0.0

        convert.setOnClickListener{
            val getDouble = getNum.text.toString().toDouble()
            val conversionRateUSD = .92
            val conversionRateEuro = 1.09
            val convertFormat = DecimalFormat("##,###.00")

            if (rbUSDtoEuro.isChecked){
                if (getDouble < 10000.00){
                    final = getDouble * conversionRateUSD
                    result.text = "€${convertFormat.format(final)}"
                } else{
                    Toast.makeText(this@MainActivity, "Value must be less than 10,000.", Toast.LENGTH_LONG).show()
                }

            }

            if (rbEurotoUSD.isChecked){
                if (getDouble < 10000.00){
                    final = getDouble * conversionRateEuro
                    result.text = "$${convertFormat.format(final)}"
                } else{
                    Toast.makeText(this@MainActivity, "Value must be less than 10,000.", Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}