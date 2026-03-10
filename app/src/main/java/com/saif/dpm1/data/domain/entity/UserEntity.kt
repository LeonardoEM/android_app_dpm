package com.saif.dpm1.data.domain.entity

data class UserEntity(
    val userId:String,
    val name:String,
    val password:String,
    val userMode: UserMode
) {}

sealed class UserMode(val userType: Int){
    object REGULAR_USER: UserMode(0)
    object CONTENT_CREATOR_USER: UserMode(1)
    object COMPANY_USER: UserMode(2)
}