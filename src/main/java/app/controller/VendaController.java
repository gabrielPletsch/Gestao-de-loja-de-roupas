package app.controller;
//Responsável por receber as requisições HTTP,

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

import app.entity.Venda;
import app.service.VendaService;

//Permite criar controladores que retornam dados diretamente no corpo das respostas HTTP
@RestController
//Usada para mapear solicitações HTTP e o URL
@RequestMapping("/api/venda")
public class VendaController {
	
	// Dependências automática elimina a necessdidade de configurar manualmente XML ou JAVA
	@Autowired
	private VendaService vendaService;//Referência para Service
	
	@PostMapping("/save")//endpoint para http save
	public ResponseEntity<String> save(@RequestBody Venda venda){//recebe um objeto do "Front/Json/Postman"
		
		try {
			String mensagem = this.vendaService.save(venda);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{idVenda}")
	public ResponseEntity<String> update(@RequestBody Venda venda, @PathVariable long idVenda) {
		
		try {
			
			String mensagem = this.vendaService.update(idVenda, venda);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Venda>> listAll (){
		
		try {
			List<Venda> list = this.vendaService.listAll();
			return new ResponseEntity<>(list, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findById/{idVenda}")
	public ResponseEntity<Venda> findById(@PathVariable long idVenda) {
		
		try {
			
			Venda venda = this.vendaService.findById(idVenda);
			return new ResponseEntity<>(venda, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("/delete/{idVenda}")
	public ResponseEntity<String> delete(@PathVariable long idVenda){
		
		try {
			String mensagem = this.vendaService.delete(idVenda);
			return new ResponseEntity<>(mensagem,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	

	//------
	
	@GetMapping("/findByNomeCliente")
	public ResponseEntity<List<Venda>> findByClienteNomeCliente (@RequestParam String nomeCliente){
		
		try {
			
			List<Venda> lista = this.vendaService.findByNomeCliente(nomeCliente);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findByFuncionarioNomeFunci")
	public ResponseEntity<List<Venda>> findByFuncionarioNomeFunci (@RequestParam String nomeFunci){
		
		try {
			
			List<Venda> lista = this.vendaService.findByFuncionarioNomeFunci(nomeFunci);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findyByValorVenda")
	public ResponseEntity<List<Venda>> findyByValorVenda (@RequestParam double valorVenda){
		
		try {
			
			List<Venda> lista = this.vendaService.findByVendaValor(valorVenda);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	

	
	 
}