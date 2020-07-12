import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;
class Agua extends JFrame implements Runnable, ActionListener
{
	JPanel panel3;
	JMenuItem awa;
	JLabel lblNota;
	JLabel lblNota1;
	JButton btn4;
  	JButton btn5;
  	JButton btn6;
  	Boolean sino=true;
	public Agua(JMenuItem awa)
	{
		this.awa = awa;
		panel3 = new JPanel();
    	panel3.setLayout(null);
    	panel3.setBackground(Color.BLACK);
    	panel3.setVisible(true);

    	btn4 = new JButton("Activar");
    	btn4.setBounds(80,175,100,30);
    	btn5 = new JButton("Desactivar");
    	btn5.setBounds(200,175,100,30);
    	btn6 = new JButton("Regresar");
    	btn6.setBounds(320,175, 100,30);

    	lblNota = new JLabel("Bien venido al modo rehidratacion.");
    	lblNota.setBounds(30,50,450,40);
    	lblNota.setForeground(Color.BLUE);
    	lblNota.setOpaque(true);
    	lblNota.setBackground(Color.BLACK);
    	lblNota.setFont(new Font("Calibri", 0, 30));

    	lblNota1 = new JLabel("Desea activar los recordatorios?");
    	lblNota1.setBounds(30,90,450,40);
    	lblNota1.setForeground(Color.BLUE);
    	lblNota1.setOpaque(true);
    	lblNota1.setBackground(Color.BLACK);
    	lblNota1.setFont(new Font("Calibri", 0, 30));

    	panel3.add(btn4);
    	panel3.add(btn5);
    	panel3.add(btn6);
    	panel3.add(lblNota);
    	panel3.add(lblNota1);

    	this.add(panel3);
    	this.setSize(500,300);
    	this.setResizable(false);
    	this.setTitle("Agua...");
    	this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);
    	btn4.addActionListener(this);
    	btn5.addActionListener(this);
    	btn6.addActionListener(this);
	}

	@Override
	public void run()
	{
		while(sino==true)
		{
			System.out.println("hola");
      		retardo(5000);
		}
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == btn4)
		{
			//Activa las notas cada hora para que el usuario no olvide tomar agua
			sino = true;
		}

		if(event.getSource() == btn5)
		{
			//Desactivar las notas cada hora para que el usuario no olvide tomar agua
			sino = false;
		}

		if(event.getSource() == btn6)
		{
			//Cierra la ventana pero el proceso interno sigue funcionando
      		dispose();
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