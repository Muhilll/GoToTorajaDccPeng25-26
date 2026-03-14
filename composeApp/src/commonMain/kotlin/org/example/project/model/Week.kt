package org.example.project.model

data class Week(
    val date: String,
    val contribution: Double,
    val progress: Float,
    val percentText: String,
    val remaining: String,
    val status: String,
)