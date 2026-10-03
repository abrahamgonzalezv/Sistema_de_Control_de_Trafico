/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Cronometro extends Thread  {
    JLabel cronometro;
    public  Cronometro( JLabel cronometro){
        this.cronometro = cronometro;
    }
    public void run () {
        try {
            while (JFInicio.iniciarHilo) {
                Thread.sleep(1);
                ejecutarHiloCronometro();
            }
        } catch (InterruptedException e ) {
            System.out.println("excepcion del hilo" + e.getMessage());
        }
        
    }
    public void ejecutarHiloCronometro (){
        JFInicio.segundo++;
        
        if (JFInicio.segundo>59 ){
            JFInicio.segundo= 0;
            JFInicio.minuto++;
            
            if ( JFInicio.minuto>59){
                JFInicio.minuto=0;
                JFInicio.hora++;
                
                if (JFInicio.hora > 23 ) {
                JFInicio.hora = 0;
                JFInicio.dias++; // Incrementa los días cada vez que pasan 24 horas
            }
            }
           
            
        }
           String txtSeg = "", txtMin="", txtHora="", txtDia;
    
    if (JFInicio.segundo<10 ){
    txtSeg ="0" +JFInicio.segundo;
}else {
        txtSeg =""+ JFInicio.segundo;
    }
    
    if (JFInicio.minuto<10){
        txtMin= "0" + JFInicio.minuto;
    }else {
        txtMin = ""+ JFInicio.minuto;
    }
    
    if (JFInicio.hora<10){
        txtHora="0"+ JFInicio.hora;
    }else {
        txtHora=""+ JFInicio.hora;
    }
   
     if(JFInicio.dias<10){
         txtDia="0" + JFInicio.dias;
     }else {
          txtDia="" + JFInicio.dias;
     }
     String reloj = txtDia+":"+txtHora+":"+txtMin+":"+txtSeg;
    cronometro.setText(reloj);
    }
   
   
}
