package com.davi.database

import groovy.sql.Sql

interface ConnectionFactory {
    Sql createConnection()
}
