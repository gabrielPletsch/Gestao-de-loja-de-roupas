package app.repository;
// Define métodos para operações de banco de dados relacionadas à entidade Produto


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findByNomeProd(String nomeProd);

	// É usada como filtro, se algum parametro acontecer vai ser filtrado
	@Query("FROM Produto p"
			+ " WHERE p.valorProd > :valorProd")
	public List<Produto> findByValorProd(double valorProd);
	
	@Query("SELECT p "
            + "FROM Produto p "
            + "WHERE p. valorProd<= :valorProd")
    public List<Produto> findByPodutoValor(double valorProd);
}