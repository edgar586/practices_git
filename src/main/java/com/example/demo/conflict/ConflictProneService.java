
package com.example.demo.conflict;

public class ConflictProneService {

    /**
     * Esta clase contiene una única sección marcada donde cada rama feature/*
     * debe aplicar cambios intencionales para provocar conflictos.
     *
     * Instrucciones: en cada rama modifica SOLO la línea marcada con
     * "// EDIT HERE (feature/devX)" y cambia el texto retornado.
     */
    public String buildMessage() {
        // BEGIN FEATURE_SECTION
        // NOTE: Cada rama feature/dev1..dev6 debe editar la siguiente línea
        // EDIT HERE (feature/devX): cambia el mensaje para tu feature
        return "Feature DEV5: soporte para bloqueo de cuenta";
        // END FEATURE_SECTION
    }
}
