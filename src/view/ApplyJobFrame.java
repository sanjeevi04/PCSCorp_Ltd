package view;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EmployeeController;
public class ApplyJobFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	Container container;
	JLabel lRecruited,lEmployeeId,lJobId;
	JTextField tRecruited,tEmployeeId,tJobId;
	JButton bSubmit;
	EmployeeController empController=null;
	JFrame f=new JFrame();
	
	public ApplyJobFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		empController=new EmployeeController();
		lRecruited=new JLabel("Recruited(yes/no)");
		lEmployeeId=new JLabel("Employee ID");
		lJobId=new JLabel("Job ID");
		tRecruited=new JTextField();
		tEmployeeId=new JTextField();
		tJobId=new JTextField();
		
		bSubmit=new JButton("SUBMIT");
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int s1,s2;
				String s3;
				s3=tRecruited.getText();
				s1=Integer.parseInt(tEmployeeId.getText());
				s2=Integer.parseInt(tJobId.getText());
				empController.addEmpJob(s1, s2,s3);
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Apply Job");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}


	private void setLayoutManager() {
		container.setLayout(null);
		
	}


	public void setLocationAndSize() {
		lEmployeeId.setBounds(50, 150, 100, 30);
		lJobId.setBounds(50, 250, 100, 30);
		lRecruited.setBounds(50, 350, 100, 30);
		
		tEmployeeId.setBounds(200, 150, 150, 30);
		tJobId.setBounds(200, 250, 150, 30);
		tRecruited.setBounds(200, 350, 150, 30);
		
		bSubmit.setBounds(100, 500, 100, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmployeeId);
		container.add(tJobId);
		container.add(lJobId);
		container.add(lRecruited);
		container.add(lJobId);
		container.add(tRecruited);
		container.add(bSubmit);
		
	}
}
