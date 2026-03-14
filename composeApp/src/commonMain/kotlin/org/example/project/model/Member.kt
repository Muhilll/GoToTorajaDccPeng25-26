package org.example.project.model

import kotlinx.serialization.Serializable

@Serializable
data class Member(
    val name: String,
    val contribution: Double,
    val progress: Float,
    val percentText: String,
    val remaining: String,
    val status: String,
    val avatarUrl: String
)