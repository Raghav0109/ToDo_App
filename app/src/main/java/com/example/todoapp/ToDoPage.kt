package com.example.todoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.todoapp.ui.theme.TodoViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ToDo(viewModel: TodoViewModel) {

val toDoList by viewModel.todoList.observeAsState()
    var inputText by remember {
        mutableStateOf("")
    }

    Column (modifier= Modifier
        .fillMaxHeight()
        .padding(8.dp)){
        Row (modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){
            OutlinedTextField(value =inputText , onValueChange ={inputText=it} )
            Button(onClick = {/* TODO:*/  }) {
            Text(text = "Add")
            }
        }

        toDoList?.let{
            LazyColumn (content = {itemsIndexed(it){index: Int, item: ToDo ->
                TodoItem(item=item)
            } })
        }

    }



}

@Composable
fun TodoItem(item:ToDo){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(MaterialTheme.colorScheme.primary)
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
        ) {
        Column (modifier = Modifier.weight(1f)){
            Text(text=SimpleDateFormat("HH:mm:aa, dd/mm",
                Locale.ENGLISH).format(item.createdAt),
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(text= item.title,
                fontSize = 20.sp,
                color = Color.White)
        }
        IconButton(onClick = {}) {
            Icon(painter = painterResource(id=R.drawable.delete24), contentDescription ="Delete" ,
                tint = Color.White)

        }
    }
}