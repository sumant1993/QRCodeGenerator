package com;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;


public class WriteToStream {

	public static String qrCode(String data) {
	    try {
	    	
	    	String charset = "UTF-8"; 
	    	
	    	 int width = 246;
		     int height = 246;

	    	BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE,width,height);  
	  
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        MatrixToImageWriter.writeToStream(matrix,"png", bos);
	        bos.close();
	        return   Base64.getEncoder().encodeToString(bos.toByteArray());
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
  public static void main(String[] args) {
	  String txt ="The first step to gathering user-generated content is identifying what kind of information you’d like to include in your emails. You’ll need to take a look at the products or services that you offer and figure out which ones are most popular based on custo";
	 System.out.println(txt.length());
}	
}
