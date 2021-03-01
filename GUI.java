package co_project;
public class Gui {

	JFrame frame;
	private JTextField textField_0;
	private JButton btnNewButton_2;
	public void display(int R[],int Mem[],int n,int m) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Gui window = new Gui(R,Mem,32,1024);
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	public Gui(int R[],int Mem[],int n,int m) 
	{
		initialize(R,Mem,n,m);
	}
    private void initialize(int R[],int Mem[],int n,int m) {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		frame.getContentPane().setForeground(new Color(255, 0, 0));
		frame.getContentPane().setBackground(new Color(0, 255, 127));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Registers");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNewButton.setBackground(new Color(245, 222, 179));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBounds(373, 41, 121, 23);
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
					textField_0.setText("M["+i+"]"+" = "+Integer.toString(Mem[i]));
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setBounds(698, 42, 127, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Console");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(1072, 42, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
					for(int i=0;i<32;i++)
					{
						int rem=i%8;
						int div=i/8;
						int h=200+div*420;
						int d=100+rem*40;
						 textField_0 = new JTextField();
						textField_0.setBounds(h, d, 95, 25);
						frame.getContentPane().add(textField_0);
						textField_0.setColumns(20);
						textField_0.setText("R["+i+"]"+" = "+Integer.toString(R[i]));
					}
             }
		});
		frame.setBounds(100, 100, 1920, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

