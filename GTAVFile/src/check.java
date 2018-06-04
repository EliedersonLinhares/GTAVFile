


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.io.FileUtils;

public class check extends JFrame{

	private static final long serialVersionUID = 1L;



	public static void main(String args[]) throws NoSuchAlgorithmException, IOException{
	    Runnable runner = new Runnable() {
	      public void run() {
	        JFrame frame = new JFrame("Button Sample");
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
	        
	       // JFileChooser fileChooser = new JFileChooser();
	        
	        JButton button = new JButton("Abrir...");
	       
	        JLabel lblNomearquivo = new JLabel();
	        JLabel lblarquivo = new JLabel();
	        JLabel lblcami = new JLabel();
	        JLabel lblsize = new JLabel();
	        JLabel lblmd5 = new JLabel();
	        
	        
	        //Seta a organização da tela
	        lblNomearquivo.setBounds(10,40,160,40);
	        lblNomearquivo.setFont(new Font("Arial", Font.PLAIN, 15));
	        lblNomearquivo.setText("Nome do Arquivo");
	        
	        
	        
	        lblarquivo.setBounds(20,80,160,40);
	        lblarquivo.setFont(new Font("Arial", Font.BOLD, 15));
	        lblarquivo.setText("x64a.rpf");
	        
	        lblcami.setBounds(140,80,160,40);
	        lblcami.setFont(new Font("Arial", Font.BOLD, 15));
	        lblcami.setText("caminho");
	        
	        
	        button.setBounds(260,80,160,40);
	        button.setSize(80, 40);
	        
	        lblsize.setBounds(380,80,160,40);
	        lblsize.setFont(new Font("Arial", Font.BOLD, 15));
	        lblsize.setText("tamanho");
	        
	        lblmd5.setBounds(500,80,160,40);
	        lblmd5.setFont(new Font("Arial", Font.BOLD, 15));
	        lblmd5.setText("md5");
	        
	        // Define ActionListener
	        x64a(button, lblcami, lblsize, lblmd5);
	        
	        //x64a X64a = new   x64a(button, lblcami, lblsize, lblmd5);
	        
	      
	   
	        //adiciona todos as labels e outros ao Jframe
	        frame.setLayout(null);
	       // button.addActionListener((ActionListener) X64a);
	        frame.add(lblNomearquivo);
	        frame.add(lblarquivo);
	        frame.add(lblcami);
	        frame.add(lblsize);
	        frame.add(lblmd5);
	        frame.add(button);


	        
	        
	        frame.setSize(900, 600);
	        frame.setVisible(true);
	      }

		
	    };
	    EventQueue.invokeLater(runner);
	}
	private static void x64a(JButton button, JLabel lblcami, JLabel lblsize, JLabel lblmd5) {
		//Classe contendo ação de abrir o arquivo referente ao botão selecionado
		
		button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              
           //Introdução do Filtro para que só seja mostrado o arquivo especifico na tela
              JFileChooser fileChooser = new JFileChooser();
              fileChooser.setAcceptAllFileFilterUsed(false);
              fileChooser.addChoosableFileFilter(new FileFilter() {
              
            	    public String getDescription() {
            	        return "Arquivo x64a.rpf";
            	    }
            	 
            	    public boolean accept(File f) {
            	        if (f.isDirectory()) {
            	            return true;
            	        } else {
            	            return f.getName().toLowerCase().endsWith("x64a.rpf");
            	        }
            	    }
            	});
              
              
          
        
              int returnValue = fileChooser.showOpenDialog(null);
            
              //pega os valores do arquivo
              if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                //System.out.println(selectedFile.getAbsolutePath());
                lblcami.setText(selectedFile.getAbsolutePath());
                File file = new File(selectedFile.getAbsolutePath()); 
               //System.out.println("File name: " + file.getName());
       		    long fileSize = file.length();
       		    //System.out.println("File size: " + fileSize);
       		    String fileSizeDisplay = FileUtils.byteCountToDisplaySize(fileSize);
       		    //System.out.println("Size Display: " + fileSizeDisplay);
       		    //System.out.println();
                 lblsize.setText(fileSizeDisplay);
              
            //verificação do algoritimo de md5 do Arquivo
      		MessageDigest md5Digest = null;
			try {
				md5Digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      		 
      		//Get the checksum
      		String checksum = null;
			try {
				checksum = getFileChecksum(md5Digest, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      		 
			lblmd5.setText(checksum);
              
              }
            }
          });
		
	}
   
 

private static String getFileChecksum(MessageDigest digest, File file) throws IOException
{
    //Pega o codigo de entrada para ler o conteudo do arquivo
    FileInputStream fis = new FileInputStream(file);
     
    //Cria um array de bytes para ler os dados
    byte[] byteArray = new byte[1024];
    int bytesCount = 0; 
      
    //Lê o arquivo e atualiza o gerador de menssagens
    while ((bytesCount = fis.read(byteArray)) != -1) {
        digest.update(byteArray, 0, bytesCount);
    };
     
    //fecha o leitor
    fis.close();
     
    //Pega o hash
    byte[] bytes = digest.digest();
     
    //O arquivo esat no formato decimal;
    //Aqui ele será convertido para o formato hexadecimal
    StringBuilder sb = new StringBuilder();
    for(int i=0; i< bytes.length ;i++)
    {
        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    }
     
    //returna o hash completo
   return sb.toString();
}	
}


	    
	    
	    
