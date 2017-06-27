package com.essejose.metrosp.model;

/**
 * Created by essejose on 26/06/2017.
 */

public class Linha {

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUrlImage() {
        return urlImagem;
    }

    public void setUrlImage(String urlImage) {
        this.urlImagem = urlImage;
    }

    private String cor;
    private String numero;
    private String urlImagem;
}
