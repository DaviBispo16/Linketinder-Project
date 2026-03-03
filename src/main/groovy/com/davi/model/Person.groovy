package com.davi.model

class Person {
    String name
    String email
    String state
    String zipCode
    String description

    Person(String name, String email, String state, String zipCode, String description) {
        this.name = name
        this.email = email
        this.state = state
        this.zipCode = zipCode
        this.description = description
    }
}
