package reloj.recurso;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;

public class ReMi extends JFrame implements Runnable, ActionListener
{
	JPanel panel5;
	JButton btnBoton1;
	JButton btnBoton2;
	JButton btnBoton3;
	JButton btnBoton4;
	JButton btnBoton5;
	JButton btnBoton6;
	JButton btnBoton7;
	JButton btnBoton8;
	JButton btnBorrar;
	JButton btnReproducir;
	JButton btnDeRegreso;
	JTextField txtIngreseArchivos;
	JTextArea txaNotasTocadas;
	MidiRe mr = new MidiRe();
	ArrayList <String> contenido1;
	public static String vacio = "";
	public static String d0= "48",re="50",mi="52",fa="53",sol="55",la="57",si="59",d1="60";
	public static int d0N= 48,reN=50,miN=52,faN=53,solN=55,laN=57,siN=59,d1n=60;
	public static int canal=1;
	public static String coma = ", ";
	private JMenuBar menu;
	private JMenu instrumentos, opciones;
	private JMenuItem piano,guitarra,bateria,bajo,saxofon,trompeta,violin,chelo,color1,color2,color3,color4;

	public ReMi()
	{
		panel5 = new JPanel();
    	panel5.setLayout(null);
    	panel5.setBackground(Color.GRAY);
    	panel5.setVisible(true);

    	/* creación de objetos y valores iniciales */
        menu = new JMenuBar();
	    instrumentos = new JMenu("Escalas");
	    opciones = new JMenu("Opciones");
	    piano = new JMenuItem("Do Mayor");
	    guitarra = new JMenuItem("Re Mmayor");
	    bateria = new JMenuItem("Mi Mayor");
	    bajo = new JMenuItem("Fa Mayor");
	    saxofon = new JMenuItem("Sol Mayor");
	    trompeta = new JMenuItem("La Mayor");
	    violin = new JMenuItem("Si Mayor");
	    chelo = new JMenuItem("Personalizada");
	    color1 = new JMenuItem("Rojo");
	    color2 = new JMenuItem("Verde");
	    color3 = new JMenuItem("Azul");
        color4 = new JMenuItem("Clasico");

		btnBoton1 = new JButton("Do");
		btnBoton1.setBounds(10, 150, 60, 90); //(x, y, w, h)
		btnBoton2 = new JButton("Re");
		btnBoton2.setBounds(70, 150, 60, 90); //(x, y, w, h)
		btnBoton3 = new JButton("Mi");
		btnBoton3.setBounds(130, 150, 60, 90); //(x, y, w, h)
		btnBoton4 = new JButton("Fa");
		btnBoton4.setBounds(190, 150, 60, 90); //(x, y, w, h)
		btnBoton5 = new JButton("Sol");
		btnBoton5.setBounds(250, 150, 60, 90); //(x, y, w, h)
		btnBoton6 = new JButton("La");
		btnBoton6.setBounds(310, 150, 60, 90); //(x, y, w, h)
		btnBoton7 = new JButton("Si");
		btnBoton7.setBounds(370, 150, 60, 90); //(x, y, w, h)
		btnBoton8 = new JButton("Do#");
		btnBoton8.setBounds(430, 150, 60, 90); //(x, y, w, h)
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(340, 60, 120, 30); //(x, y, w, h)
		btnReproducir = new JButton("Reproducir");
		btnReproducir.setBounds(340, 10, 120, 30); //(x, y, w, h)
		btnDeRegreso = new JButton("Regresar");
		btnDeRegreso.setBounds(340, 100, 120, 30); //(x, y, w, h)
		txtIngreseArchivos = new JTextField();
		txtIngreseArchivos.setBounds(40, 10, 290, 40);
		txaNotasTocadas = new JTextArea();
		txaNotasTocadas.setBounds(40, 60, 290, 70);

		/* agregando objetos al panel */
		menu.add(instrumentos);
		menu.add(opciones);
		instrumentos.add(piano);
		instrumentos.add(new JSeparator());
		instrumentos.add(guitarra);
		instrumentos.add(new JSeparator());
		instrumentos.add(bateria);
		instrumentos.add(new JSeparator());
		instrumentos.add(bajo);
		instrumentos.add(new JSeparator());
		instrumentos.add(saxofon);
		instrumentos.add(new JSeparator());
		instrumentos.add(trompeta);
		instrumentos.add(new JSeparator());
		instrumentos.add(violin);
		instrumentos.add(new JSeparator());
		instrumentos.add(chelo);
		opciones.add(color1);
		opciones.add(new JSeparator());
		opciones.add(color2);
		opciones.add(new JSeparator());
		opciones.add(color3);
		opciones.add(new JSeparator());
		opciones.add(color4);
		panel5.add(btnBoton1);
		panel5.add(btnBoton2);
		panel5.add(btnBoton3);
		panel5.add(btnBoton4);
		panel5.add(btnBoton5);
		panel5.add(btnBoton6);
		panel5.add(btnBoton7);
		panel5.add(btnBoton8);
		panel5.add(btnBorrar);
		panel5.add(btnReproducir);
		panel5.add(txtIngreseArchivos);
		panel5.add(txaNotasTocadas);
		panel5.add(btnDeRegreso);
		setJMenuBar(menu);

    	this.add(panel5);
    	this.setSize(500,300);
    	this.setResizable(false);
    	this.setTitle("Midi...");
    	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);

