package app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdCliente;
	
	@NotNull(message = "Campo Nome e CPF não pode ser nulo")
	private String nomeClient;
	private String cpf;
	
	@NotNull(message = "Campo idade não pode ser nulo")
	private int idadeClient;
	
	@NotNull(message = "Campo teleofne não pode ser nulo")
	private int telefone;
}
