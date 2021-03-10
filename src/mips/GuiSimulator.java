package mips;

import java.io.*;
import java.util.*;
import java.util.*;
import javax.swing.JFileChooser;
public class GuiSimulator 
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
			Simulator sim = new Simulator(file);
			sim.startSimulation();
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
     
}
}
