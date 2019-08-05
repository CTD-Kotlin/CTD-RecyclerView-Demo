package com.example.ctdrecviewtutorial.models

import java.util.*

data class Note(var title: String, var content: String, var isPrivate: Boolean = false, var timeStamp: Date = Date())