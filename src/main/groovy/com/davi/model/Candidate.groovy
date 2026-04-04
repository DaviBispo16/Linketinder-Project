package com.davi.model

class Candidate {
    String id
    String first_name
    String last_name
    String email
    String cpf
    String description
    String password
    String location_id

    Candidate(String first_name, String last_name, String email, String cpf, String description, String password, String location_id) {
        this.id = java.util.UUID.randomUUID().toString()
        this.first_name = first_name
        this.last_name = last_name
        this.email = email
        this.cpf = cpf
        this.description = description
        this.password = password
        this.location_id = location_id
    }
}
