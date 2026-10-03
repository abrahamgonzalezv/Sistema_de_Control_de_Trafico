/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforo;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Davixc
 */
public class Semaforo2 extends Thread {
    JLabel carro;
    JLabel semaforoVerde;
    JLabel semaforoAmarillo;
    JLabel semaforoRojo;
    JPanel panel;

    public Semaforo2(JLabel carro, JLabel semaforoVerde, JLabel semaforoAmarillo, JLabel semaforoRojo,JPanel panel) {
        this.carro = carro;
        this.semaforoVerde = semaforoVerde;
        this.semaforoAmarillo = semaforoAmarillo;
        this.semaforoRojo = semaforoRojo;
        this.panel =panel;
    }
     @Override
    public void run(){
        
         
         try {
             while(true){
                 
             
                       // Espera hasta que el primer semáforo se active
                                Thread.sleep(6000); 

                        semaforoVerde.setVisible(true);
                        semaforoAmarillo.setVisible(false);
                        semaforoRojo.setVisible(false);

                        Thread.sleep(3000);
                        moverCarroVertical(carro);
                        semaforoVerde.setVisible(false);
                        semaforoAmarillo.setVisible(true);
                        Thread.sleep(1000);
                        semaforoAmarillo.setVisible(false);
                        semaforoRojo.setVisible(true);
                        Thread.sleep(2000);
}
                
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    }
     private void moverCarroVertical(JLabel carro) {
        int x = carro.getX(); 
        int y = carro.getY(); 
 
        for (int i = 0; i < 160; i++) { 
            y -= 5; 
            carro.setLocation(x, y); 
         
            try {
                Thread.sleep(30); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             if (y + carro.getHeight() <= 0) {
            y = panel.getHeight();
        }
        }

        }
}
