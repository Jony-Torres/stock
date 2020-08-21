
package controlador;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class calcula_iva {
    public  double total;
    public calcula_iva(double total) {
        
        
        this.total = total;
       
    }
   
    public  double calcular_iva_10()
    { 
        double iva ; 
        double cantidad;
        double redoul;
     
        cantidad = total/11;
        BigDecimal d = new BigDecimal(cantidad); 
        d = d.setScale(0, RoundingMode.HALF_UP);
        int i = d.intValue(); 
      
        iva = i;
        return iva;
        
    } 
    public  double calcular_iva_5()
    { 
        double iva ; 
        double cantidad;
        double redoul;
     
        cantidad = (((total/1.05)*5)/100);
        BigDecimal d = new BigDecimal(cantidad); 
         d = d.setScale(0, RoundingMode.HALF_UP);
        int i = d.intValue(); 
      
        iva = i;
        return iva;
        
    } 
    public  double calcular_grabadas_5()
    { 
        double iva ; 
        double cantidad;
        double redoul;
     
        cantidad = total/1.05;
        BigDecimal d = new BigDecimal(cantidad); 
         d = d.setScale(0, RoundingMode.HALF_UP);
        int i = d.intValue(); 
      
        iva = i;
        return iva;
        
    } 
    public  double calcular_grabadas_10()
    { 
        double iva ; 
        double cantidad;
        double redoul;
     
        cantidad = total/1.1;
        BigDecimal d = new BigDecimal(cantidad); 
         d = d.setScale(0, RoundingMode.HALF_UP);
        int i = d.intValue(); 
      
        iva = i;
        return iva;
        
    } 
}
