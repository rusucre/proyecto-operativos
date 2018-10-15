/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author risy1
 */
public class Cronometro extends Thread{
    private Semaphore DD;
    private String estado;
    private float dormir;
    private ProyectoOperativos PP;
    private int diast;

    public Cronometro(Semaphore DD, ProyectoOperativos PP, int diast,int dormir) {
        this.DD = DD;
        this.PP = PP;
        this.diast = diast;
        this.estado="dormido";
        this.dormir=dormir;
    }

    public String getEstado() {
        return estado;
    }
    
        
    
    
    
     @Override
    public void run(){
        while(true){
        try {
            DD.acquire();
            this.estado="modificando";
            this.PP.userI.ActLabels();
            Thread.sleep((long) (0.0625*dormir));
            if(PP.getDiasdespacho()==0){
                PP.setDiasdespacho(this.diast);
            }else{
                PP.setDiasdespacho(PP.getDiasdespacho()-1);
            }
            DD.release();
            this.estado="dormido";
            this.PP.userI.ActLabels();
            Thread.sleep((long) (0.9375*dormir));
         
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    }
    
    
    
}
