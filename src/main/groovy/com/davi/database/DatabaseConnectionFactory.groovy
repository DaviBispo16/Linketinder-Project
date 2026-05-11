package com.davi.database

class DatabaseConnectionFactory {
    static ConnectionFactory getFactory(String type) {
        if (type.equalsIgnoreCase("postgres")) {
            return new PostgresConnectionFactory()
        }
        throw new IllegalArgumentException("Tipo de banco de dados não suportado: " + type)
    }
}
