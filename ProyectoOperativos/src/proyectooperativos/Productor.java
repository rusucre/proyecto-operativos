/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Productor extends Thread{
    protected ProyectoOperativos PP;
    Almacen a;
    protected Semaphore sP;
    protected Semaphore sC;
    protected Semaphore sE;
    protected int apuntP;
    protected int val;
    protected int dormir;
    public boolean fuego=true;

    public Productor(ProyectoOperativos PP,Almacen a, Semaphore sP, Semaphore sC, Semaphore sE, int apuntP, int val, int dormir) {
        this.PP=PP;
        this.a = a;
        this.sP = sP;
        this.sC = sC;
        this.sE = sE;
        this.apuntP=apuntP;
        this.val=val;
        this.dormir = dormir;
    }
    
    public void Sumar(){
        
    }
    
   public void chao(){
       this.fuego=false;
   }
    
    
    @Override
    public void run(){
        while(fuego){
        try {
            Thread.sleep(dormir);
            sP.acquire();
            sE.acquire();
            a.setVec(apuntP, val);
            this.Sumar();
            apuntP=(apuntP+1)%a.getTam();
            this.PP.userI.ActLabels();
            sC.release();
            sE.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    }

}
