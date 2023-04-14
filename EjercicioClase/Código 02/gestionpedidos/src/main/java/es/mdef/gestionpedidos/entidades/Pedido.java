package es.mdef.gestionpedidos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PEDIDOS")
public class Pedido {
	public static enum PedidoEstado {
		Realizado,
		Preparado,
		Enviado,
		Recibido
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String descripcion;
	private PedidoEstado estado = PedidoEstado.Realizado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public PedidoEstado getEstado() {
		return estado;
	}
	public void setEstado(PedidoEstado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
	
	
}
