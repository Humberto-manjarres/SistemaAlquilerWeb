/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.Date;

/**
 *
 * @author Humberto Manjarres
 */
public class Vehiculo {
    private String placa;
    private Date modelo;
    private String color;
    private String tipo;
    private String serie;
    private String marca;

    public Vehiculo(String placa, Date modelo, String color, String tipo, String serie, String marca) {
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.serie = serie;
        this.marca = marca;
    }
    
    public Vehiculo(){}

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getModelo() {
        return modelo;
    }

    public void setModelo(Date modelo) {
        this.modelo = modelo;
    }
    
    


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}
