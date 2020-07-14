import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;

public class Reloj
{
  ///Reloj apk
  public static void main(String[] args) 
  {
  	ComponentesReloj reloj = new ComponentesReloj();
  }
}

class ComponentesReloj extends JFrame implements Runnable, ActionListener
{
  JLabel lblReloj;
  String hora,minuto,segundo,am_pm;
  Calendar Calendario;
  Thread hilo1;
  Thread hilo2;
  Thread hilo3;
  Thread hilo6;
  Thread hilo7;
  Thread hilo19;
  JPanel panel;
  JMenuBar menuBar;
  JMenu opciones;
  JMenuItem item;
  JMenuItem menu;
  JMenuItem alarma;
  JMenuItem colorN,colorF,h12,h24,version,agua;
  int cN = 1;
  int cF = 1;
  int awa = 0;
  int time1, time2 = 0;
  String time3 ="";
  public ComponentesReloj()
  {
    try
    { 
      /*panel inicializacion */
      panel = new JPanel();
      panel.setLayout(null);
      panel.setFocusable(true);
      panel.requestFocusInWindow();
      /*Inicializacion etiqueta*/
      lblReloj = new JLabel();
      lblReloj.setBounds(0, 5, 500, 300);
      lblReloj.setForeground(Color.GREEN);
      lblReloj.setOpaque(true);
      lblReloj.setBackground(Color.BLACK);
      lblReloj.setFont(new Font("Calibri", 0, 80));
      hilo1 = new Thread(this);

      //Barra de Menus
      menuBar = new JMenuBar();
      opciones = new JMenu("Ajustes");
      item = new JMenuItem("Programar");
      item.setBackground(Color.RED);
      menu = new JMenuItem("Menu");
      alarma = new JMenuItem("Alarma");
      alarma.setBackground(Color.RED);

      //Ajustes y sus opciones
      colorN = new JMenuItem("Color Num.");
      colorN.setBackground(Color.RED);
      colorF = new JMenuItem("Color Fondo");
      colorF.setBackground(Color.WHITE);
      version = new JMenuItem("Version");
      agua = new JMenuItem("Agua");
      agua.setBackground(Color.RED);
   
      menuBar.add(item);
      menuBar.add(menu);
      menuBar.add(alarma);
      menuBar.add(opciones);
      opciones.add(colorN);
      opciones.add(new JSeparator()); 
      opciones.add(colorF); 
      opciones.add(new JSeparator());
      opciones.add(version);
      opciones.add(new JSeparator());
      opciones.add(agua);   
      panel.add(lblReloj);

      /*Acciones del panel */
      this.add(panel);
      this.setSize(500 ,300);
      this.setResizable(false);
      this.setTitle("Reloj Emprendedor");
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      this.setVisible(true);
      this.setJMenuBar(menuBar);

      item.addActionListener(this);
      menu.addActionListener(this);
      alarma.addActionListener(this);
      colorN.addActionListener(this);
      colorF.addActionListener(this);
      version.addActionListener(this);
      agua.addActionListener(this);
      hilo1.start();    
    }

    catch(Exception e)
    {
      System.out.println("Ha ocurrio un error al iniciar el programa :(");
    }  
  }

  @SuppressWarnings("unchecked")//Agregado para evitar los problemas tenidos a la hora de programar
  @Override
  public void run()
  {
    Thread ct = Thread.currentThread();
    while(ct == hilo1)
    {
      calcula();
      lblReloj.setText("  " + hora + ":" + minuto + ":" + segundo + " " + am_pm);

      try
      {
        Thread.sleep(1000);
      }

      catch(Exception e)
      {
        System.out.println("Ha ocurrido un error al obtener la hora");
      }
    }
  }

  //Obtiene la hora del ordenador
  public void calcula()
  {
    Calendar calendario = new GregorianCalendar();
    Date fecha = new Date();
    calendario.setTime(fecha); //obteniendo fecha

    am_pm = calendario.get(Calendar.AM_PM) == Calendar.AM?"AM":"PM";//determinando am o pm

    //condiciones si es AM
    if (am_pm.equals("AM")) 
    {
      int horaDia = calendario.get(Calendar.HOUR_OF_DAY)-12;
      hora = horaDia>9?"" + horaDia:"0" + horaDia;
    }

    else
    {
      hora = calendario.get(Calendar.HOUR_OF_DAY) > 9? "" + calendario.get(Calendar.HOUR_OF_DAY): "0" + calendario.get(Calendar.HOUR_OF_DAY);
    }

    minuto = calendario.get(Calendar.MINUTE) > 9? "" + calendario.get(Calendar.MINUTE): "0" + calendario.get(Calendar.MINUTE);
    segundo = calendario.get(Calendar.SECOND) > 9? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);

