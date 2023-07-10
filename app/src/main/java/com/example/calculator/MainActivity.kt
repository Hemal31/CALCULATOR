package com.example.conversion

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.R


class MainActivity() : AppCompatActivity(), AdapterView.OnItemSelectedListener, Parcelable {
    var cal =
        arrayOf("Select", "km-mi", "mi-km", "cm-in", "in-cm", "kg-lb", "lb-kg", "g-oz", "oz-g")
    var kilometer = 0.62
    var inch = 0.39
    var centimeter = 0.39
    var kgram = 2.2
    var gram = 0.04
    var edittext: EditText? = null;
    var textview: TextView? = null;

    constructor(parcel: Parcel) : this() {
        cal = parcel.createStringArray() as Array<String>
        kilometer = parcel.readDouble()
        inch = parcel.readDouble()
        centimeter = parcel.readDouble()
        kgram = parcel.readDouble()
        gram = parcel.readDouble()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edittext = findViewById<EditText>(R.id.edittext)

        textview = findViewById<TextView>(R.id.Textview)

//Getting the instance of Spinner and applying OnItemSelectedListener on it
//Getting the instance of Spinner and applying OnItemSelectedListener on it
        val spin = findViewById<View>(R.id.spinner) as Spinner
        spin.onItemSelectedListener = this

//Creating the ArrayAdapter instance having the bank name list

//Creating the ArrayAdapter instance having the bank name list
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
            cal
        )

        //Performing action onItemSelected and onNothing selected
        fun onItemSelected(arg0: AdapterView<*>?, arg1: View?, position: Int, id: Long) {
            Toast.makeText(applicationContext, cal[position], Toast.LENGTH_LONG).show()


        }

        fun onNothingSelected(arg0: AdapterView<*>?) = // TODO Auto-generated method stub
            Unit

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringArray(cal)
        parcel.writeDouble(kilometer)
        parcel.writeDouble(inch)
        parcel.writeDouble(centimeter)
        parcel.writeDouble(kgram)
        parcel.writeDouble(gram)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    class MainActivity() : AppCompatActivity(), Parcelable {

        constructor(parcel: Parcel) : this() {
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<MainActivity> {
            override fun createFromParcel(parcel: Parcel): MainActivity {
                return MainActivity(parcel)
            }

            override fun newArray(size: Int): Array<MainActivity?> {
                return arrayOfNulls(size)
            }
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}