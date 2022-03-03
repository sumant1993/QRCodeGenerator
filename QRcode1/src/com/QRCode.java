package com;

import java.io.File;

import java.io.IOException;

import java.nio.file.Paths;
import java.util.Base64;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCode {

	public static void gerateqrcode(String data,String height,String width) throws IOException, WriterException {
    String path="C:\\Users\\ASUS\\Desktop\\NewFolder\\";
	int leftLimit = 97; // letter 'a'
	int rightLimit = 122; // letter 'z'
	int targetStringLength = 10;

	Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	}
	    
	String generatedString = buffer.toString();
	String charset = "UTF-8";  
	int hei = Integer.parseInt(height);
	int wid=Integer.parseInt(width);
	String newpath=path.concat(generatedString).concat(".png");
	System.out.println(newpath);
	
	BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE,wid,hei);  
    
	
	MatrixToImageWriter.writeToPath(matrix,"png",Paths.get(newpath));
	MatrixToImageWriter.writeToStream(matrix, newpath, null);
	
	
    File file=new File(newpath);
    
    File inputFile = new File(newpath);
    
    BufferedImage inputImage = ImageIO.read(inputFile);
    BufferedImage outputImage = new BufferedImage(400,
            400, inputImage.getType());
    // scales the input image to the output image
    Graphics2D g2d = outputImage.createGraphics();
    g2d.drawImage(inputImage, 0, 0, 400, 400, null);
    g2d.dispose();
 // extracts extension of output file
    String formatName = newpath.substring(newpath
            .lastIndexOf(".") + 1);
    // writes to output file
     ImageIO.write(outputImage, formatName, new File(newpath));
    
    String str = FileUtils.readFileToString(file,charset);
    System.out.println(str.length());
    
    byte[] fileContent = FileUtils.readFileToByteArray(new File(newpath));
    String encodedString = Base64.getEncoder().encodeToString(fileContent);
    System.out.println(encodedString);
    
    
    
    file.delete();
    
    
	
		
}
	
	public static void main(String[] args) throws IOException, WriterException {
		gerateqrcode("i am the boss", "200", "200");
	}
	

   
	
	
}
