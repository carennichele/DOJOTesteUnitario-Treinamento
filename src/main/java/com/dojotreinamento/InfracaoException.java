/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dojotreinamento;

/**
 *
 * @author caren.moraes.nichele
 */
@SuppressWarnings("serial")
public class InfracaoException extends Exception {
    int codigo;
    String mensagem;

    public InfracaoException(int cod, String msg) {
	this.codigo = cod;
	this.mensagem = msg;
    }

    public String getMessage() {
	return this.mensagem;
    }

    public int getCodigo() {
	return this.codigo;
    }
}
