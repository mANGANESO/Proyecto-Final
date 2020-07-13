import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;

class Notas extends JFrame implements Runnable, ActionListener
{
	JPanel panel8;
	JButton btnGuardar;
	JButton btnBorra;
	JButton btnRe;
	JTextField txtNombre;
	JTextArea txaInfo;
	ArrayList <String> contenido1;
	public static String vacio = "";

	public Notas()
	{
		panel8 = new JPanel();
    	panel8.setLayout(null);
    	panel8.setBackground(Color.GRAY);
    	panel8.setVisible(true);

    	txtNombre = new JTextField();
		txtNombre.setBounds(40, 20, 300, 40);

		txaInfo = new JTextArea();
		txaInfo.setBounds(40, 100, 300, 150);

		btnBorra = new JButton("Limpiar");
    	btnBorra.setBounds(360,100,100,40);
    	btnGuardar = new JButton("Guardar");
    	btnGuardar.setBounds(360,20,100,40);
    	btnRe = new JButton("Regresar");
    	btnRe.setBounds(360,170,100,40);

		panel8.add(btnBorra);
		panel8.add(btnGuardar);
		panel8.add(btnRe);
		panel8.add(txtNombre);
		panel8.add(txaInfo);

    	this.add(panel8);
    	this.setSize(500,300);
    	this.setResizable(false);
    	this.setTitle("Notas...");
    	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);

    	txaInfo.setText(vacio);
		contenido1 = new ArrayList<String>();
		txaInfo.setEditable(true);

		btnRe.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnBorra.addActionListener(this);
	}

	@Override
  	public void run()
  	{}

  	public void actionPerformed(ActionEvent event)
  	{
  		if (event.getSource() == this.btnBorra)
		{
			vacio="";
			txaInfo.setText(vacio);
			txtNombre.setText(vacio);
		}

		else if (event.getSource() == this.btnGuardar)
		{
			try
			{
				String informacion;
				informacion = txaInfo.getText();
				String nombre;
				nombre = txtNombre.getText();
				Archi.guardarTodo(informacion, nombre);
				txtNombre.setText("");
				vacio="";
				txaInfo.setText(vacio);
			}
			catch(Exception e)
			{
				System.out.println("ERROR: Ingrese un Archivo primero.");
			}
		}
		if (event.getSource() == btnRe)
  		{
  			//Cierra la ventana
      		dispose();
  		}
  	}
}