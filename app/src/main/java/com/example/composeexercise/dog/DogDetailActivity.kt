package com.example.composeexercise.dog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexercise.Constant
import com.example.composeexercise.R
import com.example.composeexercise.adaptStatusBar

private val horizontalPadding = 15.dp

class DogDetailActivity : ComponentActivity() {
    private lateinit var dog: Dog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 调整状态栏
        window.adaptStatusBar()
        // 获取实体类
        dog = intent.getSerializableExtra(Constant.INTENT_EXTRA_DOG_DATA) as Dog

        setContent {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(vertical = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "back",
                        modifier = Modifier.clickable {
                            finish()
                        }
                    )
                    Text(
                        text = dog.name, fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold, // 设置字体的粗细
                        // 有关compose中的margin和padding设置，查看下面链接中Valeriy Katkov的回答
                        // link：https://stackoverflow.com/questions/62939473/how-to-add-margin-in-jetpack-compose
                        modifier = Modifier.padding(start = 30.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Image(
                    painter = painterResource(id = dog.image),
                    contentDescription = "dog image",
                    modifier = Modifier
                        .size(165.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                var isAdopted by remember { mutableStateOf(false) }
                var showAdoptConfirmDialog by remember { mutableStateOf(false) }
                Button(
                    onClick = { showAdoptConfirmDialog = true },
                    enabled = !isAdopted,
                    modifier = Modifier.padding(top = 30.dp)
                ) {
                    Text(text = if (isAdopted) "Adopted" else "Adopt")
                }

                // 弹出是否要领养dog的弹窗
                // compose中使用dialog：https://foso.github.io/Jetpack-Compose-Playground/material/alertdialog/
                if (showAdoptConfirmDialog) {
                    AlertDialog(
                        onDismissRequest = { // 点击dialog外部或者按下back按钮时，回调这里
                            showAdoptConfirmDialog = false
                        },
                        text = { Text(text = "Do you want to adopt this lovely dog？") },
                        confirmButton = {
                            Button(onClick = {
                                isAdopted = true
                                showAdoptConfirmDialog = false
                            }) {
                                Text(text = "Yes")
                            }
                        },
                        dismissButton = {
                            Button(onClick = {
                                isAdopted = false
                                showAdoptConfirmDialog = false
                            }) {
                                Text(text = "No")
                            }
                        }
                    )
                }

                Text(
                    text = dog.introduction,
                    modifier = Modifier.padding(top = 45.dp),
                    fontSize = 17.sp
                )
            }
        }
    }
}