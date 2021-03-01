package co_project;
import java.io.*;
import java.util.*;
import java.util.*;
import javax.*;
import javax.swing.JFileChooser;
public class simulator 
{
   public static void main(String[] args) 
   {
       int R[]=new int[32];
       int Mem[]=new int[1024];
       int PC=0;
       for(int i=0;i<32;i++)
       {
	   R[i]=0;
       }
       for(int i=0;i<1024;i++)
       {
	   Mem[i]=0;
       }
       File file ;
      Scanner fileIn;
      int response;
      JFileChooser chooser=new JFileChooser(".");
      chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      response=chooser.showOpenDialog(null);
      if(response==JFileChooser.APPROVE_OPTION)
      {
    	  file=chooser.getSelectedFile();
    	  try 
    	  {
		fileIn=new Scanner(file);
		if(file.isFile())
		{
			while(fileIn.hasNextLine())
			{
			      String line=fileIn.nextLine();
			      System.out.println(line);
			}
		}
		else
		{
		      System.out.println("That was not a File :)");
		}
                fileIn.close();
	 }
    	  catch (FileNotFoundException e) 
    	  {
		e.printStackTrace();
           }
      }
      /* the whole parsing and instruction implementation is done here!!*/
      /*Registers and memory is updated*/
      /* Display reults on console */
      Gui gui= new Gui(R,Mem,32,1024);
     gui.display(R,Mem,32,1024);
}
