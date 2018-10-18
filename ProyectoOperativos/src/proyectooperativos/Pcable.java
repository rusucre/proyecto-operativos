/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author risy1
 */
public class Pcable extends Productor{

    public Pcable(Semaphore units, ProyectoOperativos PP, Almacen a, Semaphore sP, Semaphore sC, Semaphore sE, int apuntP, int val, int dormir) {
        super(units, PP, a, sP, sC, sE, apuntP, val, dormir);
    }
   
    
    @Override
    public void Sumar(){
        PP.SumarC();
    }
    
}
