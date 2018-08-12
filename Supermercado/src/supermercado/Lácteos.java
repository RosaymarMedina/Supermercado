/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;


public class Lácteos extends Productos {
    public Lácteos(String código, String descripción, int cantExistencia, float costoCompra, float precioVenta) {
        super(código, descripción, cantExistencia, costoCompra, precioVenta);
    }

    Lácteos() {
        this(null, null, 0, 0, 0);
    }
    Lácteos(int CantExistencia){
        super(CantExistencia);
    }

    
}
