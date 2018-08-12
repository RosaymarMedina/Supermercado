/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author rosaymar.medina
 */
public class Menú {
    private Productos p;
    private ArrayList <Productos> Produc = new ArrayList <Productos>();
    private ArrayList <Facturas> Fac = new ArrayList <Facturas>();
    Scanner scan = new Scanner(System.in);
    public String Leer(String frase){
        String var;
        System.out.println(frase);
        do{
            var = scan.nextLine();
        }while(var.equals(""));
        System.out.println("");
        return var;
    }
    public int LeerInt(String Frase){
        int auu;
        String opciónChar;
        int convert = 0;
        do{
            auu = 0;
            opciónChar = Leer(Frase);
            try{
                convert = Integer.parseInt(opciónChar);
            }catch(NumberFormatException e){
                System.out.println("Debe ingresar un número");
                auu = 1;
            }
        }while (auu == 1);
        return convert;
    }
        public float LeerFloat(String Frase){
        int auu;
        String opciónChar;
        float convert = 0;
        do{
            auu = 0;
            opciónChar = Leer(Frase);
            try{
                convert = Float.parseFloat(opciónChar);
            }catch(NumberFormatException e){
                System.out.println("Debe ingresar un número");
                auu = 1;
            }
        }while (auu == 1);
        return convert;
    }
        
        public void Top10 (ArrayList <Facturas> f){
            ArrayList <Productos> listP = new ArrayList <Productos> ();
            int aux;
            for (int i = 0; i<f.size(); i++){
                for (int j = 0; j<f.get(i).getPv().size(); j++){
                    if (listP.isEmpty()){
                        if (f.get(i).getPv().get(j).getClass() == Lácteos.class | f.get(i).getPv().get(j).getClass() == Carnes.class){
                        listP.add(f.get(i).getPv().get(j));
                        }
                    }else{
                        aux = 0;
                        for (int k = 0; k < listP.size(); k++){
                            if (listP.get(k).getCódigo().equals(f.get(i).getPv().get(j).getCódigo())){
                                listP.get(k).setCantExistencia(listP.get(k).getCantExistencia()+f.get(i).getPv().get(j).getCantExistencia());
                                aux = 1;
                                break;
                            }
                        }//For k
                            if (aux == 0){
                                if (f.get(i).getPv().get(j).getClass() == Lácteos.class | f.get(i).getPv().get(j).getClass() == Carnes.class){
                                    listP.add(f.get(i).getPv().get(j));
                                }
                            }
                    }
                }//For j
            }//For i
            
            for (int i = 0; i<listP.size()-1; i++){
                if (listP.get(i).getCantExistencia() < listP.get(i+1).getCantExistencia()){
                    listP.add(listP.get(i+1));
                    listP.set((i+1), listP.get(i));
                    listP.set(i, listP.get(listP.size()-1));
                    listP.remove(listP.size()-1);
                }
            }
            
            for (int i = 0; i<listP.size(); i++){
                System.out.println("Código: "+listP.get(i).getCódigo());
                System.out.println("Nombre: "+listP.get(i).getDescripción());
                System.out.println("Cantidad: "+listP.get(i).getCantExistencia());
                System.out.println("Costo de compra: "+listP.get(i).getCostoCompra());
                System.out.println("Precio de venta: "+listP.get(i).getPrecioVenta());
                
                if (listP.get(i).getClass() == Enlatados.class){
                    Enlatados e = (Enlatados) listP.get(i);
                    System.out.println("Marca: "+e.getMarca());
                }else if(listP.get(i).getClass() == Víveres.class){
                    Víveres v = (Víveres) listP.get(i);
                    System.out.println("Marca: "+v.getMarca());
                }
            }
        }
        public void BajaExistencia (ArrayList <Productos> p){
            ArrayList <Productos> listP = new ArrayList <Productos> ();
            int aux;
            for (int i = 0; i < p.size(); i++ ){
                if(p.get(i).getCantExistencia() < 10){
                    listP.add(p.get(i));
                }
            }
                if(p.get(p.size()-1).getCantExistencia() > 10){
                    System.out.println("Ningún producto tiene una existencia menor a 10\n");
                }
            
            for (int i = 0; i<listP.size()-1; i++){
                if (listP.get(i).getCantExistencia() < listP.get(i+1).getCantExistencia()){
                    listP.add(listP.get(i+1));
                    listP.set((i+1), listP.get(i));
                    listP.set(i, listP.get(listP.size()-1));
                    listP.remove(listP.size()-1);
                }
            }
            for (int i = 0; i<listP.size(); i++){
                System.out.println("\nCódigo: "+listP.get(i).getCódigo());
                System.out.println("Nombre: "+listP.get(i).getDescripción());
                System.out.println("Cantidad: "+listP.get(i).getCantExistencia());
                System.out.println("Costo de compra: "+listP.get(i).getCostoCompra());
                System.out.println("Precio de venta: "+listP.get(i).getPrecioVenta());
                
                if (listP.get(i).getClass() == Enlatados.class){
                    Enlatados e = (Enlatados) listP.get(i);
                    System.out.println("Marca: "+e.getMarca());
                }else if(listP.get(i).getClass() == Víveres.class){
                    Víveres v = (Víveres) listP.get(i);
                    System.out.println("Marca: "+v.getMarca());
                }
            }
        }
        
