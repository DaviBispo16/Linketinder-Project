package com.davi.model

class Company {
    String id
    String name
    String cnpj
    String email
    String description
    String password
    String location_id

    Company(String name, String cnpj, String email, String description, String password, String location_id) {
        this.id = java.util.UUID.randomUUID().toString()
        this.name = name
        this.cnpj = cnpj
        this.email = email
        this.description = description
        this.password = password
        this.location_id = location_id
    }
}
