package com.essejose.metrosp.model;

/**
 * Created by essejose on 28/06/2017.
 */

public class Estacao {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCapacidade_passageiro_hora_pico() {
        return capacidade_passageiro_hora_pico;
    }

    public void setCapacidade_passageiro_hora_pico(String capacidade_passageiro_hora_pico) {
        this.capacidade_passageiro_hora_pico = capacidade_passageiro_hora_pico;
    }

    public String getArea_construida_m_2() {
        return area_construida_m_2;
    }

    public void setArea_construida_m_2(String area_construida_m_2) {
        this.area_construida_m_2 = area_construida_m_2;
    }

    public String getInauguraca() {
        return inauguraca;
    }

    public void setInauguraca(String inauguraca) {
        this.inauguraca = inauguraca;
    }

    private String endereco;
    private String latitude;
    private String longitude;
    private String capacidade_passageiro_hora_pico;
    private String area_construida_m_2;
    private String inauguraca;
}
