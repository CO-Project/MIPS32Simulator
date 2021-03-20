package mips;
import javax.swing.*;
import java.awt.*;
public class GUI {

	private JFrame frame;
	private JTextField textField_0;
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
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 1928, 1047);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1892, 986);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Registers", null, panel, null);
		panel.setLayout(null);
		
		
		 for(int i=0;i<32;i++)
		 {
			 int h,d;
			h=67+(i/6)*315;
			d=113+(i%6)*133;
			textField_0 = new JTextField();
			textField_0.setBounds(h, d, 145, 35);
			panel.add(textField_0);
			textField_0.setColumns(10);
			textField_0.setText("R["+i+"]"+" = "+R[i]);
		 }
		 
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Data Segment", null, panel_1, null);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		panel_1.setLayout(null);
		
		for(int i=0;i<1024;i++)
		{
			int rem=i%50;
			int div=i/50;
			int h=14+div*90;
			int d=96+rem*15;
			 textField_0 = new JTextField();
			textField_0.setBounds(h, d, 89, 20);
			panel_1.add(textField_0);
			textField_0.setColumns(20);
			textField_0.setText("M["+i+"]"+" = "+Mem[i]);
		}
    }
}