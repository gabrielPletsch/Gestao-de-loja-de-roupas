package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
//import app.entity.Venda;
import app.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public String save(Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
		return funcionario.getNomeFunci()+" Funcionario salvo com sucesso!!";
	}
	
	public String update (long id, Funcionario funcionario) {
		funcionario.setIdFunc(id);
		this.funcionarioRepository.save(funcionario);
		return funcionario.getNomeFunci()+" Atualizado funcionario com sucesso!!";
	}
	
	public List<Funcionario> listAll(){
		return this.funcionarioRepository.findAll();
	}
	
	public String delete (long idFuncionario) {
		this.funcionarioRepository.deleteById(idFuncionario);;
		return " Funcionario deletado com sucesso";
	}
	
	public Funcionario findById(long idFuncionario) {

		Funcionario funcionario = this.funcionarioRepository.findById(idFuncionario).get();
		return funcionario;
	}
	
	
	 //------
	
	
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
