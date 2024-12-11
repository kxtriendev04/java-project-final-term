/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controller.UserDAO;
import Models.User;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ldap.Rdn;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class PnlUsAcc extends javax.swing.JPanel {

    /**
     * Creates new form PnlUsAcc
     */
    public PnlUsAcc() throws SQLException, ClassNotFoundException {
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
        cbLoai.removeAllItems();
        cbLoai.addItem("Admin");
        cbLoai.addItem("Staff");
        cbLoai.addItem("Customer");
        chkAdmin.setVisible(false);
        cbLoai.setSelectedIndex(-1);
        btnXoaTim.setEnabled(false);
//        txtTim.setFocusable(false);
        showData();
    }
    public void showData() throws SQLException, ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) tbAcc.getModel();
        model.setRowCount(0); // Xóa các dòng cũ trong bảng

        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getAllUsers();

        for (User user : users) {
            if(user.getIsDeleted())
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
    public void resetData() {
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
        txtUsername.setText("");
        txtUsername.setVisible(false);
        cbLoai.setSelectedIndex(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbAcc = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
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
        btnReset = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        txtThang = new javax.swing.JTextField();
        txtNam = new javax.swing.JTextField();
        lblErrorHT = new javax.swing.JLabel();
        lblErrorNS = new javax.swing.JLabel();
        lblErrorDiem = new javax.swing.JLabel();
        lblErrorSDT = new javax.swing.JLabel();
        lblErrorDC = new javax.swing.JLabel();
        lblErrorEmail = new javax.swing.JLabel();
        lblErrorGT = new javax.swing.JLabel();
        chkAdmin = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        cbLoai = new javax.swing.JComboBox<>();
        btnXoaTim = new javax.swing.JButton();

        tbAcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên TK", "Họ tên", "Ngày sinh", "Giới tính", "Email", "Địa chỉ", "Số ĐT", "Điểm tích luỹ", "Loại tài khoản"
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quản lý danh sách tài khoản");

        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Có thể xem, sửa, xoá");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm: ");

        txtTim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimFocusLost(evt);
            }
        });
        txtTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimMouseClicked(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.setFocusable(false);
        btnTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimMouseClicked(evt);
            }
        });
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel5.setText("Họ tên:");

        jLabel6.setText("Ngày sinh:");

        jLabel7.setText("Điểm tích luỹ: ");

        jLabel8.setText("Email:");

        jLabel9.setText("Địa chỉ:");

        jLabel10.setText("Số ĐT: ");

        jLabel11.setText("Giới tính: ");

        radNam.setText("Nam");
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamActionPerformed(evt);
            }
        });

        radNu.setText("Nữ");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        lblErrorHT.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorHT.setText("jLabel2");

        lblErrorNS.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorNS.setText("jLabel12");

        lblErrorDiem.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorDiem.setText("jLabel13");

        lblErrorSDT.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorSDT.setText("jLabel14");

        lblErrorDC.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorDC.setText("jLabel15");

        lblErrorEmail.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorEmail.setText("jLabel16");

        lblErrorGT.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorGT.setText("jLabel17");

        chkAdmin.setText("Tài khoản admin");

        jLabel12.setText("Loại tài khoản:");

        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnXoaTim.setText("Reset");
        btnXoaTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaTimMouseClicked(evt);
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
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cbLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblErrorSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                        .addComponent(lblErrorDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(6, 6, 6))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(chkAdmin)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail)
                                .addComponent(txtDiaChi)
                                .addComponent(txtSoDT, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(lblErrorEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(lblErrorGT)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radNu)))))
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
                                .addComponent(jLabel11))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblErrorGT)
                        .addGap(65, 65, 65)))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radNam)
                        .addComponent(radNu)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorSDT)
                        .addGap(18, 18, 18)
                        .addComponent(chkAdmin))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCapNhat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnReset))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed

    public boolean checkHT(){
        String name = txtHoTen.getText();
        if(name.equals("")){
            lblErrorHT.setText("Họ tên không được bỏ trống. ");
            return false;
        }
        lblErrorHT.setText("");
        return true;
    }
    
    public boolean checkDC(){
        String name = txtDiaChi.getText();
        if(name.equals("")){
            lblErrorDC.setText("Địa chỉ không được bỏ trống. ");
            return false;
        }
        lblErrorDC.setText("");
        return true;
    }
    public boolean checkDate(){
        try{
            int day = Integer.parseInt(txtNgay.getText());
            int month = Integer.parseInt(txtThang.getText());
            int year = Integer.parseInt(txtNam.getText());
            LocalDate currentDate = LocalDate.now();
            LocalDate ageLimitDate = currentDate.minusYears(13); //lấy ngày hiện tại trừ 13 năm
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

            // Số ngày trong các tháng
            int[] daysInMonth = {31, 28 + (isLeapYear ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            // Kiểm tra tháng
            if (month < 1 || month > 12) {
                lblErrorNS.setText("Tháng không hợp lệ. ");
                return false;
            }
               
            // Kiểm tra ngày
            if (day < 1 || day > daysInMonth[month - 1]) {
                lblErrorNS.setText("Ngày không hợp lệ. ");
                return false;
            }
                
            // Kiểm tra năm
            if(year < 1900 || year > currentDate.getYear()){
                lblErrorNS.setText("Năm nhập không hợp lệ. ");
                return false;
            }
            
            LocalDate userDate = LocalDate.of(year, month, day); //Tạo đối tượng lưu ngày nhập
            if (userDate.isAfter(ageLimitDate)) {
                lblErrorNS.setText("Tuổi phải lớn hơn 13.");
                return false;
            }
            
            lblErrorNS.setText("");
            return true;
        }catch(Exception e){
            lblErrorNS.setText("Ngày sinh bị bỏ trống hoặc điền sai định dạng. ");
            return false;
        }
    }
    
    public boolean checkEmail(){
        String email = txtEmail.getText();
        if(email.equals("")){
            lblErrorEmail.setText("Email đang bị bỏ trống. ");
            return false;
        }
            
        if (!email.contains("@")){
            lblErrorEmail.setText("Chưa đúng định dạng email. ");
            return false;
        }
        
        lblErrorEmail.setText("");
        return true;
    }
    
    public boolean checkSdt(){
        String sdt = txtSoDT.getText();
        
        if(sdt.equals("")){
            lblErrorSDT.setText("Số điện thoại không được bỏ trống. ");
            return false;
        }
        
        if(sdt.charAt(0) != '0' || sdt.length() != 10 || !sdt.matches("\\d+")){
            lblErrorSDT.setText("Số điện thoại không hợp lệ. ");
            return false;
        }
        
        lblErrorSDT.setText("");
        return true;
    }
    
    public boolean checkGender(){
        if(!radNam.isSelected() && !radNu.isSelected()){
            lblErrorGT.setText("Bạn chưa chọn giới tính. ");
            return false;
        }
        lblErrorGT.setText("");
        return true;
    }
    
    public boolean checkDiem(){
        try{
            if(Integer.parseInt(txtDiem.getText()) < 0){
                lblErrorDiem.setText("Điểm không hợp lệ");
                return false;
            }
            lblErrorDiem.setText("");
            return true;
        }catch(Exception ex){
            lblErrorDiem.setText("Chưa nhập điểm");
            return false;
        }
    }
    
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        boolean error =  checkHT() && checkDate() && checkDiem()  && checkDC() && checkEmail() && checkSdt() && checkGender();
        if(error){
            try {
                //int userId, String username, String fullname, LocalDate birth, boolean gender, String email, String phone, String point, String role
                String username = txtUsername.getText();
                String fullname = txtHoTen.getText();
                int day = Integer.parseInt(txtNgay.getText());
                int month = Integer.parseInt(txtThang.getText());
                int year = Integer.parseInt(txtNam.getText());
                LocalDate date = LocalDate.of(year, month, day);
                boolean gender = false;
                if(radNam.isSelected())
                    gender = true;
                String email = txtEmail.getText();
                String phone = txtSoDT.getText();
                String address = txtDiaChi.getText();
                int point = Integer.parseInt(txtDiem.getText());
                String role = (String) cbLoai.getSelectedItem();
//                if(chkAdmin.isSelected())
//                    role = "Admin";
                
                UserDAO userDAO = new UserDAO();
                userDAO.updateUserByUsername(username, fullname, date, gender, email, phone, address ,point, role);
                // updateUserByUsername(String username, String fullname, LocalDate birth, boolean gender, String email, String phone, String city, int point, String role)
                resetData();
                showData();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PnlUsAcc.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PnlUsAcc.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int response = JOptionPane.showConfirmDialog(
            null,
            "Bạn có chắc chắn muốn xoá?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            String username = txtUsername.getText();
            UserDAO userDAO = new UserDAO();
                    resetData();
            try {
                boolean result = userDAO.softDelete(username);
                
                showData();
            } catch (SQLException ex) {
                Logger.getLogger(PnlUsAcc.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PnlUsAcc.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            
        } else if (response == JOptionPane.NO_OPTION) {
            // Hành động khi người dùng chọn No
            return;
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAccMouseClicked
        // TODO add your handling code here:
        try{
            int row =this.tbAcc.getSelectedRow();
            String username = this.tbAcc.getModel().getValueAt(row,0).toString();
            String fullname = this.tbAcc.getModel().getValueAt(row,1).toString();
            String dateStr = this.tbAcc.getModel().getValueAt(row, 2).toString(); // Giả sử cột ngày là cột thứ 2
            LocalDate date = LocalDate.parse(dateStr); // Chuyển String thành LocalDate nếu format là yyyy-MM-dd
            String gender = this.tbAcc.getModel().getValueAt(row,3).toString();
            String email = this.tbAcc.getModel().getValueAt(row, 4).toString();
            String address = this.tbAcc.getModel().getValueAt(row, 5).toString();
            String phone = this.tbAcc.getModel().getValueAt(row, 6).toString();
            int point = Integer.parseInt(this.tbAcc.getModel().getValueAt(row, 7).toString()); 
            String role = this.tbAcc.getModel().getValueAt(row, 8).toString();
            
            cbLoai.setSelectedItem(role);
            txtUsername.setText(username);
            txtHoTen.setText(fullname);
            txtNgay.setText(String.valueOf(date.getDayOfMonth()));
            txtThang.setText(String.valueOf(date.getMonthValue()));
            txtNam.setText(String.valueOf(date.getYear()));
             if("Nam".equals(gender))
                radNam.setSelected(true);
            else
                radNu.setSelected(true);
            txtEmail.setText(email);
            txtDiaChi.setText(address);
            txtSoDT.setText(phone);
            txtDiem.setText(String.valueOf(point));
            
//            if("Admin".equals(role))
//                chkAdmin.setSelected(true);
//            else
//                chkAdmin.setSelected(false);
        } catch(Exception ex){
            printStackTrace();
        }
    }//GEN-LAST:event_tbAccMouseClicked

    private void btnTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimMouseClicked
        // TODO add your handling code here:
        try {
            String tim = txtTim.getText();
            UserDAO userDAO = new UserDAO();
            DefaultTableModel model = (DefaultTableModel) tbAcc.getModel();
            model.setRowCount(0); // Xóa các dòng cũ trong bảng
            btnTim.setEnabled(false);
            btnXoaTim.setEnabled(true);

            List<User> users = userDAO.getAllUsersByName(tim);

            for (User user : users) {
                if(user.getIsDeleted())
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
        
    }//GEN-LAST:event_btnTimMouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnXoaTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaTimMouseClicked
        try {
            showData();
            btnXoaTim.setEnabled(false);
            btnTim.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(PnlUsAcc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlUsAcc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaTimMouseClicked

    private void txtTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimMouseClicked
        // TODO add your handling code here:
//        if("Tên tài khoản".equals(txtTim.getText())){
//            txtTim.setText("");
//        }
    }//GEN-LAST:event_txtTimMouseClicked

    private void txtTimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimFocusLost
        // TODO add your handling code here:
//        if("".equals(txtTim.getText())){
//            txtTim.setText("");
//        }
    }//GEN-LAST:event_txtTimFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTim;
    private javax.swing.JComboBox<String> cbLoai;
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
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtThang;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void printStackTrace() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
