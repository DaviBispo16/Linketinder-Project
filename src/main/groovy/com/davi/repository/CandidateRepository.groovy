package com.davi.repository

import groovy.sql.Sql

class CandidateRepository {
    private final Sql sql

    CandidateRepository(Sql sql) {
        this.sql = sql
    }

    void createTable() {
        sql.execute("""
            CREATE TABLE IF NOT EXISTS candidate (
                id varchar(255) primary key,
                first_name varchar(100) not null,
                last_name varchar(100) not null,
                email varchar(255) unique not null,
                cpf varchar(14) not null unique,
                description text,
                password varchar(255) not null,
                created_at timestamp with time zone default CURRENT_TIMESTAMP,
                updated_at timestamp with time zone default CURRENT_TIMESTAMP,
                location_id varchar(255) references location(id)
            )
        """)
    }

    void insertCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password, String location_id) {
        sql.executeInsert(
                'INSERT INTO candidate (id, first_name, last_name, email, cpf, description, password, location_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)',
                [id, first_name, last_name, email, cpf, description, password, location_id]
        )
    }

    List<Map> listCandidate() {
        sql.rows('SELECT first_name, last_name, email, cpf, description FROM candidate ORDER BY id')
    }

    Map findCandidateById(Long id) {
        sql.firstRow(
                'SELECT first_name, last_name, email, cpf, description FROM candidate WHERE id = ?',
                [id]
        )
    }

    void updateCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password) {
        sql.executeUpdate(
                '''
                    UPDATE candidate
                    SET first_name = ?, last_name = ?, email = ?, cpf = ?, description = ?, password = ?
                    WHERE id = ?
                    ''',
                [first_name, last_name, email, cpf, description, password, id]
        )
    }

    int deleteCandidateById(Long id) {
        sql.executeUpdate(
                'DELETE FROM candidate WHERE id = ?',
                [id]
        )
    }
}
