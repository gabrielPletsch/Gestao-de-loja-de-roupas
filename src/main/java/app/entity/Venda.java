package app.entity;
// Local para armazenar as classes que representam as entidades do DB

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Biblioteca "Lombok"(POM), permite utilizar anotation que encurtam o código, definindo  
// Getters and Setters automaticamente, com base nos atributos declarados
@Getter
@Setter

// Criar uma instância da classe Venda passando todos os parâmetros diretamente para o construtor
@NoArgsConstructor

// Gerar automaticamente um construtor sem argumentos
@AllArgsConstructor

// Está afirmando para a aplicação(STS/JPA) que este package é uma entity
@Entity
public class Venda {
	
	// Indicar que o atributo idFunc é o ID da aplicação
	@Id
	// Gerar um valor automaticamente para o ID (auto_Increment), já possui NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVenda;
	
	// Afirmar ao STS/JPA que tal atributo não deve ser nulo 
	@NotNull(message = "endereçoVenda não pode ser nulo")
	private String enderecoVenda;
	
	@NotNull(message = "ValorVenda não pode ser nulo")
	private double valorVenda;
	private double valorFinal;
	
	// Relação MUITOS para UM entre Venda e Cliente = "Muitas Vendas Um Cliente"
	@ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("venda")
    private Cliente cliente; // Representa a Lista Cliente

	// Relação MUITOS para UM entre Venda e Funcionario = "Muitas Vendas Um Funcionario"
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("venda")
    private Funcionario funcionario; 
	
    // Relação MUITOS para MUITOS entre Venda e Produto = "Muitas Vendas Muitos Produtos"
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable (name =  "venda_produto")
	private List<Produto> produto;
	
}
