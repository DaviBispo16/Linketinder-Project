package com.davi.model

class Job {
    String id
    String name
    String description
    String job_location
    String company_id

    Job(String name, String description, String job_location, String company_id) {
        this.id = java.util.UUID.randomUUID().toString()
        this.name = name
        this.description = description
        this.job_location = job_location
        this.company_id = company_id
    }
}
