package com.ochoa.componentescomposelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoLazyColumn()
            DemoCheckbox()
        }
    }
}

/* -----------------------------
   📦 CONTENEDORES
-------------------------------- */

@Composable
fun DemoLazyColumn() {
    LazyColumn {
        items(5) { index ->
            Text(
                "Item $index",
                fontSize = 20.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyColumn() {
    DemoLazyColumn()
}

// LazyRow
@Composable
fun DemoLazyRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(5) { index ->
            Card(
                modifier = Modifier.size(80.dp),
                colors = CardDefaults.cardColors(Color(0xFF64B5F6))
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text("Item $index", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyRow() {
    DemoLazyRow()
}

/* -----------------------------
   🎛️ CONTROLES
-------------------------------- */

// Checkbox
@Composable
fun DemoCheckbox() {
    var checked by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Text(if (checked) "Seleccionado" else "No seleccionado")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCheckbox() {
    DemoCheckbox()
}

// Button
@Composable
fun DemoButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFE91E63),
            contentColor = Color.White
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text("Click Me!", fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButton() {
    DemoButton()
}

// Slider
@Composable
fun DemoSlider() {
    var value by remember { mutableStateOf(0f) }
    Column {
        Slider(value = value, onValueChange = { value = it })
        Text("Valor: ${value.times(100).toInt()}%")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSlider() {
    DemoCheckbox()
}
