import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;
class Programar extends JFrame implements Runnable{
	
   JPanel panel2;
   JButton btn;
   JButton btn2;
   JButton btn3;
   JMenuItem item;
   JComboBox tiempo;
   public Programar(JMenuItem item){
        this.item = item;
        panel2 = new JPanel();
        panel2.setLayout(null);
        btn = new JButton("Guardar");
        btn.setBounds(80,150,100,30);
        btn2 = new JButton("");
        btn2.setBounds(190,150,100,30);
        btn3 = new JButton("Cancelar");
        btn3.setBounds(300,150, 100,30);



        /*Datos de la comboBox */
         int[] timer = new int[1440];

         for (int i =1 ;i <=1440; i++ ) {
        	
        	timer[i] = i;
        	
        }
        for (int i = 1;i<= 1440 ;i++ ) {
        	System.out.println(timer[i]);
        }

        String timerS[] = new String[timer.length]; 
        for (int x = 0; x <timer.length; x++ ) {
        	timerS[x] = String.valueOf(timer[x]);
        	System.out.println(Arrays.toString(timerS));
        	
        }
        tiempo = new JComboBox(timerS);
        tiempo.setBounds(250, 30, 100, 30);




        panel2.add(tiempo);
        panel2.add(btn);
        panel2.add(btn2);
        panel2.add(btn3);

        this.add(panel2);
        this.setSize(500,300);
        this.setResizable(false);
        this.setTitle("Programar...");
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
   }

   @Override
   public void run(){



   }
}