import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;
class Programar extends JFrame implements Runnable, ActionListener, ItemListener
{
  JPanel panel2;
  JButton btn;
  JButton btn2;
  JButton btn3;
  JMenuItem item;
  JComboBox opHoras;
  JComboBox opMinutos;
  JComboBox opAmPm;
  public Programar(JMenuItem item)
  {
    this.item = item;
    panel2 = new JPanel();
    panel2.setLayout(null);
    panel2.setVisible(true);
    btn = new JButton("Guardar");
    btn.setBounds(80,150,100,30);
    btn2 = new JButton("Cancelar");
    btn2.setBounds(200,150,100,30);
    btn3 = new JButton("Regresar");
    btn3.setBounds(320,150, 100,30);

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
    opHoras.setBounds(80, 30, 100, 30);
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
    opMinutos.setBounds(200, 30, 100, 30);
    /*Datos de la comboBox Am/Pm*/
    String[] ampm = new String[2];
    ampm[0]=("Am");
    ampm[1]=("Pm");
    opAmPm = new JComboBox(ampm);
    opAmPm.setBounds(320, 30, 100, 30);
    
    panel2.add(opHoras);
    panel2.add(opMinutos);
    panel2.add(opAmPm);
    panel2.add(btn);
    panel2.add(btn2);
    panel2.add(btn3);

    this.add(panel2);
    this.setSize(500,300);
    this.setResizable(false);
    this.setTitle("Programar...");
    this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  @Override
  public void run()
  {

  }
  public void actionPerformed(ActionEvent event)
  {
      
  }
  public void itemStateChanged(ItemEvent e)
  {

  }
}