/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.ui;

import java.awt.CardLayout;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.controller.DayCareCompany;
import edu.neu.csye6200.model.Person;

/**
 *
 * @author hairihan
 */
public class StudentPanel extends javax.swing.JPanel {

	private DayCareCompany d;
	private JPanel userProcessContainer;

	/**
	 * Creates new form StudentPanel
	 */
	public StudentPanel(DayCareCompany d, JPanel userProcessContainer) {
		this.d = d;
		this.userProcessContainer = userProcessContainer;
		initComponents();
		populate();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		btnAddStudent = new javax.swing.JButton();
		btnSearchStudent = new javax.swing.JButton();

		jLabel1.setBackground(new java.awt.Color(51, 0, 153));
		jLabel1.setFont(new java.awt.Font("Garamond", 1, 30)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Student");
		jLabel1.setForeground(new java.awt.Color(255,255,255));

		btnAddStudent.setText("Add Student");
		btnAddStudent.setForeground(new java.awt.Color(20,61,89));
		btnAddStudent.setFont(new java.awt.Font("Garamond", 1, 18));
		btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddStudentActionPerformed(evt);
			}
		});

		btnSearchStudent.setText("Search Student");
		btnSearchStudent.setForeground(new java.awt.Color(20,61,89));
		btnSearchStudent.setFont(new java.awt.Font("Garamond", 1, 18));
		btnSearchStudent.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSearchStudentActionPerformed(evt);
			}
		});

		setBackground(new java.awt.Color(20,61,89));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(164, 164, 164)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addComponent(btnAddStudent)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnSearchStudent))
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup().addGap(546, 546, 546).
								addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(217, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(83, 83, 83).addComponent(jLabel1).addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(123, 123, 123)));
	}// </editor-fold>

	void populate() {
		DefaultTableModel table = new DefaultTableModel();
		String[] colTitles = { "Student ID ", "Name", "Date of Enrollment", "Age", "Need Renewal" };
		table.setColumnCount(colTitles.length);
		table.setColumnIdentifiers(colTitles);

		for (Person s : d.getStudents()) {
			String ifRenew = "NO";
			int l = s.ft.format(s.getDateOfEnrollment()).length();
			String x = s.ft.format(s.getDateOfEnrollment());
			if (Integer.parseInt(x.substring(l - 4, l)) < Calendar.getInstance().get(Calendar.YEAR)) {
				int day= Integer.parseInt(x.substring(l - 7, l-5));
				int month=Integer.parseInt(x.substring(0, 2));
				System.out.println("Day: "+Calendar.getInstance().get(Calendar.DATE));
				System.out.println(Calendar.getInstance().get(Calendar.MONTH));
				if((day==Calendar.getInstance().get(Calendar.DATE))&&(month==Calendar.getInstance().get(Calendar.MONTH)+1)) {
				ifRenew = "YES";
				}
			}
			table.addRow(new Object[] { s.getId(), s.getFirstName() + " " + s.getLastName(), s.getDateOfEnrollment(),
					s.getAge(), ifRenew });

		}
		

		jTable1.setModel(table);
		
		jScrollPane1.setViewportView(jTable1);
	}

	private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {
		AddStudentJPanel panel = new AddStudentJPanel(d, userProcessContainer);
		userProcessContainer.add("AddStudentPanel", panel);
		CardLayout layout = (CardLayout) userProcessContainer.getLayout();
		layout.next(userProcessContainer);
	}

	private void btnSearchStudentActionPerformed(java.awt.event.ActionEvent evt) {
		JFrame searchStudentFrame = new JFrame();
		searchStudentFrame.setBounds(0, 0, 934, 680);
		StudentJPanel AS = new StudentJPanel(d);
		AS.setVisible(true);
		searchStudentFrame.add(AS);
		searchStudentFrame.setVisible(true);
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnAddStudent;
	private javax.swing.JButton btnSearchStudent;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	public static javax.swing.JTable jTable1;
	// End of variables declaration
}
