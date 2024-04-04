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

import app.entity.Cliente;
import app.repository.ClienteRepository;

	@SpringBootTest
	public class ClienteControllerTest {
		
		@Autowired
		ClienteController clienteController;
		
		@MockBean
		ClienteRepository clienteRepository;
		
		@BeforeEach
		void setup () {
			List<Cliente> listCliente = new ArrayList<>();
			listCliente.add(new Cliente(1, null, null, 0, 0, null));
			listCliente.add(new Cliente(2, null, null, 0, 0, null));
			when(this.clienteRepository.findAll()).thenReturn(listCliente);
			
			//MOCK DE SAVE
			Cliente novoCliente = new Cliente(3, null, null, 0, 0, null);
			when(this.clienteRepository.save(novoCliente)).thenReturn(novoCliente);

			//MOCK DE FINDBYID
			Cliente objetoASerRetornado = new Cliente(2, null, null, 0, 0, null);
			when(this.clienteRepository.findById(1L)).thenReturn(Optional.of(objetoASerRetornado));

			}



			@Test
			void cenario01() {

			    ResponseEntity<List<Cliente>> listaCliente = this.clienteController.listAll();
			    assertEquals(2, listaCliente.getBody().size());    
			}


			@Test
			void testSave() {
			    Cliente novoCliente = new Cliente(3, null, null, 0, 0, null);


			    ResponseEntity<String> response = this.clienteController.save(novoCliente);

			    assertEquals(HttpStatus.CREATED, response.getStatusCode());
			    assertEquals(" foi o valor total da compra!", response.getBody());

			}

			@Test
			void testFindByIdOk() {

			    ResponseEntity<Cliente> response = this.clienteController.findById(1L);

			    assertEquals(HttpStatus.OK, response.getStatusCode());
			    assertEquals("GHIABC", response.getBody().getNomeCliente());

			}

			@Test
			void testFindByIdNOTOK() {

			    ResponseEntity<Cliente> response = this.clienteController.findById(-1L);

			    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

			}

			@Test
			void testFindByIdOkSEMDADO() {

			    ResponseEntity<Cliente> response = this.clienteController.findById(22222L);

			    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

			}

		
}

