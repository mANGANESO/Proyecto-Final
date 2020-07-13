import javax.sound.midi.*;
import java.util.*;
import javax.swing.*;
import java.io.PrintWriter;
import java.io.*;

class MidiRe
{
	public static ArrayList<String> contenido = new ArrayList<String>();
	private Synthesizer synthe = null;
	private int intensity = 200;
	private MidiChannel [] channels;
	private MidiChannel channel;

	public MidiRe()
	{
		try
		{
			synthe = MidiSystem.getSynthesizer();
		}
		catch(Exception e)
		{
			System.out.println("Error: al obtener synthe.");
		}
	}

	public void inicializar()
	{
		try
		{
			synthe.open();
			channels = synthe.getChannels();
		}

		catch(Exception e)
		{
			System.out.println("Error: al inizializar el synthe.");
		}
	}


	public void reproducirNota(int nota, int canal, int duracion)
	{
		channel = channels[canal];
		channel.noteOn(nota, intensity);

		try
		{
			Thread.sleep(duracion);
		}
		
		catch(Exception e)
		{
			System.out.println("ERROR: en sleep.");
		}

		channel.noteOff(nota);
	}

	public void finalizar()
	{
		try
		{
			synthe.close();

		}

		catch(Exception e)
		{
			System.out.println("Error: al finalizar el synthe.");
		}
	}

	public void loop(int nota, int canal, int duracion, int loo)
	{
		System.out.println("EJECUTANDO LOOP!!!");
		try 
		{
			for (int i=0; i<loo; i++) 
		    {
		    	channel = channels[canal];
		        channel.noteOn(nota, intensity);

		        try
		        {
			        Thread.sleep(duracion);
		        }
		
		        catch(Exception e)
		        {
			        System.out.println("ERROR: en sleep.");
		        }

		        channel.noteOff(nota);
		    }
		}
		
		catch(Exception e)
		{
			System.out.println("Error: al ejecutar el loop");
			e.printStackTrace();
		}
	}

	public void notaPersonalizada()
	{
		int nt=0;
		int cl=0;
		int id=0;
		int dn=0;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el numero de la nota que desea tocar");
		nt=teclado.nextInt();
		System.out.println("Ingrese el numero del que canal que desea usar");
		cl=teclado.nextInt();
		System.out.println("Ingrese el numero de intensidad con el que desea tocar");
		id=teclado.nextInt();
		System.out.println("Ingrese el numero de la duracion de la nota que desea tocar");
		dn=teclado.nextInt();

		channel = channels[cl];
		channel.noteOn(nt, id);

	    try
		{
		    Thread.sleep(dn);
		}
		
		catch(Exception e)
		{
			System.out.println("ERROR: en sleep.");
        }

		channel.noteOff(nt);
	}

	public void reproducirAcorde(int nota, int nota1, int nota2, int canal, int duracion)
	{
		
		channel = channels[canal];
		channel.noteOn(nota, intensity);
		channel.noteOn(nota1, intensity);
		channel.noteOn(nota2, intensity);

		try
		{
			Thread.sleep(duracion);
		}
		
		catch(Exception e)
		{
			System.out.println("ERROR: en sleep.");
		}

		channel.noteOff(nota);
		channel.noteOff(nota1);
		channel.noteOff(nota2);
	}

	public void leerAcordes(ArrayList<String> contenido,int canal)
	{
		for( String i : contenido)
		{
			String nota = i.substring(0, 2);
			String nota1 = i.substring(3, 5);
			String nota2 = i.substring(6, 8);
			String duracion = i.substring(9, 12);

			int notaInt = Integer.parseInt(nota);
			int notaInt1 = Integer.parseInt(nota1);
			int notaInt2 = Integer.parseInt(nota2);
			int duracionInt = Integer.parseInt(duracion);

			System.out.println("Nota 1: "+nota+" Nota 2: "+nota1+" Nota 3: "+nota2+" Duracion: "+duracion);
			
			channel = channels[canal];
		    channel.noteOn(notaInt, intensity);
		    channel.noteOn(notaInt1, intensity);
		    channel.noteOn(notaInt2, intensity);

			try
			{
				Thread.sleep(duracionInt);
			}
			catch(Exception e)
			{
				System.out.println("ERROR: en sleep.");
			}

			channel.noteOff(notaInt);
			channel.noteOff(notaInt1);
			channel.noteOff(notaInt2);
		}
	}


	public void reproducirAcordeN(ArrayList<Integer> notas,int nNotas, int canal, int duracion)
	{
		
		channel = channels[canal];
		for (int i=0; i<nNotas; i++)
		{
			channel.noteOn(notas.get(i),intensity);
			try
		    {
				Thread.sleep(duracion);
			}
		
			catch(Exception e)
			{
				System.out.println("ERROR: en sleep.");
			}
		}

		for (int f=0; f<nNotas; f++)
		{
			channel.noteOff(notas.get(f),intensity);
		}
	}

	public static ArrayList<String> leerPartitura(String nombreArchivo)
	{
		
		String cadena = new String();
		try
		(  FileInputStream fil = new FileInputStream(nombreArchivo);
	       DataInputStream in = new DataInputStream(fil);
	       BufferedReader bff = new BufferedReader(new InputStreamReader(in));
	    )

	    {
	    	cadena = bff.readLine();
	        while(cadena != null)
	        {
	        	contenido.add(cadena);
	        	cadena = bff.readLine();
	        }
        }
        
        catch(Exception e)
        {
    	  e.printStackTrace();
        }

        return contenido;
    }

}