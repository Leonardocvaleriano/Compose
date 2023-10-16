package com.codeplace.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        setContent block defines the activity's layout where composable functions are called.
        Composable functions can only be called from other composable functions.
        */
        setContent {
            MessageCard(Message("Leonardo", "This is my first Composable layout!"))
        }
    }
}

data class Message(val author:String, val body:String)

@Composable
fun MessageCard(msg:Message){
    // Add padding around our message
    Row(modifier = Modifier.padding(all= 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Profile photo",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .fillMaxSize()
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column{
            Text(text = msg.author, style = TextStyle(color = Color.Blue))
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body, style = TextStyle(color = Color.Blue))
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(Message("Author Name", "Message body"))
}