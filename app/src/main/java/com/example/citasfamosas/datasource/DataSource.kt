package com.example.citasfamosas.datasource

import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.citasfamosas.R
import com.example.citasfamosas.model.Cita
import com.google.firebase.firestore.FirebaseFirestore

class DataSource {

    //TAG del Log
    private val TAG = "DataSource"

    //Instancia de acceso a firebase
    private val db = FirebaseFirestore.getInstance()

    fun getCitas(setLista: (List<Cita>) -> Unit) {

        //Obtenemos la colección de citas
        val citas = db.collection("citas")

        //Creamos una lista de citas modificable
        val listaCitas = mutableListOf<Cita>()

        citas.get().addOnSuccessListener { documents ->
            //Recorremos todos los documentos de la colección citas
            for (document in documents) {
                //Obtenemos los campos de cada documento
                val frase = document.getString("cita") ?: ""
                val autor = document.getString("autor") ?: ""
                val imagenUrl = document.getString("imagen") ?: ""

                //Creamos un objeto cita y lo añadimos a la lista
                val cita = Cita(frase, autor, imagenUrl)
                listaCitas.add(cita)

                //Escribimos una línea en el LOG para verificar la lectura de datos
                Log.i(TAG, "------> AUTOR: $autor")
            }

            //Actualizamos la lista que nos pasan como parámetro
            setLista(listaCitas)
        }
    }

}