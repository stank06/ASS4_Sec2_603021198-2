package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;


import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addListenerOnButton()

    }


    fun addListenerOnButton(){
        val btn_click:Button = findViewById(R.id.register) as Button
        btn_click.setOnClickListener{
            var radioGroup: RadioGroup = findViewById(R.id.radiogroup)
            var selectedId : Int = radioGroup.checkedRadioButtonId;
            var radioButton : RadioButton = findViewById(selectedId);
            text_show.text="Name: ${id.text}\nPassword: ${pass_id.text}\nGender: ${radioButton.text}\n" +
                           "Email: ${email_id.text}\nBirthday: ${dateex.text}"
        }
    }

    fun showDatePickerDialog(v: View){
        val newDateFragment = DatePickerFragment()
        newDateFragment.show(supportFragmentManager,"Date Picker")
    }
    /*fun register(view: View){
        text_show.text="Name: ${id.text}\nPassword: ${pass_id.text}\nGender: ${radioButton.text}\nBirthday: ${dateex.text}\nEmail: ${email_id.text}"
    }*/

    fun reset() {
        id.text.clear()
        pass_id.text.clear()
        email_id.text.clear()
        text_show.text = "Show Information"
        dateex.text = " mm / dd / yy"

    }

}
