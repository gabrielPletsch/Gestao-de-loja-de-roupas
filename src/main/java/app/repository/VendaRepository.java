package app.repository;
// Define métodos para operações de banco de dados relacionadas à entidade Venda


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Venda;


public interface VendaRepository extends JpaRepository<Venda, Long> {

		
	public List<Venda> findByClienteNomeCliente(String nomeCliente);
	
	public List<Venda> findByFuncionarioNomeFunci(String nomeFunci);
	
	// É usada como filtro, se algum parametro acontecer vai ser filtrado
	@Query("FROM Venda v "
			+ "WHERE v.valorVenda >= :valorVenda")
	public List<Venda> findByVendaValor(double valorVenda);
	
}