package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
	public List<Funcionario> findByNomeFunci(String nome);
	 
	//@Query("FROM Funcionario as f Where f.idade > :idade")
	public List<Funcionario> findByIdadeFunci(int idade);
	
	//@Query ("FROM Funcionario f WHERE f.Matricula > :Matricula")
	public List<Funcionario> findByMatricula (String Matricula);
	
}