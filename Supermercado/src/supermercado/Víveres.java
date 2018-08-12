/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;


public class Víveres extends ConIVA {

    public Víveres(String código, String descripción, int cantExistencia, float costoCompra, float precioVenta, String marca) {
        super(código, descripción, cantExistencia, costoCompra, precioVenta, marca);
    }

    Víveres() {
        this(null, null, 0, 0, 0, null);
    }
    Víveres(float IVA, int CantExistencia, String marca){
        super(IVA,CantExistencia, marca);
    }
    

    

    
}
