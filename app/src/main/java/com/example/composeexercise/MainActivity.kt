package com.example.composeexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.composeexercise.dog.DogListActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 调整状态栏
        window.adaptStatusBar()

        setContent {
            Column {
                RouterButton({ startActivitySimply(DogListActivity::class.java) }, "跳转到 Dog 领养应用")
            }
        }
    }
}

@Composable
fun RouterButton(action: () -> Unit, msg: String) {
    Button(onClick = { action() }) {
        Text(text = msg)
    }
}
