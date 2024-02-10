package com.example.citasfamosas.datasource

import com.example.citasfamosas.R
import com.example.citasfamosas.model.Cita

class DataSource {

    fun getCitas(): List<Cita> {
        //Devuelve la lista de citas
        return listOf(
            Cita(R.string.cita1, R.string.autor1, R.drawable.walt_disney_1946),
            Cita(R.string.cita2, R.string.autor2, R.drawable.john_lennon_1974)
        )
    }
}