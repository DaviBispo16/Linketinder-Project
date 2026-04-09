package com.davi.repository

import groovy.sql.Sql

class JobRepository {
    private final Sql sql

    JobRepository(Sql sql) {
        this.sql = sql
    }

    void createTable() {
        sql.execute("""
            CREATE TABLE IF NOT EXISTS job (
                id varchar(255) primary key,
                name varchar(255) not null,
                description text,
                job_location varchar(100) not null,
                created_at timestamp with time zone default CURRENT_TIMESTAMP,
                updated_at timestamp with time zone default CURRENT_TIMESTAMP,
                company_id varchar(255) references company(id)
            )
        """)
    }

    void insertJob(String id, String name, String description, String job_location, String company_id) {
        sql.executeInsert(
                'INSERT INTO job (id, name, description, job_location, company_id) VALUES (?, ?, ?, ?, ?)',
                [id, name, description, job_location, company_id]
        )
    }

    List<Map> listJob() {
        sql.rows('SELECT name, description, job_location, company_id FROM job ORDER BY id')
    }

    void updateJob(String id, String name, String description, String job_location, String company_id) {
        sql.executeUpdate(
                'UPDATE job SET name = ?, description = ?, job_location = ?, company_id = ? WHERE id = ?',
                [name, description, job_location, company_id, id]
        )
    }

    int deleteJobById(String id) {
        sql.executeUpdate(
                'DELETE FROM job WHERE id = ?',
                [id]
        )
    }
}
