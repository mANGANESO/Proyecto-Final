import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;

class Menu extends JFrame implements Runnable, ActionListener
{
	JMenuItem menu;
	JPanel panel3;
  JButton btn7;
  JButton btn8;
  JButton btn9;
  JButton btnOk;
  Thread hilo11;
  Thread hilo12;
  Thread hilo13;

	public Menu(JMenuItem menu)
	{
		this.menu=menu;
		panel3 = new JPanel();
    panel3.setLayout(null);
    panel3.setBackground(Color.GRAY);
    panel3.setVisible(true);

    btn7 = new JButton("Lector");
    btn7.setBounds(100,50,100,50);
    btn8 = new JButton("Midi");
    btn8.setBounds(300,50,100,50);
    btn9 = new JButton("Notas");
    btn9.setBounds(100,150, 100,50);
    btnOk = new JButton("Regresar");
    btnOk.setBounds(300,150, 100,50);

    panel3.add(btn7);
    panel3.add(btn8);
    panel3.add(btn9);
    panel3.add(btnOk);

    this.add(panel3);
    this.setSize(500,300);
    this.setResizable(false);
    this.setTitle("Menu...");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    btn7.addActionListener(this);
    btn8.addActionListener(this);
    btn9.addActionListener(this);
    btnOk.addActionListener(this);
	}

	@Override
  public void run()
  {
  }

  public void actionPerformed(ActionEvent event)
  {
    //Lector
  	if (event.getSource() == btn7)
  	{
      LectorV2 lv = new LectorV2();
      hilo11 = new Thread(lv);
      hilo11.start();
  	}
    //Midi
  	if (event.getSource() == btn8)
  	{
      ReMi rm = new ReMi();
      hilo12 = new Thread(rm);
      hilo12.start();
  	}
    //Notas
  	if (event.getSource() == btn9)
  	{
      Notas nota = new Notas();
      hilo13 = new Thread(nota);
      hilo13.start();
  	}
    //Regresa al Reloj
  	if (event.getSource() == btnOk)
  	{
  		//Cierra la ventana
      dispose();
  	}
  }
}