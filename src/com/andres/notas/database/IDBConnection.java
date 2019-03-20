
package com.andres.notas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.andres.notas.database.Database.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface IDBConnection {
    
    default Connection conectarBD() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("No se ha establecido la conexión");
        }
        return DriverManager.getConnection(URL + DB + "?charSet=UTF8", USER, PASSWORD);
    }
    
}
