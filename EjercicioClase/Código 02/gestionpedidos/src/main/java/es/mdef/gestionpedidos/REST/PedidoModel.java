package es.mdef.gestionpedidos.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gestionpedidos.entidades.Pedido.PedidoEstado;

@Relation(itemRelation="pedido")
public class PedidoModel extends RepresentationModel<PedidoModel>{

	private String descripcion;
	private PedidoEstado estado = PedidoEstado.Realizado;
	
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
		return "PedidoModel [descripcion=" + descripcion + ", estado=" 
				+ estado + "]";
	}
	
}
