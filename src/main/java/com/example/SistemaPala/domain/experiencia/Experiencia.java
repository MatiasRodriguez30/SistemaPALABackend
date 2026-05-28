package com.example.SistemaPala.domain.experiencia;

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
@Table(name = "experiencia")
public class Experiencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String descripcionExperiencia;

	@Column
	private LocalDateTime fechaBajaExperiencia;

	@Column(nullable = false)
	private LocalDateTime fechaDesdeExperiencia;

	@Column(nullable = false)
	private LocalDateTime fechaHastaExperiencia;

	@Column(nullable = false, length = 150)
	private String nombreCargoExperiencia;

	@Column(nullable = false, length = 150)
	private String nombreEmpresaExperiencia;
}
