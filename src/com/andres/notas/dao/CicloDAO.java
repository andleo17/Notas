package com.andres.notas.dao;

import java.sql.Connection;

import com.andres.notas.database.IDBConnection;
import com.andres.notas.model.Ciclo;
import static com.andres.notas.database.Database.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public interface CicloDAO extends IDBConnection{

    default Ciclo obtenerCicloActual() {
        Ciclo c = new Ciclo();
        ArrayList<Ciclo> ciclos = new ArrayList<>();
        try (Connection connection = conectarBD()) {
            String query = String.format("SELECT * FROM %s WHERE %s LIKE EXTRACT(YEAR FROM CURRENT_DATE)::VARCHAR || ", 
                TCICLO,
                TCICLO_nombre);
            query = query + "\'%\'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Ciclo ciclo = new Ciclo();
                ciclo.setId(rs.getInt(TCICLO_id));
                ciclo.setNombre(rs.getString(TCICLO_nombre));
                
                ciclos.add(ciclo);
            }
            ps.close();
            
            if (LocalDate.now().getMonthValue() < 8){
                c = ciclos.get(0);
            }else {
                c = ciclos.get(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }
}