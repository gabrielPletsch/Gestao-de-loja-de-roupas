package app.controller;
// Responsável por receber as requisições HTTP,

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Cliente;
import app.service.ClienteService;

// Permite criar controladores que retornam dados diretamente no corpo das respostas HTTP
@RestController
// Usada para mapear solicitações HTTP e o URL 
@RequestMapping("/api/cliente")
public class ClienteController {
	
	// Dependências automática elimina a necessdidade de configurar manualmente XML ou JAVA
	@Autowired
	private ClienteService clienteService; //Referência para Service
	
	@PostMapping("/save") //endpoint para http save
	public ResponseEntity<String> save(@RequestBody Cliente cliente) //recebe um objeto do "Front/Json/Postman"
	{
		try { //Se for bem sucedida
			String mensagem = this.clienteService.save(cliente); //responsável por realizar a lógica para salvar e retorna
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED); //Retornando uma mensagem se for bem sucedida
		} catch (Exception e) { //Se acontecer algum erro
			
			return new ResponseEntity<String>("Ocorreu o seguinte erro"+e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
	}
		
	
	@PutMapping("/update/{idClient}")
	public ResponseEntity<String> update(@RequestBody Cliente cliente, @PathVariable long idClient){
		try {
			String mensagem = this.clienteService.update(idClient, cliente);
			 return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Cliente>> listAll (){
		
		try {
			
			List<Cliente> lista = this.clienteService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	@GetMapping("/findById/{idClient}")
	public ResponseEntity<Cliente> findById(@PathVariable long idClient){
		
		try {
			
			Cliente cliente = this.clienteService.findById(idClient);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findByNomeCliente")
	public ResponseEntity<List<Cliente>> findByNomeCliente (@RequestParam String nomeCliente){
		
		try {
			
			List<Cliente> lista = this.clienteService.findByNomeCliente(nomeCliente);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}

	
	@DeleteMapping("/delete/{idCliente}")
	public ResponseEntity<String> delete(@PathVariable long idCliente){
		try {
			
			String mensagem = this.clienteService.delete(idCliente);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu o seguinte erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//-------
	
	
	@GetMapping("/findByCpfCliente")
	public ResponseEntity<List<Cliente>> findByCpfCliente (@RequestParam String cpfCliente){
		
		try {
			
			List<Cliente> lista = this.clienteService.findByCpfCliente(cpfCliente);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	@GetMapping("/findByTelefoneCliente")
	public ResponseEntity<List<Cliente>> findByTelefoneCliente (@RequestParam int TelefoneCliente){
		
		try {
			List<Cliente> lista = this.clienteService.findByTelefoneCliente(TelefoneCliente);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
			
	}
	
}
