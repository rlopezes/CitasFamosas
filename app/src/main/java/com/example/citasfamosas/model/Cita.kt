package com.example.citasfamosas.model

/**
 * Objeto de datos Cita
 *
 * @param frase: frase de la cita
 * @param autor: autor de la cita
 * @param imagenUrl: dirección url con imagen del autor de la cita
 */
data class Cita (
    val frase: String,
    val autor: String,
    val imagenUrl: String
)