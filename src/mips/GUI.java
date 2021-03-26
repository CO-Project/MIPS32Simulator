package mips;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GUI
{

	private JFrame frame;
	private JTable table;
	private JRadioButton enabled;
	private JRadioButton Disable;
	private JLabel lblNewLabel;
	private JEditorPane dtrpnStallinstructions;
	private JScrollPane scrollPane;
	private JTextField txtInstrlabel;
	private JTextField txtClockcycleslabel;
	private JTextField txtStallslabel;
	private JTextField txtIpclabel;
	public void display(String R[],String Mem[],int n,int m,String str,int instr,int stallsEnabled,int stallsDisabled, int clocksEnabled,int clocksDisabled,String stallInsEnabled, String stallInsDisabled) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI window = new GUI(R,Mem,32,1024,str,instr,stallsEnabled,stallsDisabled, clocksEnabled,clocksDisabled,stallInsEnabled, stallInsDisabled);
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	public GUI(String R[],String Mem[],int n,int m,String str,int instr,int stallsEnabled,int stallsDisabled, int clocksEnabled,int clocksDisabled,String stallInsEnabled, String stallInsDisabled) 
	{
		initialize(R,Mem,32,1024,str,instr,stallsEnabled,stallsDisabled, clocksEnabled,clocksDisabled,stallInsEnabled, stallInsDisabled);
	}
    private void initialize(String R[],String Mem[],int n,int m,String str,int instr,int stallsEnabled,int stallsDisabled, int clocksEnabled,int clocksDisabled,String stallInsEnabled, String stallInsDisabled) 
    {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 1928, 1047);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPane.setBackground(Color.DARK_GRAY);
		tabbedPane.setBounds(10, 11, 1892, 986);
		frame.getContentPane().add(tabbedPane);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Main Window", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPane_1.setBounds(10, 11, 1434, 936);
		panel_3.add(tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		tabbedPane_1.addTab("Data Segment", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 5, 1409, 891);
		panel_5.add(scrollPane_1);
		String DataSegmentstr=" ";
		for(int j=0;j<m;j++)
		{
			DataSegmentstr=DataSegmentstr+"Address("+j+")"+"   =   "+Mem[j]+"\n";
		}
		JEditorPane dtrpnDatasegmentJeditorPane = new JEditorPane();
		dtrpnDatasegmentJeditorPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtrpnDatasegmentJeditorPane.setText(DataSegmentstr);
		dtrpnDatasegmentJeditorPane.setForeground(Color.WHITE);
		dtrpnDatasegmentJeditorPane.setBackground(Color.DARK_GRAY);
		scrollPane_1.setViewportView(dtrpnDatasegmentJeditorPane);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.DARK_GRAY);
		tabbedPane_1.addTab("Text", null, panel_6, null);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 1409, 885);
		panel_6.add(scrollPane_2);
		
		JEditorPane dtrpnTextJeditorPane = new JEditorPane();
		dtrpnTextJeditorPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtrpnTextJeditorPane.setText(str);
		dtrpnTextJeditorPane.setForeground(Color.WHITE);
		dtrpnTextJeditorPane.setBackground(Color.DARK_GRAY);
		scrollPane_2.setViewportView(dtrpnTextJeditorPane);
		
		JPanel panelinfo = new JPanel();
		panelinfo.setBackground(Color.DARK_GRAY);
		panelinfo.setForeground(Color.WHITE);
		tabbedPane_1.addTab("Info", null, panelinfo, null);
		panelinfo.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(981, 92, 363, 804);
		panelinfo.add(scrollPane);
		
		dtrpnStallinstructions = new JEditorPane();
		dtrpnStallinstructions.setFont(new Font("Tahoma", Font.PLAIN, 19));
		dtrpnStallinstructions.setText(null);
		dtrpnStallinstructions.setForeground(Color.WHITE);
		dtrpnStallinstructions.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(dtrpnStallinstructions);
		
		enabled = new JRadioButton("Enable");
		enabled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(enabled.isSelected())
				{
					Disable.setSelected(false);
                   txtInstrlabel.setText(Integer.toString(instr));
				   txtClockcycleslabel.setText(Integer.toString(clocksEnabled));
				   txtStallslabel.setText(Integer.toString(stallsEnabled));
					double ipcEnabled = (double)instr/(double)clocksEnabled;
					txtIpclabel.setText(Double.toString(ipcEnabled));
			        dtrpnStallinstructions.setText(stallInsEnabled);
				}
			}
		});
		enabled.setFont(new Font("Tahoma", Font.BOLD, 12));
		enabled.setBounds(75, 87, 109, 23);
		panelinfo.add(enabled);
		
		Disable = new JRadioButton("Disable");
		Disable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(Disable.isSelected())
				{
					enabled.setSelected(false);
					 txtInstrlabel.setText(Integer.toString(instr));
					  txtClockcycleslabel.setText(Integer.toString(clocksDisabled));
					 txtStallslabel.setText(Integer.toString(stallsDisabled));
					double ipcDisabled = (double)instr/(double)clocksDisabled;
					txtIpclabel.setText(Double.toString(ipcDisabled));
					dtrpnStallinstructions.setText(stallInsDisabled);
				}
			}
		});
		Disable.setFont(new Font("Tahoma", Font.BOLD, 12));
		Disable.setBounds(75, 129, 109, 23);
		panelinfo.add(Disable);
		
		lblNewLabel = new JLabel("Data Forwarding");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(75, 38, 142, 30);
		panelinfo.add(lblNewLabel);
		
		JLabel lblStallInstructions = new JLabel("Stall Instructions :");
		lblStallInstructions.setForeground(Color.WHITE);
		lblStallInstructions.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStallInstructions.setBounds(981, 50, 155, 30);
		panelinfo.add(lblStallInstructions);
		
		JLabel lblNumberOfInstructions = new JLabel(" Instructions     :");
		lblNumberOfInstructions.setForeground(Color.WHITE);
		lblNumberOfInstructions.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberOfInstructions.setBounds(101, 291, 142, 30);
		panelinfo.add(lblNumberOfInstructions);
		
		JLabel lblNumberOfClock = new JLabel("Clock Cycles     :");
		lblNumberOfClock.setForeground(Color.WHITE);
		lblNumberOfClock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberOfClock.setBounds(101, 348, 142, 30);
		panelinfo.add(lblNumberOfClock);
		
		JLabel lblStalls = new JLabel("Stalls                  :");
		lblStalls.setForeground(Color.WHITE);
		lblStalls.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStalls.setBounds(101, 400, 142, 30);
		panelinfo.add(lblStalls);
		
		JLabel lblIpc = new JLabel("IPC                      :");
		lblIpc.setForeground(Color.WHITE);
		lblIpc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIpc.setBounds(101, 450, 142, 30);
		panelinfo.add(lblIpc);
		
		txtInstrlabel = new JTextField();
		txtInstrlabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtInstrlabel.setText(null);
		txtInstrlabel.setBounds(274, 298, 67, 20);
		panelinfo.add(txtInstrlabel);
		txtInstrlabel.setColumns(10);
		
		txtClockcycleslabel = new JTextField();
		txtClockcycleslabel.setText(null);
		txtClockcycleslabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtClockcycleslabel.setColumns(10);
		txtClockcycleslabel.setBounds(274, 354, 67, 20);
		panelinfo.add(txtClockcycleslabel);
		
		txtStallslabel = new JTextField();
		txtStallslabel.setText(null);
		txtStallslabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtStallslabel.setColumns(10);
		txtStallslabel.setBounds(274, 407, 67, 20);
		panelinfo.add(txtStallslabel);
		
		txtIpclabel = new JTextField();
		txtIpclabel.setText(null);
		txtIpclabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtIpclabel.setColumns(10);
		txtIpclabel.setBounds(274, 456, 150, 20);
		panelinfo.add(txtIpclabel);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPane_2.setBounds(1446, 11, 431, 936);
		panel_3.add(tabbedPane_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		tabbedPane_2.addTab("Registers", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 406, 885);
		panel_4.add(scrollPane_3);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.DARK_GRAY);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"$zero", "0", R[0]},
				{"$at", "1", R[1]},
				{"$v0", "2", R[2]},
				{"$v1", "3",R[3]},
				{"$a0", "4", R[4]},
				{"$a1", "5", R[5]},
				{"$a2", "6", R[6]},
				{"$a3", "7", R[7]},
				{"$t0", "8", R[8]},
				{"$t1", "9", R[9]},
				{"$t2", "10", R[10]},
				{"$t3", "11", R[11]},
				{"$t4", "12", R[12]},
				{"$t5", "13", R[13]},
				{"$t6", "14", R[14]},
				{"$t7", "15", R[15]},
				{"$s0", "16", R[16]},
				{"$s1", "17", R[17]},
				{"$s2", "18", R[18]},
				{"$s3", "19", R[19]},
				{"$s4", "20", R[20]},
				{"$s5", "21", R[21]},
				{"$s6", "22", R[22]},
				{"$s7", "23",R[23]},
				{"$t8", "24", R[24]},
				{"$t9", "25", R[25]},
				{"$k0", "26", R[26]},
				{"$k1", "27", R[27]},
				{"$gp", "28", R[28]},
				{"$sp", "29", R[29]},
				{"$fp", "30", R[30]},
				{"$ra", "31", R[31]},
			},
			new String[] {
				"Name", "Number", "Value"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_3.setViewportView(table);
    }
}
