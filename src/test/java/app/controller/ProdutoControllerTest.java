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
    }
    
    @Test
    void cenario01() {
        
        ResponseEntity<List<Produto>> listaProduto = this.produtoController.listAll();
        assertEquals(2, listaProduto.getBody().size());    
    }
    
}
