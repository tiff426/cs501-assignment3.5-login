package com.example.loginform

import android.R.color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.copy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loginform.ui.theme.LoginFormTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginFormTheme {
                LoginForm()
            }
        }
    }
}


@Composable
fun LoginForm() {
    var username by rememberSaveable { mutableStateOf("")}
    var password by rememberSaveable { mutableStateOf("") }

    // using these functions to tell if username and passord have values or not
    val isUsernameEmpty = username.isEmpty()
    val isPasswordEmpty = password.isEmpty()

    var message by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.padding(50.dp)) {
        Text("Login form",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary)
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.secondary,
            )
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.secondary,
            )
        )
        FilledTonalButton(
            onClick = {if(isUsernameEmpty or isPasswordEmpty) {message = "please input something"} else {message="good login"} }
        ) {
            Text("login")
        }
        Text(text=message, color = if(isUsernameEmpty or isPasswordEmpty) MaterialTheme.colorScheme.error
        else MaterialTheme.colorScheme.primary)

    }
}