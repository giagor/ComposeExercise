package com.example.composeexercise.dog

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexercise.*

private val itemWidth = 350.dp

// 体验：compose的列表用着确实有点卡
class DogListActivity : ComponentActivity() {
    // 为了让标题文字的左边和列表item的左边对齐，煞费苦心
    private val titlePaddingWidth: Dp by lazy {
        availableHorizontalPadding(itemWidth, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 调整状态栏
        window.adaptStatusBar()

        setContent {
            // 默认情况下，Column的宽度由宽度最大的子元素来决定
            // 看fillMaxWidth()注释，默认情况下，它可以实现match_parent的效果
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Puppies Home",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(
                            start = titlePaddingWidth,
                            top = 10.dp,
                            end = titlePaddingWidth,
                            bottom = 10.dp
                        ),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold // 设置字体的粗细
                )
                LazyColumn(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    verticalArrangement = Arrangement.spacedBy(15.dp) // 设置item间距，图像高度不会受影响
                ) {
                    this.items(items = dogList, key = null, itemContent = { dog ->
                        DogCover(dog = dog)
                    })
                }
            }
        }
    }

    @Composable
    fun DogCover(dog: Dog) {
        // 设置海拔高度和圆角
        Surface(elevation = 3.dp,
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.clickable {
                // 点击后跳转到狗狗详情页
                val intent = Intent(this, DogDetailActivity::class.java)
                intent.putExtra(Constant.INTENT_EXTRA_DOG_DATA, dog)
                startActivityByIntent(intent)
            }) {
            // Box中有contentAlignment属性用于指定对齐方式，但是如果要指定子元素的对齐
            // 方式，得对子元素单独使用Modifier指定
            Box(
                modifier = Modifier.width(itemWidth)
            ) {
                Image(
                    painter = painterResource(id = dog.image),
                    contentDescription = "dog image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .align(Alignment.BottomStart),
                    color = Color.Black.copy(alpha = 0.4f)
                ) {
                    VerticalCenterText {
                        Text(
                            text = dog.name,
                            modifier = Modifier.padding(horizontal = 10.dp),
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }

    // 想让Text的内容在垂直方向居中，没有想到什么比较好的办法，就在Text外面套了一层Column
    @Composable
    fun VerticalCenterText(text: @Composable () -> Unit) {
        Column(verticalArrangement = Arrangement.Center) {
            text()
        }
    }
}