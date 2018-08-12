/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;


public class Enlatados extends ConIVA {

    public Enlatados(String código, String descripción, int cantExistencia, float costoCompra, float precioVenta, String marca) {
        super(código, descripción, cantExistencia, costoCompra, precioVenta, marca);
    }

    Enlatados() {
        this(null,null, 0,0, 0,null);
    }

    Enlatados(float IVA, int CantExistencia, String marca){
        super(IVA, CantExistencia, marca);
    }

    

    
}
