package app.service;
//Intermediário entre a camada de controle(Repository) e a camada de acesso a dados (Controller)
//Contém a lógica de negócios da aplicação.

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;

//Indica para a aplicação (STS/JPA) que este package é uma service
@Service
public class VendaService {

	// Dependências automática elimina a necessdidade de configurar manualmente XML ou JAVA
	@Autowired
	private VendaRepository vendaRepository; //Ligação entre Service Repository

	//CRUD

	/*public String save(Venda venda) {
		this.vendaRepository.save(venda);
		return venda.getEnderecoVenda()+ " salvo com sucesso";
	} */


	//Create	
	//For para percorrer os produtos dentro da venda e retornar o valor final
	public String save(Venda venda) {
		double total = this.calcularValorTotal(venda.getProduto());
		venda.setValorFinal(total);
		vendaRepository.save(venda);
		return " foi o valor total da compra!";
	}

	public double calcularValorTotal (List<Produto> produtos) {
		DecimalFormat df = new DecimalFormat("##,##"); 
		double valorFinal = 0;
		
		if(produtos != null)
			for (Produto produto : produtos) {		
				valorFinal += produto.getValorProd();
			}
		
		
		String valorFormatado = df.format(valorFinal);
		return valorFinal;
	}

	//Read
	public List<Venda> listAll() {
		return this.vendaRepository.findAll();
	}
	public Venda findById(long idVenda) {
		Venda venda = this.vendaRepository.findById(idVenda).get();
		return venda;
	}

	//Update
	public String update(long idVenda, Venda venda) {
		venda.setIdVenda(idVenda);
		this.vendaRepository.save(venda);
		return " Venda Alterada com sucesso";
	}

	//Delete
	public String delete(long idVenda) { //Recebe o ID da excluisao
		this.vendaRepository.deleteById(idVenda);//Define se os ID existe(Repository) e exclui o objeto no (DB)
		return " Venda deletada"; //Retorna a mensagem 
	}


	//-- Consulta ao SGDB (Read)--


	public List<Venda> findByVendaValor(double valorVenda){ //Recebe o valorVenda(parametro)
		return this.vendaRepository.findByVendaValor(valorVenda); // Mnada para o repository fazer a busca no DB
	}

	public List<Venda> findByNomeCliente(String nomeCliente){
		return this.vendaRepository.findByClienteNomeCliente(nomeCliente);
	}

	public List<Venda> findByFuncionarioNomeFunci(String nomeFunci){
		return this.vendaRepository.findByFuncionarioNomeFunci(nomeFunci);
	}
}