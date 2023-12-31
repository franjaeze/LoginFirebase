package com.example.loginfirebase.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.loginfirebase.R
import com.google.android.material.snackbar.Snackbar


class RegisterFragment : Fragment() {

lateinit var v:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_register, container, false)
        return v
    }

    override fun onStart() {
        super.onStart()
        val singUp = v.findViewById<Button>(R.id.singUpBtn)

        singUp.setOnClickListener{
            val userName = v.findViewById<EditText>(R.id.singUpName).text.toString();
            // el text es para obtener el valor del campo, y luego lo parceo a String
            val passPass = v.findViewById<EditText>(R.id.singUpPassword).text.toString();
            val passPass2 = v.findViewById<EditText>(R.id.singUpPassword2).text.toString();
            val userEmail = v.findViewById<EditText>(R.id.singUpemail).text.toString();

            if (passPass != passPass2 ){
                val text = "Password are not the same!"
                val duration = Toast.LENGTH_SHORT

                //snackbar
                val snackbar = Snackbar.make(v,text,duration)
                snackbar.setTextColor(Color.RED)
               // snackbar.setBackgroundTint(getResources().getColor(R.color.black))

                snackbar.show()
            }

        }

    }

}