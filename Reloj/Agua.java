import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;
class Agua implements Runnable
{

	public Agua()
	{
	}

	@Override
	public void run()
	{
		while(true)
		{
			retardo(5000);
			JOptionPane.showMessageDialog(null,"Ya es hora de tomar agua, han pasado ya 40 minutos desde la ultima vez.","A tomar Agua...",JOptionPane.INFORMATION_MESSAGE);
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
			System.out.println("Error: al ejecuar el sleep.");
		}
	}
}