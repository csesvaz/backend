package es.mdef.gestionpedidos.REST;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.mdef.gestionpedidos.entidades.Usuario;
import es.mdef.gestionpedidos.repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private final UsuarioRepositorio repositorio;
	private final UsuarioAssembler assembler;

	UsuarioController(UsuarioRepositorio repositorio, UsuarioAssembler assembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;

	}
	@GetMapping("{id}")
	public EntityModel<Usuario> one(@PathVariable Long id) {
		Usuario usuario = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		return assembler.toModel(usuario);
	}
	@PostMapping
	public EntityModel<Usuario> add(@RequestBody UsuarioModel model) {
		Usuario usuario = repositorio.save(assembler.toEntity(model));
		return assembler.toModel(usuario);
	}
	
}


//	
//
//	
//	
//	@PutMapping("{id}")
//	public EntityModel<Pedido> edit(@PathVariable Long id, @RequestBody PedidoModel model) {
//		Pedido pedido = repositorio.findById(id).map(ped -> {
//			ped.setDescripcion(model.getDescripcion());
//			ped.setEstado(model.getEstado());
//			return repositorio.save(ped);
//		})
//		.orElseThrow(() -> new RegisterNotFoundException(id, "pedido"));
//		log.info("Actualizado " + pedido);
//		return assembler.toModel(pedido);
//	}
//	
//	@DeleteMapping("{id}")
//	public void delete(@PathVariable Long id) {
//		log.info("Borrado pedido " + id);
//		repositorio.deleteById(id);
//	}
//}
