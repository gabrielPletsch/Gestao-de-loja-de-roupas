package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
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
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFuncionario;
	
	@NotNull (message = "nomeFunci não pode ser nulo")
	private String nomeFunci;
	
	@NotNull (message = "idadeFunci não pode ser nulo")
	private int idadeFunci;
	
	@NotNull (message = "matricula não pode ser nulo")
	private String matricula;

	//@OneToMany (mappedBy = "funcionario")
	//private List<Venda> venda;
}
