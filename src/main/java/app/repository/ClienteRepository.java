package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	
	public List<Cliente> findByNomeCliente(String nome);
	
	public List<Cliente> findByCpfCliente (String cpf);
	
	public List<Cliente> findByIdadeCliente (int idade);
	
	public List<Cliente> findByTelefoneCliente (int telefone);
}
