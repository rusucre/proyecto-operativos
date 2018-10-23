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
public class Gerente extends Thread{
    private Semaphore DD;
    private String estado;
    private Semaphore MU;
    private int dormir;
    private ProyectoOperativos PP;
    private int diast;
    private int alet;
    private long sleep;

    public Gerente(Semaphore DD, int dormir, ProyectoOperativos PP, int diast) {
        this.DD = DD;
        this.estado = "Dormido";
        this.dormir=dormir;
        this.PP=PP;
        this.diast=diast;
        
    }

    public String getEstado() {
        return estado;
    }
    
    
     @Override
    public void run(){ // falta arreglar bug que no se despierta el gerente
        while(true){ // gerente se queda dormido hasta que se hace 0 los dias a despachar
        try {  // luego se despierta y se vuelve a dormir
            
            DD.acquire();
            if(PP.getDiasdespacho()==0){
                PP.despachar();
                PP.setDiasdespacho(this.diast);
                DD.release();
                sleep=1;
                PP.userI.ActLabels();
            }else{
                DD.release();
                alet=(int) (Math.random() * 12) + 6;
                this.estado="dormido";
                PP.userI.ActLabels();
//                System.out.println("dolmido");
                Thread.sleep((long) (dormir*0.041666667*alet));
                sleep=(long) (dormir*(1-(0.041666667*alet)));
            }

            
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
//            System.out.println("mercdes");
            this.estado="despierto";
            PP.userI.ActLabels();
            try{
                Thread.sleep(sleep);
        
            }catch (InterruptedException ex){
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            
        
        }
    }
    
    
}
