package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity

import android.widget.TimePicker

import kotlinx.android.synthetic.main.activity_main.*

import java.util.*
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener{

    private lateinit var calendar: Calendar
    @SuppressLint("ResourceType")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val year = calendar.get(Calendar.YEAR)
        return DatePickerDialog(activity!!, 2,this, month, day, year)
    }

    override fun onDateSet(view: DatePicker?, month: Int, day: Int, year: Int) {
        //activity!!.findViewById<TextView>(R.id.dateex).text = formatDate(month, day, year)
        activity!!.dateex?.text = "${day+1} / ${year} / ${month}"
        Toast.makeText(activity, "selected date!", Toast.LENGTH_SHORT).show()
    }

    override fun onCancel(dialog: DialogInterface?) {
        Toast.makeText(activity, "Please select date before you go out", Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }

   /* private fun formatDate(month: Int, day: Int, year: Int){
        calendar.set(month,day,year)
        val chosenDate = calendar.time
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
        return df.format(chosenDate)

    }*/

}