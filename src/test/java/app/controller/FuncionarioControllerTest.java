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

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@SpringBootTest
public class FuncionarioControllerTest {
    
    @Autowired
    FuncionarioController funcionarioController;
    
    @MockBean
    FuncionarioRepository funcionarioRepository;
    
    @BeforeEach
    void setup () {
        List<Funcionario> listFuncionario = new ArrayList<>();
        listFuncionario.add(new Funcionario(1, "Frederico", 23, "678", null));
        listFuncionario.add(new Funcionario(2, "Enzo", 18, "679", null));
        when(this.funcionarioRepository.findAll()).thenReturn(listFuncionario);
        
      //MOCK DE SAVE
        Funcionario novoFuncionario = new Funcionario(3, "Enzo", 18, "679", null);
        when(this.funcionarioRepository.save(novoFuncionario)).thenReturn(novoFuncionario);

        //MOCK DE FINDBYID
        Funcionario objetoASerRetornado = new Funcionario(2, "GHIABC", 60, null, null);
        when(this.funcionarioRepository.findById(1L)).thenReturn(Optional.of(objetoASerRetornado));

        }



        @Test
        void cenario01() {

            ResponseEntity<List<Funcionario>> listaFuncionario = this.funcionarioController.listAll();
            assertEquals(2, listaFuncionario.getBody().size());    
        }


        @Test
        void testSave() {
            Funcionario novoFuncionario = new Funcionario(3, "ghi", 60, null, null);


            ResponseEntity<String> response = this.funcionarioController.save(novoFuncionario);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(" foi o valor total da compra!", response.getBody());

        }

        @Test
        void testFindByIdOk() {

            ResponseEntity<Funcionario> response = this.funcionarioController.findById(1L);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals("GHIABC", response.getBody().getNomeFunci());

        }

        @Test
        void testFindByIdNOTOK() {

            ResponseEntity<Funcionario> response = this.funcionarioController.findById(-1L);

            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        }

        @Test
        void testFindByIdOkSEMDADO() {

            ResponseEntity<Funcionario> response = this.funcionarioController.findById(22222L);

            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        }

    
}