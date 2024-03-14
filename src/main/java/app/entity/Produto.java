package app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProd;
	@NotNull(message = "NomeProd não pode ser nulo")

	private String nomeProd;
	@NotNull(message = "valorProd não pode ser nulo")
	private double valorProd;
	
	/*@ManyToMany( cascade = CascadeType.ALL )
	@JoinTable( name = "ProdutoVenda" )
	private List<Venda> venda;*/

}