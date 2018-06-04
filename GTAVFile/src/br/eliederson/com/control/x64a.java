package br.eliederson.com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.io.FileUtils;

public class x64a {
	public x64a(JButton btnx64a, JLabel lblx64asize, JLabel lblx64amd5, JLabel ico1x64a,JLabel ico2x64a,ImageIcon IconNO, ImageIcon IconOK) {


		//parametros com os quais os dados dos arquivos serão comparados
		long size = 48699392;// tamanho do arquivo
		String md5  = "683610e269ba60c5fcc7a9f6d1a8bfd5";// hash md5

		//Classe contendo ação de abrir o arquivo referente ao botão selecionado

		btnx64a.addActionListener(new ActionListener() {



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
					System.out.println(selectedFile.getAbsolutePath());
					
					File file = new File(selectedFile.getAbsolutePath()); 
					System.out.println("File name: " + file.getName());
					long fileSize = file.length();
					System.out.println("File size: " + fileSize);
					String fileSizeDisplay = FileUtils.byteCountToDisplaySize(fileSize);
					// System.out.println("Size Display: " + fileSizeDisplay);
					//System.out.println();
					lblx64asize.setText(fileSizeDisplay);

					//***comparamos o tamanho do arquivo correto com o do arquivo a ser verificado...
					if(fileSize == size ){
						//...se for igual exibe o simbolo de ok
						ico1x64a.setIcon(IconOK);
						System.out.println("OK");
					}else{
						//...se for diferente  exibe o simbo de perigo
						ico2x64a.setIcon(IconNO);
						System.out.println("ERRO");
						//lblmd5.setText("ERRO");
					}

					//***verificação do algoritimo de md5 do Arquivo
					MessageDigest md5Digest = null;
					try {
						md5Digest = MessageDigest.getInstance("MD5");
					} catch (NoSuchAlgorithmException e) {

						e.printStackTrace();
					}


					String checksum = null;
					try {
						checksum = MD5.getFileChecksum(md5Digest, file);
					} catch (IOException e) {

						e.printStackTrace();
					}

					lblx64amd5.setText(checksum);
					System.out.println(checksum);

					//comparamaos o md5 correto com o do arquivo a ser verificado...
					if(lblx64amd5.getText().equals(md5) ){
						//..se for o mesmo exibe o simbolo de ok
						ico1x64a.setIcon(IconOK);
						System.out.println("OK");
					}else{
						//...senão for exibe o simbolo de perigo
						ico1x64a.setIcon(IconNO);
						System.out.println("ERRO");
						//lblmd5.setText("ERRO");
					}

				}
			}
		});
	}


}

