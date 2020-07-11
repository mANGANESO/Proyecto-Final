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
  JPanel panel;
  JMenuBar menuBar;
  JMenu menu;
  JMenuItem item;

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
      menuBar = new JMenuBar();
      menu = new JMenu("Ajustes");
      item = new JMenuItem("Programar");
   
      menuBar.add(item);
      menuBar.add(menu); 
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
  }
}