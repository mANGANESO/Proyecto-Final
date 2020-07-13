package reloj.recurso;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;

public class LectorV2 extends JFrame implements Runnable, ActionListener
{
	JPanel panel4;
	JButton btnBuscar;
	JButton btnCerrar;
	JButton btnLimpiar;
	JTextField txtCampoEscribe;
	JTextArea txaAreaInfo;
	public static String vacio = "";
	ArrayList <String> contenido1;
	public LectorV2()
	{
		panel4 = new JPanel();
    	panel4.setLayout(null);
    	panel4.setBackground(Color.GRAY);
    	panel4.setVisible(true);

    	btnBuscar = new JButton("Leer");
    	btnBuscar.setBounds(350,25,125,25);

    	btnCerrar = new JButton("Regresar");
    	btnCerrar.setBounds(350,0,125,25);

    	btnLimpiar = new JButton("Limpiar");
    	btnLimpiar.setBounds(350,50,125,25);

    	txtCampoEscribe = new JTextField();
		txtCampoEscribe.setBounds(25, 25, 300, 50); //(x, y, w, h)

		txaAreaInfo = new JTextArea();
		txaAreaInfo.setBounds(25, 100, 450, 150); //(x, y, w, h)
		txaAreaInfo.setText(vacio);
		txaAreaInfo.setEditable(false);

		panel4.add(txtCampoEscribe);
		panel4.add(txaAreaInfo);
		panel4.add(btnBuscar);
		panel4.add(btnCerrar);
		panel4.add(btnLimpiar);

    	this.add(panel4);
    	this.setSize(500,300);
    	this.setResizable(false);
    	this.setTitle("Lector...");
    	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);
    	contenido1 = new ArrayList<String>();
    	btnBuscar.addActionListener(this);
    	btnCerrar.addActionListener(this);
    	btnLimpiar.addActionListener(this);
	}

	@Override
  	public void run()
  	{
  	}

  	public void actionPerformed(ActionEvent event)
  	{
  		if (event.getSource() == btnBuscar)
  		{
  			try
			{
				String nombreA;
				nombreA = txtCampoEscribe.getText();
				contenido1 = Archi.leerTodo(nombreA);

				String cadena = "";
				for (int i=0; i<contenido1.size(); i++) 
				{
					cadena = cadena + contenido1.get(i) +"\n";
				}
				txaAreaInfo.setText(cadena);
			}
			catch(Exception e)
			{
				System.out.println("ERROR: Ingrese un Archivo primero.");
			}
  		}

  		if(event.getSource()==btnLimpiar)
  		{
  			//Limpa el txtArea
  			txaAreaInfo.setText(vacio);
  		}
  		if(event.getSource()==btnCerrar)
  		{
  			//Cierra la ventana
  			dispose();
  		}
  	}
}