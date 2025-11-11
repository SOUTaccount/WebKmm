package stebakov.sitekmm

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.onClick
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import sitekmm.composeapp.generated.resources.Res
import sitekmm.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        BoxWithConstraints {
            val device = remember { defineDevice(maxWidth) }

            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Header(device)

                HorizontalDivider(modifier = Modifier.fillMaxWidth())

                Button(onClick = { showContent = !showContent }) {
                    Text("Click me!")
                }
                AnimatedVisibility(showContent) {
                    val greeting = remember { Greeting().greet() }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text("Compose: $greeting")
                    }
                }
            }
        }
    }
}

@Composable
private fun ColumnScope.Header(device: Device) {
    if (device == Device.Mobile) HeaderMobile() else HeaderDesktop()
}

@Composable
private fun HeaderMobile() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            modifier = Modifier.size(width = 180.dp, height = 90.dp),
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = null
        )
        Text(modifier = Modifier.clickable(onClick = {}), text = "О КОМПАНИИ")
        Text(modifier = Modifier.clickable(onClick = {}), text = "НОВОСТИ")
        Text(modifier = Modifier.clickable(onClick = {}), text = "КОНТАКТЫ")
    }
}

@Composable
private fun HeaderDesktop() {
    Row(
        modifier = Modifier
            .padding(horizontal = 64.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        Image(
            modifier = Modifier.size(width = 380.dp, height = 180.dp),
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = null
        )
        Text(modifier = Modifier.clickable(onClick = {}), text = "О КОМПАНИИ")
        Text(modifier = Modifier.clickable(onClick = {}), text = "НОВОСТИ")
        Text(modifier = Modifier.clickable(onClick = {}), text = "КОНТАКТЫ")
    }
}

private fun defineDevice(maxWidth: Dp) = if (maxWidth > 800.dp) Device.Desktop else Device.Mobile

enum class Device {
    Desktop, Mobile
}