# Sistema PALA

Sistema backend en Spring Boot para la gestión general de PALA.

## Estado actual

En esta etapa solo están modeladas las entidades de dominio. No hay todavía `service`, `repository` ni `controller` para estos módulos.

## Entidades creadas

### Postulante
Ubicada en `src/main/java/com/example/SistemaPala/domain/postulante/Postulante.java`.

Campos principales:
- `id`
- `apellidoPostulante`
- `fechaBajaPostulante`
- `fechaNacimientoPostulante`
- `legajoAcademicoPostulante`
- `mailAcademicoPostulante`
- `mailPersonalPostulante`
- `nombrePostulante`
- `urlCVGuardado`

Relaciones:
- `Postulante -> TipoEstudiante`
- `Postulante -> Habilidad`
- `Postulante -> ExperienciaAcademica`
- `Postulante -> Experiencia`
- `Postulante -> PostulanteCarrera`

### TipoEstudiante
Ubicada en `src/main/java/com/example/SistemaPala/domain/tipoestudiante/TipoEstudiante.java`.

Campos principales:
- `id`
- `fechaAltaTipoEstudiante`
- `fechaBajaTipoEstudiante`
- `nombreTipoEstudiante`

Relaciones:
- No tiene relaciones inversas por ahora.

### Habilidad
Ubicada en `src/main/java/com/example/SistemaPala/domain/habilidad/Habilidad.java`.

Campos principales:
- `id`
- `fechaBajaHabilidad`
- `nombreHabilidad`

Relaciones:
- Pertenece a `Postulante` de forma unidireccional.

### ExperienciaAcademica
Ubicada en `src/main/java/com/example/SistemaPala/domain/experienciaacademica/ExperienciaAcademica.java`.

Campos principales:
- `id`
- `fechaBajaExpAcademica`
- `fechaDesdeExpAcademica`
- `fechaHastaExpAcademica`
- `nombreInstitucionExpAcademica`
- `tituloExpAcademica`

Relaciones:
- Pertenece a `Postulante` de forma unidireccional.

### Experiencia
Ubicada en `src/main/java/com/example/SistemaPala/domain/experiencia/Experiencia.java`.

Campos principales:
- `id`
- `descripcionExperiencia`
- `fechaBajaExperiencia`
- `fechaDesdeExperiencia`
- `fechaHastaExperiencia`
- `nombreCargoExperiencia`
- `nombreEmpresaExperiencia`

Relaciones:
- Pertenece a `Postulante` de forma unidireccional.

### PostulanteCarrera
Ubicada en `src/main/java/com/example/SistemaPala/domain/postulantecarrera/PostulanteCarrera.java`.

Campos principales:
- `id`
- `fechaDesdePostulanteCarrera`
- `fechaHastaPostulanteCarrera`

Relaciones:
- `PostulanteCarrera -> Postulante`
- `PostulanteCarrera -> Carrera`

### Carrera
Ubicada en `src/main/java/com/example/SistemaPala/domain/carrera/Carrera.java`.

Campos principales:
- `id`
- `descripcionCarrera`
- `fechaActualizacionCarrera`
- `fechaAltaCarrera`
- `fechaBajaCarrera`
- `nombreCarrera`

Relaciones:
- No conoce `PostulanteCarrera` en sentido inverso.

### Aviso
Ubicada en `src/main/java/com/example/SistemaPala/domain/aviso/Aviso.java`.

Campos principales:
- `id`
- `descripcionAviso`
- `fechaBajaAviso`
- `fechaCierreAviso`
- `fechaCreacionAviso`
- `fechaPublicacionAviso`
- `imagenUrlAviso`
- `nombreAviso`

Relaciones:
- `Postulacion -> Aviso`

### EstadoPostulacion
Ubicada en `src/main/java/com/example/SistemaPala/domain/estadopostulacion/EstadoPostulacion.java`.

Campos principales:
- `id`
- `fechaAltaEstadoPostulacion`
- `fechaBajaEstadoPostulacion`
- `nombreEstadoPostulacion`

Relaciones:
- `Postulacion -> EstadoPostulacion` como estado actual
- No conoce `PostulacionEstado` en sentido inverso

### Postulacion
Ubicada en `src/main/java/com/example/SistemaPala/domain/postulacion/Postulacion.java`.

Campos principales:
- `id`
- `descripcionPostulacion`
- `fechaPostulacion`
- `urlCVPostulacion`

Relaciones:
- `Postulacion -> Postulante`
- `Postulacion -> EstadoPostulacion`
- `Postulacion -> Aviso`
- `Postulacion -> PostulacionEstado`

### PostulacionEstado
Ubicada en `src/main/java/com/example/SistemaPala/domain/postulacionestado/PostulacionEstado.java`.

Campos principales:
- `id`
- `contadorPostulacionEstado`
- `fechaFinVigenciaEP`
- `fechaInicioVigenciaEP`

Relaciones:
- `PostulacionEstado -> EstadoPostulacion`
- Es la clase intermedia del historial de estados de una postulacion

## Cardinalidades actuales

- `Postulante * -> 1 TipoEstudiante`
- `Postulante 1 -> 0..* Habilidad`
- `Postulante 1 -> 0..* ExperienciaAcademica`
- `Postulante 1 -> 0..* Experiencia`
- `Postulante 1 -> * PostulanteCarrera`
- `PostulanteCarrera * -> 1 Carrera`
- `Postulacion * -> 1 Postulante`
- `Postulacion * -> 1 EstadoPostulacion`
- `Postulacion 1 -> * PostulacionEstado`
- `PostulacionEstado * -> 1 EstadoPostulacion`
- `Postulacion * -> 1 Aviso`

## Convenciones aplicadas

- Todas las entidades usan `Long id` como clave primaria.
- Las relaciones son unidireccionales salvo la entidad intermedia `PostulanteCarrera`, que mantiene relación con sus dos extremos.
- `EstadoPostulacion` no conoce `PostulacionEstado`.
- `Carrera` no conoce `PostulanteCarrera`.

