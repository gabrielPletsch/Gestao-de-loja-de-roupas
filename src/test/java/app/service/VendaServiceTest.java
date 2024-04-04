package app.service;

	import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Produto;

	@SpringBootTest
	public class VendaServiceTest {

		@Autowired
		VendaService vendaService;
		
		@Test
		void cenario01() {
			List<Produto> listaProd = new ArrayList<>();
			listaProd.add(new Produto(1, "camiseta", 50));
			listaProd.add(new Produto(2, "calca", 50));
			double resultado = this.vendaService.calcularValorTotal(listaProd);
			assertEquals(100, resultado);
		}
}
