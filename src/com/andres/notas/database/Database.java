
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
    public static final String TESTUDIANTE_contraseña = "contraseña";

    public static final String TCURSO = "curso";
    public static final String TCURSO_id = "id";
    public static final String TCURSO_creditos = "creditos";

    public static final String TPROFESOR = "profesor";
    public static final String TPROFESOR_id = "id";
    public static final String TPROFESOR_nombre = "nombre";
    public static final String TPROFESOR_apellidos = "apellidos";
    public static final String TPROFESOR_email = "email";
    
    public static final String TCICLO = "ciclo";
    public static final String TCICLO_ID = "id";
    public static final String TCICLO_NOMBRE = "nombre";

    public static final String TMATRICULA = "matricula";
    public static final String TMATRICULA_IDESTUDIANTE = "idEstudiante";
    public static final String TMATRICULA_IDCURSO = "idCurso";
    public static final String TMATRICULA_IDCICLO = "idCiclo";
    public static final String TMATRICULA_IDPROFESOR = "idProfesor";
    public static final String TMATRICULA_PROMEDIOFINAL = "promedioFinal";

    public static final String TRUBRICA = "rubrica";
    public static final String TRUBRICA_IDESTUDIANTE = "idEstudiante";
    public static final String TRUBRICA_IDCURSO = "idCurso";
    public static final String TRUBRICA_IDCICLO = "idCiclo";
    public static final String TRUBRICA_NUMERORUBRICA = "numeroRubrica";
    public static final String TRUBRICA_PESO = "peso";

    public static final String TNOTA = "nota";
    public static final String TNOTA_IDESTUDIANTE = "idEstudiante";
    public static final String TNOTA_IDCURSO = "idCurso";
    public static final String TNOTA_IDCICLO = "idCiclo";
    public static final String TNOTA_NUMERORUBRICA = "numeroRubrica";
    public static final String TNOTA_NUMERONOTA = "numeroNota";
    public static final String TNOTA_NOTA = "nota";
    
}
