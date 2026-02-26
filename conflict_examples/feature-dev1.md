
# feature/dev1 — ejemplo de cambio conflictivo

Objetivo:
- En la rama `feature/dev1` edita la línea marcada en `ConflictProneService.buildMessage()`.

Sugerencia de cambio (hacer en `feature/dev1`):
1. Abre `src/main/java/com/example/demo/conflict/ConflictProneService.java`.
2. Localiza la línea: `return "BASE MESSAGE - change me in your feature branch";`.
3. Cámbiala por algo propio de dev1, por ejemplo:
   `return "Feature DEV1: añade soporte para login SSO";`

Propósito:
- Si otras ramas cambian la misma línea, al hacer merge se generará un conflicto que deberás resolver manualmente.
