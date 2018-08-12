/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;


public abstract class ConIVA extends Productos {
    private String marca;
    private float IVA;

    public ConIVA(String código, String descripción, int cantExistencia, float costoCompra, float precioVenta, String marca) {
        super(código, descripción, cantExistencia, costoCompra, precioVenta);
        this.marca = marca;
    }
    
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setIVA(float precioVenta) {
        float iva;
        iva= (precioVenta*12)/100;
        this.IVA=iva;
    }
    
    public String getMarca() {
        return marca;
    }

    public float getIVA() {
        return IVA;
    }

    public ConIVA(float IVA, int cantExistencia, String marca) {
        super(cantExistencia);
        this.IVA = IVA;
        this.marca = marca;
    }
}
