package app.entity;
// Local para armazenar as classes que representam as entidades do DB

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Biblioteca "Lombok"(POM), permite utilizar anotation que encurtam o código, definindo  
// Getters and Setters automaticamente, com base nos atributos declarados
@Getter
@Setter

// Criar uma instância da classe Produto passando todos os parâmetros diretamente para o construtor
@NoArgsConstructor

// Gerar automaticamente um construtor sem argumentos
@AllArgsConstructor

// Está afirmando para a aplicação(STS/JPA) que este package é uma entity
@Entity
public class Produto {
	
	// Indicar que o atributo idProd é o ID da aplicação
	@Id
	// Gerar um valor automaticamente para o ID (auto_Increment), já possui NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProd;
	
	// Afirmar ao STS/JPA que tal atributo não deve ser nulo 
	@NotNull(message = "NomeProd não pode ser nulo")
	private String nomeProd;
	
	@NotNull(message = "valorProd não pode ser nulo")
	private double valorProd;
	
	// Comentado pois não é necessario 2 relações iguais de ManyToMany para uma mesma função
	/*@ManyToMany( cascade = CascadeType.ALL )
	@JoinTable( name = "ProdutoVenda" )
	private List<Venda> venda;*/

}