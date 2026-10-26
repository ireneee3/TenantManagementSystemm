
package com.example.tenantmanagementsystem

import java.io.Serializable

data class Tenant(
    val name: String,
    val phone: String,
    val rent: String
) : Serializable {

    fun summary(): String {
        return "Name: $name\nPhone: $phone\nRent: $rent"
    }
}
