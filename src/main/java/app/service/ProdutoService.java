package app.service;
//Intermediário entre a camada de controle(Repository) e a camada de acesso a dados (Controller)
//Contém a lógica de negócios da aplicação.

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.repository.ProdutoRepository;

//Indica para a aplicação (STS/JPA) que este package é uma service
@Service
public class ProdutoService {

	// Dependências automática elimina a necessdidade de configurar manualmente XML ou JAVA
	@Autowired

	private ProdutoRepository produtoRepository;//Ligação entre Service Repository

	//CRUD
	
	//Create
	public String save(Produto produto) {
		this.produtoRepository.save(produto);
		return produto.getNomeProd() + " Produto Salvo com Sucesso";
	}

	//Read
	public List<Produto> listAll() {
		return this.produtoRepository.findAll();
	}

	public Produto findById(long idProduto) {
		Produto produto = this.produtoRepository.findById(idProduto).get();
		return produto;
	}
	
	//Update
	public String update(long id, Produto produto) { //Recebe o ID a ser modificado
		produto.setIdProd(id); // define o id do produto salvo com o atualizado
		this.produtoRepository.save(produto); // Salva o objeto atuaizado no DB
		return produto.getNomeProd() + " Produto Atualizado com Sucesso"; //Retorna para o Prod + msg
	}

	//Delete
	public String delete(long idProduto) {
		this.produtoRepository.deleteById(idProduto);
		return "Produto Deletado com Sucesso!";
	}
	
	
	//-- Consulta ao SGDB (Read)--
	

	public List<Produto> findByNomeProd(String nome) {
		return this.produtoRepository.findByNomeProd(nome);

	}

	public List<Produto> findByValorProd(double valor) {
		return this.produtoRepository.findByValorProd(valor);

	}
	
	public List<Produto> findByPodutoValor(double valorProd){
        return this.produtoRepository.findByPodutoValor(valorProd);
    }

}