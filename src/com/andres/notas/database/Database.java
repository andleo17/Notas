
package com.andres.notas.database;

public class Database {
    
    public static final String URL = "jdbc:postgres://localhost:5432/";
    public static final String DB = "notas";
    public static final String USER = "postgres";
    public static final String PASSWORD = "123456789";
    
    public static final String TESTUDIANTE = "estudiante";
    public static final String TESTUDIANTE_id = "id";
    public static final String TESTUDIANTE_nombre = "nombre";
    public static final String TESTUDIANTE_apellidos = "apellidos";
    public static final String TESTUDIANTE_email = "email";
    public static final String TESTUDIANTE_password = "pass";

    public static final String TCURSO = "curso";
    public static final String TCURSO_id = "id";
    public static final String TCURSO_nombre = "nombre";
    public static final String TCURSO_creditos = "creditos";

    public static final String TPROFESOR = "profesor";
    public static final String TPROFESOR_id = "id";
    public static final String TPROFESOR_nombre = "nombre";
    public static final String TPROFESOR_apellidos = "apellidos";
    public static final String TPROFESOR_email = "email";
    
    public static final String TCICLO = "ciclo";
    public static final String TCICLO_id = "id";
    public static final String TCICLO_nombre = "nombre";

    public static final String TMATRICULA = "matricula";
    public static final String TMATRICULA_idEstudiante = "idEstudiante";
    public static final String TMATRICULA_idCurso = "idCurso";
    public static final String TMATRICULA_idCiclo = "idCiclo";
    public static final String TMATRICULA_idProfesor = "idProfesor";
    public static final String TMATRICULA_promedioFinal = "promedioFinal";

    public static final String TRUBRICA = "rubrica";
    public static final String TRUBRICA_idEstudiante = "idEstudiante";
    public static final String TRUBRICA_idCurso = "idCurso";
    public static final String TRUBRICA_idCiclo = "idCiclo";
    public static final String TRUBRICA_numeroRubrica = "numeroRubrica";
    public static final String TRUBRICA_peso = "peso";

    public static final String TNOTA = "nota";
    public static final String TNOTA_idEstudiante = "idEstudiante";
    public static final String TNOTA_idCurso = "idCurso";
    public static final String TNOTA_idCiclo = "idCiclo";
    public static final String TNOTA_numeroRubrica = "numeroRubrica";
    public static final String TNOTA_numeroNota = "numeroNota";
    public static final String TNOTA_nota = "nota";
    
}
