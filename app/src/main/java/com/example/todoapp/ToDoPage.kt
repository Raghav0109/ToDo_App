package com.example.todoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ToDo(modifier: Modifier = Modifier) {

val toDoList= getFakeToDo()

    Column (modifier=Modifier.fillMaxHeight()
        .padding(8.dp)){
        LazyColumn (content = {  itemsIndexed(toDoList){index: Int, item: ToDo ->
            TodoItem(item=item)
        } })
    }



}

@Composable
fun TodoItem(item:ToDo){
    Row (modifier = Modifier.fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(MaterialTheme.colorScheme.primary)
        .padding(16.dp)) {
        Column {
            Text(text=SimpleDateFormat("HH:mm:aa, dd/mm", Locale.ENGLISH).format(item.createdAt),
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(text= item.title,
                fontSize = 20.sp,
                color = Color.White)
        }
    }
}