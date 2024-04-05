package app.service;
// Intermediário entre a camada de controle(Repository) e a camada de acesso a dados (Controller)
// Contém a lógica de negócios da aplicação.

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;

//Indica para a aplicação (STS/JPA) que este package é uma service
@Service
public class ClienteService {
	
	// Dependências automática elimina a necessdidade de configurar manualmente XML ou JAVA
	@Autowired
	private ClienteRepository clienteRepository; //Ligação entre Service Repository
	
	//CRUD
	
	
	//Create
	public String save(Cliente cliente) {	//Salva o objeto Cliente
		this.clienteRepository.save(cliente); // Manda o objeto para o ClienteRepository(DB)
		return cliente.getNomeCliente()+"Cliente Salvo!"; // Apos ser salvo Aparece o nomeCliente + Msg
	}
	
	
	//Read
	public List<Cliente> listAll(){
		return this.clienteRepository.findAll();
	}
	public Cliente findById(long idClient) {
		
		Cliente cliente = this.clienteRepository.findById(idClient).get();
		return cliente;
	}
	
	
	//Update
	public String update (long id, Cliente cliente) {
		cliente.setIdCliente(id);
		this.clienteRepository.save(cliente);
		return cliente.getNomeCliente()+" Atualizado funcionario com sucesso!!";
	}
	
	
	//Delete
	public String delete (long idClient) {
		this.clienteRepository.deleteById(idClient);;
		return " Cliente deletado com sucesso";
	}
	

	//-- Consulta ao SGDB (Read)--	
	
	public List<Cliente> findByNomeCliente(String nome){
		return this.clienteRepository.findByNomeCliente(nome);
	}
	
	public List<Cliente> findByCpfCliente(String cpf){
		return this.clienteRepository.findByCpfCliente(cpf);
	}
	
	
	public List<Cliente> findByTelefoneCliente(int telefone){
		return this.clienteRepository.findByTelefoneCliente(telefone);
	}
	
}
