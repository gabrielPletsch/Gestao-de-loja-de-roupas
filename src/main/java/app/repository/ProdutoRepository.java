package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findByNomeProd(String nomeProd);

	
	@Query("FROM Produto p WHERE p.valorProd > :valorProd")
	public List<Produto> findByValorProd(double valorProd);
}