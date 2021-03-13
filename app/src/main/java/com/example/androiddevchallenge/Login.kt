package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun InitialScreen(
    onClick: (LoginState) -> Unit,
    isDarkTheme: Boolean
) {
    Surface(color = MaterialTheme.colors.primary) {
        Box {
            Image(
                painter = painterResource(
                    id = if (isDarkTheme) R.drawable.ic_dark_welcome_bg else R.drawable.ic_light_welcome_bg
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
        }

        Column {
            Image(
                modifier = Modifier
                    .padding(start = 88.dp, top = 72.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .graphicsLayer(
                        translationX = 100.dp.value
                    ),
                painter = painterResource(
                    id = if (isDarkTheme) R.drawable.ic_dark_welcome_illos else R.drawable.ic_light_welcome_illos
                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
            Spacer(modifier = Modifier.height(48.dp))

            Image(
                painter = painterResource(
                    id = if (isDarkTheme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo
                ),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(id = R.string.title_motivation),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(48.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text(
                    text = stringResource(id = R.string.create_account),
                    style = MaterialTheme.typography.button
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(
                onClick = { onClick(LoginState.IN_PROCESS) },
                modifier = Modifier
                    .height(48.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(id = R.string.login_text),
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}

@Preview
@Composable
fun InitialScreenPreview() {
    MyTheme {
        InitialScreen(onClick = { /*TODO*/ }, isDarkTheme = true)
    }
}

@Composable
fun LoginScreen(
    onClick: (LoginState) -> Unit
) {
    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }

    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                stringResource(id = R.string.login_screen_title),
                modifier = Modifier
                    .paddingFromBaseline(top = 184.dp, bottom = 8.dp),
                style = MaterialTheme.typography.h1
            )
            OutlinedTextField(
                value = email,
                onValueChange = setEmail,
                label = { Text(text = stringResource(id = R.string.hint_email_address)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = MaterialTheme.colors.onPrimary,
                    unfocusedLabelColor = MaterialTheme.colors.onPrimary
                ),
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = setPassword,
                label = {
                    Text(
                        text = stringResource(id = R.string.hint_password),
                        style = MaterialTheme.typography.body1
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = MaterialTheme.colors.onPrimary,
                    unfocusedLabelColor = MaterialTheme.colors.onPrimary
                ),
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = stringResource(id = R.string.login_term),
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .paddingFromBaseline(24.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { onClick(LoginState.COMPLETED) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(48.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text(
                    text = stringResource(id = R.string.login_text),
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}