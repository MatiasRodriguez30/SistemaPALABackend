package com.example.SistemaPala.domain.postulante;

import com.example.SistemaPala.domain.carrera.Carrera;
import com.example.SistemaPala.domain.experiencia.Experiencia;
import com.example.SistemaPala.domain.experienciaacademica.ExperienciaAcademica;
import com.example.SistemaPala.domain.habilidad.Habilidad;
import com.example.SistemaPala.domain.postulantecarrera.PostulanteCarrera;
import com.example.SistemaPala.domain.tipoestudiante.TipoEstudiante;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "postulante")
public class Postulante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 120)
	private String apellidoPostulante;

	@Column(nullable = false)
	private LocalDateTime fechaBajaPostulante;

	@Column(nullable = false)
	private LocalDate fechaNacimientoPostulante;

	@Column(nullable = false)
	private LocalDateTime legajoAcademicoPostulante;

	@Column(nullable = false, length = 180)
	private String mailAcademicoPostulante;

	@Column(nullable = false, length = 180)
	private String mailPersonalPostulante;

	@Column(nullable = false, length = 120)
	private String nombrePostulante;

	@Column(nullable = false, length = 255)
	private String urlCVGuardado;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_estudiante_id", nullable = false)
	private TipoEstudiante tipoEstudiante;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "postulante_id")
	private List<Habilidad> habilidades = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "postulante_id")
	private List<ExperienciaAcademica> experienciasAcademicas = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "postulante_id")
	private List<Experiencia> experiencias = new ArrayList<>();

	@OneToMany(mappedBy = "postulante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostulanteCarrera> postulanteCarreras = new ArrayList<>();
}
