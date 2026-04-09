package com.davi.repository

import groovy.sql.Sql

class SkillRepository {
    private final Sql sql

    SkillRepository(Sql sql) {
        this.sql = sql
    }

    void createTable() {
        sql.execute("""
            CREATE TABLE IF NOT EXISTS skill (
                id varchar(255) primary key,
                name varchar(255) not null,
                created_at timestamp with time zone default CURRENT_TIMESTAMP,
                updated_at timestamp with time zone default CURRENT_TIMESTAMP
            )
        """)
    }

    void insertSkill(String id, String name) {
        sql.executeInsert(
                'INSERT INTO skill (id, name) VALUES (?, ?)',
                [id, name]
        )
    }

    List<Map> listSkill() {
        sql.rows('SELECT id, name FROM skill ORDER BY id')
    }

    void updateSkill(String id, String name) {
        sql.executeUpdate(
                'UPDATE skill SET name = ? WHERE id = ?',
                [name, id]
        )
    }

    int deleteSkillById(String id) {
        sql.executeUpdate(
                'DELETE FROM skill WHERE id = ?',
                [id]
        )
    }
}
