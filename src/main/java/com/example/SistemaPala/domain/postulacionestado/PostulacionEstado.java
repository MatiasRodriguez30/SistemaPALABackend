package com.example.SistemaPala.domain.postulacionestado;

import com.example.SistemaPala.domain.estadopostulacion.EstadoPostulacion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "postulacion_estado")
public class PostulacionEstado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer contadorPostulacionEstado;

	@Column(nullable = false)
	private LocalDateTime fechaFinVigenciaEP;

	@Column(nullable = false)
	private LocalDateTime fechaInicioVigenciaEP;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_postulacion_id", nullable = false)
	private EstadoPostulacion estadoPostulacion;
}
