package com.example.todoapp

import java.time.Instant
import java.util.Date

data class ToDo(
    var id: Int,
    var title:String,
    var createdAt:Date
)



fun getFakeToDo():List<ToDo>{


    return listOf(
        ToDo(1,"FirstToDo",Date.from(Instant.now())),
        ToDo(2,"SecondToDo",Date.from(Instant.now())),
        ToDo(3,"ThirdToDo",Date.from(Instant.now())),
        ToDo(4,"FourthToDo",Date.from(Instant.now())),
        ToDo(5,"FifthToDo",Date.from(Instant.now())),
        ToDo(6,"SixthToDo",Date.from(Instant.now()))
    );
}