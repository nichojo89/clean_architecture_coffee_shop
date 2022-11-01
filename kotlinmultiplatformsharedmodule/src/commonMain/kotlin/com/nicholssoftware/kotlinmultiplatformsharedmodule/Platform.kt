package com.nicholssoftware.kotlinmultiplatformsharedmodule

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform