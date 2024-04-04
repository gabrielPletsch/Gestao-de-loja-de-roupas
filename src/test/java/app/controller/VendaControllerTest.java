package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import app.entity.Venda;
import app.repository.VendaRepository;

@SpringBootTest
public class VendaControllerTest {

	@Autowired
	VendaController vendaController;

	@MockBean
	VendaRepository vendaRepository;

	@BeforeEach
	void setup () {
		
		//MOCK LISTALL
		List<Venda> listVenda = new ArrayList<>();
		listVenda.add(new Venda(1, "abc", 50, 0, null, null, null));
		listVenda.add(new Venda(2, "def", 50, 0, null, null, null));
		when(this.vendaRepository.findAll()).thenReturn(listVenda);


		//MOCK DE SAVE
		Venda novaVenda = new Venda(3, "ghi", 60, 0, null, null, null);
		when(this.vendaRepository.save(novaVenda)).thenReturn(novaVenda);
		
		//MOCK DE FINDBYID
		Venda objetoASerRetornado = new Venda(3, "GHIABC", 60, 0, null, null, null);
		when(this.vendaRepository.findById(1L)).thenReturn(Optional.of(objetoASerRetornado));

	}

	
	
	@Test
	void cenario01() {

		ResponseEntity<List<Venda>> listaVenda = this.vendaController.listAll();
		assertEquals(2, listaVenda.getBody().size());	
	}


	@Test
	void testSave() {
		Venda novaVenda = new Venda(3, "ghi", 60, 0, null, null, null);


		ResponseEntity<String> response = this.vendaController.save(novaVenda);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(" foi o valor total da compra!", response.getBody());

	}
	
	@Test
	void testFindByIdOk() {

		ResponseEntity<Venda> response = this.vendaController.findById(1L);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("GHIABC", response.getBody().getEnderecoVenda());

	}
	
	@Test
	void testFindByIdNOTOK() {

		ResponseEntity<Venda> response = this.vendaController.findById(-1L);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}
	
	@Test
	void testFindByIdOkSEMDADO() {

		ResponseEntity<Venda> response = this.vendaController.findById(22222L);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}
	

}
