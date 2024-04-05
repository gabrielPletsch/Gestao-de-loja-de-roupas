package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Produto;
import app.repository.ProdutoRepository;

@SpringBootTest
public class ProdutoControllerTest {
    
    @Autowired
    ProdutoController produtoController;
    
    @MockBean
    ProdutoRepository produtoRepository;
    
    @BeforeEach
    void setup () {
        List<Produto> listProduto = new ArrayList<>();
        listProduto.add(new Produto(1, "pedro", 123));
        listProduto.add(new Produto(2, "joao", 456));
        when(this.produtoRepository.findAll()).thenReturn(listProduto);
      
        //MOCK DE SAVE
        Produto novoProduto = new Produto(3, "egter", 7);
		when(this.produtoRepository.save(novoProduto)).thenReturn(novoProduto);

		//MOCK DE FINDBYID
		Produto objetoASerRetornado = new Produto(2, "GHIABC", 4);
		when(this.produtoRepository.findById(1L)).thenReturn(Optional.of(objetoASerRetornado));

		}



		@Test
		void cenario01() {

		    ResponseEntity<List<Produto>> listaProduto = this.produtoController.listAll();
		    assertEquals(2, listaProduto.getBody().size());    
		}


		@Test
		void testSave() {
			Produto novoProduto = new Produto(3, null, 0);


		    ResponseEntity<String> response = this.produtoController.save(novoProduto);

		    assertEquals(HttpStatus.CREATED, response.getStatusCode());
		   // assertEquals(" Cliente salvo!", response.getBody());

		}

		@Test
		void testFindByIdOk() {

		    ResponseEntity<Produto> response = this.produtoController.findById(1L);

		    assertEquals(HttpStatus.OK, response.getStatusCode());
		    assertEquals("GHIABC", response.getBody().getNomeProd());

		}

		@Test
		void testFindByIdNOTOK() {

		    ResponseEntity<Produto> response = this.produtoController.findById(-1L);

		    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		}

		@Test
		void testFindByIdOkSEMDADO() {

		    ResponseEntity<Produto> response = this.produtoController.findById(22222L);

		    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		}
		
		@Test
		void testUpdate() {
			
			Produto produtoExistente = new Produto(4, "abc", 50);
			Produto produtoAtualizada = new Produto(1, "xyz", 60);
		    long idProduto = 1L;
			
			ResponseEntity<String> response = produtoController.update(produtoAtualizada, idProduto);
		    
		    assertEquals(HttpStatus.OK, response.getStatusCode());
		   
		    when(produtoRepository.findById(idProduto)).thenReturn(Optional.of(produtoExistente));
		    when(produtoRepository.save(produtoAtualizada)).thenReturn(produtoAtualizada);
		}
		
		@Test
	    void testDelete() {
	        long idVenda = 1L;
	        ResponseEntity<String> response = produtoController.delete(idVenda);
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        verify(produtoRepository).deleteById(idVenda);
	    }

}
