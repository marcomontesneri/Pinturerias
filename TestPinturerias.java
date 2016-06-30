package com.mxinteligente.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class TestPinturerias {
	
	
	
	public static void main(String[] args) {
		 
		 try {

			 TestPinturerias pinturerias = new TestPinturerias();
			 
			 //Parametros codigo, monto, compañia y sucursal
			 pinturerias.reedemCode("ce62u", "200", "1", "1");
			 
			 //Parametros compañia, celular
			 pinturerias.getBalanceCommerce("1", "5542301423");
			 
			  } catch (Exception e) {

				e.printStackTrace();
			 }
		 
		
		 
		  

		}

	
	public String reedemCode(String codigo, String amount, String idCompany, String idSucursal ) {
		String sesion = "";
		 try {

				URL url = new URL("https://www.saldo.mx/Saldos/api/ripplev4/redeemCodeMerchant");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");

//
				 String data = "code=" + URLEncoder.encode(codigo) +
			                "&amount=" + URLEncoder.encode(amount) + 
			                "&idCompany=" + URLEncoder.encode(idCompany)+
			                "&idSucursal=" + URLEncoder.encode(idSucursal)
			                ;
				
				OutputStreamWriter os = new OutputStreamWriter(conn.getOutputStream());
				os.write(data);
				os.flush();

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

				String output;			
				output = br.readLine();
				
				
				
				System.out.println("Respuesta " + output);
				

				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();
				return "";

			  } catch (IOException e) {

				e.printStackTrace();
				return "";
			 }
		 
		 return sesion;
		
	}
	
	
	public String getBalanceCommerce(String commerce, String phone) {
		String sesion = "";
		 try {

				URL url = new URL("https://www.saldo.mx/Saldos/api/ripplev4/getBalanceCommerce");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");

//
				 String data = "idCommerce=" + URLEncoder.encode(commerce) +
			                "&phone=" + URLEncoder.encode(phone)  
			                
			                ;
				
				OutputStreamWriter os = new OutputStreamWriter(conn.getOutputStream());
				os.write(data);
				os.flush();

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

				String output;			
				output = br.readLine();
				
				
				
				System.out.println("Respuesta " + output);
								//if(respuesta.contains("BIEN")){


				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();
				return "";

			  } catch (IOException e) {

				e.printStackTrace();
				return "";
			 }
		 
		 return sesion;
		
	}


}
