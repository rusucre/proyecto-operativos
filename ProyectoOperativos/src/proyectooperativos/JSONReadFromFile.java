package proyectooperativos;

import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import static java.lang.Integer.parseInt;

 
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
    
            

    public JSONReadFromFile() {
        JSONParser parser = new JSONParser();
      
 
        try {
            Object obj = parser.parse(new FileReader("config.json"));
            JSONObject jsonObject = (JSONObject) obj;
 
             dias = Integer.parseInt((String) jsonObject.get("dias"));
            diasdespacho = Integer.parseInt((String) jsonObject.get("diasdespacho"));
            apantallaMax = Integer.parseInt((String) jsonObject.get("apantallaMax"));
            acablesMax = Integer.parseInt((String) jsonObject.get("acablesMax"));
           abateriasMax = Integer.parseInt((String) jsonObject.get("abateriasMax"));
                  epantallaIni = Integer.parseInt((String) jsonObject.get("epantallaIni"));
             ecablesIni = Integer.parseInt((String) jsonObject.get("ecablesIni"));
             ebateriasIni = Integer.parseInt((String) jsonObject.get("ebateriasIni"));
           ensamIni = Integer.parseInt((String) jsonObject.get("ensamIni"));
                        pantallaMax = Integer.parseInt((String) jsonObject.get("pantallaMax"));
                cablesMax = Integer.parseInt((String) jsonObject.get("cablesMax"));
             bateriasMax = Integer.parseInt((String) jsonObject.get("bateriasMax"));
           ensamMax = Integer.parseInt((String) jsonObject.get("ensamMax"));
            
            
            
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