package com.lamzentertainment.testceiba.domain.entities

data class PostEntity(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)