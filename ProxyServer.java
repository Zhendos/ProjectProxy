package org.bot.proxyserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import org.bot.frame.*;


public class ProxyServer { 
	String s1;	
	
	
	
	/**
	 * 
	 * 
	 * Formateert de tijd.
	 * @param l
	 * @return
	 */
	
	public static String formatTime(final long l){
		final long day = TimeUnit.MILLISECONDS.toDays(l);
		final long hr = TimeUnit.MILLISECONDS.toHours(l - TimeUnit.DAYS.toMillis(day));
		final long min = TimeUnit.MILLISECONDS.toMinutes(l - TimeUnit.DAYS.toMillis(day) - TimeUnit.HOURS.toMillis(hr));
		final long sec = TimeUnit.MILLISECONDS.toSeconds(l - TimeUnit.DAYS.toMillis(day) - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min));
		final long mil = TimeUnit.MILLISECONDS.toMillis(l - TimeUnit.DAYS.toMillis(day) - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min) - TimeUnit.SECONDS.toMillis(sec));
		
		return String.format("%02d:%02d:%02d:%02d:%02d", day, hr, min, sec, mil);
		
	}
	
	
	
	public static void Proxy() throws IOException, URISyntaxException{
		long time = System.currentTimeMillis();

		
		/**
		 * 
		 * Objects aanmaken
		 * 
		 */
		BufferedReader br;
		BufferedWriter bw;
		FileOutputStream fo;
		FileInputStream fi;
		InputStreamReader is;
		InputStreamReader iw;
		FileWriter fw;
		File file;
		
		String line;
		
		file = new File("C:\\Users\\youri\\zBot\\mijnip.txt");
		
		/**
		 * 
		 * Maak de proxy object aan.
		 * Verbinden met de connectie met de proxy 
		 * 
		 */
		
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("183.230.53.163", 8123));
		URL url = new URL("http://watismijnipadres.nl/");
		URLConnection urlconnection = url.openConnection();
		br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
		System.out.println("Connected met de URL " + url.toURI() + " en met port: " + url.getPort());
		/**
		 * 
		 *Maak het bestandje aan. 
		 * 
		 */
		//file = new File("Website.txt");
		//if(!file.exists()){
		//	System.out.println("Het bestandje wordt nu aangemaakt onder de naam: " + file.getName());
		//	file.createNewFile();
		//}
		
		/**
		 * 
		 * Lees de website
		 * 
		 */
		while((line = br.readLine()) != null){
			System.out.println(line);
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(line);
		}
		System.out.println("Klaar met het aanmaken van het bestandje: " + file.getName());
		
		/**
		 * 
		 * Sluit de connectie
		 * 
		 */
		System.out.println("Sluit de connectie");
		
		br.close();
		
		/**
		 * 
		 * Bereken de elapsed tijd.
		 * 
		 */
		int secondes = (int) ((time / 1000) % 60);
		
		System.out.println("-----> Klaar in " + secondes + " seconden " + "<------");

	}


}
