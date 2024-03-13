package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
	public List<Funcionario> findByNomeFunci(String nome);
	 
	public List<Funcionario> findByIdadeFunci(int idadeFunci);
	
	public List<Funcionario > findByIdFunc (long idFunc);
	
	//@Query ("FROM Funcionario f WHERE f.Matricula > :Matricula")
	public List<Funcionario> findByMatricula (String Matricula);
	
}