/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dojotreinamento;

import com.dojotreinamento.LombadaEletronica;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 *
 * @author caren.moraes.nichele
 */
/**
 * This is a sample class to contain a TestCase
 */
public class LombadaEletronicaTest {

    public LombadaEletronicaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    // ------------------------------------------------------------------
    // Exercício 1 - testes unitários para método público verificaSeInfracao()
    // (Junit puro)
    // ------------------------------------------------------------------
    @Test
    // Verifica infração dia de semana e velocidade <= 40
    public void test_Ex1_verificaSeInfracao_DiaDeSemana_Velocidade_Ok() {
        // 1. Instanciar as classes necessárias (a ser testada)
        LombadaEletronica lombadaeletronica = new LombadaEletronica();
        Calendar cal = Calendar.getInstance();

        // 2. Setar os valores de entrada
        // cal.set(YYYY, M, D, HH, MM, SS)
        // M (0 to 11 => January to December)
        cal.set(2017, 5, 1, 10, 30, 00);

        // 3. Chamar o método e verificar o resultado com o “Assert” do Junit
        assertFalse(lombadaeletronica.verificaSeInfracao(30, cal));
    }

    // @Test
    // Verifica infração dia de semana e velocidade > 40
    public void test_Ex1_verificaSeInfracao_DiaDeSemana_Velocidade_NOk() {

    }

    // @Test
    // Verifica infração dia de semana e velocidade <= 60
    public void test_Ex1_verificaSeInfracao_FinalDeSemana_Velocidade_Ok() {

    }

    // @Test
    // Verifica infração dia de semana e velocidade > 60
    public void test_Ex1_verificaSeInfracao_FinalDeSemana_Velocidade_NOk() {

    }

    // ------------------------------------------------------------------
    // Exercício 2 - teste unitário (Junit + mockito)
    // Objetivo: testar o método LombadaEletronica.registraInfracao() mockando a
    // chamada da classe RegistraDAO.gravaNoDB() que acessa ao BD
    // Passos:
    // - registraDAO = Mockar e simular respostado metodo gravaNoDB()
    // - LombadaEletronica = Spy e recebe a classe mockada mockRegistraDAO
    // ------------------------------------------------------------------
    // @Test
    // Verifica infração final de semana velocidade > 60
    public void test_Ex2_registraInfracao_FinalDeSemana_Velocidade_NOK() throws Exception {

    }

    // ------------------------------------------------------------------
    // Exercício 2 - teste unitário (Junit + mockito + @Mock @Spy + @BeforeTest)
    // Objetivo: utilizar as annotations @Mock @Spy e @BeforeTest
    // ------------------------------------------------------------------
    // @Test
    // Verifica infração final de semana velocidade > 60
    public void test_Ex2_registraInfracao_FinalDeSemana_Velocidade_NOK_ComAnnotations() throws Exception {

    }

    // ------------------------------------------------------------------
    // Exercício 3 - testes unitários para testar exceptions (Junit + mockito)
    // Objetivo: forçar exception via inputs e validar Exception recebida
    // ------------------------------------------------------------------
    // @Test(expected = InfracaoException.class)
    public void test_Ex3_RegistraInfracao_Exception() throws InfracaoException {

    }

    // ------------------------------------------------------------------
    // Exercício 3 - testes unitários para testar exceptions (Junit + mockito)
    // Objetivo: forçar Exception no teste e validar Exception recebida
    // ------------------------------------------------------------------
    // @Test(expected = InfracaoException.class)
    public void test_Ex3_RegistraInfracao_Exception_doThrow() throws InfracaoException {

    }

    // ------------------------------------------------------------------
    // Exercício 3 - testes unitários para testar exceptions (Junit + mockito)
    // Objetivo: forçar a Exeption e validar atributos da Exception recebida
    // ------------------------------------------------------------------
    // @Test
    public void test_Ex3_RegistraInfracao_Exception_TryCatch() throws InfracaoException {

    }

    // ------------------------------------------------------------------
    // Exercício 4 - teste unitário (Junit + mockito + @Mock @Spy + @BeforeTest)
    // Objetivo: utilizar as annotations @Mock @Spy e @BeforeTest
    // ------------------------------------------------------------------
    // @Test
    // Verifica infração final de semana velocidade > 60
    public void test_Ex4_registraInfracao_FinalDeSemana_Velocidade_NOK_ComAnnotations() throws Exception {

    }
}
