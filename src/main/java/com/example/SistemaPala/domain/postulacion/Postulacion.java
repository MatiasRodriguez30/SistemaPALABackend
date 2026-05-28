package com.example.SistemaPala.domain.postulacion;

import com.example.SistemaPala.domain.aviso.Aviso;
import com.example.SistemaPala.domain.estadopostulacion.EstadoPostulacion;
import com.example.SistemaPala.domain.postulacionestado.PostulacionEstado;
import com.example.SistemaPala.domain.postulante.Postulante;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "postulacion")
public class Postulacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String descripcionPostulacion;

	@Column(nullable = false)
	private LocalDateTime fechaPostulacion;

	@Column(nullable = false, length = 255)
	private String urlCVPostulacion;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "postulante_id", nullable = false)
	private Postulante postulante;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_postulacion_actual_id", nullable = false)
	private EstadoPostulacion estadoPostulacionActual;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "aviso_id", nullable = false)
	private Aviso aviso;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "postulacion_id")
	private List<PostulacionEstado> postulacionEstados = new ArrayList<>();
}
