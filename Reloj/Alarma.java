import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;

class Alarma extends JFrame implements Runnable, ActionListener
{
	JLabel lblAlar;
  JPanel panel11;
  JButton btn15;
  JButton btn16;
  JButton btn17;
  JMenuItem alarma;
  JComboBox opHora;
  JComboBox opMinuto;
  JComboBox opAP;
  String hor = "00";
  String min = "00";
  String ampm = "Am";
  int hs;
  int ms;
	public Alarma(JMenuItem alarma)
	{
		this.alarma = alarma;

<<<<<<< HEAD
    panel11 = new JPanel();
    panel11.setLayout(null);
    panel11.setBackground(Color.BLACK);
    panel11.setVisible(true);
    lblAlar = new JLabel("  " + hor + ":" + min +" " + ampm);
    lblAlar.setBounds(120,100,300,50);
    lblAlar.setForeground(Color.GREEN);
    lblAlar.setOpaque(true);
    lblAlar.setBackground(Color.BLACK);
    lblAlar.setFont(new Font("Calibri", 0, 50));
    btn15 = new JButton("Guardar");
    btn15.setBounds(80,200,100,30);
    btn16 = new JButton("Cancelar");
    btn16.setBounds(200,200,100,30);
    btn17 = new JButton("Regresar");
    btn17.setBounds(320,200, 100,30);

    /*Datos de la comboBox de las Horas*/
    int[] horas = new int[25];

    for (int i =1 ;i <=24; i++ ) 
    {	
      horas[i] = i;	
    }

    String timerS[] = new String[horas.length]; 
    for (int x = 1; x <horas.length; x++ ) 
    {
      timerS[x] = String.valueOf(horas[x]);       	
    }
    opHora = new JComboBox(timerS);
    opHora.setBounds(80, 20, 100, 30);
    opHora.removeItemAt(0);

    /*Datos de la comboBox de los Minutos*/
    int[] minutos = new int[60];
    for (int i =1 ;i <=59; i++ ) 
    { 
      minutos[i] = i; 
    }

    String timerM[] = new String[minutos.length]; 
    for (int y = 0; y <minutos.length; y++ ) 
    {
      timerM[y] = String.valueOf(minutos[y]);          
    }
    opMinuto = new JComboBox(timerM);
    opMinuto.setBounds(200, 20, 100, 30);

    /*Datos de la comboBox Am/Pm*/
    String[] ampm = new String[2];
    ampm[0]=("AM");
    ampm[1]=("PM");
    opAP = new JComboBox(ampm);
    opAP.setBounds(320, 20, 100, 30);
=======
    	panel11 = new JPanel();
    	panel11.setLayout(null);
    	panel11.setBackground(Color.BLACK);
    	panel11.setVisible(true);
    	lblAlar = new JLabel("  " + hor + ":" + min +" " + ampm);
    	lblAlar.setBounds(120,100,300,50);
    	lblAlar.setForeground(Color.GREEN);
    	lblAlar.setOpaque(true);
    	lblAlar.setBackground(Color.BLACK);
    	lblAlar.setFont(new Font("Calibri", 0, 50));
    	btn15 = new JButton("Guardar");
    	btn15.setBounds(80,200,100,30);
      btn15.setBackground(Color.GREEN);
    	btn16 = new JButton("Cancelar");
    	btn16.setBounds(200,200,100,30);
      btn15.setBackground(Color.ORANGE);
    	btn17 = new JButton("Regresar");
    	btn17.setBounds(320,200, 100,30);
      btn15.setBackground(Color.RED);

    	/*Datos de la comboBox de las Horas*/
    	int[] horas = new int[25];

    	for (int i =1 ;i <=24; i++ ) 
    	{	
      		horas[i] = i;	
    	}

    	String timerS[] = new String[horas.length]; 
    	for (int x = 1; x <horas.length; x++ ) 
    	{
      		timerS[x] = String.valueOf(horas[x]);       	
    	}
    	opHora = new JComboBox(timerS);
    	opHora.setBounds(80, 20, 100, 30);
    	opHora.removeItemAt(0);

    	/*Datos de la comboBox de los Minutos*/
    	int[] minutos = new int[60];
    	for (int i =1 ;i <=59; i++ ) 
    	{ 
      		minutos[i] = i; 
    	}

    	String timerM[] = new String[minutos.length]; 
    	for (int y = 0; y <minutos.length; y++ ) 
    	{
      		timerM[y] = String.valueOf(minutos[y]);          
    	}
    	opMinuto = new JComboBox(timerM);
    	opMinuto.setBounds(200, 20, 100, 30);

    	/*Datos de la comboBox Am/Pm*/
    	String[] ampm = new String[2];
    	ampm[0]=("Am");
    	ampm[1]=("Pm");
    	opAP = new JComboBox(ampm);
    	opAP.setBounds(320, 20, 100, 30);
>>>>>>> origin/master
    
    panel11.add(opHora);
    panel11.add(opMinuto);
    panel11.add(opAP);
    panel11.add(btn15);
    panel11.add(btn16);
    panel11.add(btn17);
    panel11.add(lblAlar);

    this.add(panel11);
    this.setSize(500,300);
    this.setResizable(false);
    this.setTitle("Alarma...");
    this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    opHora.addActionListener(this);
    opMinuto.addActionListener(this);
    opAP.addActionListener(this);
    btn15.addActionListener(this);
    btn16.addActionListener(this);
    btn17.addActionListener(this);
	}

