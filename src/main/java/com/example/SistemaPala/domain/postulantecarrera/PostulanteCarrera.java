package com.example.SistemaPala.domain.postulantecarrera;

import com.example.SistemaPala.domain.carrera.Carrera;
import com.example.SistemaPala.domain.postulante.Postulante;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "postulante_carrera")
public class PostulanteCarrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime fechaDesdePostulanteCarrera;

	@Column
	private LocalDateTime fechaHastaPostulanteCarrera;

	@ManyToOne(optional = false)
	@JoinColumn(name = "postulante_id", nullable = false)
	private Postulante postulante;

	@ManyToOne(optional = false)
	@JoinColumn(name = "carrera_id", nullable = false)
	private Carrera carrera;
}
