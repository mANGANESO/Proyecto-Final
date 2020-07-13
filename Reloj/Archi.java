package reloj.recurso;
import java.io.*;
import java.util.*;

public class Archi
{
	
	public static ArrayList<String> leerTodo(String nombreArchivo)
    {
            String strLine = new String();
			ArrayList<String> arraylist = new ArrayList<String>();
			
            try(FileInputStream fis = new FileInputStream(nombreArchivo);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader( new InputStreamReader(in));)
			{
				strLine = br.readLine();
                while (strLine != null)
                {
                    //System.out.println(strLine)	;
					arraylist.add(strLine);
                    strLine = br.readLine();   
                }
                //in.close();
            }
            catch (Exception e ) //Agregar Excepciones
            {
                    e.printStackTrace();
                    System.exit(1);
            }
			//arraylist.remove(arraylist.size()-1); // remover el ultimo elemento, que es null
			return arraylist;
			
	}

    public static void guardarTodo(String informacion)
    {
    try
    {
        FileOutputStream fos = new FileOutputStream ("archivo_creado_1.txt");
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
        out.write(informacion);
        out.close(); 
    }
        catch (Exception e) //Agregar Excepciones
        { 
            e.printStackTrace();
            System.exit(1);
        }   
    }

    public static void guardarTodo(String informacion, String nombre)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream (nombre);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            out.write(informacion);
            out.close(); 
        }
        catch (Exception e) //Agregar Excepciones
        { 
            e.printStackTrace();
            System.exit(1);
        }   
    }
}