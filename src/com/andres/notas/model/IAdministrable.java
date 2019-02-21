package com.andres.notas.model;

import java.sql.SQLException;

public interface IAdministrable {

    void agregar() throws SQLException;
    void actualizar();
    void eliminar();
    
}