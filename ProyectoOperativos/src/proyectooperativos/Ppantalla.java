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
public class Ppantalla extends Productor{
    
    public Ppantalla(ProyectoOperativos PP, Almacen a, Semaphore sP, Semaphore sC, Semaphore sE, int apuntP, int val, int dormir) {
        super(PP, a, sP, sC, sE, apuntP, val, dormir);
    }
    
    @Override
    public void Sumar(){
        PP.SumarP();
    }
    
}
