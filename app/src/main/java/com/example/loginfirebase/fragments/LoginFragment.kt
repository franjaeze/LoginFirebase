package com.example.loginfirebase.fragments

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.loginfirebase.R
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match



class LoginFragment : Fragment() {
    lateinit var v:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_login_fragment, container, false)
        return v
    }


    override fun onStart() {
        super.onStart()
        val singUpBtn = v.findViewById<Button>(R.id.SingUp)
        val loginBtn = v.findViewById<Button>(R.id.loginBtn)

        singUpBtn.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            v.findNavController().navigate(action)
        }

        loginBtn.setOnClickListener{
            val userInput = v.findViewById<EditText>(R.id.username).text.toString();
            // el text es para obtener el valor del campo, y luego lo parceo a String
            val passInput = v.findViewById<EditText>(R.id.password).text.toString();

            if (userInput.isEmpty() || passInput.isEmpty()) {
                val errorMessageTextView = v.findViewById<TextView>(R.id.errorMessageTextView)

                // Autenticación fallida. Mensaje que indica error,
                // se muestra text view que estaba oculto
                errorMessageTextView.visibility = View.VISIBLE
                errorMessageTextView.text =
                    "Todos los campos son obligatorios"
                Handler().postDelayed({
                    errorMessageTextView.visibility = View.INVISIBLE
                }, 3000)
            } else {

            var i = 0;
//            var userLogin: User
            var credentials:Boolean = false
//            while (!credentials && i < UserList.users.size) {
//
//                val user = UserList.users[i]
//                if (user.name == userInput && user.password == passInput) {
//                    credentials = true;
//                    val userLogin = user; // asi se instancia una clase en kl, sin el new.Ojo que la debo importar antes
//                    //val action = LoginFragmentDirections.actionLoginFragmentToDataFragment(userEmail)
//                    val action = LoginFragmentDirections.actionLoginFragmentToDataFragment(userLogin)
//                    v.findNavController().navigate(action)
//
//                } else{
//                    i++
//                }
//            }



            if(!credentials){



                // toast
                val text = "Credenciales incorrectas!"
                val duration = Toast.LENGTH_SHORT

                //snackbar
                val snackbar = Snackbar.make(v,text,duration)
                snackbar.setTextColor(Color.WHITE)
                snackbar.setBackgroundTint(getResources().getColor(R.color.black))


                snackbar.show()




            } else {
                val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
                v.findNavController().navigate(action)
            }

        }

    }}



}