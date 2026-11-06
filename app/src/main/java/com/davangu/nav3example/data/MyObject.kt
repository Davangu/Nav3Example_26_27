package com.davangu.nav3example.data

import kotlinx.serialization.Serializable

@Serializable
data class MyObject(
    val name:String,
    val id:Int
)
