package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Cliente;
import app.entity.Venda;


public interface VendaRepository extends JpaRepository<Venda, Long> {

	public List<Venda> findByCliente (Cliente cliente);
		
	public List<Venda> findByFuncionarioNomeFunci(String nome);
	
	@Query("FROM Venda v WHERE v.valorVenda > :valorVenda")
	public List<Venda> vendaValor(double valorVenda);
	
}