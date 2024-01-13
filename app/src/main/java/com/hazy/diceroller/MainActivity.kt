package com.hazy.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally  //垂直主轴对齐，居中
    ){  // 下面是一个lambda表达式，采用尾随语法
        Image(
            painter = painterResource(id = R.drawable.dice_1), // 图片
            contentDescription = "1" // 内容说明
        )

        Button(onClick = { /*TODO*/ }) {
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