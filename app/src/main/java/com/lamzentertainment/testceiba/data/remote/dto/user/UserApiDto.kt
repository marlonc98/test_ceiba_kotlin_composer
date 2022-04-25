package com.lamzentertainment.testceiba.data.remote.dto.user

import com.lamzentertainment.testceiba.domain.entities.UserEntity

data class UserApiDto(
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
)

fun UserApiDto.toUser():UserEntity{
    return UserEntity(
        id = this.id,
        name = this.name,
        email = this.email,
        phone = this.phone,
    )
}