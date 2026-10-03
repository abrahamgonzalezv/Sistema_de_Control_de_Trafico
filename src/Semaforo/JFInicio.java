/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Davixc
 */
public class JFInicio extends JFrame {

    JPanel panel;

    public JFInicio() {
        iniciarComponentes();
        setSize(710, 730);
        setTitle("Semaforos");
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        boton2.setEnabled(false);
        boton3.setEnabled(false);
        boton4.setEnabled(false);

    }

    public static void main(String[] args) {
        JFInicio principal = new JFInicio();
        principal.setVisible(true);

    }
    Cronometro miCro;
    static boolean iniciarHilo = true;
    static int hora = 0, minuto = 0, segundo= 0, dias=0;
public void iniciarHilo (){
    if (iniciarHilo == true){
        System.out.println("iniciando ");
        miCro = new Cronometro (cronometro);
        miCro.start();
    }
     }
    private void iniciarComponentes() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.white);

        botones();
        etliquetas();

    }
    Semaforo1 semaforo1;
    Semaforo2 semaforo2;
    Semaforo3 semaforo3;
    public void iniciar(){
        semaforo1 = new Semaforo1(carro1, semaforoverde1, semaforoamarillo1, semaforoRojo1, panel);
                semaforo2 = new Semaforo2(carro2, semaforoverde2, semaforoamarillo2, semaforoRojo2, panel);
                semaforo3 = new Semaforo3(carro3, semaforoverde3, semaforoamarillo3, semaforoRojo3, panel);
                semaforo1.start();
                semaforo2.start();
                semaforo3.start();
           
    }
boolean ejecutando = false;

    private void botones() {

        JButton boton1 = new JButton();
        boton1.setBounds(200, 470, 100, 50);
        boton1.setText("INICIAR");
        boton1.setMnemonic('a');
        panel.add(boton1);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 iniciarHilo();
            iniciar();
             boton2.setEnabled(true);
        boton4.setEnabled(true);
                 
            }

        });

         boton2 = new JButton();
        boton2.setBounds(200, 530, 100, 50);
//        boton2.setMnemonic('a');
        boton2.setText("detener");
        panel.add(boton2);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCro.stop();
            
                semaforo1.stop();
                semaforo2.stop();
                semaforo3.stop();
                boton3.setEnabled(true);

//              pausarReanudarHilos();
            }
        });
  boton3 = new JButton();
        boton3.setBounds(200, 590, 100, 50);
//        boton2.setMnemonic('a');
        boton3.setText("continuar");
        panel.add(boton3);
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            boton3.setEnabled(false);
               iniciarHilo();
iniciar();
//              pausarReanudarHilos();
            }
        });
         boton4 = new JButton();
        boton4.setBounds(200, 650, 100, 50);
//        boton2.setMnemonic('a');
        boton4.setText("salir");
        panel.add(boton4);
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

