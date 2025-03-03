/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controller.RoomDAO;
import Models.Room;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class PnlAdDeletedPhong extends javax.swing.JPanel {

    /**
     * Creates new form PnlAdDeletedPhong
     */
    public PnlAdDeletedPhong() {
        initComponents();
        txtMaPhong.setVisible(false);
        btnXoaTim.setEnabled(false);
        try {
            showData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlAdDeletedPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PnlAdDeletedPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void showData() throws ClassNotFoundException, SQLException {
        DefaultTableModel model = (DefaultTableModel) tbPhong.getModel();
        model.setRowCount(0); // Xóa các dòng cũ trong bảng

        RoomDAO roomDAO = new RoomDAO();
        List<Room> rooms = roomDAO.getAllRoom();

        for (Room room : rooms) {
            if(!room.isDeleted())
                continue;
            Object row[] = new Object[3];
            row[0] = room.getRoomId();
            row[1] = room.getRoomName();
            row[2] = room.getRoomType();
            
            // Thêm dòng vào bảng
            model.addRow(row);
        }
    }
    public void resetData() {
        txtMaPhong.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        btnXoaAll = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPhong = new javax.swing.JTable();
        btnRestore = new javax.swing.JButton();
        btnXoaTim = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm: ");

        txtTim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnXoa.setText("Xoá vĩnh viễn");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quản lý thùng rác phòng chiếu phim");

        txtMaPhong.setText("không được xóa");
        txtMaPhong.setEnabled(false);

        btnXoaAll.setText("Xoá tất cả");
        btnXoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAllActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Có thể xem, xoá");

        tbPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Phòng", "Tên Phòng", "Loại phòng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPhong);

        btnRestore.setText("Khôi phục");
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
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
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnXoaTim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTim))
                    .addComponent(btnXoaTim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int response = JOptionPane.showConfirmDialog(
            null,
            "Bạn có chắc chắn muốn xoá?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            // Hành động khi người dùng chọn Yes
            int id = Integer.parseInt(txtMaPhong.getText());
            RoomDAO roomDAO = new RoomDAO();
            try {
                if(roomDAO.deleteRoomForever(id)){
                    resetData();
                    showData();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PnlAdDeletedPhong.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PnlAdDeletedPhong.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (response == JOptionPane.NO_OPTION) {
            // Hành động khi người dùng chọn No
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAllActionPerformed
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
    }//GEN-LAST:event_btnXoaAllActionPerformed

    private void tbPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhongMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
         int row =this.tbPhong.getSelectedRow();
         String id = this.tbPhong.getModel().getValueAt(row,0).toString();
         txtMaPhong.setText(id);
    }//GEN-LAST:event_tbPhongMouseClicked

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(txtMaPhong.getText());
        RoomDAO roomDAO = new RoomDAO();
        try {
            if(roomDAO.roomRestore(id)){
                resetData();
                showData();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlAdDeletedPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PnlAdDeletedPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRestoreActionPerformed

    private void btnXoaTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTimActionPerformed
        try {
            showData();
            btnXoaTim.setEnabled(false);
            btnTim.setEnabled(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlAdPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PnlAdPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaTimActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tbPhong.getModel();
            model.setRowCount(0); // Xóa các dòng cũ trong bảng
            
            RoomDAO roomDAO = new RoomDAO();
            Room room = roomDAO.getAllRoomById(Integer.parseInt(txtTim.getText()));
            btnXoaTim.setEnabled(true);
            btnTim.setEnabled(false);
            if(room != null)
                if(room.isDeleted()){
                    Object row[] = new Object[3];
                    row[0] = room.getRoomId();
                    row[1] = room.getRoomName();
                    row[2] = room.getRoomType();

                    // Thêm dòng vào bảng
                    model.addRow(row);
                }
                else
                    return;
            else
                return;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlAdPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PnlAdPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaAll;
    private javax.swing.JButton btnXoaTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPhong;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
