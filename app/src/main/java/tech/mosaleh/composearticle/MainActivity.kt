package tech.mosaleh.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.mosaleh.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    ComposeQuadrantScreen()
                }
            }
        }
    }

    @Composable
    fun ComposeArticle() {
        val image = painterResource(id = R.drawable.bg_compose_background)
        val description = stringResource(id = R.string.image_bg_dsc)
        val header = stringResource(id = R.string.header_title)
        val firstParagraph = stringResource(id = R.string.first_paragraph)
        val secondParagraph = stringResource(id = R.string.second_paragraph)
        Column {
            Image(painter = image, contentDescription = description)
            Text(
                text = header, fontSize = 24.sp, modifier = Modifier.padding(
                    top = 16.dp, start = 16.dp,
                )
            )

            Text(
                text = firstParagraph, fontSize = 16.sp, modifier = Modifier.padding(
                    top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp
                )
            )

            Text(
                text = secondParagraph, fontSize = 16.sp, modifier = Modifier.padding(
                    top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp
                )
            )
        }
    }

    @Composable
    fun TaskManager() {
        val image = painterResource(id = R.drawable.ic_task_completed)
        val taskCompleted = stringResource(id = R.string.complete)
        val niceText = stringResource(id = R.string.nice)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(painter = image, contentDescription = null)
            Text(
                text = taskCompleted,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = 24.dp, bottom = 8.dp
                )
            )

            Text(
                text = niceText, fontSize = 16.sp,
            )
        }
    }

    @Composable
    fun ComposeQuadrantScreen() {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            val titleText = stringResource(id = R.string.title_text_composable)
            val descriptionText = stringResource(id = R.string.description_text_composable)

            val titleImage = stringResource(id = R.string.title_Image_composable)
            val descriptionImage = stringResource(id = R.string.description_image_composable)

            Row(
                Modifier
                    .weight(1f)
            ) {
                QuadrantCard(
                    title = titleText,
                    description = descriptionText,
                    color = Color.Green,
                    Modifier.weight(1f)
                )
                QuadrantCard(
                    title = titleImage,
                    description = descriptionImage,
                    color = Color.Yellow,
                    Modifier.weight(1f)
                )
            }
            Row(modifier = Modifier.weight(1f)) {
                val titleRow = stringResource(id = R.string.title_Row_composable)
                val descriptionRow = stringResource(id = R.string.description_row_composable)

                val titleColumn = stringResource(id = R.string.title_Column_composable)
                val descriptionColumn = stringResource(id = R.string.description_Column_composable)

                QuadrantCard(
                    title = titleRow,
                    description = descriptionRow,
                    color = Color.Cyan,
                    Modifier.weight(1f)
                )
                QuadrantCard(
                    title = titleColumn,
                    description = descriptionColumn,
                    color = Color.LightGray,
                    Modifier.weight(1f)
                )
            }
        }
    }

    @Composable
    fun QuadrantCard(
        title: String,
        description: String, color: Color,
        modifier: Modifier
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = color)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    bottom = 16.dp
                )
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(
                    bottom = 16.dp
                )
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ComposeQuadrantAppPreview() {
        ComposeArticleTheme {
            ComposeQuadrantScreen()
        }
    }
}


