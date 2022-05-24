package com.jfj.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class HikariCPDataSource {


    /**
     * host,port, login, password - can be in app.yml
     * and provide here by @Value annotation
     */
//    @Value("${host}")
//    private final String host;
//    @Value("${port}")
//    private final int port;

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:postgresql://localhost:5432/postgres" );
        config.setUsername( "user" );
        config.setPassword( "passw0rd" );
        config.setSchema("public");
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    public HikariCPDataSource() {
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
