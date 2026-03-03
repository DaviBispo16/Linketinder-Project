package com.davi.model

class Company extends Person{
    String cnpj
    String country

    Company(String name, String email, String state, String zipCode, String description, String cnpj, String country) {
        super(name, email, state, zipCode, description)
        this.cnpj = cnpj
        this.country = country
    }
}
