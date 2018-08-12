
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;


public class Carnes extends Productos {

    public Carnes(String código, String descripción, int cantExistencia, float costoCompra, float precioVenta) {
        super(código, descripción, cantExistencia, costoCompra, precioVenta);
    }

    Carnes() {
        this(null, null, 0, 0, 0);
    }
    Carnes(int CantExistencia){
        super(CantExistencia);
    }

    
}
