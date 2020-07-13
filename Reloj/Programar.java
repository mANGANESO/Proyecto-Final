package reloj.recurso;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;
public class Programar extends JFrame implements Runnable, ActionListener
{
  JLabel lblSus;
  JPanel panel2;
  JButton btn;
  JButton btn2;
  JButton btn3;
  JMenuItem item;
  JComboBox opHoras;
  JComboBox opMinutos;
  JComboBox opAmPm;
  String ho = "00";
  String mi = "00";
  String ap = "Am";
  int h;
  int m;
  public Programar(JMenuItem item)
  {
    this.item = item;
    panel2 = new JPanel();
    panel2.setLayout(null);
    panel2.setBackground(Color.BLACK);
    panel2.setVisible(true);
    lblSus = new JLabel("  " + ho + ":" + mi +" " + ap);
    lblSus.setBounds(120,100,300,50);
    lblSus.setForeground(Color.GREEN);
    lblSus.setOpaque(true);
    lblSus.setBackground(Color.BLACK);
    lblSus.setFont(new Font("Calibri", 0, 50));
    btn = new JButton("Guardar");
    btn.setBounds(80,200,100,30);
    btn2 = new JButton("Cancelar");
    btn2.setBounds(200,200,100,30);
    btn3 = new JButton("Regresar");
    btn3.setBounds(320,200, 100,30);

    /*Datos de la comboBox de las Horas*/
    int[] horas = new int[25];

    for (int i =1 ;i <=24; i++ ) 
    {	
      horas[i] = i;	
    }

    String timerS[] = new String[horas.length]; 
    for (int x = 1; x <horas.length; x++ ) 
    {
      timerS[x] = String.valueOf(horas[x]);       	
    }
    opHoras = new JComboBox(timerS);
    opHoras.setBounds(80, 20, 100, 30);
    opHoras.removeItemAt(0);

    /*Datos de la comboBox de los Minutos*/
    int[] minutos = new int[60];
    for (int i =1 ;i <=59; i++ ) 
    { 
      minutos[i] = i; 
    }

    String timerM[] = new String[minutos.length]; 
    for (int y = 0; y <minutos.length; y++ ) 
    {
      timerM[y] = String.valueOf(minutos[y]);          
    }
    opMinutos = new JComboBox(timerM);
    opMinutos.setBounds(200, 20, 100, 30);
    /*Datos de la comboBox Am/Pm*/
    String[] ampm = new String[2];
    ampm[0]=("Am");
    ampm[1]=("Pm");
    opAmPm = new JComboBox(ampm);
    opAmPm.setBounds(320, 20, 100, 30);
    
    panel2.add(opHoras);
    panel2.add(opMinutos);
    panel2.add(opAmPm);
    panel2.add(btn);
    panel2.add(btn2);
    panel2.add(btn3);
    panel2.add(lblSus);

    this.add(panel2);
    this.setSize(500,300);
    this.setResizable(false);
    this.setTitle("Programar...");
    this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    opHoras.addActionListener(this);
    opMinutos.addActionListener(this);
    opAmPm.addActionListener(this);
    btn.addActionListener(this);
    btn2.addActionListener(this);
    btn3.addActionListener(this);
  }

  @Override
  public void run()
  {
    while(true)
    {
      
      retardo(5000);
    } 
  }
  public void actionPerformed(ActionEvent event)
  {
  	if (event.getSource() == btn)
    {  
    	boolean carga = true;
    	String ho = (String)opHoras.getSelectedItem();
      String mi = (String)opMinutos.getSelectedItem();
      String ap = (String)opAmPm.getSelectedItem();
      Temporizador timer = new Temporizador(carga);
      timer.compara(ho,mi,ap);
      JOptionPane.showMessageDialog(null, "Guardado exitosamente");
      dispose();   
    }    
   
    //Boton Cancelar
    if (event.getSource() == btn2)
    {
      ho = "00";
      mi = "00";
      ap ="Am";
      lblSus.setText("  " + ho + ":" + mi +" " + ap);
    }

    //Boton Regresar
    if (event.getSource() == btn3)
    {
      //Cierra la ventana pero el proceso interno sigue funcionando
      dispose();
    }

    if(event.getSource()==opHoras)
    {
      String ho = (String)opHoras.getSelectedItem();
      String mi = (String)opMinutos.getSelectedItem();
      String ap = (String)opAmPm.getSelectedItem();
      int h = Integer.parseInt(ho);
      int m = Integer.parseInt(mi);
      if(h<10)
      {
        if(m<10)
        {
          lblSus.setText("0" + ho + ":" + "0" + mi +" " + ap);
        }
        if(m>9)
        {
          lblSus.setText("0" + ho + ":" + mi +" " + ap);
        }
      }
      if(h>9)
      {
        if(m<10)
        {
          lblSus.setText(" " + ho + ":" + "0" + mi +" " + ap);
        }
        if(m>9)
        {
          lblSus.setText(" " + ho + ":" + mi +" " + ap);
        }
      }   
    }

    if(event.getSource()==opMinutos)
    {
      String ho = (String)opHoras.getSelectedItem();
      String mi = (String)opMinutos.getSelectedItem();
      String ap = (String)opAmPm.getSelectedItem();
      int h = Integer.parseInt(ho);
      int m = Integer.parseInt(mi);
      if(h<10)
      {
        if(m<10)
        {
          lblSus.setText("0" + ho + ":" + "0" + mi +" " + ap);
        }
        if(m>9)
        {
          lblSus.setText("0" + ho + ":" + mi +" " + ap);
        }
      }
      if(h>9)
      {
        if(m<10)
        {
          lblSus.setText(" " + ho + ":" + "0" + mi +" " + ap);
        }
        if(m>9)
        {
          lblSus.setText(" " + ho + ":" + mi +" " + ap);
        }
      } 
    }

    if(event.getSource()==opAmPm)
    {
      String ho = (String)opHoras.getSelectedItem();
      String mi = (String)opMinutos.getSelectedItem();
      String ap = (String)opAmPm.getSelectedItem();
      int h = Integer.parseInt(ho);
      int m = Integer.parseInt(mi);
      if(h<10)
      {
        if(m<10)
        {
          lblSus.setText("0" + ho + ":" + "0" + mi +" " + ap);
        }
        if(m>9)
        {
          lblSus.setText("0" + ho + ":" + mi +" " + ap);
        }
      }
      if(h>9)
      {
        if(m<10)
        {
          lblSus.setText(" " + ho + ":" + "0" + mi +" " + ap);
        }
        if(m>9)
        {
          lblSus.setText(" " + ho + ":" + mi +" " + ap);
        }
      } 
   }
  }
  public void retardo(int ms)
  {
    try
    {
      Thread.sleep(ms);
    }
    catch(Exception e)
    {
      System.out.println("Error: al ejecutar el sleep.");
    }
  }
}