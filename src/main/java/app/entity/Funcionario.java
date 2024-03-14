package app.entity;
// Local para armazenar as classes que representam as entidades do DB

import java.util.List;

//import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Biblioteca "Lombok"(POM), permite utilizar anotation que encurtam o código, definindo  
// Getters and Setters automaticamente, com base nos atributos declarados
@Getter
@Setter

// Criar uma instância da classe Funcionario passando todos os parâmetros diretamente para o construtor
@AllArgsConstructor

// Gerar automaticamente um construtor sem argumentos
@NoArgsConstructor

// Está afirmando para a aplicação(STS/JPA) que este package é uma entity
@Entity
public class Funcionario {
	
	// Indicar que o atributo idFunc é o ID da aplicação
	@Id
	// Gerar um valor automaticamente para o ID (auto_Increment), já possui NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFunc;
	
	// Afirmar ao STS/JPA que tal atributo não deve ser nulo 
	@NotNull (message = "nomeFunci não pode ser nulo")
	private String nomeFunci;
	
	@NotNull (message = "idadeFunci não pode ser nulo")
	private int idadeFunci;
	
	@NotNull (message = "matricula não pode ser nulo")
	private String matricula;

	// Relação UM para MUITOS entre Funcionario e Venda = "Um Funcionario Muitas Vendas"
	@OneToMany (mappedBy = "funcionario")
	private List<Venda> venda; // Representa a Lista Venda
}
