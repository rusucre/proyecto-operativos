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
    Almacen a;
    private Semaphore sP;
    private Semaphore sC;
    private Semaphore sE;
    private int apuntP;
    private int val;
    private int unidades;
    private int dormir;

    public Productor(Almacen a, Semaphore sP, Semaphore sC, Semaphore sE, int apuntP, int val, int domir) {
        this.a = a;
        this.sP = sP;
        this.sC = sC;
        this.sE = sE;
        this.apuntP=apuntP;
        this.val=val;
        this.dormir=dormir;
    }
    
    @Override
    public void run(){
        while(true){
        try {
            Thread.sleep(dormir);
            sP.acquire();
            sE.acquire();
            a.setVec(apuntP, val);
            apuntP=(apuntP+1)%a.getTam();
            sC.release();
            sE.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    }

}
