package com.H.ai_dollop

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.H.affirmations.data.Datasource
import com.H.affirmations.model.Affirmation
import com.H.affirmations.model.Dog
import com.H.ai_dollop.ui.theme.AiDollopTheme

// 要么在文件中声明TAG，妖魔在文件顶层添加 const val
private const val TAG = "MainActivity"


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Log 类将消息写入LogCat
        // Log.v() 会记录详细消息。
        // Log.d() 方法会写入调试消息。
        // Log 类中的其他方法包括 Log.i()（表示信息性消息）、Log.w()（表示警告）和Log.e()（表示错误消息）。
        Log.d(TAG, "onCreate Called")
        setContent {
            AiDollopTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun AiDollopThemePreview() {
    AiDollopTheme(
        useDarkTheme = true
    ) {
        AffirmationsApp()
    }
}

@Composable
fun AffirmationsApp() {
    // 中间层
    AffirmationList(
        affirmationList = Datasource().loadAffirmations(),
        dogsList = Datasource().loadDogs()
    )
}

@Composable
fun AffirmationList(
    affirmationList: List<Affirmation>,
    dogsList: List<Dog>,
    modifier: Modifier = Modifier
) {
    var expanded: Boolean by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            WoofTopAppBar()
        }
    ) { it ->
        LazyColumn(
            contentPadding = it,
            verticalArrangement = Arrangement.Top
        ) {
            items(dogsList.size) {
                AffirmationCard(
                    affirmation = affirmationList[it],
                    dog = dogsList[it],
                    expanded = expanded,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(
                // 垂直对齐
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.ic_woof_logo),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        })
}


@Composable
fun AffirmationCard(
    affirmation: Affirmation,
    dog: Dog,
    modifier: Modifier = Modifier,
    expanded: Boolean
) {
//    Card 本身是中等大小组件，更改Shape.kt文件中的默认Medium即可修改Car
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = stringResource(id = affirmation.stringResourcedId),
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            ImageInformation(
                dog = dog,
                expanded = expanded,
            )

        }
    }
}

@Composable
fun ImageInformation(
    dog: Dog,
    modifier: Modifier = Modifier,
    expanded: Boolean
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {
        DogIcon(dog.imageResourceId)
        DogInformation(dog.name, dog.age)
        // 由于分隔符是行中唯一加权的子元素，
        // 因此该元素会在测量其他未加权子元素的宽度之后，
        // 填充行中的剩余空间。
        Spacer(modifier = Modifier.weight(1f))
        AffirmationCardButton(
            expanded = expanded,
            onClick = { /*TODO*/ }
        )

    }
}

@Composable
private fun AffirmationCardButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

//    展开图标
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.ExpandMore,
            contentDescription = stringResource(
//                包提供的描述
                id = R.string.expand_button_content_description
            ),
//            图标颜色
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = dogName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .padding(dimensionResource(id = R.dimen.padding_small))
//        clip 属性添加到 Image 的 modifier；这会将图片裁剪为某种形状。
            //        传入 MaterialTheme.shapes.small。
            .clip(MaterialTheme.shapes.small),
        // 请添加 ContentScale 和 Crop 属性，这会根据显示大小裁剪图片。
        contentScale = ContentScale.Crop,
        painter = painterResource(id = dogIcon),
        contentDescription = null
    )
}
