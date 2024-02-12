package com.example.citasfamosas

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import com.example.citasfamosas.model.Cita

@Composable
fun TarjetaCita(
    cita: Cita,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.secondaryContainer
    )

    Card(modifier = modifier
        .clip(
            MaterialTheme.shapes.medium //Valor por defecto
        )
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = color)
        ) {
            Row() {
                //Texto de la cita
                Text(
                    text = stringResource(R.string.cita, cita.frase),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_small))
                        .weight(1f)
                )
                BotonExpandir(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }

            if (expanded) {
                DatosAutor(cita, modifier)
            }
        }
    }
}

@Composable
private fun BotonExpandir(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.boton_espandir_descripcion),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
private fun DatosAutor(cita: Cita, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {

        //Imagen obtenida a partir de una url. Para ello hemos utilizado la libreria coil
        //   https://coil-kt.github.io/coil/
        //Para usar este librería debemos importarla en nuestro proyecto
        //   implementation("io.coil-kt:coil-compose:2.5.0")
        AsyncImage(
            model = cita.imagenUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = modifier
                .size(dimensionResource(R.dimen.image_size))
                .clip(MaterialTheme.shapes.small)
        )
    }

    //Nombre autor
    Text(
        text = stringResource(R.string.autor, cita.autor),
        style = MaterialTheme.typography.labelSmall,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = dimensionResource(R.dimen.padding_small),
                bottom = dimensionResource(R.dimen.padding_small)
            )
    )
}