    //Condiciones si es PM
    if (am_pm.equals("PM")) 
    {   
      int horaDia = calendario.get(Calendar.HOUR_OF_DAY);
      hora = horaDia>9?"" + horaDia:"0" + horaDia;
    }

    else
    {
      hora = calendario.get(Calendar.HOUR_OF_DAY) > 9? "" + calendario.get(Calendar.HOUR_OF_DAY): "0" + calendario.get(Calendar.HOUR_OF_DAY);
    }

    minuto = calendario.get(Calendar.MINUTE) > 9? "" + calendario.get(Calendar.MINUTE): "0" + calendario.get(Calendar.MINUTE);
    segundo = calendario.get(Calendar.SECOND) > 9? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
  }

  //oyente de los botones
  public void actionPerformed(ActionEvent event)
  {
    //fijar hora de suspension
    if (event.getSource() == item) 
    {
      Programar programar = new Programar(this.item);
      hilo2 = new Thread(programar);
      hilo2.start();
    }

    if (event.getSource() == colorN)
    {
      cN=cN+1;
      if(cN>5)
      {
        cN=1;
      }
      switch (cN)
      {
        case 1:
          lblReloj.setForeground(Color.GREEN);
          colorN.setBackground(Color.RED);
        break;
        case 2:
          lblReloj.setForeground(Color.RED);
          colorN.setBackground(Color.BLUE);
        break;
        case 3:
          lblReloj.setForeground(Color.BLUE);
          colorN.setBackground(Color.YELLOW);
        break;
        case 4:
          lblReloj.setForeground(Color.YELLOW);
          colorN.setBackground(Color.MAGENTA);
        break;
        case 5:
          lblReloj.setForeground(Color.MAGENTA);
          colorN.setBackground(Color.GREEN);
        break;
      }
    }

    if (event.getSource() == colorF)
    {
      cF=cF+1;
      if(cF>5)
      {
        cF=1;
      }
      switch (cF)
      {
        case 1:
          lblReloj.setBackground(Color.BLACK);
          colorF.setBackground(Color.WHITE);
        break;
        case 2:
          lblReloj.setBackground(Color.WHITE);
          colorF.setBackground(Color.CYAN);
        break;
        case 3:
          lblReloj.setBackground(Color.CYAN);
          colorF.setBackground(Color.PINK);
        break;
        case 4:
          lblReloj.setBackground(Color.PINK);
          colorF.setBackground(Color.ORANGE);
        break;
        case 5:
          lblReloj.setBackground(Color.ORANGE);
          colorF.setBackground(Color.BLACK);
        break;
      }
    }

    if (event.getSource() == version)
    {
      //Ventana Emergente que muestra la version actual del programa.
      JOptionPane.showMessageDialog(null,"Version: 1.9","Version",JOptionPane.INFORMATION_MESSAGE);
    }

    if (event.getSource() == agua)
    {
      awa=awa+1;
      if(awa>2)
      {
        cF=0;
      }

      switch (awa)
      {
        case 1:
        agua.setBackground(Color.GREEN);
        JOptionPane.showMessageDialog(null,"Se Activo el Modo Rehidratacion","Modo Rehidratacion...",JOptionPane.INFORMATION_MESSAGE);
        Agua awa = new Agua();
        hilo6 = new Thread(awa);
        hilo6.start();
        break;
        case 2:
        agua.setBackground(Color.RED);
        JOptionPane.showMessageDialog(null,"Se Desactivo el Modo Rehidratacion","Modo Rehidratacion...",JOptionPane.INFORMATION_MESSAGE);
        hilo6.stop();
        break;
      }    
    }

    if (event.getSource() == menu)
    {
      Menu menus = new Menu(this.menu);
      hilo7 = new Thread(menus);
      hilo7.start();
    }
    if (event.getSource() == alarma)
    {
      Alarma alar = new Alarma(this.alarma);
      hilo19 = new Thread(alar);
      hilo19.start();
    }
  }
}