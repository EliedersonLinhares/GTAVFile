package br.eliederson.com.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public class MD5 {

	static String getFileChecksum(MessageDigest digest, File file) throws IOException
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
	     
	    //retorna o hash completo
	   return sb.toString();
	}

}
