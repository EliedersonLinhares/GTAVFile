

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.io.FileUtils;

public class x64a {
	public x64a(JButton button, JLabel lblcami, JLabel lblsize, JLabel lblmd5) {
	
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

