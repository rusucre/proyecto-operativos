package proyectooperativos;

import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


 
public class JSONReadFromFile {
    

    
           private int dias;
           private int diasdespacho ;
            private int apantallaMax;
            private int acablesMax;
            private int abateriasMax;
            private int epantallaIni;
            private int ecablesIni;
            private int ebateriasIni;
            private int ensamIni ;
            private int pantallaMax ;
            private int cablesMax ;
            private int bateriasMax ;
            private int ensamMax;
            private boolean seguir;
   
            

    public JSONReadFromFile() {
        JSONParser parser = new JSONParser();
        this.seguir=true;
   
      
 
        try {
            
            Object obj = parser.parse(new FileReader("C:\\Users\\risy1\\Desktop\\Operativos\\proyecto-operativos\\ProyectoOperativos\\config.json"));
            JSONObject jsonObject = (JSONObject) obj;
 
            this.dias = Integer.parseInt((String) jsonObject.get("dias"));
             
            this.diasdespacho = Integer.parseInt((String) jsonObject.get("diasdes"));
            
            this.apantallaMax = Integer.parseInt((String) jsonObject.get("apantallaMax"));
            
            this.acablesMax = Integer.parseInt((String) jsonObject.get("acablesMax"));
            
           this.abateriasMax = Integer.parseInt((String) jsonObject.get("abateriasMax"));
           
           this.epantallaIni = Integer.parseInt((String) jsonObject.get("epantallasIni"));
           
           this.ecablesIni = Integer.parseInt((String) jsonObject.get("ecablesIni"));
           
           this.ebateriasIni = Integer.parseInt((String) jsonObject.get("ebateriasIni"));
          
           this.ensamIni = Integer.parseInt((String) jsonObject.get("ensamIni"));
           
           this.pantallaMax = Integer.parseInt((String) jsonObject.get("pantallasMax"));
           
           this.cablesMax = Integer.parseInt((String) jsonObject.get("cablesMax"));
           
           this.bateriasMax = Integer.parseInt((String) jsonObject.get("bateriasMax"));
           
           this.ensamMax = Integer.parseInt((String) jsonObject.get("ensamMax"));
           
           
           
             
             
             
             
             
            
            
//            {
//    "dias" : "1000",
//    "diasdespacho" : "5",
//    "apantallaMax" : "30",
//    "acablesMax" : "25",
//    "abateriasMax" : "35",
//    "epantallaIni" : "4",
//    "ecablesIni" : "1",
//    "ebateriasIni" : "4",
//    "ensamIni" : "4",
//    "epantallaMax" : "8",
//    "ecablesMax" : "4",
//    "ebateriaMax" : "1",
//    "ensamMax" : "5"
//}
            

            
        } catch (Exception e) {
            
        }
        
        this.validar();
        
        
        
    }
    
    public void validar(){
        if(dias<=0){
                 JOptionPane.showMessageDialog(null,"Error (numero negativo): dias en milisegundos");
                 this.seguir=false;
             }
        if(diasdespacho<1){
                JOptionPane.showMessageDialog(null,"Error (numero negativo): dias antes de despacho");
                this.seguir=false;
            }
        if(apantallaMax<0){
                JOptionPane.showMessageDialog(null,"Error (numero negativo): almacen de pantalla");
                this.seguir=false;
            }
        if(acablesMax<0){
                JOptionPane.showMessageDialog(null,"Error (numero negativo): almacen de cables");
                this.seguir=false;
                
            }
        if(abateriasMax<0){
                JOptionPane.showMessageDialog(null,"Error (numero negativo): almacen de baterias");
                this.seguir=false;
            }
        if(pantallaMax<0){
               JOptionPane.showMessageDialog(null,"Error (numero negativo): empleados maximos productores de pantalla");
               this.seguir=false;
           }
        if(cablesMax<0){
               JOptionPane.showMessageDialog(null,"Error (numero negativo): empleados maximos productores de cables");
               this.seguir=false;
           }
        if(bateriasMax<0){
               JOptionPane.showMessageDialog(null,"Error (numero negativo): empleados maximos productores de baterias");
               this.seguir=false;
           }
        if(ensamMax<0){
               JOptionPane.showMessageDialog(null,"Error (numero negativo): empleados maximos ensambladores");
               this.seguir=false;
           }
         if(epantallaIni<0){
                JOptionPane.showMessageDialog(null,"Error (numero negativo): empleados inciales productores de pantalla");
                this.seguir=false;
                     
                  }
            if(ecablesIni<0){
                      JOptionPane.showMessageDialog(null,"Error (numero negativo): empleados iniciales productores de cables");
                      this.seguir=false;
                  }
             if(ebateriasIni<0){
                      JOptionPane.showMessageDialog(null,"Error (numero negativo): empleados iniclales productores de baterias");
                      this.seguir=false;
                  }
             if(ensamIni<0){
                 JOptionPane.showMessageDialog(null,"Error (numero negativo): empleados inciales ensambladores");
                 this.seguir=false;
               
           }
             if(epantallaIni>pantallaMax){
                 JOptionPane.showMessageDialog(null,"Error (numero mayor al maximo permitido): empleados inciales productores de pantalla");
                 this.seguir=false;
             }
             if(ecablesIni>cablesMax){
                 JOptionPane.showMessageDialog(null,"Error (numero mayor al maximo permitido): empleados inciales productores de cables");
                 this.seguir=false;
             }
             if(ebateriasIni>bateriasMax){
                 JOptionPane.showMessageDialog(null,"Error (numero mayor al maximo permitido): empleados inciales productores de baterias");
                 this.seguir=false;
             }
             if(ensamIni>ensamMax){
                 JOptionPane.showMessageDialog(null,"Error (numero mayor al maximo permitido): empleados inciales ensambladores");
                 this.seguir=false;
             }
        
        
        if(!seguir){
                 JOptionPane.showMessageDialog(null,"No se puede incializar el programa con datos invalidos");
                 System.exit(0);
             }
    }

    public int getDias() {
        return dias;
    }

    public int getDiasdespacho() {
        return diasdespacho;
    }

    public int getApantallaMax() {
        return apantallaMax;
    }

    public int getAcablesMax() {
        return acablesMax;
    }

    public int getAbateriasMax() {
        return abateriasMax;
    }

    public int getEpantallaIni() {
        return epantallaIni;
    }

    public int getEcablesIni() {
        return ecablesIni;
    }

    public int getEbateriasIni() {
        return ebateriasIni;
    }

    public int getEnsamIni() {
        return ensamIni;
    }

    public int getPantallaMax() {
        return pantallaMax;
    }

    public int getCablesMax() {
        return cablesMax;
    }

    public int getBateriasMax() {
        return bateriasMax;
    }

    public int getEnsamMax() {
        return ensamMax;
    }
    
    
    
    
}