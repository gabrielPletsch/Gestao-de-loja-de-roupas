package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Venda;
import app.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;

	public String save(Venda venda) {
		this.vendaRepository.save(venda);
		return venda.getEnderecoVenda()+ " salvo com sucesso";
	} 
	
	/*
	public String save(Venda venda) {
		this.vendaRepository.save(venda);
		List <Produto> produtos = venda.getProduto();
		double valorFinal = 0;
		for (Produto produto : produtos) {
			valorFinal += produto.getValorProd();
		}
		venda.setValorFinal(valorFinal);
		vendaRepository.save(venda);
		return valorFinal +" Pedido realizado com sucesso";
	}
	 */

	
	public String update(long idVenda, Venda venda) {
		venda.setIdVenda(idVenda);
		this.vendaRepository.save(venda);
		return " Venda Alterada com sucesso";
	}
	
	public List<Venda> listAll() {
		return this.vendaRepository.findAll();
	}
	
	public Venda findById(long idVenda) {
		Venda venda = this.vendaRepository.findById(idVenda).get();
		return venda;
	}
	
	public String delete(long idVenda) {
		this.vendaRepository.deleteById(idVenda);
		return " Venda deletada";
	}
	
	 //------
	
	public List<Venda> findByVendaValor(double valorVenda){
		return this.vendaRepository.findByVendaValor(valorVenda);
	}
	
	public List<Venda> findByNomeCliente(String nomeCliente){
		return this.vendaRepository.findByClienteNomeCliente(nomeCliente);
	}
	
	public List<Venda> findByFuncionarioNomeFunci(String nomeFunci){
		return this.vendaRepository.findByFuncionarioNomeFunci(nomeFunci);
	}
}