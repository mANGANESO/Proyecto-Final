package fc.resouy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
 
class Temporizador implements Runnable
{
  String hora,minuto,segundo,am_pm;
  Calendar Calendario;
  String time1, time2, time3;
  Thread hilo3;
  public Temporizador(boolean carga)
  {
    carga = carga;
    hilo3 = new Thread(this);
    hilo3.start();
  }
   @Override
  public void run()
  {
    boolean m = true;
   	while(m == true)
   	{  
       hora();
       if (hora.equals(time1) && minuto.equals(time2)) 
       {
        try
        {
          JOptionPane.showMessageDialog(null, "EL EQUIPO SE APAGARA EN: 2MIN.", "AVISO", JOptionPane.WARNING_MESSAGE);
          retardo(120000); 
          Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
          m=false;

        }catch(Exception e){
          JOptionPane.showMessageDialog(null, "ErrorMsg", "Failure", JOptionPane.ERROR_MESSAGE);
        }
       }
       retardo(1000); 
    }

  }

  public void compara(String ho, String mi, String ap)
  {
    ho = ho;
    mi = mi;
    ap = ap;

    time1 = ho;
    time2 = mi;
    time3 = ap;
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