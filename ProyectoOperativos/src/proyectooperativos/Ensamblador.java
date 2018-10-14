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
public class Ensamblador extends Thread{
    private ProyectoOperativos PP;
    private int pantallas; // 1 pantalla
    private int cables; // 2 cables
    private int baterias; // 1 bateria
    Almacen a1;
    private Semaphore sP1;
    private Semaphore sC1;
    private Semaphore sE1;
    private Semaphore sI1;
    private int apuntP1;
    Almacen a2;
    private Semaphore sP2;
    private Semaphore sC2;
    private Semaphore sE2;
    private Semaphore sI2;
    private int apuntP2;
    Almacen a3;
    private Semaphore sP3;
    private Semaphore sC3;
    private Semaphore sE3;
    private Semaphore sI3;
    private int apuntP3;
    private int val;
    private int unidades;
    private int dormir;
    
    

    public Ensamblador(ProyectoOperativos PP,Almacen a1, Semaphore sP1, Semaphore sC1, Semaphore sE1, int apuntP1, Almacen a2, Semaphore sP2, Semaphore sC2, Semaphore sE2, int apuntP2, Almacen a3, Semaphore sP3, Semaphore sC3, Semaphore sE3, int apuntP3, int val, int dormir) {
        this.PP=PP;
        this.a1 = a1;
        this.sP1 = sP1;
        this.sC1 = sC1;
        this.sE1 = sE1;
        this.apuntP1 = apuntP1;
        this.a2 = a2;
        this.sP2 = sP2;
        this.sC2 = sC2;
        this.sE2 = sE2;
        this.apuntP2 = apuntP2;
        this.a3 = a3;
        this.sP3 = sP3;
        this.sC3 = sC3;
        this.sE3 = sE3;
        this.apuntP3 = apuntP3;
        this.val = val;
        this.unidades = 0;
        this.dormir=dormir;
    }
    
    
    
    public void contruir(){
        if(pantallas==1&&cables==2&&baterias==1){
            PP.SumarU();
            PP.RestarC();
            try{
            Thread.sleep(dormir);
            }catch(InterruptedException ex){
                
            }

            pantallas--;
            cables--;
            cables--;
            baterias--;
            System.out.println("tengo uno mas xd"+PP.getUnidadesT());
            
            
            
            
            
            
            
            
        }
    }
    
    public boolean NeedPantallas(){
        return (pantallas==1);
    }
     public boolean NeedBaterias(){
        return (baterias==1);
    }
     public boolean NeedCables(){
        return (cables==2);
    }
     
     public void PantSum(){
         this.pantallas++;
     }
     
     public void CabSum(){
         this.cables++;
     }
     
     public void BatSum(){
         this.baterias++;
     }
     
     
     
      public void run(){
        while(true){
        
            this.contruir();
            
          if(!NeedPantallas()){
              try {
            this.PP.userI.ActLabels();
            sP1.acquire();
            sE1.acquire();
            a1.setVec(apuntP1, val);
            apuntP1=(apuntP1+1)%a1.getTam();
            this.PantSum();
            this.PP.userI.ActLabels();
            sC1.release();
            sE1.release();
            this.PP.userI.ActLabels();
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
          }  
          
          this.contruir();
            
          if(!NeedCables()){
              try {
            this.PP.userI.ActLabels();
            sP2.acquire(2);
            sE2.acquire();
            this.PP.userI.ActLabels();
            for(int i=0;i<2;i++){
                a2.setVec(apuntP2, val);
                apuntP2=(apuntP2+1)%a2.getTam();
                this.CabSum();
            }
            this.PP.userI.ActLabels();
            sC2.release(2);
            sE2.release();
            this.PP.userI.ActLabels();
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
          }
          
          this.contruir();
            
          if(!NeedBaterias()){
              try {
            this.PP.userI.ActLabels();
            sP3.acquire();
            sE3.acquire();
            a3.setVec(apuntP3, val);
            apuntP3=(apuntP3+1)%a3.getTam();
            this.BatSum();
            this.PP.userI.ActLabels();
            sC3.release();
            sE3.release();
            this.PP.userI.ActLabels();
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
          }
            
            
            
            
            
        }
    }
    
}
