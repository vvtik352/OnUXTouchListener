package com.example.uxanalitic



data class TouchModel(val touchOwner: String, val viewType: String, val x: Float, val y: Float) {
    override fun toString(): String {
        return "${touchOwner}\n${viewType}\n${x};${y}"
    }
}