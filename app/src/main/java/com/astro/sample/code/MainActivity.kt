package com.astro.sample.code

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.astro.sample.code.presentation.ChatHistoryViewModel
import com.astro.sample.code.ui.theme.SampleCodeTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleCodeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding))
                }
            }
        }


    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    viewModel: ChatHistoryViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val data by viewModel.data.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.initiateData(
            appId = context.getString(R.string.qiscus_app_id),
            userId = context.getString(R.string.qiscus_user_id),
            channelId = context.getString(R.string.qiscus_channel_id).toInt()
        )
    }

    Text(
        text = data,
        modifier = modifier
    )
}