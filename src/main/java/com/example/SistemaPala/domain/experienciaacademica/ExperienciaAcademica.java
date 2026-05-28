package com.example.SistemaPala.domain.experienciaacademica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "experiencia_academica")
public class ExperienciaAcademica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private LocalDateTime fechaBajaExpAcademica;

	@Column
	private LocalDateTime fechaDesdeExpAcademica;

	@Column
	private LocalDateTime fechaHastaExpAcademica;

	@Column(nullable = false, length = 180)
	private String nombreInstitucionExpAcademica;

	@Column(nullable = false, length = 120)
	private String tituloExpAcademica;
}
