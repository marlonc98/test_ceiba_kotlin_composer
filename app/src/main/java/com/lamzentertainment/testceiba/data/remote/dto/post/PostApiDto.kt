package com.lamzentertainment.testceiba.data.remote.dto.post

import com.lamzentertainment.testceiba.domain.entities.PostEntity

data class PostApiDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun PostApiDto.toPost():PostEntity{
    return PostEntity(
        body = this.body,
        id = this.id,
        title = this.title,
        userId = this.userId
    )
}