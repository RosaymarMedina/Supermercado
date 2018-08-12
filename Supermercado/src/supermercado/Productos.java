/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *
 * @author rosaymar.medina
 */
public abstract class Productos{
    private String código;
    private String unidades;
    private String descripción;
    private int cantExistencia;
    private float costoCompra;
    private float precioVenta;

    public Productos(String código, String descripción, int cantExistencia, float costoCompra, float precioVenta) {
        this.código = código;
        this.descripción = descripción;
        this.cantExistencia = cantExistencia;
        this.costoCompra = costoCompra;
        this.precioVenta = precioVenta;
    }

    public void setCódigo(String código) {
        this.código = código;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public void setCantExistencia(int cantExistencia) {
        this.cantExistencia = cantExistencia;
    }

    public void setCostoCompra(float costoCompra) {
        this.costoCompra = costoCompra;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCódigo() {
        return código;
    }

    public String getDescripción() {
        return descripción;
    }

    public int getCantExistencia() {
        return cantExistencia;
    }

    public float getCostoCompra() {
        return costoCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public Productos(int cantExistencia) {
        this.cantExistencia = cantExistencia;
    }
  


    
    
}
