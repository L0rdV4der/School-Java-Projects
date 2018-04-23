package algorithms3;

import java.io.*;
public class hw3
{
public void listFiles(String dn)
{
File d = new File(dn);
File [] fList = d.listFiles();
for (File f1 : fList)
{
if (f1.isFile())
{
System.out.println(f1.getName() + "\t\t\t" +f1.length());
}
}
}
public static void main (String[] args)
{
hw3 FileSize = new hw3();
String s ="//Users//darthvader//Desktop";
FileSize.listFiles(s);
}
}