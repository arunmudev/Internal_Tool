package org.company.model;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class MainClass extends Model{

public static void main(String arg[])throws IOException{

List<Model> object = new ArrayList<>();
DataInputStream din = new DataInputStream(System.in);
Model obj = new Model();
for(int i=1;i<=2;i++) {
obj.setName(din.readLine());
object.add(obj);
}
System.out.println(obj.getName());

System.out.println(object.size());
}
}