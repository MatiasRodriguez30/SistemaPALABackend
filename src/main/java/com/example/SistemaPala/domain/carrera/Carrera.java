package com.example.SistemaPala.domain.carrera;

import com.example.SistemaPala.domain.postulantecarrera.PostulanteCarrera;
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
@Table(name = "carrera")
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150)
	private String descripcionCarrera;

	@Column(nullable = false)
	private LocalDateTime fechaActualizacionCarrera;

	@Column(nullable = false)
	private LocalDateTime fechaAltaCarrera;

	@Column
	private LocalDateTime fechaBajaCarrera;

	@Column(nullable = false, length = 120)
	private String nombreCarrera;
}
