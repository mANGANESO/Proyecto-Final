import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
 
class Tempo implements Runnable
{
  JMenuItem alarma;
  String hora,minuto,segundo,am_pm;
  Calendar Calendario;
  String time1, time2, time3;
  Thread hilo3;
  Boolean cierto = true;
  MidiRe mr = new MidiRe();
  ArrayList <String> contenido1;
  public Tempo(JMenuItem alarma)
  {
    this.alarma = alarma;
    hilo3 = new Thread(this);
    hilo3.start();
  }
  @Override
  public void run()
  {
   	while(cierto)
   	{
      hora();
      if (hora.equals(time1))
      {
        if(am_pm.equals(time3))
        {
          if(minuto.equals(time2))
          {
            mr.inicializar();
            mr.reproducirNota(24,1,500);      
            mr.reproducirNota(26,1,500);
            mr.reproducirNota(28,1,500);
            mr.reproducirNota(29,1,500);
            mr.reproducirNota(31,1,500);
            mr.reproducirNota(33,1,500);
            mr.reproducirNota(35,1,500);
            mr.reproducirNota(36,1,500);
            mr.reproducirNota(35,1,500);     
            mr.reproducirNota(33,1,500);
            mr.reproducirNota(31,1,500);
            mr.reproducirNota(29,1,500);
            mr.reproducirNota(28,1,500);
            mr.reproducirNota(26,1,500);
            mr.reproducirNota(24,1,500); 
            mr.finalizar();
            JOptionPane.showMessageDialog(null,"YA ES LA"+hora+":"+ minuto + " " + am_pm,"Ya es hora...",JOptionPane.INFORMATION_MESSAGE);
            cierto=false;
            alarma.setBackground(Color.RED);
          }
        }
      }
      System.out.println("hola");
      retardo(3000);	   
    }
  }

  public void compara(String hor, String min, String ampm)
  {
    hor = hor;
    min = min;
    ampm = ampm;

    time1 = hor;
    time2 = min;
    time3 = ampm;
    System.out.println(time1+time2+time3);
  }

  public void hora()
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

  public void retardo(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(Exception e)
		{
			System.out.println("Error: al ejecuar el sleep.");
		}
	}
}