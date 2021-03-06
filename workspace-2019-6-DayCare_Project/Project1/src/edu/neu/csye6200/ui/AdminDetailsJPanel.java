/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.ui;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.controller.DayCareCompany;
import edu.neu.csye6200.model.ClassRoom;
import edu.neu.csye6200.model.Person;

/**
 *
 * @author hairihan
 */
public class AdminDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminDetailsJPanel
     * @param userProcessContainer 
     * @param company 
     */
	
	private DayCareCompany company;
	 private JPanel userProcessContainer;
	 int classNo;
	
    public AdminDetailsJPanel(DayCareCompany company, JPanel userProcessContainer, int classNo) {
    	this.company=company;
    	this.userProcessContainer=userProcessContainer;
    	this.classNo=classNo;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudent = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTeacher = new javax.swing.JTable();
      //  Student = new javax.swing.JButton();
       // btnAddTeacher = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setBackground(new java.awt.Color(20,61,89));
      //  setBackground(new java.awt.Color(255,255,255));

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255,255,255));
        //jPanel1.setBackground(new java.awt.Color(20,61,89));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Class Details");

		DefaultTableModel studentTable = new DefaultTableModel();
		String[] stitles = { "Student ID ", "Name", "Date of Enrollment", "Age", "Need Renewal" };
		studentTable.setColumnCount(stitles.length);
		studentTable.setColumnIdentifiers(stitles);

		for (Person s : company.getClassRooms().get(classNo-1).getStudents()) {
			String ifRenew = "NO";
			int l = s.getDateOfEnrollment().toString().length();
			String x = s.getDateOfEnrollment().toString();
			if (Integer.parseInt(x.substring(l - 4, l)) < 2019) {
				ifRenew = "YES";
			}
			studentTable.addRow(new Object[] { s.getId(), s.getFirstName() + " " + s.getLastName(), s.getDateOfEnrollment(),
					s.getAge(), ifRenew });

		}
		
        jTableStudent.setModel(studentTable);
        jScrollPane1.setViewportView(jTableStudent);

        jLabel2.setBackground(new java.awt.Color(51, 0, 153));
        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Teacher");

        jLabel3.setBackground(new java.awt.Color(51, 0, 153));
        jLabel3.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student");

        DefaultTableModel teacherTable = new DefaultTableModel();
		String[] colTitles_t = { "Teacher ID", "Name" };
		teacherTable.setColumnCount(colTitles_t.length);
		teacherTable.setColumnIdentifiers(colTitles_t);
		for (Person p : company.getClassRooms().get(classNo-1).getTeachers()) {
			teacherTable.addRow(new Object[] { p.getId(), p.getFirstName() + " " + p.getLastName() });
		}
    	jTableTeacher.setModel(teacherTable);
        jScrollPane3.setViewportView(jTableTeacher);
        
        /*
         * 
         */

//        btnAddStudent.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
//        btnAddStudent.setForeground(new java.awt.Color(51, 0, 153));
//        btnAddStudent.setText("Add Student");
//
//        btnAddTeacher.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
//        btnAddTeacher.setForeground(new java.awt.Color(51, 0, 153));
//        btnAddTeacher.setText("Add Teacher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                     //   .addComponent(btnAddTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        //.addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE
                        		))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(213, 213, 213))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18,18,18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 //   .addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                   // .addComponenddTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                		)
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
 //   private javax.swing.JButton Student;
    private javax.swing.JButton Teacher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableStudent;
    private javax.swing.JTable jTableTeacher;
    // End of variables declaration//GEN-END:variables
}
