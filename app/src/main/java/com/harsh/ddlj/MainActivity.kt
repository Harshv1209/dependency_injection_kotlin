package com.harsh.ddlj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.harsh.ddlj.data.repositories.UserRepo
import com.harsh.ddlj.ui.theme.DDLJTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var UserRepo: UserRepo

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            DDLJTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    MainNavigation()
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MainApp()
}

data class Task(val id: Int, val text: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoApp() {
    var tasks = remember { mutableStateListOf<Task>() }
    var taskText = remember { mutableStateOf("Enter Task") }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "TODO List",
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            TextField(
                value = taskText.value,
                onValueChange = { taskText.value = it },
                singleLine = true,
            )
            Button(
                onClick = {
                    if (taskText.value.isNotBlank()) {
                        tasks.add(
                            Task(tasks.size + 1, taskText.value)
                        )

                        taskText.value = ""
                    }
                },
                shape = MaterialTheme.shapes.small,
            ) {
                Text(
                    text = "Add Todo",
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .size(500.dp)
                .border(5.dp, Color.White)
                .padding(2.dp)

        ) {
            LazyColumn() {
                items(tasks) { task ->
                    val checkedState = rememberSaveable { mutableStateOf(false) }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Checkbox(
                            checked = checkedState.value,
                            onCheckedChange = { isChecked ->
                                checkedState.value = isChecked
                            },
                            modifier = Modifier.padding(end = 16.dp)
                        )
                        Text(
                            text = task.text,
                            style = MaterialTheme.typography.titleSmall.copy(
                                textDecoration = if (checkedState.value) TextDecoration.LineThrough else TextDecoration.None
                            ),
                            modifier = Modifier.padding(18.dp)

                        )
                        Button(
                            onClick = {
                                tasks.remove(task)
//                                tasks = tasks.toList().toMutableStateList()

                            },
                            shape = MaterialTheme.shapes.small,
                        ) {
                            Text(
                                text = "Delete",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }

            }
        }
    }
}

