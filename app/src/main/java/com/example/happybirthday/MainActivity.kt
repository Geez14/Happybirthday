package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappybirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappybirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    HappyBirthdayMessageWithImage(
                        name = stringResource(id = R.string.NameOfBirthDayBoy),
                        sender = stringResource(id = R.string.BirthdayWisher)
                    )
                }
            }
        }
    }
}

@Composable
fun HappyBirthdayMessageWithImage(name: String, sender: String) {
    val image = painterResource(id = R.drawable.birthday)
    Image(
        painter = image,     // making some kinda pointer of the image and fitting the value
        contentDescription = null, // Talkback off
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop // Maintaining the aspect ration according to the screen size
    )
    HappyBirthdayMessage(name = name, sender = sender)
}


@Composable
fun HappyBirthdayMessage(name: String, sender: String) {
    val body = """
        The older I get, the more I realize that I am still a little younger than you! Happy birthday.
Work hard. Play hard. Eat lots of cake. That’s a good motto for your birthday and for life.
You are my kind of crazy and that is what life is really about! Happy birthday.
Not giving in to temptation is one way to increase your relative happiness.
Giving in to temptation is a way to immediately increase your happiness. Be happy. Happy birthday.
    """.trimIndent()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 16.dp)
                .wrapContentWidth(align = Alignment.Start),

            fontFamily = FontFamily.Cursive,
            fontSize = 32.sp
        )
        Text(
            text = "-$sender",
            modifier = Modifier
                .align(alignment = Alignment.End)
                .padding(end = 20.dp),
            fontFamily = FontFamily.Monospace,
            fontSize = 18.sp
        )
        Text(
            text = body,
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally)
                .wrapContentWidth(align = Alignment.Start),
            color = Color.Yellow,
            fontFamily = FontFamily.Cursive,
            fontSize = 22.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HappyBirthdayMessageWithImagePreview() {
    HappybirthdayTheme {
        HappyBirthdayMessageWithImage(
            name = stringResource(R.string.NameOfBirthDayBoy),
            sender = stringResource(R.string.BirthdayWisher)
        )
    }
}