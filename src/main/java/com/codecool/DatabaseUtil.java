package com.codecool;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DatabaseUtil {
    public static DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL("jdbc:postgresql://localhost:5432/");
        dataSource.setUser("ElProyecteGrande");
        dataSource.setPassword("ElProyecteGrande");
        dataSource.setDatabaseName("ElProyecteGrande");
        dataSource.getConnection().close();
        return dataSource;
    }
}

