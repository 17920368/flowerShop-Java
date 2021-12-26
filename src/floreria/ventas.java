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
public class ventas {
   private String nomCliente;
    private int numPedido;
    private String fecha;
    private String tipoPago;
    private float importe;
    private int arreglo;

    public ventas() {

    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public int getArreglo() {
        return arreglo;
    }

    public void setArreglo(int arreglo) {
        this.arreglo = arreglo;
    }

    @Override
    public String toString() {
        return nomCliente + ","+ fecha + "," + tipoPago + "," + importe + "," + arreglo+","+ this.numPedido ;
    }

     
}
