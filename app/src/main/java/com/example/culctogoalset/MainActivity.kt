package com.example.culctogoalset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.ColorSpace
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // variables
    companion object{
        const val EXTRA_BRAND = "com.example.kotlinactivitydatatrans.BRAND"
        const val EXTRA_MODEL = "com.example.kotlinactivitydatatrans.MODEL"
        const val EXTRA_FUEL = "com.example.kotlinactivitydatatrans.FUEL"
        const val EXTRA_DISTANCE = "com.example.kotlinactivitydatatrans.DISTANCE"
    }

    // initializations
    //spinners
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null

    private val fuelItems = arrayOf("Biodiesel", "Diesel", "Petrol")
    var selectedFuel: String = "Biodiesel"

    //form
    private val DISTANCE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //spinners
        val spinner3 = findViewById<Spinner>(R.id.spinner3)

        // ArrayAdapter
        val adapter3 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, fuelItems
        )

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //set adapters to spinners
        spinner3.adapter = adapter3

        //register listeners
        //Brand
        //Model

        spinner1 = findViewById(R.id.spinner1) as Spinner
        spinner2 = findViewById(R.id.spinner2) as Spinner
        val adapter1 = ArrayAdapter.createFromResource(
            this,
            R.array.array1, android.R.layout.simple_spinner_item
        )
        spinner1?.setAdapter(adapter1)
        spinner1?.setOnItemSelectedListener(this)

        //Fuel
        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //　when the item was selected
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                // Kotlin Android Extensions
                selectedFuel = item
            }

            //if the item was not selected
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the main; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.main, menu)
            return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            val id = item.getItemId()
            return if (id == R.id.action_settings) {
                true
            } else super.onOptionsItemSelected(item)
    }

    override fun onItemSelected(
            parent: AdapterView<*>, view: View, position: Int,
            id: Long
    ) {
            if(spinner1?.getSelectedItem() == "Alfa Romeo") {
                Toast.makeText(
                    applicationContext, "Mobil dipilih",
                    Toast.LENGTH_SHORT
                ).show()

                val adapter2 = ArrayAdapter.createFromResource(
                    this,
                    R.array.AlfaRomeo_array, android.R.layout.simple_spinner_item
                )
                spinner2?.setAdapter(adapter2)
            } else if (spinner1?.getSelectedItem() == "BMW") {
                val adapter2 = ArrayAdapter.createFromResource(
                    this,
                    R.array.BMW_array, android.R.layout.simple_spinner_item
                )
                spinner2?.setAdapter(adapter2)
            } else {
                val adapter2 = ArrayAdapter.createFromResource(
                    this,
                    R.array.TOYOTA_array, android.R.layout.simple_spinner_item
                )
                spinner2?.setAdapter(adapter2)
            }


        }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

        /*
        //move to the sub page once the culc button was tapped
        button.setOnClickListener{
            if (distance.text != null){
            val intent = Intent(applicationContext, SubActivity::class.java)
            val str = distance.text.toString()
            val brand_result = selectedBrand
            val model_result = selectedModel
            val fuel_result = selectedFuel
            Log.d("debug", str)

            intent.putExtra(EXTRA_BRAND, brand_result)
            intent.putExtra(EXTRA_MODEL,model_result)
            intent.putExtra(EXTRA_FUEL, fuel_result)
            intent.putExtra(EXTRA_DISTANCE, str)
            startActivityForResult(intent, DISTANCE)
                distance.setText("")
            }
        }

         */

    }

