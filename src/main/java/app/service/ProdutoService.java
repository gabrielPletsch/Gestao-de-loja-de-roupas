package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.repository.ProdutoRepository;

@Service

public class ProdutoService {

	@Autowired

	private ProdutoRepository produtoRepository;
	public String save(Produto produto) {
		this.produtoRepository.save(produto);
		return produto.getNomeProd() + " Produto Salvo com Sucesso";

	}

	public String update(long id, Produto produto) {
		produto.setIdProd(id);
		this.produtoRepository.save(produto);
		return produto.getNomeProd() + " Produto Atualizado com Sucesso";

	}

	public List<Produto> listAll() {
		return this.produtoRepository.findAll();

	}

	public Produto findById(long idProduto) {
		Produto produto = this.produtoRepository.findById(idProduto).get();
		return produto;

	}

	public String delete(long idProduto) {
		this.produtoRepository.deleteById(idProduto);
		return "Produto Deletado com Sucesso!";

	}
	
	
	//-----
	
	
	
	public List<Produto> findByIdProd(long idProduto){
		Produto produto = new Produto();
		produto.setIdProd(idProduto);
		return this.produtoRepository.findByIdProd(idProduto);
	}
	

	public List<Produto> findByNomeProd(String nome) {
		return this.produtoRepository.findByNomeProd(nome);

	}

	public List<Produto> findByValorProd(double valor) {
		return this.produtoRepository.findByValorProd(valor);

	}
	
	public List<Produto> filterStartWord (String nomeProd){
		return this.produtoRepository.filterStartWord(nomeProd);
	}

}