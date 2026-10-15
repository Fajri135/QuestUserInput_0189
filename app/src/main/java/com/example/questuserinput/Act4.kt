package com.example.questuserinput

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.res.dimensionResource
import androidx.compose.material3.Divider

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    // variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    val gender: List<String> = listOf("Laki-Laki", "Perempuan")

    // variabel-variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )
        Row {
            gender.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        }
                    )
                    Text(item)
                }
            }
        }
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(250.dp),
            label = { Text("Alamat") },
            onValueChange = {
                textAlamat = it
            }
        )
        Divider(
            modifier = Modifier.padding(
            bottom = dimensionResource(id = R.dimen.padding_medium),
            top = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = Color.DarkGray
        )