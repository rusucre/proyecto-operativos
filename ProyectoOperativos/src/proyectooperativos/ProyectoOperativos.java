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
import java.util.logging.Level;
import java.util.logging.Logger;
// revisar constructores del ensamblador y de pantallas, unico valor que se buguea

/**
 *
 * @author Estudiantes
 */
public class ProyectoOperativos {
    
    public UI userI;
    
    private Cronometro cron;
    private Gerente geren;
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
    private Semaphore Ensam;
    private Semaphore DD;
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
     private int dormir;
     
     private int MaxP;
     private int MaxC;
     private int MaxB;
     private int MaxE;
     
     
    private int PantallasT;
    private int CablesT;
    private int BateriasT;
    private int UnidadesT;
    
    private int diasdespacho;

    public Cronometro getCron() {
        return cron;
    }

    public Gerente getGeren() {
        return geren;
    }
    
    
     
     

    public ProyectoOperativos(int dormir,int diasdespacho, int Apan, int Acab, int Abat, int DormirPantalla, int DormirCable, int DormirBateria, int DormirEnsamblador, int MaxP, int MaxC, int MaxB, int MaxE) {
        
        this.diasdespacho=diasdespacho;
        DD= new Semaphore(1);
        this.dormir=dormir;
        geren=new Gerente( DD,dormir, this, this.diasdespacho);
        cron=new Cronometro( DD, this, this.diasdespacho,dormir);

        userI= new UI(this);
        userI.setVisible(true);
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
          Ensam=new Semaphore(1);
          
          
          
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
    
        PantallasT=0;
        CablesT=0;
        BateriasT=0;
        UnidadesT=0;
    
   
         
    
    }

    public int getPantallasT() {
        return PantallasT;
    }

    public int getCablesT() {
        return CablesT;
    }

    public int getBateriasT() {
        return BateriasT;
    }
    
   

    public int getUnidadesT() {
        return UnidadesT;
    }

    public int getEmpleadosP() {
        return empleadosP;
    }

    public int getEmpleadosC() {
        return empleadosC;
    }

    public int getEmpleadosB() {
        return empleadosB;
    }

    public int getEmpleadosE() {
        return empleadosE;
    }
    
    
    
    public void SumarP(){
        PantallasT++;
    }
    public void SumarC(){
        CablesT++;
    }
    public void SumarB(){
        BateriasT++;
    }
    public void SumarU(){
        UnidadesT++;
    }
    
    public void RestarP(){
        PantallasT--;
    }
    
    public void RestarC(){
        CablesT--;
    }
    
    public void RestarB(){
        BateriasT--;
    }
    
   
    
    
    public void contratarPantalla(){
         int i=0;
         if(empleadosP<MaxP){
             do{
             if(ppantallas[i]==null){
                 ppantallas[i]=new Ppantalla(this.Ensam, this, Apantallas, semaProductoresPantalla, semaConsumidoresPantalla, semaExclusividadPantalla, apuntPpantallas,1,DormirPantalla);
                 empleadosP++;
                 ppantallas[i].start();
                 i=this.MaxP;
                 userI.ActLabels();
             }else{
                 i++;
             }
         }while(i<this.MaxP);
         }
         
    }
    
    public void contratarCable(){
        int i=0;
        if(empleadosC<MaxC){
            do{
             if(pcables[i]==null){
                 pcables[i]=new Pcable(this.Ensam, this, Acables, semaProductoresCables, semaConsumidoresCables, semaExclusividadCables, apuntPcables,1,DormirCable);
                 empleadosC++;
                 pcables[i].start();
                 i=this.MaxC;
                 userI.ActLabels();
             }else{
                 i++;
             }
         }while(i<this.MaxC);
         }
         
        
    }
    
