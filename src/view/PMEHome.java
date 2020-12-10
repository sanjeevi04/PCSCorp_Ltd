package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class PMEHome extends JFrame {
	 Container container=null;
	 
	 JLabel lTitle;
	 JButton bViewAllSkill,bAddJob,bViewAllJobs,bViewEmpbySkill,bViewJobsbySkill,bViewAppliedJob,bSetDeactiveJob,bLogout;
		
		
	 public PMEHome() {
		 container=getContentPane();
		 lTitle=new JLabel("Welcome to PME Portal");
		 
		 this.setTitle("PME Frame");
		 this.setVisible(true);
		 this.setBounds(10, 10, 500, 600);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
	 }
}
