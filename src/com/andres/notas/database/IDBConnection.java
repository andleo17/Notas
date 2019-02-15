
package com.andres.notas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.andres.notas.database.Database.*;
import java.sql.SQLException;

public interface IDBConnection {
    
    default Connection conectarBD() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL + DB, USER, PASSWORD);
    }
    
}
