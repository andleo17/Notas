
package com.andres.notas.dao;

import com.andres.notas.database.IDBConnection;
import com.andres.notas.model.Curso;
import java.sql.Connection;
import java.util.ArrayList;
import static com.andres.notas.database.Database.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface CursoDAO extends IDBConnection {
    
    default ArrayList<Curso> consultarLista(){
        ArrayList<Curso> cursos = new ArrayList<>();
        
        try (Connection connection = conectarBD()){
            String query = String.format("SELECT * FROM %s ORDER BY %s;",
                            TCURSO,
                            TCURSO_id);
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt(TCURSO_id));
                curso.setNombre(rs.getString(TCURSO_nombre));
                curso.setCreditos(rs.getInt(TCURSO_creditos));
                cursos.add(curso);
            }
            
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cursos;
    }
    
    default void agregar(Curso curso){
        try (Connection connection = conectarBD()){
            String insert = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?);",
                                TCURSO,
                                TCURSO_nombre,
                                TCURSO_creditos);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, curso.getNombre());
            ps.setInt(2, curso.getCreditos());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void actualizar(Curso curso) {
        try (Connection connection = conectarBD()) {
            String update = String.format("UPDATE %s SET %s = ?, %s = ? WHERE %s = ?;",
                                TCURSO,
                                TCURSO_nombre,
                                TCURSO_creditos,
                                TCURSO_id);
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, curso.getNombre());
            ps.setInt(2, curso.getCreditos());
            ps.setInt(3, curso.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void eliminar(Curso curso) {
        try (Connection connection = conectarBD()){
            String delete = String.format("DELETE FROM %s WHERE %s = ?;", TCURSO, TCURSO_id);
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1, curso.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