    public void contratarBateria(){
        int i=0;
        if(empleadosB<MaxB){
            do{
             if(pbaterias[i]==null){
                 pbaterias[i]=new Pbateria(this.Ensam, this, Abaterias, semaProductoresBaterias, semaConsumidoresBaterias, semaExclusividadBaterias, apuntPbaterias,1,DormirBateria);
                 empleadosB++;
                 pbaterias[i].start();
                 i=this.MaxB;
                 userI.ActLabels();
             }else{
                 i++;
             }
         }while(i<this.MaxB);
         }
         
        
    }
    
//        public Ensamblador(Semaphore units, ProyectoOperativos PP,Almacen a1, Semaphore sP1, Semaphore sC1, Semaphore sE1, int apuntP1, Almacen a2, Semaphore sP2, Semaphore sC2, Semaphore sE2, int apuntP2, Almacen a3, Semaphore sP3, Semaphore sC3, Semaphore sE3, int apuntP3, int val, int dormir) {

    
    public void contratarEnsamblador(){
        int i=0;
        if(empleadosE<MaxE){
            do{
             if(ensambladores[i]==null){
//                     public Ensamblador(Almacen a1, Semaphore sP1, Semaphore sC1, Semaphore sE1, Semaphore sI1, int apuntP1, Almacen a2, Semaphore sP2, Semaphore sC2, Semaphore sE2, Semaphore sI2, int apuntP2, Almacen a3, Semaphore sP3, Semaphore sC3, Semaphore sE3, Semaphore sI3, int apuntP3, int val) {

                 ensambladores[i]=new Ensamblador(this.Ensam, this, Apantallas, semaConsumidoresPantalla, semaProductoresPantalla, semaExclusividadPantalla, apuntCpantallas, Acables, semaConsumidoresCables, semaProductoresCables, semaExclusividadCables,apuntCcables ,Abaterias, semaConsumidoresBaterias, semaProductoresBaterias, semaExclusividadBaterias, apuntCbaterias,0, DormirEnsamblador);
                 empleadosE++;
                 ensambladores[i].start();
                 i=MaxE;
                 userI.ActLabels();
             }else{
                 i++;
             }
         }while(i<this.MaxE);
         }
         
         
         
       
    }
    
    public void despedirPantalla(){ // evaluar

        int i=0;
        if(empleadosP>0){
            do{
                if(ppantallas[i]!=null){
                    ppantallas[i].chao();
                    ppantallas[i]=null;
                    empleadosP--;
                    i=this.MaxP;
                    userI.ActLabels();
                }else{
                    i++;
                }
            }while(i<this.MaxP);

        }
             
//        if(empleadosP>0){
//            empleadosP--;
//            int i=0;
//         do{
//             if(ppantallas[i]!=null){
//                 i=this.MaxP;
//                 userI.ActLabels();
//                 ppantallas[i].fuego=false;
//                 ppantallas[i]=null;
//             }else{
//                 i++;
//             }
//         }while(i<this.MaxP);
//        }
         
         
         }
    
    public void despedirCable(){
                     int i=0;
                     if(empleadosC>0){
                       do{
             if(pcables[i]!=null){
                 pcables[i].chao();
                 pcables[i]=null;
                 empleadosC--;
                 i=this.MaxC;
                 userI.ActLabels();
             }else{
                 i++;
             }
         }while(i<this.MaxC);
           
                     }
        
    }
    
    public void despedirBateria(){
                     int i=0;
                     if(empleadosB>0){
                        do{
             if(pbaterias[i]!=null){
                 pbaterias[i].chao();
                 pbaterias[i]=null;
                 empleadosB--;
                 i=this.MaxB;
                 userI.ActLabels();
             }else{
                 i++;
             }
         }while(i<this.MaxB); 
                     }
         
        
    }
    
    public void despedirEnsamblador(){
                     int i=0;
                     if(empleadosE>0){
                          do{
             if(ensambladores[i]!=null){
                 ensambladores[i].chao();
                 ensambladores[i]=null;
                 empleadosE--;
                 i=this.MaxE;
                 userI.ActLabels(); 
             }else{
                 i++;
             }
         }while(i<this.MaxE);
                     }
        
        
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

    public int getDiasdespacho() {
        return diasdespacho;
    }

    public void setDiasdespacho(int diasdespacho) {
        this.diasdespacho = diasdespacho;
        System.out.println("cerito");
    }
    
    public void despachar(){

        try {
        this.Ensam.acquire();
        UnidadesT=0;
        this.userI.ActLabels();
            System.out.println("Despache xd");
        this.Ensam.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

   
    public static void main(String[] args) {
        int dia=1000;
        int pantallasmaximas=30;
        int cablesmaximos=25;
        int bateriasmaximas=35;
        int productoresdepantallasmas=8;
        int productoresdecablesmax=8;
        int productoresdebateriasmax=5;
        int ensambladoresmax=20;
        int productoresdepantallasini=2;
        int productoresdecablesini=2; 
        int productoresdebateriasini=1;
        int ensambladoresini=1;
        int diasdespacho=5;

        // leer jason
        
       
       ProyectoOperativos a= new ProyectoOperativos(dia,diasdespacho,pantallasmaximas,cablesmaximos,bateriasmaximas,(2*dia),(dia),(dia),(2*dia),productoresdepantallasmas,productoresdecablesmax,productoresdebateriasmax,ensambladoresmax);
       
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
       
       a.geren.start();
       a.cron.start();
       
      
       
       
    }
    
}
