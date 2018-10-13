/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

/**
 *
 * @author risy1
 */

import java.util.concurrent.Semaphore;

/**
 *
 * @author Estudiantes
 */
public class ProyectoOperativos {
    
    private Almacen Apantallas;
    private Almacen Acables;
    private Almacen Abaterias;
    private Semaphore semaProductoresPantalla;
    private Semaphore semaConsumidoresPantalla;
    private Semaphore semaExclusividadPantalla;
    private Semaphore semaImpresionPantalla;
    private Semaphore semaProductoresCables;
    private Semaphore semaConsumidoresCables;
    private Semaphore semaExclusividadCables;
    private Semaphore semaImpresionCables;
    private Semaphore semaProductoresBaterias;
    private Semaphore semaConsumidoresBaterias;
    private Semaphore semaExclusividadBaterias;
    private Semaphore semaImpresionBaterias;
    private int apuntPpantallas;
    private int apuntCpantallas;
    private int apuntPcables;
    private int apuntCcables;
    private int apuntPbaterias;
    private int apuntCbaterias;
    private Productor ppantallas[];
    private Productor pcables[];
    private Productor pbaterias[];
    private Ensamblador ensambladores[];
    private int Apan;
    private int Acab;
    private int Abat;
    private int empleadosP;
    private int empleadosC;
    private int empleadosB;
    private int empleadosE;
    
     private int DormirEnsamblador;
     private int DormirPantalla;
     private int DormirCable;
     private int DormirBateria;
     
     private int MaxP;
     private int MaxC;
     private int MaxB;
     private int MaxE;
     
     private int IniP;
     private int IniC;
     private int IniB;
     private int IniE;

    public ProyectoOperativos(int Apan, int Acab, int Abat, int DormirPantalla, int DormirCable, int DormirBateria, int DormirEnsamblador, int MaxP, int MaxC, int MaxB, int MaxE) {
        this.Abat=Abat;
        this.Acab=Acab;
        this.Apan=Apan;
        this.DormirPantalla=DormirPantalla;
        this.DormirCable=DormirCable;
        this.DormirBateria=DormirBateria;
        this.DormirEnsamblador=DormirEnsamblador;
        this.MaxP=MaxP;
        this.MaxC=MaxC;
        this.MaxB=MaxB;
        this.MaxE=MaxE;
        empleadosP=0;
        empleadosC=0;
        empleadosB=0;
        empleadosE=0;
        
        Apantallas=new Almacen(Apan);
        Abaterias=new Almacen(Abat);
        Acables=new Almacen(Acab);
        
          semaProductoresPantalla=new Semaphore(Apan);
          semaConsumidoresPantalla=new Semaphore(0);
          semaExclusividadPantalla=new Semaphore(1);
          semaProductoresCables=new Semaphore(Acab);
          semaConsumidoresCables=new Semaphore(0);
          semaExclusividadCables=new Semaphore(1);
          semaProductoresBaterias=new Semaphore(Abat);
          semaConsumidoresBaterias=new Semaphore(0);
          semaExclusividadBaterias=new Semaphore(1);
          
          
          
    apuntPpantallas=0;
    apuntCpantallas=0;
    apuntPcables=0;
    apuntCcables=0;
    apuntPbaterias=0;
    apuntCbaterias=0;
    
    ppantallas=new Productor[MaxP]; //inicial 3 maximo 8
    pcables=new Productor[MaxC]; //inical 1 maximo 3
    pbaterias=new Productor [MaxB]; //inicial 2 maximo 4
    ensambladores= new Ensamblador[MaxE]; //incial 1 maximo 5
    
   
         
    
    }
    
    public void contratarPantalla(){
         int i=0;
         do{
             if(ppantallas[i]==null){
                 ppantallas[i]=new Productor(Apantallas, semaProductoresPantalla, semaConsumidoresPantalla, semaExclusividadPantalla, apuntPpantallas,1,DormirPantalla);
                 empleadosP++;
                 ppantallas[i].start();
             }else{
                 i++;
             }
         }while(i<this.MaxP);
    }
    
    public void contratarCable(){
        int i=0;
         do{
             if(pcables[i]==null){
                 pcables[i]=new Productor(Acables, semaProductoresCables, semaConsumidoresCables, semaExclusividadCables, apuntPcables,1,DormirCable);
                 empleadosC++;
                 pcables[i].start();
                 i=3;
             }else{
                 i++;
             }
         }while(i<this.MaxC);
        
    }
    
    public void contratarBateria(){
        int i=0;
         do{
             if(pbaterias[i]==null){
                 pbaterias[i]=new Productor(Abaterias, semaProductoresBaterias, semaConsumidoresBaterias, semaExclusividadBaterias, apuntPbaterias,1,DormirBateria);
                 empleadosB++;
                 pbaterias[i].start();
                 i=4;
             }else{
                 i++;
             }
         }while(i<this.MaxB);
        
    }
    
    public void contratarEnsamblador(){
        int i=0;
         do{
             if(ensambladores[i]==null){
//                     public Ensamblador(Almacen a1, Semaphore sP1, Semaphore sC1, Semaphore sE1, Semaphore sI1, int apuntP1, Almacen a2, Semaphore sP2, Semaphore sC2, Semaphore sE2, Semaphore sI2, int apuntP2, Almacen a3, Semaphore sP3, Semaphore sC3, Semaphore sE3, Semaphore sI3, int apuntP3, int val) {

                 ensambladores[i]=new Ensamblador(Apantallas, semaConsumidoresPantalla, semaProductoresPantalla, semaExclusividadPantalla, apuntCpantallas, Acables, semaConsumidoresCables, semaProductoresCables, semaExclusividadCables,apuntCcables ,Abaterias, semaConsumidoresBaterias, semaProductoresBaterias, semaExclusividadBaterias, apuntCbaterias,0, DormirEnsamblador);
                 empleadosE++;
                 ensambladores[i].start();
                 i=5;
             }else{
                 i++;
             }
         }while(i<this.MaxE);
       
    }
//    public void despedirPantalla(){
//              
//    }
//    
//    public void despedirCable(){
//        
//    }
//    
//    public void despedirBateria(){
//        
//    }
//    
//    public void despedirEnsablador(){
//        
//    }

   
    public static void main(String[] args) {
        int dia=1000;
        int pantallasmaximas=30;
        int cablesmaximos=25;
        int bateriasmaximas=35;
        int productoresdepantallasmas=8;
        int productoresdecablesmax=4;
        int productoresdebateriasmax=3;
        int ensambladoresmax=5;
        int productoresdepantallasini=3;
        int productoresdecablesini=2; 
        int productoresdebateriasini=1;
        int ensambladoresini=1;

        // leer jason
        
       
       ProyectoOperativos a= new ProyectoOperativos(pantallasmaximas,cablesmaximos,bateriasmaximas,(dia),(2*dia),(dia),(2*dia),productoresdepantallasmas,productoresdecablesmax,productoresdebateriasmax,ensambladoresmax);
       
       for(int i=0; i<productoresdepantallasini; i++){
       a.contratarPantalla();           
       }
       for(int i=0; i<productoresdecablesini; i++){
       a.contratarCable();           
       }
       for(int i=0; i<productoresdebateriasini; i++){
       a.contratarBateria();           
       }
       for(int i=0; i<ensambladoresini; i++){
       a.contratarEnsamblador();           
       }
       
       
    }
    
}
