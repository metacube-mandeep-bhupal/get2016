package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestIO {

	public static void main(String[] args) throws IOException {
		File file = new File("pro.txt");
		 //File file = new File("C:\\Users\\avinash\\Dropbox\\Codes\\work\\Works\\Codes\\Codes\\serverTest\\pro.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String host = br.readLine();
		String dbName = br.readLine();
		String mysqlURL = host+dbName;
		String userId = br.readLine();
		String password = br.readLine();
		System.out.println(host);
		System.out.println(dbName);
		System.out.println(mysqlURL);
		System.out.println(userId);
		System.out.println(password);
		br.close();
	}

}
