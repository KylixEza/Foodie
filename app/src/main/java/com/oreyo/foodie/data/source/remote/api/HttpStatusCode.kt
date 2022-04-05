package com.oreyo.foodie.data.source.remote.api

enum class HttpStatusCode(val value: String) {
    OK("200"),
    BadRequest("400"),
    NotFound("404"),
    Conflict("409")
}