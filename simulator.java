package co_project;
import java.io.*;
import java.util.*;
public class simulator 
{
   public static void main(String[] args) 
   {
	Scanner sc=new Scanner(System.in);
	int R[]=new int[32];
       int Mem[]=new int[1024];
       int PC=0;
       File file = new File("./cs19b010.asm");
       BufferedReader reader;
       try 
       {
            reader = new BufferedReader(new FileReader(file));
	    String line = reader.readLine();
	    while (line != null) 
            {
		PC=PC+4;
		System.out.println(line);
		line = reader.readLine();
	    }
	   System.out.println();
	   reader.close();
      } 
       catch (Exception e)
       {
	   e.printStackTrace();
	}
   }

}
