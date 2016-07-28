/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaescritorio.entidade;

import java.util.Date;

/**
 *
 * @author Miih Santos
 */
public class Processo {
    private int id;
    private String numero;
    private String tipo_Processo;
    private String status;
    private Date data_Inicio;
    private Date data_Atualizacao;
    private String descricao;
    Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo_Processo() {
        return tipo_Processo;
    }

    public void setTipo_Processo(String tipo_Processo) {
        this.tipo_Processo = tipo_Processo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_Inicio() {
        return data_Inicio;
    }

    public void setData_inicio(Date data_Inicio) {
        this.data_Inicio = data_Inicio;
    }

    public Date getData_Atualizacao() {
        return data_Atualizacao;
    }

    public void setData_atualizacao(Date data_Atualizacao) {
        this.data_Atualizacao = data_Atualizacao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
