package com.example.citasfamosas.datasource

import android.util.Log
import com.example.citasfamosas.model.Cita
import com.google.firebase.firestore.FirebaseFirestore


/**
 * Clase que implementa el acceso a una base de datos Firebase
 */
class DataSource {

    //TAG del Log
    private val TAG = "DataSource"

    //Nombres de la base de datos
    private val COLECCION_CITAS = "citas"
    private val CAMPO_FRASE = "cita"
    private val CAMPO_AUTOR = "autor"
    private val CAMPO_IMAGEN = "imagen"

    //Instancia de acceso a firebase
    private val db = FirebaseFirestore.getInstance()

    //Obtenemos la colección de citas
    private val citas = db.collection(COLECCION_CITAS)

    fun getCitas(setLista: (List<Cita>) -> Unit) {

        //Creamos una lista de citas modificable
        val listaCitas = mutableListOf<Cita>()

        citas.get().addOnSuccessListener { documents ->

            //Recorremos todos los documentos de la colección
            for (document in documents) {
                //Obtenemos los campos de cada documento
                val frase = document.getString(CAMPO_FRASE) ?: ""
                val autor = document.getString(CAMPO_AUTOR) ?: ""
                val imagenUrl = document.getString(CAMPO_IMAGEN) ?: ""

                //Creamos un objeto cita y lo añadimos a la lista
                val cita = Cita(frase, autor, imagenUrl)
                listaCitas.add(cita)

                //Escribimos una línea en el LOG para verificar la lectura correcta de los datos
                Log.i(TAG, "------> AUTOR: $autor")
            }

            //Actualizamos la lista que nos pasan como parámetro
            //Este método es necesario ya que la asignación es ASÍNCRONA
            setLista(listaCitas)
        }
    }

}