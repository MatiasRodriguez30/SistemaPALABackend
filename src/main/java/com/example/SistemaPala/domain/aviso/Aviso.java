package com.example.SistemaPala.domain.aviso;

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
@Table(name = "aviso")
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String descripcionAviso;

	@Column
	private LocalDateTime fechaBajaAviso;

	@Column(nullable = false)
	private LocalDateTime fechaCierreAviso;

	@Column(nullable = false)
	private LocalDateTime fechaCreacionAviso;

	@Column(nullable = false)
	private LocalDateTime fechaPublicacionAviso;

	@Column(nullable = false, length = 255)
	private String imagenUrlAviso;

	@Column(nullable = false, length = 120)
	private String nombreAviso;
}
