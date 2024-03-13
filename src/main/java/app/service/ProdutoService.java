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
		produto.setIdProduto(id);
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

	public List<Produto> findByNomeProd(String nome) {
		return this.produtoRepository.findByNomeProd(nome);

	}

	public List<Produto> findByValorProd(double valor) {
		return this.produtoRepository.findByValorProd(valor);

	}

}