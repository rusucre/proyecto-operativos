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
public class Pbateria extends Productor{

    public Pbateria(Semaphore units, ProyectoOperativos PP, Almacen a, Semaphore sP, Semaphore sC, Semaphore sE, int apuntP, int val, int dormir) {
        super(units, PP, a, sP, sC, sE, apuntP, val, dormir);
    }
   
    
    @Override
    public void Sumar(){

        PP.SumarB();
    }
}
