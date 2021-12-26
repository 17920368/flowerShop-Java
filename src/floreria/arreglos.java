/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floreria;

/**
 *
 * @author Victor Rodriguez
 */
public class arreglos {
    private int codigo;
    private String nomArreglo;
    private float precio;

    public arreglos() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomArreglo() {
        return nomArreglo;
    }

    public void setNomArreglo(String nomArreglo) {
        this.nomArreglo = nomArreglo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo + "," + nomArreglo + "," + precio;
    }
}