    public void Menú(){
    
        int auu = 0;
        int opciónInt = 0;
        float opciónFloat = 0;
        String opciónChar; 
        String Menú;
        Menú = "\t\tMenú\n";
                Menú += "1. Añadir un producto.\n";
                Menú += "2. Modificar existencia de un producto.\n";
                Menú += "3. Factura de ventas.\n";
                Menú += "4. Ingresos brutos.\n";
                Menú += "5. Egresos de la empresa.\n";
                Menú += "6. Reporte de exentos de mayores ventas.\n";
                Menú += "7. Reporte de productos de baja existencia.\n";
                Menú += "8. Salir.";
        do{
                opciónInt = LeerInt(Menú);
                switch(opciónInt){
                    case 1: 
                        int opciónInt1 = 0;
                        int posición = 0;
                        
                        do{
                            int opciónInt2;
                        
                            opciónInt1 = LeerInt("Seleccione el tipo de producto: \n1. Enlatados. \n2. Lácteos. \n3. Carnes. \n4. Víveres.\n5. Atrás.");
                            switch (opciónInt1){
                                case 1:
                                    p = new Enlatados();
                                    p.setUnidades("Unidades");
                                    break;
                                case 2:
                                    p = new Lácteos();
                                    do{
                                        opciónInt2 = LeerInt("1. Líquido. \n2. Sólido");
                                        switch(opciónInt2){
                                            case 1:
                                                p.setUnidades("Litros"); 
                                                break;
                                            case 2:
                                                p.setUnidades("Kilos"); 
                                                break;
                                            default:
                                                System.out.println("Opción inválida");
                                                break;
                                        }
                                    
                                    }while(opciónInt2 != 1 & opciónInt2 !=2);
                                    break;
                                case 3:
                                    p = new Carnes ();
                                    p.setUnidades("Kilos"); 
                                    break;
                                case 4:
                                    p = new Víveres();
                                    p.setUnidades("Unidades");
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Opción inválida");
                                    break;
                            }
                                if (opciónInt1>0 & opciónInt1<5){
                                    p.setCódigo(Leer("Código: "));
                                    p.setDescripción(Leer("Descripción: "));
                                    
                                    opciónInt2 = LeerInt("Cantidad en existencia: ");
                                    p.setCantExistencia(opciónInt2);
                                    opciónFloat = LeerFloat("Costo de compra: ");
                                    p.setCostoCompra(opciónFloat);
                                    opciónFloat = LeerFloat("Precio de venta: ");
                                    p.setPrecioVenta(opciónFloat);
                                    if (!Produc.isEmpty()){
                                        auu = 0;
                                       for (int i=0; i<Produc.size(); i++){
                                           if (Produc.get(i).getCódigo().equals(p.getCódigo())){
                                               System.out.println("Este código ya existe. ");
                                               auu = 1;
                                               break;
                                            }
                                        }   
                                    }
                                    if(auu == 0){
                                        if (p instanceof Víveres){
                                            Víveres v = (Víveres) p;
                                            v.setMarca(Leer("Marca: "));
                                            v.setIVA(v.getPrecioVenta());
                                            Produc.add(v);

                                        }else if (p instanceof Enlatados){
                                            Enlatados e = (Enlatados)p;
                                            e.setMarca(Leer("Marca: "));
                                            e.setIVA(e.getPrecioVenta());
                                            Produc.add(e);
                                        }else if(p instanceof Lácteos | p instanceof Carnes){
                                            Produc.add(p);
                                        }
                                    }
                                }
                                System.out.println("");
                        }while (opciónInt1 != 5);
                        
                        break;
                    case 2:
                        opciónInt1 = 0;
                        do{
                            opciónInt1 = LeerInt("1. Insertar código.\n2. Salir.");
                        switch(opciónInt1){
                            case 1:
                                opciónChar = Leer("Inserte el código a modificar. ");
                                auu = 0;
                                for (int i=0; i<Produc.size(); i++){
                                    if (Produc.get(i).getCódigo().equals(opciónChar)){
                                        System.out.println("Descripción: "+Produc.get(i).getDescripción());
                                        opciónInt1 = LeerInt("¿Cuántos productos quiere agregar? ");
                                        Produc.get(i).setCantExistencia(Produc.get(i).getCantExistencia()+opciónInt1);
                                        
                                        System.out.println("Código: "+Produc.get(i).getCódigo());
                                        System.out.println("Descripción: "+Produc.get(i).getDescripción());
                                        System.out.println("Cantidad en existencia: "+Produc.get(i).getCantExistencia() + " " + Produc.get(i).getUnidades());
                                        System.out.println("Costo de compra: "+Produc.get(i).getCostoCompra());
                                        System.out.println("Precio de venta: "+Produc.get(i).getPrecioVenta());
                                        
                                        if (Produc.get(i).getClass() == Enlatados.class){
                                            Enlatados e = (Enlatados) Produc.get(i);
                                            System.out.println("Marca: "+e.getMarca());
                                        }else if(Produc.get(i).getClass() == Víveres.class){
                                            Víveres v = (Víveres) Produc.get(i);
                                            System.out.println("Marca: "+v.getMarca());
                                        }
                                        System.out.println("\nSe actualizaron los datos exitosamente. ");
                                        auu = 1;
                                        break;
                                    }
                                }
                                if(auu == 0){
                                        System.out.println("El código no ha sido encontrado.");
                                    }
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Opción inválida");
                                break;
                        }
                        }while(opciónInt1 != 2);
                        
                        break;
                    case 3:
                        String opciónChar1;
                        int cond;
                        Fac.add(new Facturas());
                        Fac.get(Fac.size()-1).setCédula(Leer("Cédula: "));
                        do{
                            cond = 0;
                        opciónChar=Leer("Ingrese el código del producto que va a comprar. ");  
                        int pos = 0;
                for (Productos Produc1 : Produc) {
                    if (Produc1.getCódigo().equals(opciónChar)) {
                        if (!Produc.isEmpty()){
                            auu = 0;
                            
                            for (pos =0; pos < Fac.get(Fac.size()-1).getPv().size(); pos ++){
                                if (Fac.get(Fac.size()-1).getPv().get(pos).getCódigo().equals(opciónChar)){
                                    auu = 1;
                                    break;
                                }
                            }
                        }
                        System.out.println("Descripción: " + Produc1.getDescripción());
                        System.out.println("CantExistencia: " + Produc1.getCantExistencia() + " " + Produc1.getUnidades());
                        do {
                            opciónInt1 = LeerInt("¿Este es el producto que desea comprar?\n1. Si.\n2. No.");
                        int opciónInt2;
                        
                            switch (opciónInt1) {
                                case 1:
                                    do {
                                        opciónInt2 = LeerInt("¿Cuántos productos desea comprar? ");
                                        if (Produc1.getCantExistencia() >= opciónInt2) {
                                            if (auu == 1){
                                                Fac.get(Fac.size()-1).getPv().get(pos).setCantExistencia(Fac.get(Fac.size()-1).getPv().get(pos).getCantExistencia()+opciónInt2);
                                            }else{
                                                
                                                if(Produc1.getClass() == Enlatados.class){
                                                    Enlatados e = (Enlatados)Produc1;
                                                    Productos h = new Enlatados(e.getIVA(),opciónInt2, e.getMarca()); 
                                                    System.out.println(e.getMarca());
                                                    Fac.get(Fac.size()-1).setProducto(h);
                                                    Enlatados t = (Enlatados)Fac.get(Fac.size()-1).getPv().get(Fac.get(Fac.size()-1).getPv().size()-1);
                                                    System.out.println(t.getMarca());
                                                }else if(Produc1.getClass() == Víveres.class){
                                                    Víveres v = (Víveres)Produc1;
                                                    Productos h = new Víveres(v.getIVA(),opciónInt2, v.getMarca());
                                                    Fac.get(Fac.size()-1).setProducto(h);
                                                }else if(Produc1.getClass() == Lácteos.class){
                                                    Lácteos v = (Lácteos)Produc1;
                                                    Productos h = new Lácteos(opciónInt2);
                                                    Fac.get(Fac.size()-1).setProducto(h);
                                                }else if(Produc1.getClass() == Carnes.class){
                                                    Carnes v = (Carnes)Produc1;
                                                    Productos h = new Carnes(opciónInt2);
                                                    Fac.get(Fac.size()-1).setProducto(h);
                                                }
                                                Fac.get(Fac.size()-1).getPv().get(Fac.get(Fac.size()-1).getPv().size()-1).setCódigo(Produc1.getCódigo());
                                                Fac.get(Fac.size()-1).getPv().get(Fac.get(Fac.size()-1).getPv().size()-1).setDescripción(Produc1.getDescripción());
                                                Fac.get(Fac.size()-1).getPv().get(Fac.get(Fac.size()-1).getPv().size()-1).setCostoCompra(Produc1.getCostoCompra());
                                                Fac.get(Fac.size()-1).getPv().get(Fac.get(Fac.size()-1).getPv().size()-1).setPrecioVenta(Produc1.getPrecioVenta());
                                            
                                                }
                                            Produc1.setCantExistencia(Produc1.getCantExistencia()-opciónInt2);
                                            System.out.println("CantExistencia: " + Produc1.getCantExistencia() + " " + Produc1.getUnidades());
                                            System.out.print("CantVendida: " + Fac.get(Fac.size()-1).getPv().get(Fac.get(Fac.size()-1).getPv().size()-1).getCantExistencia());
                                            System.out.println(" " + Fac.get(Fac.size()-1).getPv().get(Fac.get(Fac.size()-1).getPv().size()-1).getUnidades());
                                            
                                            
                                            cond = 1;
                                            opciónInt2 = 2;
                                        } else{
                                            opciónInt2 = LeerInt("La cantidad solicitada no está disponible.\n1. Cambiar cantidad. \n2. No comprar. ");
                                            do{
                                                switch (opciónInt2){
                                                    case 1:

                                                        break;
                                                    case 2:
                                                        cond = 2;
                                                        break;
                                                    default:
                                                        System.out.println("Opción inválida. ");
                                                        break;
                                                }
                                            }while (opciónInt2 != 1 & opciónInt2 != 2);
                                        }
                                    } while (opciónInt2 == 1);
                                    break;
                                case 2:
                                    cond = 2;
                                    break;
                                default:
                                    System.out.println("Opción inválida");
                                    break;
                            } //Switch
                        } while (opciónInt1 != 2 & opciónInt1 != 1);
                        break;
                    }
                }
                            switch (cond){
                                case 0:
                                    System.out.println("El código no se encontró.\n¿Desea intentarlo nuevamente?");
                                    break;
                                case 1:
                                    System.out.println("El producto ha sido agregado exitosamente. \n¿Desea comprar algo más?");
                                    break;
                                case 2:
                                    System.out.println("¿Desea comprar otro producto?");
                                    break;
                            }
                            do{
                            cond = LeerInt("1. Si\n2. No");
                            }while(cond !=1 & cond != 2);
                        }while (cond == 1);
                        if (Fac.get(Fac.size()-1).getPv().isEmpty()){
                            Fac.remove(Fac.size()-1);
                            System.out.println("No se ha realizado ninguna compra. Operación cancelada");
                        }else{
                            System.out.println("\t\tFactura\n");
                            System.out.println("Cédula: "+Fac.get(Fac.size()-1).getCédula());
                            for (int i = 0; i<Fac.get(Fac.size()-1).getPv().size(); i++){
                                System.out.println((i+1));
                                System.out.println("Código: "+Fac.get(Fac.size()-1).getPv().get(i).getCódigo());
                                System.out.println("Descripción: "+Fac.get(Fac.size()-1).getPv().get(i).getDescripción());
                                System.out.println("Cantidad: "+Fac.get(Fac.size()-1).getPv().get(i).getCantExistencia() + " " + Fac.get(Fac.size()-1).getPv().get(i).getUnidades());
                                System.out.println("Precio de venta: "+Fac.get(Fac.size()-1).getPv().get(i).getPrecioVenta());
                                if (Fac.get(Fac.size()-1).getPv().get(i).getClass() == Enlatados.class){
                                    Enlatados e = (Enlatados) Fac.get(Fac.size()-1).getPv().get(i);
                                    System.out.println("Marca: "+e.getMarca());
                                }else if(Fac.get(Fac.size()-1).getPv().get(i).getClass() == Víveres.class){
                                    Víveres v = (Víveres) Fac.get(Fac.size()-1).getPv().get(i);
                                    System.out.println("Marca: "+v.getMarca());
                                }
                            }
                            Fac.get(Fac.size()-1).TotalPagar();
                            System.out.println("Total productos exentos de IVA: "+Fac.get(Fac.size()-1).getTotalSinIVA()+" bs");
                            System.out.println("Total productos con IVA: "+Fac.get(Fac.size()-1).getTotalConIVA()+" bs");
                            System.out.println("Total por concepto de IVA: "+Fac.get(Fac.size()-1).getTotalIVA()+" bs");
                            System.out.println("Total a pagar: "+Fac.get(Fac.size()-1).getTotalPagar()+" bs");
                        }
                        break;
                    case 4:
                        float totalVentas = 0;
                        System.out.println("Dinero por concepto de ventas: ");
                        totalVentas = Fac.stream().map((f) -> f.getTotalPagar()).reduce(totalVentas, (accumulator, _item) -> accumulator + _item);
                        System.out.println(totalVentas);
                        break;
                    case 5:
                        float totalCompras = 0;
                        System.out.println("Dinero por concepto de ventas: ");
                        totalCompras = Produc.stream().map((Productos f) -> (f.getCostoCompra()*f.getCantExistencia())).reduce(totalCompras, (accumulator, _item) -> accumulator + _item);
                        System.out.println(totalCompras);
                        break;
                    case 6:
                        Top10(Fac);
                        break;
                    case 7:
                        BajaExistencia(Produc);
                        break;
                    case 8:
                        System.out.println("Ejecución finalizada. ");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            
            
            
            
            
        }while (opciónInt != 8);
        
    
    
    
    }
}
