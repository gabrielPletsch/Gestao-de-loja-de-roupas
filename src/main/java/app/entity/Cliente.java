package app.entity;
// Local para armazenar as classes que representam as entidades do DB

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Biblioteca "Lombok"(POM), permite utilizar anotation que encurtam o código, definindo  
// Getters and Setters automaticamente, com base nos atributos declarados
@Getter
@Setter

//  Criar uma instância da classe Cliente passando todos os parâmetros diretamente para o construtor
@AllArgsConstructor

// Gerar automaticamente um construtor sem argumentos
@NoArgsConstructor

//Está afirmando para a aplicação(STS/JPA) que este package é uma entity
@Entity
public class Cliente {
	
	// Indicar que o atributo idCliente é o ID da aplicação
	@Id
	// Gerar um valor automaticamente para o ID (auto_Increment), já possui NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdCliente;
	
	// Afirmar ao STS/JPA que tal atributo não deve ser nulo 
	@NotNull(message = "Campo Nome não pode ser nulo")
	private String nomeCliente;
	
	@NotNull(message = "Campo  CPF não pode ser nulo")
	private String cpfCliente;
	
	@NotNull(message = "Campo idade não pode ser nulo")
	private int idadeCliente;
	
	@NotNull(message = "Campo telefone não pode ser nulo")
	private int telefoneCliente;
	
	// Relação UM para MUITOS entre Cliente e Venda = "Um Cliente Muitas Vendas"
	@OneToMany (mappedBy = "cliente")
	@JsonIgnoreProperties("cliente") //Ignora propriedade cliente durante a incialização
	private List<Venda> venda; // Representa a Lista Venda
}