    	btnBoton1.addActionListener(this);
		btnBoton2.addActionListener(this);
		btnBoton3.addActionListener(this);
		btnBoton4.addActionListener(this);
		btnBoton5.addActionListener(this);
		btnBoton6.addActionListener(this);
		btnBoton7.addActionListener(this);
		btnBoton8.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnReproducir.addActionListener(this);
		btnDeRegreso.addActionListener(this);
		color1.addActionListener(this);
		color2.addActionListener(this);
		color3.addActionListener(this);
		color4.addActionListener(this);
		piano.addActionListener(this);
		guitarra.addActionListener(this);
		bateria.addActionListener(this);
		bajo.addActionListener(this);
		saxofon.addActionListener(this);
		trompeta.addActionListener(this);
		violin.addActionListener(this);
		chelo.addActionListener(this);

		txaNotasTocadas.setText(vacio);
		contenido1 = new ArrayList<String>();
		txaNotasTocadas.setEditable(false);
	}

	@Override
  	public void run()
  	{
  	}

  	public void actionPerformed(ActionEvent event)
  	{
  		if(event.getSource() == this.btnBoton1)
		{
			mr.inicializar();
			mr.reproducirNota(d0N,canal,1000);
			mr.finalizar();
			vacio = vacio + d0 + coma;
			txaNotasTocadas.setText(vacio);
		}
		else if (event.getSource() == this.btnBoton2)
		{
			mr.inicializar();
			mr.reproducirNota(reN,canal,1000);
			mr.finalizar();
			vacio = vacio + re + coma;
			txaNotasTocadas.setText(vacio);
		}
		else if (event.getSource() == this.btnBoton3)
		{
			mr.inicializar();
			mr.reproducirNota(miN,canal,1000);
			mr.finalizar();
			vacio = vacio + mi + coma;			
			txaNotasTocadas.setText(vacio);
		}
		else if (event.getSource() == this.btnBoton4)
		{
			mr.inicializar();
			mr.reproducirNota(faN,canal,1000);
			mr.finalizar();
			vacio = vacio + fa + coma;
			txaNotasTocadas.setText(vacio);
		}
		else if (event.getSource() == this.btnBoton5)
		{
			mr.inicializar();
			mr.reproducirNota(solN,canal,1000);
			mr.finalizar();
			vacio = vacio + sol + coma;
			txaNotasTocadas.setText(vacio);
		}
		else if (event.getSource() == this.btnBoton6)
		{
			mr.inicializar();
			mr.reproducirNota(laN,canal,1000);
			mr.finalizar();
			vacio = vacio + la + coma;
			txaNotasTocadas.setText(vacio);
		}
		else if (event.getSource() == this.btnBoton7)
		{
			mr.inicializar();
			mr.reproducirNota(siN,canal,1000);
			mr.finalizar();
			vacio = vacio + si + coma;
			txaNotasTocadas.setText(vacio);
		}
		else if (event.getSource() == this.btnBoton8)
		{
			mr.inicializar();
			mr.reproducirNota(d1n,canal,1000);
			mr.finalizar();
			vacio = vacio + d1 + coma;
			txaNotasTocadas.setText(vacio);
		}
		else if (event.getSource() == this.btnReproducir)
		{
			mr.inicializar();
			mr.leerAcordes(contenido1,canal);
			mr.finalizar();
		}
		else if (event.getSource() == this.btnBorrar)
		{
			vacio="";
			txaNotasTocadas.setText(vacio);
			txtIngreseArchivos.setText(vacio);
			txaNotasTocadas.setEditable(false);
		}
		else if (event.getSource() == this.color1)
		{
			panel5.setBackground(new Color(255,0,0));
		}
		else if (event.getSource() == this.color2)
		{
			panel5.setBackground(new Color(0,255,0));
		}
		else if (event.getSource() == this.color3)
		{
			panel5.setBackground(new Color(0,0,255));
		}
		else if (event.getSource() == this.color4)
		{
			panel5.setBackground(new Color(255,255,255));
		}
		else if (event.getSource() == this.piano)
		{
			canal=1;
			d0N= 24; reN=26; miN=28; faN=29; solN=31; laN=33; siN=35; d1n=36;
			d0= "24"; re="26"; mi="28"; fa="29"; sol="31"; la="33"; si="35"; d1="36";
		}
		else if (event.getSource() == this.guitarra)
		{
			canal=1;
			d0N= 38; reN=40; miN=42; faN=43; solN=45; laN=47; siN=49; d1n=50;
			d0= "38"; re="40"; mi="42"; fa="43"; sol="45"; la="47"; si="49"; d1="50";
		}
		else if (event.getSource() == this.bateria)
		{
			canal=1;
			d0N= 52; reN=54; miN=56; faN=57; solN=59; laN=61; siN=63; d1n=64;
			d0= "52"; re="54"; mi="56"; fa="57"; sol="59"; la="61"; si="63"; d1="64";
		}
		else if (event.getSource() == this.bajo)
		{
			canal=1;
			d0N= 66; reN=68; miN=70; faN=71; solN=73; laN=75; siN=77; d1n=78;
			d0= "66"; re="68"; mi="70"; fa="71"; sol="73"; la="75"; si="77"; d1="78";
		}
		else if (event.getSource() == this.saxofon)
		{
			canal=1;
			d0N= 79; reN=81; miN=83; faN=84; solN=86; laN=88; siN=90; d1n=91;
			d0= "79"; re="81"; mi="83"; fa="84"; sol="86"; la="88"; si="90"; d1="91";
		}
		else if (event.getSource() == this.trompeta)
		{
			canal=1;
			d0N= 93; reN=95; miN=97; faN=98; solN=100; laN=102; siN=104; d1n=105;
			d0= "93"; re="95"; mi="97"; fa="98"; sol="100"; la="102"; si="104"; d1="105";
		}
		else if (event.getSource() == this.violin)
		{
			canal=1;
			d0N= 23; reN=25; miN=27; faN=28; solN=30; laN=32; siN=34; d1n=35;
			d0= "23"; re="25"; mi="27"; fa="28"; sol="30"; la="32"; si="34"; d1="35";
		}
		else if (event.getSource() == this.chelo)
		{
			d0= "48"; re="50"; mi="52"; fa="53"; sol="55"; la="57"; si="59"; d1="60";
			d0N= 48; reN=50; miN=52; faN=53; solN=55; laN=57; siN=59; d1n=60;
		}
		else if (event.getSource() == this.btnDeRegreso)
		{
			//Cierra la ventana
      		dispose();
		}
  	}
}