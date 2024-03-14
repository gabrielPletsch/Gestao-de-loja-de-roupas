package app.entity;

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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVenda;
	
	@NotNull(message = "endereçoVenda não pode ser nulo")
	private String enderecoVenda;
	
	@NotNull(message = "ValorVenda não pode ser nulo")
	private double valorVenda;
	//private double valorFinal;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("venda")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("venda")
    private Funcionario funcionario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable (name =  "venda_produto")
	private List<Produto> produto;
	
}
