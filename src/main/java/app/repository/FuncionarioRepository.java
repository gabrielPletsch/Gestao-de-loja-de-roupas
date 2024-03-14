package app.repository;
// Define métodos para operações de banco de dados relacionadas à entidade Funcionario

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
	public List<Funcionario> findByNomeFunci(String nome);
	 
	public List<Funcionario> findByMatricula (String matricula);
	
	// É usada como filtro, se algum parametro acontecer vai ser filtrado
	@Query("FROM Funcionario as f "
			+ "Where f.idadeFunci > :idadeFunci") 
	public List<Funcionario> findByIdadeMaior(int idadeFunci);
	
	/*@Query ("FROM Funcionario f WHERE f.matricula > :matricula")
	public List<Funcionario> findByMatricula (String matricula);*/
	
}