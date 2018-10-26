/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dojotreinamento;

import java.util.Calendar;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import javax.persistence.EntityManager;

/**
 *
 * @author caren.moraes.nichele
 */
public class LombadaEletronica {

    double valorMulta = 0;
    private EntityManager entityManager;

    // ISSUE 1: Static Log - para mockar precisa refatorar
    private static Log log;

    static {
        try {
            log = LogFactory.getLog("C:\teste.log");
        } catch (final Exception exe) {
            // exe.printStackTrace(); // Não foi possivel gerar arquivo de log
            // ao carregar esta classe
        }
    }

    protected double getValorMulta() {
        return valorMulta;
    }

    public LombadaEletronica() {

    }

    // Exemplo 1
    // Método de cálculo da regra do negócio (se velocidade > max)
    // Não precisa ser mockado, pois não usa recursos externos a esta classe
    protected boolean verificaSeInfracao(double velocidade, Calendar data) {
        boolean retorno = false;

        // 1 to 7 => Sunday to Saturday
        int iDiaSemana = data.get(Calendar.DAY_OF_WEEK);

        // Verifica se é dia de semana (40kh)
        if ((iDiaSemana > 1) && (iDiaSemana < 7)) {
            retorno = (velocidade > 40);
        } // Final de semana (60kh)
        else {
            if ((iDiaSemana == 7) || (iDiaSemana == 1)) {
                retorno = (velocidade > 60);
            }
        }

        return retorno;
    }

    // Exemplo 2 - uma classe que usa outra classe que precisa ser mockada
    // Método publico registraInfracao() deve ser chamado no teste
    // Método interno registraDAO.gravaNoDB() deve ser mockado no teste
    public boolean registraInfracao(double velocidade, Calendar data, String placa) throws InfracaoException {
        boolean retorno = false;

        // ISSUE 2: recurso externo (DAO) instanciado dentro do método da classe
        // não pode ser mockado
        RegistraDAO registraDAO = new RegistraDAO();

        if (data != null && placa != null) {
            if (verificaSeInfracao(velocidade, data)) {
                retorno = registraDAO.gravaNoDB(entityManager, velocidade, data, placa);
            }
        } else {
            InfracaoException ex = new InfracaoException(1, "EXCEPTION: DATA OU PLACA NULAS");
            // ISSUE 1: recurso externo (Log) deve ser mockado
            log.error(ex);
            throw ex;

        }
        return retorno;
    }

    // Exemplo VOID (A) - método com retorno void que precisa ser testado
    protected void metodoOneVoid(double valor) {
        metodoTwoVoid(valor * 3); // regra qualquer
    }

    // Exemplo VOID (A) - Método com retorno void que recebe valor do
    // metodoOneVoid
    protected void metodoTwoVoid(double valor) {
        System.out.printf("\n>>>>METODO VOID  <%d><<<\n", valor);
    }

    // Exemplo VOID (B) - Método com retorno void que precisa ser testado
    protected void metodoVoid(double valor) {
        this.valorMulta = valor * 5; // facilidade para o teste unitario:
        // armazena o valor a ser validado em um
        // atributo privado da classe
    }
}
