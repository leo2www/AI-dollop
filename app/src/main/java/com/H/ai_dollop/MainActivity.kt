package com.H.ai_dollop

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.H.affirmations.data.Datasource
import com.H.affirmations.model.Affirmation
import com.H.ai_dollop.ui.theme.AIdollopTheme

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
            AIdollopTheme {
                AffirmationsApp()
                Log.d(TAG, "SSS")
            }
        }
    }
}
@Preview
@Composable
fun AffirmationsApp() {
    AffirmationList(
        affirmationList = Datasource().loadAffirmations(),
    )
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier=Modifier) {
    LazyColumn(modifier = modifier) {
        // 注意导入不同库的items，其参量不同，
        // 这里是 androidx.compose.foundation.lazy。
        items(affirmationList) {affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = stringResource(id = affirmation.stringResourcedId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(affirmation.stringResourcedId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}


@Composable
private fun AffirmationCardPreview() {
    AffirmationCard(affirmation = Affirmation(R.string.affirmation1, R.drawable.image1))
}