//              pausarReanudarHilos();
            }
        });
        
    }

    private void etliquetas() {
        //cronometro
        cronometro = new JLabel();
        cronometro.setBounds(60, 510, 150, 50);
        cronometro.setText("00: 00: 00: 00");
         cronometro.setFont(new Font("Arial", Font.BOLD, 20)); // Cambia la fuente a Arial, negrita y tamaño 24
        cronometro.setForeground(Color.BLACK); // C
        cronometro.setBackground(Color.white);
        panel.add(cronometro);

        //carros
        ImageIcon imagen1 = new ImageIcon("src/imagenes/carro1.1.png");
        carro1 = new JLabel(imagen1);
        carro1.setText("carro1");
        carro1.setBounds(54, 381, 115, 80);
        carro1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(carro1.getWidth(), carro1.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(carro1);

        ImageIcon imagen2 = new ImageIcon("src/imagenes/carsrojo.png");
        carro2 = new JLabel(imagen2);
        carro2.setText("carro1");
        carro2.setBounds(387, 550, 64, 115);
        carro2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(carro2.getWidth(), carro2.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(carro2);

        ImageIcon imagen3 = new ImageIcon("src/imagenes/carro2.1.png");
        carro3 = new JLabel(imagen3);
        carro3.setText("carro1");
        carro3.setBounds(561, 272, 115, 80);
        carro3.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(carro3.getWidth(), carro3.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(carro3);

        //semaforos verdes
        ImageIcon imagen4 = new ImageIcon("src/imagenes/semaforoverde.png");
        semaforoverde1 = new JLabel(imagen4);
        semaforoverde1.setText("semaforo1");
        semaforoverde1.setBounds(195, 360, 60, 100);
        semaforoverde1.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(semaforoverde1.getWidth(), semaforoverde1.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(semaforoverde1);

        ImageIcon imagen5 = new ImageIcon("src/imagenes/semaforo1.png");
        semaforoverde2 = new JLabel(imagen5);
        semaforoverde2.setText("semaforo2");
        semaforoverde2.setBounds(375, 485, 128, 43);
        semaforoverde2.setIcon(new ImageIcon(imagen5.getImage().getScaledInstance(semaforoverde2.getWidth(), semaforoverde2.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(semaforoverde2);

        ImageIcon imagen6 = new ImageIcon("src/imagenes/semaforoverde.png");
        semaforoverde3 = new JLabel(imagen6);
        semaforoverde3.setText("semaforo3");
        semaforoverde3.setBounds(495, 220, 60, 100);
        semaforoverde3.setIcon(new ImageIcon(imagen6.getImage().getScaledInstance(semaforoverde3.getWidth(), semaforoverde3.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(semaforoverde3);

        //semaforos amarillos
        ImageIcon imagen7 = new ImageIcon("src/imagenes/semaforoamarillo.png");
        semaforoamarillo1 = new JLabel(imagen7);
        semaforoamarillo1.setText("semaforoamarillo1");
        semaforoamarillo1.setBounds(195, 360, 60, 100);
        semaforoamarillo1.setIcon(new ImageIcon(imagen7.getImage().getScaledInstance(semaforoamarillo1.getWidth(), semaforoamarillo1.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(semaforoamarillo1);

        ImageIcon imagen8 = new ImageIcon("src/imagenes/semaforoA1.png");
        semaforoamarillo2 = new JLabel(imagen8);
        semaforoamarillo2.setText("semaforoamarillo1");
        semaforoamarillo2.setBounds(410, 485, 50, 43);
        semaforoamarillo2.setIcon(new ImageIcon(imagen8.getImage().getScaledInstance(semaforoamarillo2.getWidth(), semaforoamarillo2.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(semaforoamarillo2);

        ImageIcon imagen9 = new ImageIcon("src/imagenes/semaforoamarillo.png");
        semaforoamarillo3 = new JLabel(imagen9);
        semaforoamarillo3.setText("semaforo2");
        semaforoamarillo3.setBounds(495, 220, 60, 100);
        semaforoamarillo3.setIcon(new ImageIcon(imagen9.getImage().getScaledInstance(semaforoamarillo3.getWidth(), semaforoamarillo3.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(semaforoamarillo3);

        //semaforo roojo
        ImageIcon imagen10 = new ImageIcon("src/imagenes/semafororojo.png");
        semaforoRojo1 = new JLabel(imagen10);
        semaforoRojo1.setText("semaforoamarillo1");
        semaforoRojo1.setBounds(195, 360, 60, 100);
        semaforoRojo1.setIcon(new ImageIcon(imagen10.getImage().getScaledInstance(semaforoRojo1.getWidth(), semaforoRojo1.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(semaforoRojo1);

        ImageIcon imagen11 = new ImageIcon("src/imagenes/semaforoultimo.png");
        semaforoRojo2 = new JLabel(imagen11);
        semaforoRojo2.setText("semaforoamarillo1");
        semaforoRojo2.setBounds(375, 485, 1, 43);
        semaforoRojo2.setIcon(new ImageIcon(imagen11.getImage().getScaledInstance(semaforoRojo2.getWidth(), semaforoRojo2.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(semaforoRojo2);

        ImageIcon imagen12 = new ImageIcon("src/imagenes/semafororojo.png");
        semaforoRojo3 = new JLabel(imagen12);
        semaforoRojo3.setText("semaforo2");
        semaforoRojo3.setBounds(495, 220, 60, 100);
        semaforoRojo3.setIcon(new ImageIcon(imagen12.getImage().getScaledInstance(semaforoRojo3.getWidth(), semaforoRojo3.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(semaforoRojo3);

        ImageIcon fondo1 = new ImageIcon("src/imagenes/fundo.png");
        fondo = new JLabel(fondo1);
        fondo.setText("carro1");
        fondo.setBounds(0, 0, 700, 700);
        fondo.setIcon(new ImageIcon(fondo1.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(fondo);

    }
    public static JLabel carro1;
    public static JLabel carro2;
    public static JLabel carro3;
    public static JLabel semaforoverde1;
    public static JLabel semaforoverde2;
    public static JLabel semaforoverde3;
    public static JLabel semaforoamarillo1;
    public static JLabel semaforoamarillo2;
    public static JLabel semaforoamarillo3;
    public static JLabel semaforoRojo1;
    public static JLabel semaforoRojo2;
    public static JLabel semaforoRojo3;
     public static JLabel cronometro;
     public static JButton boton2;
     public static JButton boton3;
     public static JButton boton4;
    public JLabel fondo;

}
