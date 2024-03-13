package app.controller;

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

import app.entity.Funcionario;
import app.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Funcionario funcionario)  {
	
		try {
			
			String mensagem = this.funcionarioService.save(funcionario);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Ocorreu o seguinte erro:"+e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@PutMapping("/update/{idFuncionario}")
	public ResponseEntity<String> update(@RequestBody Funcionario funcionario, @PathVariable long idFuncionario) {
	    try {
	        String mensagem = this.funcionarioService.update(idFuncionario, funcionario);
	        return new ResponseEntity<String>(mensagem, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<String>("Ocorreu o seguinte erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
	

	@GetMapping("/listAll")
	public ResponseEntity<List<Funcionario>> listAll (){
		
		try {
			
			List<Funcionario> lista = this.funcionarioService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findById/{idFuncionario}")
	public ResponseEntity<Funcionario> findById(@PathVariable long idFuncionario){
		
		try {
			
			Funcionario funcionario = this.funcionarioService.findById(idFuncionario);
			return new ResponseEntity<>(funcionario, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/delete/{idFuncionario}")
	public ResponseEntity<String> delete(@PathVariable long idFuncionario){
		
		try {
			
			String mensagem = this.funcionarioService.delete(idFuncionario);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu o seguinte erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//-------
	
	@GetMapping("/findByNomeFunc")
	public ResponseEntity<List<Funcionario>> findByNomeFunc (@RequestParam String nomeFunc){
		
		try {
			
			List<Funcionario> lista = this.funcionarioService.findByNomeFunci(nomeFunc);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findByIdadeFunc")
	public ResponseEntity<List<Funcionario>> findByIdadeFunci (@RequestParam int idadeFunc){
		
		try {
			
			List<Funcionario> lista = this.funcionarioService.findByIdadeFunci(idadeFunc);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findByMatricula")
	public ResponseEntity<List<Funcionario>> findByMatricula (@RequestParam String Matricula){
		
		try {
			
			List<Funcionario> lista = this.funcionarioService.findByMatricula(Matricula);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}

	@GetMapping("/findByIdFunc")
	public ResponseEntity<List<Funcionario>> findByIdFunc(@RequestParam long idFuncionario){
		
		try {
			List<Funcionario> lista = this.funcionarioService.findByIdFunc(idFuncionario);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
}
