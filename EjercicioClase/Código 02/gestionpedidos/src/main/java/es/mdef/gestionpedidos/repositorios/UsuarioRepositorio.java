package es.mdef.gestionpedidos.repositorios;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.mdef.gestionpedidos.entidades.Usuario;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>  {
//	public List<Usuario> usuariosAplicacion;
}
