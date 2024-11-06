package com.example.latihaninput

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.npca1.R
import kotlin.math.round

@Preview (showBackground = true)
@Composable
fun dashboard(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderSection()
        data()

    }
}

@Composable
fun HeaderSection() {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)
            .padding(15.dp)


    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = null
                )
                Spacer(Modifier.padding(5.dp))

                Text(
                    text = "Halo,",
                    color = Color.White,
                    fontSize = 30.sp
                )
                Text(
                    text = "Aditya Wirajaya Permono",
                    color = Color.White
                )
            }
            Box (
                contentAlignment = Alignment.BottomStart
            ){
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}


@Composable
fun data(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var noTelpon by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var noTelponsv by remember { mutableStateOf("") }
    var memilihJKsv by remember { mutableStateOf("") }

    val listJK = listOf("laki-laki", "perempuan")

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment =  Alignment.CenterHorizontally
    ){
        Text("Yuk Lengkapi Data Dirimu !",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.padding(16.dp))

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("nama")},
            placeholder = { Text("Masukkan Nama Anda")}

        )

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = noTelpon,
            onValueChange = {noTelpon = it},
            label = { Text("NoTelpon")},
            placeholder = { Text("Masukkan NoHandphone Anda")}
        )

        Row (modifier = Modifier
        ){
            listJK.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically ) { RadioButton(
                    selected = memilihJK == item,
                    onClick = {
                        memilihJK = item
                    }
                )
                    Text(item)

                }
            }
        }


        Button (modifier = Modifier .fillMaxWidth() .padding(5.dp),
            onClick = {
            namasv = nama
            noTelponsv = noTelpon
                memilihJKsv = memilihJK
        }) {
            Text("Simpan")
        }

        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
                .fillMaxWidth()

        ){
            DetailSurat(judul = "No Handphone", isinya = noTelponsv)
            DetailSurat(judul = "Jenis Kelamin", isinya = memilihJKsv)
        }
    }
}

@Composable
fun DetailSurat(
    judul: String, isinya: String
){
    Column (
        modifier = Modifier.fillMaxWidth().padding(10.dp),
    ){
        Row(

        ) {
            Text(text = judul,
                modifier = Modifier.weight(1f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
        }
        Row(

        ){
            Text(text = isinya,
                modifier = Modifier.weight(2f))
            Icon(imageVector = Icons.Filled.Call,
                contentDescription = null)
        }


    }

}