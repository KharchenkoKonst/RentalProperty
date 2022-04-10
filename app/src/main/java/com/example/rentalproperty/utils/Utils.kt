package com.example.rentalproperty.utils

import android.view.View

fun View.setVisibility(visibility: Boolean) {
    when(visibility){
        true -> this.visibility = View.VISIBLE
        false -> this.visibility = View.GONE
    }
}
