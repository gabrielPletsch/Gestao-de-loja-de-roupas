package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	
	public List<Cliente> findByNomeCliente(String nomeCliente);	
	
	public List<Cliente> findByCpfCliente (String cpfCliente);
	
	@Query("FROM Cliente c WHERE c.telefoneCliente > :telefoneCliente" )
	public List<Cliente> findByTelefoneCliente (int telefoneCliente);
}
