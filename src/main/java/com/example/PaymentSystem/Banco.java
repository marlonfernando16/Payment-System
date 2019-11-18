package com.example.PaymentSystem;

public class Banco {
    private String agencia;
    private String conta;
    private String bandeira;
	private String senha;
    private String cartao;
    private Double valor;

	public Banco(String agencia, String conta,String bandeira, String senha, String cartao, Double valor) {
        this.agencia = agencia;
        this.conta = conta;
        this.bandeira = bandeira;
        this.senha = senha;
        this.cartao = cartao;
        this.valor = valor;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return this.conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
    
    public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}


    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getcartao() {
        return this.cartao;
    }

    public void setcartao(String cartao) {
        this.cartao = cartao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    @Override
	public String toString() {
		return "Banco [agencia=" + agencia + ", conta=" + conta + ", bandeira=" + bandeira + ", senha=" + senha
				+ ", cartao=" + cartao + ", valor=" + valor + "]";
	}

}