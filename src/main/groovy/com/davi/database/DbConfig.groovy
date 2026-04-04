package com.davi.database

class DbConfig {
    private static String env(String key, String defaultValue) {
        System.getenv(key) ?: defaultValue
    }

    static final String HOST = env('DB_HOST', 'localhost')
    static final String PORT = env('DB_PORT', '5432')
    static final String NAME = env('DB_NAME', 'linketinder')
    static final String USER = env('DB_USER', 'postgres')
    static final String PASSWORD = env('DB_PASSWORD', 'linketinderzg')

    static final String URL = "jdbc:postgresql://${HOST}:${PORT}/${NAME}"
    static final String DRIVER = 'org.postgresql.Driver'
}
