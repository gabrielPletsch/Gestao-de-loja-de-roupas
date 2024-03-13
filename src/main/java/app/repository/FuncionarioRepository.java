package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{
	
	public List<Funcionario> findByNomeFunci(String nomeFunc);
	 
	public List<Funcionario> findByIdadeFunci (int idadeFunc);
	
	public List<Funcionario > findByIdFunc (long idFunc);
	
	@Query ("FROM Funcionario f WHERE M.Matricula > :Matricula")
	public List<Funcionario> findByMatricula (String Matricula);
	
}