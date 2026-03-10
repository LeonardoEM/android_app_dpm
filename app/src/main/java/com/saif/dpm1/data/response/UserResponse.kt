package com.saif.dpm1.data.response

import com.saif.dpm1.data.domain.entity.UserEntity
import com.saif.dpm1.data.domain.entity.UserMode
import kotlin.Int

data class UserResponse (
    val userId:String,
    val name:String,
    val password:String,
    val userType: Int
)

fun UserResponse.toDomain(): UserEntity{
    val userMode=when(userType){
        UserMode.REGULAR_USER.userType->UserMode.REGULAR_USER
        UserMode.CONTENT_CREATOR_USER.userType->UserMode.CONTENT_CREATOR_USER
        UserMode.COMPANY_USER.userType->UserMode.COMPANY_USER
        else->UserMode.REGULAR_USER
    }

    return UserEntity(
        userId=userId,
        name=name,
        password=password,
        userMode=userMode
    )
}