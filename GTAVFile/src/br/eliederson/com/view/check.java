package br.eliederson.com.view;


import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.eliederson.com.control.x64a;
import br.eliederson.com.control.x64b;

public class check extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) throws NoSuchAlgorithmException, IOException{
	    
		Runnable runner = new Runnable() {
	      public void run() {
	        JFrame frame = new JFrame("Verificador de arquivos do GTAV");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        //Defini um thema para o swing
	        try {
	            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	          } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	          } catch (InstantiationException e) {
	            e.printStackTrace();
	          } catch (IllegalAccessException e) {
	            e.printStackTrace();
	          } catch (UnsupportedLookAndFeelException e) {
	            e.printStackTrace();
	          }

	          SwingUtilities.updateComponentTreeUI(frame);
	        //Lista os temas instalados
	          //UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
	          //for (UIManager.LookAndFeelInfo look : looks) {
	            //System.out.println(look.getClassName());
	          //}
	        ///
	        
	          //Imagens a serem usadas
	          ImageIcon IconNO = new ImageIcon("src/no2.png");
	          ImageIcon IconOK = new ImageIcon("src/ok2.png");
	          
	          JLabel ico1x64a = new JLabel();
	          JLabel ico2x64a = new JLabel();
	          JLabel ico1x64b = new JLabel();
	          JLabel ico2x64b = new JLabel();
	   
	        
	        JButton btnx64a = new JButton("Abrir x64a.rpf...");
	        JButton btnx64b = new JButton("Abrir x64b.rpf...");
	       
	        JLabel lblNomearquivo = new JLabel();
	        JLabel lblNomesize = new JLabel();
	        JLabel lblNomemd5 = new JLabel();
	       
	        JLabel lblx64a = new JLabel();
	       	JLabel lblx64asize = new JLabel();
	        JLabel lblx64amd5 = new JLabel();
	        
	        JLabel lblx64b = new JLabel();
	       	JLabel lblx64bsize = new JLabel();
	        JLabel lblx64bmd5 = new JLabel();
	        
	        
	        
	        JSeparator sep1 = new JSeparator();
	        
	        x64a X64a = new x64a(btnx64a, lblx64asize, lblx64amd5, ico1x64a, ico2x64a, IconNO, IconOK );
	        x64b X64b = new x64b(btnx64b, lblx64bsize, lblx64bmd5, ico1x64b, ico2x64b, IconNO, IconOK );
	        
	        //Seta a organização da tela
	       
	        sep1.setBounds(110,75,620,40);
	        
	        ico1x64a.setBounds(470,80,160,40);
	        ico2x64a.setBounds(810,80,160,40);
	        ico1x64b.setBounds(470,140,160,40);
	        ico2x64b.setBounds(810,140,160,40);
	        
	        
	        lblNomearquivo.setBounds(120,40,160,40);
	        lblNomearquivo.setFont(new Font("Arial", Font.PLAIN, 15));
	        lblNomearquivo.setText("Nome do Arquivo");
	        
	        lblNomesize.setBounds(380,40,160,40);
	        lblNomesize.setFont(new Font("Arial", Font.PLAIN, 15));
	        lblNomesize.setText("Tamanho do Arquivo");
	        
	        lblNomemd5.setBounds(620,40,160,40);
	        lblNomemd5.setFont(new Font("Arial", Font.PLAIN, 15));
	        lblNomemd5.setText("MD5 do Arquivo");
	        
	        //x64a
	        lblx64a.setBounds(120,80,160,40);
	        lblx64a.setFont(new Font("Arial", Font.BOLD, 15));
	        lblx64a.setText("x64a.rpf");
        
	        btnx64a.setBounds(250,80,160,40);
	        btnx64a.setSize(80, 40);
	        
	        lblx64asize.setBounds(410,80,160,40);
	        lblx64asize.setFont(new Font("Arial", Font.BOLD, 15));

	        lblx64amd5.setBounds(540,80,160,40);
	        lblx64amd5.setFont(new Font("Arial", Font.BOLD, 15));
	        lblx64amd5.setSize(300, 40);
	      
	        //x64b
	        lblx64b.setBounds(120,140,160,40);
	        lblx64b.setFont(new Font("Arial", Font.BOLD, 15));
	        lblx64b.setText("x64b.rpf");
        
	        btnx64b.setBounds(250,140,160,40);
	        btnx64b.setSize(80, 40);
	        
	        lblx64bsize.setBounds(410,140,160,40);
	        lblx64bsize.setFont(new Font("Arial", Font.BOLD, 15));

	        lblx64bmd5.setBounds(540,140,160,40);
	        lblx64bmd5.setFont(new Font("Arial", Font.BOLD, 15));
	        lblx64bmd5.setSize(300, 40);
	        
	        
	        
	        
	        //adiciona todos as labels e outros ao Jframe
	        frame.setLayout(null);
	     
	        frame.add(lblNomearquivo);
	        frame.add(lblNomesize);
	        frame.add(lblNomemd5);
	       
	        frame.add(lblx64a);
	        frame.add(lblx64asize);
	        frame.add(lblx64amd5);
	       
	        frame.add(lblx64b);
	        frame.add(lblx64bsize);
	        frame.add(lblx64bmd5);
	        
	        frame.add(btnx64a);
	        frame.add(btnx64b);
	        
	        frame.add(sep1);

	        frame.add(ico1x64a);
	        frame.add(ico2x64a);
	        frame.add(ico1x64b);
	        frame.add(ico2x64b);
	        
	        frame.setSize(900, 600);
	        frame.setVisible(true);
	      }

		
	    };
	    EventQueue.invokeLater(runner);
	}
	
}


	    
	    
	    
