package com.nicholssoftware.core.data

data class Drink(
    var title: String,
    var description: String,
    var contentDescription: String,
    var imageResource: Int,
    var id: Long = 0L)