	@Override
  public void run()
  {}

  public void actionPerformed(ActionEvent event)
  {
  	//Boton de Guardar la Alarma
  	if (event.getSource() == btn15)
  	{
      boolean carga = true;
      String hor = (String)opHora.getSelectedItem();
      String min = (String)opMinuto.getSelectedItem();
      String ampm = (String)opAP.getSelectedItem();
      Tempo time = new Tempo(alarma);
      time.compara(hor,min,ampm);
      JOptionPane.showMessageDialog(null, "Guardado exitosamente");
  		alarma.setBackground(Color.GREEN);
      dispose();
  	}

  	//Boton Cancelar
    if (event.getSource() == btn16)
    {
      alarma.setBackground(Color.RED);
      hor = "00";
      min = "00";
      ampm ="Am";
      lblAlar.setText("  " + hor + ":" + min +" " + ampm);
    }

    //Boton Regresar
    if (event.getSource() == btn17)
    {
      //Cierra la ventana pero el proceso interno sigue funcionando
      dispose();
    }

    if(event.getSource()==opHora)
    {
      String hor = (String)opHora.getSelectedItem();
      String min = (String)opMinuto.getSelectedItem();
		  String ampm = (String)opAP.getSelectedItem();
		  int hs = Integer.parseInt(hor);
		  int ms = Integer.parseInt(min);
		  if(hs<10)
		  {
		    if(ms<10)
		    {
		      lblAlar.setText("0" + hor + ":" + "0" + min +" " + ampm);
		    }

		    if(ms>9)
		    {
		      lblAlar.setText("0" + hor + ":" + min +" " + ampm);
		    }
		  }
		  if(hs>9)
		  {
		    if(ms<10)
		    {
		      lblAlar.setText(" " + hor + ":" + "0" + min +" " + ampm);
		    }

		    if(ms>9)
		    {
		      lblAlar.setText(" " + hor + ":" + min +" " + ampm);
		    }
		  }   
    }

    if(event.getSource()==opMinuto)
    {
	   String hor = (String)opHora.getSelectedItem();
	   String min = (String)opMinuto.getSelectedItem();
	   String ampm = (String)opAP.getSelectedItem();
	   int hs = Integer.parseInt(hor);
	   int ms = Integer.parseInt(min);
	   if(hs<10)
	   {
	     if(ms<10)
	     {
	       lblAlar.setText("0" + hor + ":" + "0" + min +" " + ampm);
	     }

	     if(ms>9)
	     {
	       lblAlar.setText("0" + hor + ":" + min +" " + ampm);
	     }
	   }

	   if(hs>9)
	   {
	     if(ms<10)
	     {
	       lblAlar.setText(" " + hor + ":" + "0" + min +" " + ampm);
	     }
	     if(ms>9)
	     {
	       lblAlar.setText(" " + hor + ":" + min +" " + ampm);
	     }
	   } 
    }

    if(event.getSource()==opAP)
    {
	   String hor = (String)opHora.getSelectedItem();
	   String min = (String)opMinuto.getSelectedItem();
	   String ampm = (String)opAP.getSelectedItem();
	   int hs = Integer.parseInt(hor);
	   int ms = Integer.parseInt(min);
	   if(hs<10)
	   {
	     if(ms<10)
	     {
	       lblAlar.setText("0" + hor + ":" + "0" + min +" " + ampm);
	     }

	     if(ms>9)
	     {
	       lblAlar.setText("0" + hor + ":" + min +" " + ampm);
	     }
	   }

	   if(hs>9)
	   {
	     if(ms<10)
	     {
	       lblAlar.setText(" " + hor + ":" + "0" + min +" " + ampm);
	     }

	     if(ms>9)
	     {
	       lblAlar.setText(" " + hor + ":" + min +" " + ampm);
	     }
	   } 
	  }
  }
}