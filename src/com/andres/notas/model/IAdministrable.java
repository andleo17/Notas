package com.andres.notas.model;

import java.sql.SQLException;

public interface IAdministrable {

    void agregar() throws SQLException;
    void actualizar() throws SQLException ;
    void eliminar() throws SQLException ;
    
}