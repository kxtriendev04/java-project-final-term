/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controller.UserDAO;
import Models.User;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class PnlAdDeletedUs extends javax.swing.JPanel {

    /**
     * Creates new form PnlAdDeletedUs
     */
    public PnlAdDeletedUs() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(radNam);
        group.add(radNu);
        lblErrorEmail.setText("");
        lblErrorSDT.setText("");
        lblErrorNS.setText("");
        lblErrorGT.setText("");
        lblErrorHT.setText("");
        lblErrorDC.setText("");
        lblErrorDiem.setText("");
        txtUsername.setVisible(false);
        try {
            showData();
        } catch (SQLException ex) {
            Logger.getLogger(PnlAdDeletedUs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlAdDeletedUs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showData() throws SQLException, ClassNotFoundException{
        DefaultTableModel model = (DefaultTableModel) tbAcc.getModel();
        model.setRowCount(0); // Xóa các dòng cũ trong bảng

        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getAllUsers();

        for (User user : users) {
            if(!user.getIsDeleted())
                continue;
            Object row[] = new Object[9];  // Đảm bảo khai báo mảng Object để chứa các loại dữ liệu khác nhau
            row[0] = user.getUsername();
            row[1] = user.getFullname();
            row[2] = user.getBirthday().toString();
            // Kiểm tra và chuyển đổi giới tính từ số sang chữ
            row[3] = user.getGender() == 1 ? "Nam" : "Nữ";
            row[4] = user.getEmail();
            row[5] = user.getCity();
            row[6] = user.getPhone();
            row[7] = user.getPoint();
            row[8] = user.getRole();
            // Thêm dòng vào bảng
            model.addRow(row);
        }
    }
    public void resetData(){
        txtUsername.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtThang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        txtNam = new javax.swing.JTextField();
        lblErrorHT = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        lblErrorNS = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblErrorDiem = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblErrorSDT = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblErrorDC = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblErrorEmail = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblErrorGT = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        txtNgay = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAcc = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXoaAll = new javax.swing.JButton();
        chkAdmin = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        txtRestore = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        btnXoaTim = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quản lý thùng rác tài khoản");

        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Có thể xem, xoá");

        txtThang.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm: ");

        txtTim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNam.setEnabled(false);

        lblErrorHT.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorHT.setText("jLabel2");

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        lblErrorNS.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorNS.setText("jLabel12");

        jLabel5.setText("Họ tên:");

        lblErrorDiem.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorDiem.setText("jLabel13");

        jLabel6.setText("Ngày sinh:");

        lblErrorSDT.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorSDT.setText("jLabel14");

        jLabel7.setText("Điểm tích luỹ: ");

        lblErrorDC.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorDC.setText("jLabel15");

        jLabel8.setText("Email:");

        lblErrorEmail.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorEmail.setText("jLabel16");

        jLabel9.setText("Địa chỉ:");

        lblErrorGT.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorGT.setText("jLabel17");

        jLabel10.setText("Số ĐT: ");

        jLabel11.setText("Giới tính: ");

        txtHoTen.setEnabled(false);

        txtDiem.setEnabled(false);

        txtSoDT.setEnabled(false);

        txtEmail.setEnabled(false);

        txtDiaChi.setEnabled(false);

        radNam.setText("Nam");
        radNam.setEnabled(false);
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamActionPerformed(evt);
            }
        });

        radNu.setText("Nữ");
        radNu.setEnabled(false);

        txtNgay.setEnabled(false);

        tbAcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên TK", "Họ tên", "Ngày sinh", "Giới tính", "Email", "Địa chỉ", "Số ĐT", "Điểm tích luỹ", "Loại TK"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAccMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbAcc);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá vĩnh viễn");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnXoaAll.setText("Xoá tất cả");
        btnXoaAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaAllMouseClicked(evt);
            }
        });
        btnXoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAllActionPerformed(evt);
            }
        });

        chkAdmin.setText("Tài khoản admin");
        chkAdmin.setEnabled(false);

        jLabel12.setText("Loại tài khoản:");

        txtRestore.setText("Khôi phục");
        txtRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRestoreActionPerformed(evt);
            }
        });

        btnXoaTim.setText("Reset");
        btnXoaTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnXoaTim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(chkAdmin)
                                .addGap(60, 60, 60)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrorNS, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblErrorHT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDiem, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNam, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail)
                                    .addComponent(txtDiaChi)
                                    .addComponent(txtSoDT, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(lblErrorEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radNam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radNu)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblErrorSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                            .addComponent(lblErrorDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(6, 6, 6)
                                        .addComponent(lblErrorGT))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 66, Short.MAX_VALUE)
                                        .addComponent(btnReset)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRestore)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnXoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(btnXoaTim))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTim)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblErrorHT)
                            .addComponent(lblErrorEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jLabel6)
                                .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblErrorNS)
                            .addComponent(lblErrorDC))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblErrorDiem)
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(chkAdmin)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnXoaAll)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblErrorSDT)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radNam)
                            .addComponent(radNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorGT)
                        .addGap(94, 94, 94)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(txtRestore)
                    .addComponent(btnReset))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtHoTen.setText("");
        txtSoDT.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtNgay.setText("");
        txtThang.setText("");
        txtNam.setText("");
        txtDiem.setText("");
        radNam.setSelected(false);
        radNu.setSelected(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int response = JOptionPane.showConfirmDialog(
            null,
            "Bạn có chắc chắn muốn xoá vĩnh viễn?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            // Hành động khi người dùng chọn Yes
            String username = txtUsername.getText();
            UserDAO userDAO = new UserDAO();
            try {
                boolean result = userDAO.deleteUserForever(username);
                if(result){
                    resetData();
                    showData();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PnlAdDeletedUs.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PnlAdDeletedUs.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (response == JOptionPane.NO_OPTION) {
            // Hành động khi người dùng chọn No
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaAllMouseClicked
        int response = JOptionPane.showConfirmDialog(
            null,
            "Bạn có chắc chắn muốn xoá?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            // Hành động khi người dùng chọn Yes

        } else if (response == JOptionPane.NO_OPTION) {
            // Hành động khi người dùng chọn No
            return;
        }
    }//GEN-LAST:event_btnXoaAllMouseClicked

    private void txtRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRestoreActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        UserDAO userDAO = new UserDAO();
        try {
            boolean result = userDAO.userRestore(username);
            if(result){
                resetData();
                showData();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlAdDeletedUs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PnlAdDeletedUs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtRestoreActionPerformed

    private void tbAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAccMouseClicked
        // TODO add your handling code here:
        int row =this.tbAcc.getSelectedRow();
        String username = this.tbAcc.getModel().getValueAt(row,0).toString();
        txtUsername.setText(username);
    }//GEN-LAST:event_tbAccMouseClicked

    private void btnXoaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaAllActionPerformed

    private void btnXoaTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTimActionPerformed
        try {
            showData();
            btnXoaTim.setEnabled(false);
            btnTim.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(PnlUsAcc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlUsAcc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaTimActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        try {
            String tim = txtTim.getText();
            UserDAO userDAO = new UserDAO();
            DefaultTableModel model = (DefaultTableModel) tbAcc.getModel();
            model.setRowCount(0); // Xóa các dòng cũ trong bảng
            btnTim.setEnabled(false);
            btnXoaTim.setEnabled(true);

            List<User> users = userDAO.getAllUsersByName(tim);

            for (User user : users) {
                if(!user.getIsDeleted())
                    continue;
                Object row[] = new Object[9];  // Đảm bảo khai báo mảng Object để chứa các loại dữ liệu khác nhau
                row[0] = user.getUsername();
                row[1] = user.getFullname();
                row[2] = user.getBirthday().toString();
                // Kiểm tra và chuyển đổi giới tính từ số sang chữ
                row[3] = user.getGender() == 1 ? "Nam" : "Nữ";
                row[4] = user.getEmail();
                row[5] = user.getCity();
                row[6] = user.getPhone();
                row[7] = user.getPoint();
                row[8] = user.getRole();
                // Thêm dòng vào bảng
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PnlUsAcc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlUsAcc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaAll;
    private javax.swing.JButton btnXoaTim;
    private javax.swing.JCheckBox chkAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblErrorDC;
    private javax.swing.JLabel lblErrorDiem;
    private javax.swing.JLabel lblErrorEmail;
    private javax.swing.JLabel lblErrorGT;
    private javax.swing.JLabel lblErrorHT;
    private javax.swing.JLabel lblErrorNS;
    private javax.swing.JLabel lblErrorSDT;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTable tbAcc;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JButton txtRestore;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtThang;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
