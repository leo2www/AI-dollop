package com.hazy.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazy.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

// @Composable 使用Modifier 修饰Compose界面元素行为
// 默认Modifier对象
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
//    创建Column界面

    // 新建一个触发器mutable,
    // mutableStateOf()返回一个可观察对象，result发生变化，系统触发重组
    var result by remember{ mutableIntStateOf(1) }

    // lambda函数，返回图片地id
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally  //垂直主轴对齐，居中
    ){  // 下面是一个lambda表达式，采用尾随语法
        Image(
            painter = painterResource(id = imageResource), // 图片
            contentDescription = "1" // 内容说明
        )

        // 保留垂直空间，以4.dp为增量更改
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { result = (1..6).random()} ) {
            Text(stringResource(R.string.roll))
            // roll字符串的if传到stringResource()函数，结果到Text可组合项
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()  // 让布局填充整个屏幕
            .wrapContentSize(Alignment.Center)  // 同时再水平垂直上居中
    )
}