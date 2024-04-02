package app.controller;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.when;

	import java.util.ArrayList;
	import java.util.List;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
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
			List<Venda> listVenda = new ArrayList<>();
			listVenda.add(new Venda(1, "abc", 50, 0, null, null, null));
			listVenda.add(new Venda(2, "def", 50, 0, null, null, null));
			when(this.vendaRepository.findAll()).thenReturn(listVenda);
		}
		
		@Test
		void cenario01() {
			
			ResponseEntity<List<Venda>> listaVenda = this.vendaController.listAll();
			assertEquals(2, listaVenda.getBody().size());
			
		}
}
