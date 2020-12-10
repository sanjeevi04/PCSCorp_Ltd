package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.*;
import controller.JobController;


public class DeactivateJobFrame extends JFrame {

	Container container;
	JFrame f;
	JLabel lJobId;
	JTextField tJobId;
	JButton bDeactivate;
	JobController jobController=null;
	
	public DeactivateJobFrame() throws ClassNotFoundException, SQLException{
		container=getContentPane();
		f=new JFrame();
		lJobId=new JLabel("ENTER JOB ID");
		tJobId=new JTextField();
		bDeactivate=new JButton("DEACTIVATE");
		jobController=new JobController();
		
		bDeactivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int j;
				j=Integer.parseInt(tJobId.getText());
				try {
					jobController.deactivateJob();
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Deactivate Skill");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	

	private void setLayoutManager() {
		container.setLayout(null);
		
	}
	private void setLocationAndSize() {
		lJobId.setBounds(30, 150, 300, 30);
		tJobId.setBounds(200, 150, 150, 30);
		bDeactivate.setBounds(200, 250, 100, 30);
	}

	private void addComponentsToContainer() {
		container.add(lJobId);
		container.add(tJobId);
		container.add(bDeactivate);
	}

	
	
}
