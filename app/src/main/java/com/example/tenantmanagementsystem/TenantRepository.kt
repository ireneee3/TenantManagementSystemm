package com.example.tenantmanagementsystem

object TenantRepository {

    // One shared list of tenants for the whole app
    val tenants = mutableListOf<Tenant>()

    fun addTenant(tenant: Tenant) {
        tenants.add(tenant)
    }

    // Adds up every tenant's rent (invalid text counts as 0.0)
    fun totalRent(): Double {
        return tenants.sumOf { it.rent.toDoubleOrNull() ?: 0.0 }
    }
}