package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public String save(Cliente cliente) {
		this.clienteRepository.save(cliente);
		return cliente.getNomeCliente()+" Cliente Salvo!";
		
	}
	
	public String update (long id, Cliente cliente) {
		cliente.setIdCliente(id);
		this.clienteRepository.save(cliente);
		return cliente.getNomeCliente()+" Atualizado funcionario com sucesso!!";
	}
	
	public List<Cliente> listAll(){
		return this.clienteRepository.findAll();
	}
	
	public String delete (long idClient) {
		this.clienteRepository.deleteById(idClient);;
		return " Cliente deletado com sucesso";
	}
	
	public Cliente findById(long idClient) {

		Cliente cliente = this.clienteRepository.findById(idClient).get();
		return cliente;
	}
	
	public List<Cliente> findByNomeCliente(String nome){
		return this.clienteRepository.findByNomeCliente(nome);
	}
//	
//	public List<Cliente> findByCpfCliente(String cpf){
//		return this.clienteRepository.findByCpfCliente(cpf);
//	}
	
	
	/*public List<Cliente> findByVenda(long id(){
		Venda venda = new venda();
		venda.setIdVenda(id);
		return this.clienteRepository.findByVenda(venda);
	}*/
	
}
