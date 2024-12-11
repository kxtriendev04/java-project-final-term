package Views;

import Controller.BookingDAO;
import Controller.ChartDAO;
import Controller.FoodDetailsDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;

public class PnlAdThongKe extends javax.swing.JPanel {

    public PnlAdThongKe() {
        initComponents();
        showData();
        lbl1.setVisible(false);
        lbl2.setVisible(false);
        
    }
    public void showData(){
        BookingDAO BookingDAO = new BookingDAO();
        try {
            List<List<Integer>> monthYears = BookingDAO.getBookingMonthYear();
            
            DefaultTableModel model = (DefaultTableModel) tbNam.getModel();
            model.setRowCount(0); // Xóa các dòng cũ trong bảng
            for(List<Integer> item: monthYears){
                Object row[] = new Object[1];
                row[0] = item.get(1);
            
            // Thêm dòng vào bảng
            model.addRow(row);
            }
            System.out.println(monthYears);
        } catch (SQLException ex) {
            Logger.getLogger(PnlAdThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlAdThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNam = new javax.swing.JTable();
        pnDoAn = new javax.swing.JPanel();
        pnVe = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();

        setAutoscrolls(true);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thống kê");

        jScrollPane2.setAutoscrolls(true);

        jPanel1.setAutoscrolls(true);

        tbNam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Năm"
            }
        ));
        tbNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNam);

        pnDoAn.setPreferredSize(new java.awt.Dimension(570, 250));

        javax.swing.GroupLayout pnDoAnLayout = new javax.swing.GroupLayout(pnDoAn);
        pnDoAn.setLayout(pnDoAnLayout);
        pnDoAnLayout.setHorizontalGroup(
            pnDoAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        pnDoAnLayout.setVerticalGroup(
            pnDoAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnVeLayout = new javax.swing.GroupLayout(pnVe);
        pnVe.setLayout(pnVeLayout);
        pnVeLayout.setHorizontalGroup(
            pnVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        pnVeLayout.setVerticalGroup(
            pnVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );

        lbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl1.setText("THỐNG KÊ DOANH SỐ BÁN VÉ");

        lbl2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl2.setText("THỐNG KÊ DOANH SỐ ĐỒ ĂN KÈM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lbl2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lbl1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnDoAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(1091, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnDoAn, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbNamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNamMouseClicked
        // TODO add your handling code here:
        lbl1.setVisible(true);
        lbl2.setVisible(true);
        int row =this.tbNam.getSelectedRow();
        FoodDetailsDAO FoodDetailsDAO = new FoodDetailsDAO();
        BookingDAO BookingDAO = new BookingDAO();
        int year = Integer.parseInt(this.tbNam.getModel().getValueAt(row,0).toString());
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        for(int i = 1; i <= 12; i++){
            try {
                double money1 = BookingDAO.getTotalRevenueByMonth(year, i);
                dataset1.addValue(money1, "Số lượng", ""+i);
                double money2 = FoodDetailsDAO.getTotalFoodRevenueByMonth(year, i);
                dataset2.addValue(money2, "Số lượng", ""+i);
            } catch (SQLException ex) {
                Logger.getLogger(PnlAdThongKe.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PnlAdThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ChartDAO ChartDAO = new ChartDAO();
        ChartDAO.createChartInPn(pnVe, dataset1);
        ChartDAO.createChartInPn(pnDoAn, dataset2);
    }//GEN-LAST:event_tbNamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JPanel pnDoAn;
    private javax.swing.JPanel pnVe;
    private javax.swing.JTable tbNam;
    // End of variables declaration//GEN-END:variables
}
