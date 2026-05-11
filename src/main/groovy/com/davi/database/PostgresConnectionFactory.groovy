package com.davi.database

import groovy.sql.Sql

class PostgresConnectionFactory implements ConnectionFactory {
    private static Sql connectionInstance

    @Override
    Sql createConnection() {
        if (connectionInstance == null) {
            connectionInstance = Sql.newInstance(
                    DbConfig.URL,
                    DbConfig.USER,
                    DbConfig.PASSWORD,
                    DbConfig.DRIVER
            )
        }
        return connectionInstance
    }
}
