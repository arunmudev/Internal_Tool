package org.company.dao;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.UUID;

public class Test {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter value");
		
		DataInputStream din = new DataInputStream(System.in);
		Integer ar;
		ar = Integer.parseInt(din.readLine());
		if(ar != null){
			
			System.out.println(ar+" "+UUID.randomUUID());
		}else{
			System.out.println("bye");
		}
	}

}
