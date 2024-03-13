package app.entity;

import java.util.List;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdCliente;
	
	@NotNull(message = "Campo Nome não pode ser nulo")
	private String nomeCliente;
	
	@NotNull(message = "Campo  CPF não pode ser nulo")
	private String cpfCliente;
	
	@NotNull(message = "Campo idade não pode ser nulo")
	private int idadeCliente;
	
	@NotNull(message = "Campo idade não pode ser nulo")
	private int idade_client;
	
	@NotNull(message = "Campo telefone não pode ser nulo")
	private int telefoneCliente;
	
	@NotNull(message = "Campo telefone não pode ser nulo")
	private int telefone;
	
	@OneToMany (mappedBy = "cliente")
	private List<Venda> venda;
}
