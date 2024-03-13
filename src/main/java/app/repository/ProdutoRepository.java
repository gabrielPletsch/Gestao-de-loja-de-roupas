package app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findByNomeProd(String nome);

	public List<Produto> findByValorProd(double nome);

	//public List<Produto> FindByValorProd(int nome);

}