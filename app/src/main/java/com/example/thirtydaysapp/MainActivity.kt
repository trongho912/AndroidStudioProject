package com.example.thirtydaysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydaysapp.model.AppContentModel
import com.example.thirtydaysapp.ui.theme.ThirtyDaysAppTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.thirtydaysapp.data.AppContent


class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun App() {
    Scaffold(
        topBar = {
            AppTopBar()
        }
    ) {
        LazyColumn(
            modifier = Modifier,
            contentPadding = it
        ) {
            items(AppContent().loadAppContent()) { appCard ->
                AppCard(
                    appContentModel = appCard,
                )
            }
        }
    }

}

@ExperimentalMaterial3Api
@Composable
fun AppTopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row{
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold,

                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun AppCard(appContentModel: AppContentModel, modifier: Modifier = Modifier){
    var expanded by remember { mutableStateOf(false) }
    Card (
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ){
        Column (
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = LocalContext.current.getString(appContentModel.titleResourceId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                AppCardButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            Text(
                text = LocalContext.current.getString(appContentModel.contentResourceId),
                modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            if (expanded) {
                AppExpand(
                    appDetail = R.string.hiddenContent,
                    modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp),

                    )
            }
            Image(
                painter = painterResource(appContentModel.imageResourceId),
                contentDescription = stringResource(appContentModel.titleResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
private fun AppCardButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = "Expand",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun AppExpand(@StringRes appDetail: Int, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = appDetail),
            style = MaterialTheme.typography.bodyLarge,
        )
    }

}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ThirtyDaysAppTheme(darkTheme = false) {
        App()
    }
}