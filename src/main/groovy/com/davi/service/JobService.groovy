package com.davi.service

import com.davi.model.Job

class JobService {
    private List<Job> jobs = []

    Job create(Job newJob) {
        jobs << newJob
        return newJob
    }

    List<Job> listAll() {
        return jobs
    }
}
