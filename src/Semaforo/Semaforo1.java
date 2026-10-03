/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforo;

import java.awt.Panel;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Davixc
 */
public class Semaforo1 extends Thread {
    JLabel carro;
    JLabel semaforoVerde;
    JLabel semaforoAmarillo;
    JLabel semaforoRojo;
    JPanel panel;

    public Semaforo1(JLabel carro, JLabel semaforoVerde, JLabel semaforoAmarillo, JLabel semaforoRojo,JPanel panel) {
        this.carro = carro;
        this.semaforoVerde = semaforoVerde;
        this.semaforoAmarillo = semaforoAmarillo;
        this.semaforoRojo = semaforoRojo;
        this.panel =panel;
    }
    int con =0;
    @Override
    public void run(){
//          while (true) {
            try {
                while (true) {
             semaforoVerde.setVisible(true);
                        semaforoAmarillo.setVisible(false);
                        semaforoRojo.setVisible(false);

                        Thread.sleep(3000);
                        // Tiempo que el semáforo verde permanece encendido
                        moverCarroHorizontal(carro);
                        semaforoVerde.setVisible(false);
                        semaforoAmarillo.setVisible(true);
                        Thread.sleep(1000);  // Tiempo que el semáforo amarillo permanece encendido
                        semaforoAmarillo.setVisible(false);
                        semaforoRojo.setVisible(true);
                        Thread.sleep(2000);  // Tiempo que el semáforo rojo permanece encendido
                // Cambiar a verde
                 }

                

                // Cambiar a rojo
               
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }
    }

public void reiniciar(){
    
}

        private void moverCarroHorizontal(JLabel carro) {
        int x = carro.getX(); 
        int y = carro.getY(); 
 
        for (int i = 0; i < 120; i++) { 
            x += 5; 
            carro.setLocation(x, y); 
         
            try {
                Thread.sleep(30); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//               if (x + carro.getWidth() >=750) {
//            x = -panel.getWidth();
//        }
//            if (x == panel.getWidth()) {
//                x = -carro.getWidth();
//            }
 if (x + carro.getWidth() >= panel.getWidth()) {
           x = 0;
          
            carro.setLocation(x, y);
        }
        }

        }
    
    
}
