package mips;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
   JFrame frame;
	private JTextField textField_0;
	private JButton btnNewButton_2;
	private JTextField textField;
	
	public void display(String R[],String Mem[],int n,int m) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI window = new GUI(R,Mem,32,1024);
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	public GUI(String R[],String Mem[],int n,int m) 
	{
		initialize(R,Mem,n,m);
	}
    private void initialize(String R[],String Mem[],int n,int m) {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		frame.getContentPane().setForeground(new Color(255, 0, 0));
		frame.getContentPane().setBackground(new Color(0, 255, 127));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Registers");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNewButton.setBackground(new Color(245, 222, 179));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBounds(16, 859, 121, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Data Segment");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				for(int i=0;i<1024;i++)
				{
					int rem=i%50;
					int div=i/50;
					int h=14+div*90;
					int d=96+rem*15;
					 textField_0 = new JTextField();
					textField_0.setBounds(h, d, 89, 20);
					frame.getContentPane().add(textField_0);
					textField_0.setColumns(20);
					textField_0.setText("M["+i+"]"+" = "+Mem[i]);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setBounds(10, 62, 127, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Console");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				textField = new JTextField();
				textField.setBounds(182, 11, 1684, 51);
				frame.getContentPane().add(textField);
				textField.setColumns(10);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(26, 28, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				 for(int i=0;i<32;i++)
				 {
					 int h,d;
				 if(i%2==0)
						 d=902;
					 else
						 d=951;
					h=20+(i/2)*118;
					textField_0 = new JTextField();
					textField_0.setBounds(h, d, 115, 30);
					frame.getContentPane().add(textField_0);
					textField_0.setColumns(10);
					textField_0.setText("R["+i+"]"+" = "+R[i]);
				 }
		}
		});
		frame.setBounds(100, 100, 1928, 1047);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}