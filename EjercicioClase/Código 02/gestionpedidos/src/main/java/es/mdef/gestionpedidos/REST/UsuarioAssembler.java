package es.mdef.gestionpedidos.REST;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import es.mdef.gestionpedidos.entidades.Usuario;

@Component
public class UsuarioAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>> {

	@Override
	public EntityModel<Usuario> toModel(Usuario entity) {
		EntityModel<Usuario> model = EntityModel.of(entity);
		model.add(linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel());
		return model;
	}

	public Usuario toEntity(UsuarioModel model) {
		Usuario usuario = new Usuario();
		usuario.setNombre(model.getNombre());
		usuario.setContrasena(model.getContrasena());
		return usuario;
	}

}
