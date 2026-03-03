package com.davi.model

class Candidate extends Person{
    String cpf
    int age

    Candidate(String name, String email, String state, String zipCode, String description, String cpf, int age) {
        super(name, email, state, zipCode, description)
        this.cpf = cpf
        this.age = age
    }
}
