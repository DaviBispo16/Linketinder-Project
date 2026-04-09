package com.davi.model

class Skill {
    String id
    String name

    Skill(String name) {
        this.id = java.util.UUID.randomUUID().toString()
        this.name = name
    }
}
