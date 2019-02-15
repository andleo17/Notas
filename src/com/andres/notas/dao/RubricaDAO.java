package com.andres.notas.dao;

import static com.andres.notas.database.Database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.andres.notas.database.IDBConnection;
import com.andres.notas.model.Matricula;
import com.andres.notas.model.Rubrica;

public interface RubricaDAO extends IDBConnection, NotaDAO {

    default ArrayList<Rubrica> obtenerRubricas(Matricula matricula) {
        ArrayList<Rubrica> rubricas = new ArrayList<>();

        try (Connection connection = conectarBD()) {
            String query = String.format("SELECT * FROM %s WHERE %s = ?, %s = ?, %s = ?;",
                            TRUBRICA,
                            TRUBRICA_idCiclo,
                            TRUBRICA_idCurso,
                            TRUBRICA_idEstudiante);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, matricula.getIdCiclo());
            ps.setInt(2, matricula.getIdCurso());
            ps.setInt(3, matricula.getIdEstudiante());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Rubrica rubrica = new Rubrica();
                rubrica.setIdCiclo(rs.getInt(TRUBRICA_idCiclo));
                rubrica.setIdCurso(rs.getInt(TRUBRICA_idCurso));
                rubrica.setIdEstudiante(rs.getInt(TRUBRICA_idEstudiante));
                rubrica.setNumeroRubrica(rs.getInt(TRUBRICA_numeroRubrica));
                rubrica.setPeso(rs.getFloat(TRUBRICA_peso));
                rubrica.setNotas(obtenerNotas(rubrica));
                rubricas.add(rubrica);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rubricas;
    }

    default void agregar(Rubrica rubrica) {
        try (Connection connection = conectarBD()) {
            String insert = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?);",
                                TRUBRICA,
                                TRUBRICA_idCiclo,
                                TRUBRICA_idCurso,
                                TRUBRICA_idEstudiante,
                                TRUBRICA_numeroRubrica,
                                TRUBRICA_peso);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setInt(1, rubrica.getIdCiclo());
            ps.setInt(2, rubrica.getIdCurso());
            ps.setInt(3, rubrica.getIdEstudiante());
            ps.setInt(4, rubrica.getNumeroRubrica());
            ps.setFloat(5, rubrica.getPeso());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void actualizar(Rubrica rubrica) {
        try (Connection connection = conectarBD()){
            String update = String.format("UPDATE %s SET %s = ? WHERE %s = ? AND %s = ? AND %s = ? AND %s = ?;",
                                TRUBRICA,
                                TRUBRICA_peso,
                                TRUBRICA_idCiclo,
                                TRUBRICA_idCurso,
                                TRUBRICA_idEstudiante,
                                TRUBRICA_numeroRubrica);
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setFloat(1, rubrica.getPeso());
            ps.setInt(2, rubrica.getIdCiclo());
            ps.setInt(3, rubrica.getIdCurso());
            ps.setInt(4, rubrica.getIdEstudiante());
            ps.setInt(5, rubrica.getNumeroRubrica());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void eliminar(Rubrica rubrica) {
        try (Connection connection = conectarBD()) {
            String delete = String.format("DELETE FROM %s WHERE %s = ? AND %s = ?, %s = ?, %s = ?;", 
                                TRUBRICA,
                                TRUBRICA_idCiclo,
                                TRUBRICA_idCurso,
                                TRUBRICA_idEstudiante,
                                TRUBRICA_numeroRubrica);
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1, rubrica.getIdCiclo());
            ps.setInt(2, rubrica.getIdCurso());
            ps.setInt(3, rubrica.getIdEstudiante());
            ps.setInt(4, rubrica.getNumeroRubrica());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}