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

import app.entity.Produto;
import app.service.ProdutoService;

//Permite criar controladores que retornam dados diretamente no corpo das respostas HTTP
@RestController
//Usada para mapear solicitações HTTP e o URL 
@RequestMapping("/api/produto")

public class ProdutoController {

	// Dependências automática elimina a necessdidade de configurar manualmente XML ou JAVA
	@Autowired
	private ProdutoService produtoService;//Referência para Service
	
	@PostMapping("/save")//endpoint para HTTP save
	public ResponseEntity<String> save(@RequestBody Produto produto) {//recebe um objeto do "Front/Json/Postman"

		try {
			String mensagem = this.produtoService.save(produto);  //responsável por realizar a lógica e salva pela service
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: " + e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

	@PutMapping("/update/{idProduto}") //endpoint HTTP
	public ResponseEntity<String> update(@RequestBody Produto produto, @PathVariable int idProduto) { //recebe um objeto

		try {
			String mensagem = this.produtoService.update(idProduto, produto); //atualiza um produto DB por produtoService
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu o seguinte erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/listAll")

	public ResponseEntity<List<Produto>> listAll() {
		
		try {
			List<Produto> lista = this.produtoService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findById/{idProduto}")

	public ResponseEntity<Produto> findById(@PathVariable long idProduto) {
		
		try {
			Produto produto = this.produtoService.findById(idProduto);
			return new ResponseEntity<>(produto, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{idProduto}")

	public ResponseEntity<String> delete(@PathVariable long idProduto) {

		try {
			String mensagem = this.produtoService.delete(idProduto);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu o seguinte erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	
	//------
	
	
	@GetMapping("/findByNomeProd")

	public ResponseEntity<List<Produto>> findByNomeProd(@RequestParam String nomeProd) {
		
		try {
			List<Produto> lista = this.produtoService.findByNomeProd(nomeProd);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/findByValorProd")

	public ResponseEntity<List<Produto>> findByValorProd(@RequestParam double valorProd) {
		
		try {
			List<Produto> lista = this.produtoService.findByValorProd(valorProd);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/findByProdutoValor")
    public ResponseEntity<List<Produto>> findByPodutoValor (@RequestParam double valorProd){

        try {

            List<Produto> lista = this.produtoService.findByPodutoValor(valorProd);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
	
}