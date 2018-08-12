/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;
import java.util.ArrayList;
/**
 *
 * @author rosaymar.medina
 */
public class Facturas {
    private String cédula;
    private ArrayList <Productos> pv = new ArrayList<Productos>();
    private float totalSinIVA;
    private float totalConIVA;
    private float totalIVA;
    private float totalPagar;
    
    
    public void setCédula(String cédula) {
        this.cédula = cédula;
    }
    
    public void TotalPagar (){
        totalSinIVA = 0;
        for (int i = 0; i<pv.size(); i++){
            if (pv.get(i).getClass() == Lácteos.class | pv.get(i).getClass() == Carnes.class){
                totalSinIVA += pv.get(i).getCantExistencia()*pv.get(i).getPrecioVenta();
            }
        }
    
        totalConIVA = 0;
        for (int i = 0; i<pv.size(); i++){
            if (pv.get(i).getClass() == Enlatados.class | pv.get(i).getClass() == Víveres.class){
                totalConIVA += pv.get(i).getCantExistencia()*pv.get(i).getPrecioVenta();
            }
        }
    
        totalIVA = 0;
        for (int i = 0; i<pv.size(); i++){
            if (pv.get(i).getClass() == Enlatados.class){
                Enlatados e = (Enlatados) pv.get(i);
                totalIVA += e.getIVA()*e.getCantExistencia();
            }else if (pv.get(i).getClass() == Víveres.class){
                Víveres v = (Víveres) pv.get(i);
                totalIVA += v.getIVA()*v.getCantExistencia();
            }
        }
    
    
        totalPagar=totalIVA+totalConIVA+totalSinIVA;
    }
    
    public void setProducto(Productos p){
        pv.add(p);
    }

    public void setPv(ArrayList<Productos> pv) {
        this.pv = pv;
    }

    public String getCédula() {
        return cédula;
    }

    public ArrayList<Productos> getPv() {
        return pv;
    }

    public float getTotalSinIVA() {
        return totalSinIVA;
    }

    public float getTotalConIVA() {
        return totalConIVA;
    }

    public float getTotalIVA() {
        return totalIVA;
    }

    public float getTotalPagar() {
        return totalPagar;
    }
}
