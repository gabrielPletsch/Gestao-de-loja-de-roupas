package app.service;
//Intermediário entre a camada de controle(Repository) e a camada de acesso a dados (Controller)
//Contém a lógica de negócios da aplicação.

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
//import app.entity.Venda;
import app.repository.FuncionarioRepository;

//Indica para a aplicação (STS/JPA) que este package é uma service
@Service
public class FuncionarioService {

	// Dependências automática elimina a necessdidade de configurar manualmente XML ou JAVA
	@Autowired
	private FuncionarioRepository funcionarioRepository; //Ligação entre Service Repository
	
	//CRUD
	
	
	//Create
	public String save(Funcionario funcionario) { 	
		this.funcionarioRepository.save(funcionario);
		return funcionario.getNomeFunci()+" Funcionario salvo com sucesso!!";
	}
	
	
	//Read
	public List<Funcionario> listAll(){ //retorna a lista contendo todos os registros da entidade Funcionario do DB
		return this.funcionarioRepository.findAll(); // retorna a lista de funcionários obtida do DB
	}
	public Funcionario findById(long idFuncionario) { // Recebe o ID a ser buscado
		Funcionario funcionario = this.funcionarioRepository.findById(idFuncionario).get(); //Get pega o objeto funcionario
		return funcionario; //Retorna o objeto Funcionario (DB)
	}
	
	
	//Update
	public String update (long id, Funcionario funcionario) { 
		funcionario.setIdFunc(id); 
		this.funcionarioRepository.save(funcionario);
		return funcionario.getNomeFunci()+" Atualizado funcionario com sucesso!!";
	}
	
	
	//Delete
	public String delete (long idFuncionario) {
		this.funcionarioRepository.deleteById(idFuncionario);;
		return " Funcionario deletado com sucesso";
	}
	
	
	//-- Consulta ao SGDB (Read)--

	
	public List<Funcionario> findByNomeFunci(String nome){
		return this.funcionarioRepository.findByNomeFunci(nome);
	}
	
	public List<Funcionario> findByIdadeMaior(int idadeFunci){
		return this.funcionarioRepository.findByIdadeMaior(idadeFunci);
	}	
	
	public List<Funcionario> findByMatricula(String matricula){
		return this.funcionarioRepository.findByMatricula(matricula);
	}
	
	
}
