
package Views;

import Controller.BillDAO;
import Controller.BookingDAO;
import Controller.BookingDetailsDAO;
import Controller.FoodDetailsDAO;
import Controller.RoomScheduleMovieDAO;
import Controller.ScheduleDAO;
import Controller.SeatDAO;
import Controller.UserDAO;
import Models.Booking;
import Models.BookingDetails;
import Models.RoomScheduleMovie;
import Models.Schedule;
import Models.Seat;
import Models.User;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author nguye
 */
public class PnlChoNgoi extends javax.swing.JPanel {

    /**
     * Creates new form PnlChoNgoi
     */
//    private int scheduleId;
    private JLabel[][] labels = new JLabel[5][5];
//    private Frame currentFrame = this;
    private Schedule curentSchedule = null;
    private User currentUser;
    private List<Integer> selectedSeats = new ArrayList<>(); // is selecting
    private int bong, nuoc, combo1, combo2;
    private float tongVe, tongDoAn, tongTienDiem, tongTienThanhToan;
    
    public PnlChoNgoi(int scheduleId, User user) {
        initComponents();
        pnlMain.setLayout(new GridLayout(5, 5, 10, 10));
        pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        initLabels(scheduleId, user);
        btnThanhToan.setEnabled(false);
//        int discount = user.getPoint() * 1000;
        tongTienDiem = user.getPoint() * 1000;
        chkDiem.setText("Sử dụng " + user.getPoint() + " điểm để giảm " + tongTienDiem + "VND");
    }
    
    private void initLabels(int scheduleId, User user) {
        pnlMain.removeAll();
        currentUser = user;
        System.out.println("Username is booking: " + currentUser.getUsername());
        SeatDAO seatDao = new SeatDAO();
        int[] seatBooked = new int[0]; // Mặc định là mảng rỗng
        try {
            seatBooked = seatDao.getSeatNumbersByScheduleId(scheduleId); // Lấy số ghế đã đặt
            ScheduleDAO ScheduleDAO = new ScheduleDAO();
            curentSchedule = ScheduleDAO.getScheduleById(scheduleId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlChoNgoi.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Duyệt qua hàng và cột để tạo JLabel cho từng ghế
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int seatId = i * 5 + j + 1; // Tạo ID ghế (1-25)
                JLabel label = new JLabel("" + seatId, SwingConstants.CENTER);
                label.setOpaque(true);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // Kiểm tra ghế có nằm trong danh sách đã đặt không
                boolean isBooked = Arrays.stream(seatBooked).anyMatch(x -> x == seatId);

                // Đặt màu ghế: đỏ nếu đã đặt, trắng nếu chưa
                label.setBackground(isBooked ? Color.RED : Color.WHITE);

                // Xử lý sự kiện click chuột
                label.addMouseListener(new MouseAdapter() {
                    @Override
                        public void mouseClicked(MouseEvent e) {
                        if (label.getBackground() == Color.CYAN) {
                            label.setBackground(Color.WHITE); // Trở lại trạng thái ban đầu
                            selectedSeats.remove((Integer) seatId); // Loại bỏ ghế khỏi danh sách
                        } else if (label.getBackground() == Color.WHITE) {
                            label.setBackground(Color.CYAN); // Đổi màu khi được chọn
                            selectedSeats.add(seatId); // Thêm ghế vào danh sách
                            updateSeatSelecting();
                            btnThanhToan.setEnabled(true);
                        }
                        System.out.println("Selected Seats: " + selectedSeats); // Debug danh sách ghế đã chọn
                    }
                });

                // Gán vào mảng labels và thêm vào giao diện
                labels[i][j] = label;
                pnlMain.add(label);
            }
        }
        
    }
    public void updateSeatSelecting(){
        float totalAmount = 0;
        for(int i : selectedSeats){
                if(i <= 10){
                    totalAmount += 50000;
                } else if(i <= 20){
                    totalAmount += 60000;
                }
                else if(i <=25){
                    totalAmount += 70000;
                }
            }
        tongVe = totalAmount;
        lblTongTienGhe.setText("Tổng tiền chỗ ngồi: " + tongVe);
        updateTotalPay();
    }
    public void updateTotalSelecting(){
        tongDoAn = bong * 90000 + nuoc * 50000 + combo1 * 120000 + combo2 * 150000;
        lblTongDoAn.setText( "Tổng tiền đồ ăn kèm: " + tongDoAn);
        lblTongTienGhe.setText("Tổng tiền chỗ ngồi: " + tongVe);
        updateTotalPay();
    }
    public void updateTotalPay(){
//        float total = 0;
        if(chkDiem.isSelected()){
            if(tongVe > tongTienDiem){
                tongTienThanhToan = tongDoAn + tongVe - tongTienDiem;
            } else {
                tongTienThanhToan = tongDoAn;
            }
        } else {
            tongTienThanhToan = tongDoAn + tongVe;
        }
//        float total = tongDoAn + tongVe - tongTienDiem;
        lblTongTienThanhToan.setText("Tổng tiền thanh toán: " + tongTienThanhToan);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThanhToan = new javax.swing.JButton();
        pnlMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        spBong = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        spNuoc = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spCombo1 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spCombo2 = new javax.swing.JSpinner();
        lblTongTienGhe = new javax.swing.JLabel();
        lblTongDoAn = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTongTienThanhToan = new javax.swing.JLabel();
        chkDiem = new javax.swing.JCheckBox();

        btnThanhToan.setText("Thanh toán!");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jLabel1.setText("Màn hình chiếu");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Bỏng ngô: ");

        spBong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spBongStateChanged(evt);
            }
        });

        jLabel3.setText("Nước uống:");

        spNuoc.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spNuocStateChanged(evt);
            }
        });

        jLabel4.setText("Combo 1 bỏng 1 nước:");

        spCombo1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spCombo1StateChanged(evt);
            }
        });

        jLabel5.setText("Combo 2 bỏng 1 nước:");

        spCombo2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spCombo2StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spBong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spBong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lblTongTienGhe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongTienGhe.setText("Tổng tiền chỗ ngồi: 0.0");

        lblTongDoAn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongDoAn.setText("Tổng tiền đồ ăn kèm: 0.0");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel8.setText("Ghế Thường (Từ ghế 1 tới 10): 50.000đ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel9.setText("Ghế Vip (Từ ghế 10 tới 20): 60.000đ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel10.setText("Ghế Siêu Vip (Từ ghế 20 tới 25): 70.000đ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTongTienThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongTienThanhToan.setText("Tổng tiền thanh toán: 0.0");

        chkDiem.setText("Sử dụng điểm");
        chkDiem.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkDiemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTongTienGhe)
                            .addComponent(lblTongDoAn)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTongTienThanhToan)
                            .addComponent(chkDiem)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkDiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(lblTongTienGhe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongDoAn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongTienThanhToan)))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        
        if(!btnThanhToan.isEnabled()){
            return;
        }
        // Kiểm tra user tồn tại và có ghế đang chọn
        if(currentUser == null){
            System.out.println("Vui lòng đăng nhập để đặt vé");
            return;
        }
        else if(selectedSeats.isEmpty()){
            System.out.println("Vui lòng chọn ghế ngồi trước khi thanh toán");
        }
        
        //Dữ liệu cho hóa đơn:
        RoomScheduleMovieDAO roomScheduleMovieDAO = new RoomScheduleMovieDAO();
        RoomScheduleMovie roomScheduleMovie = null;
        try {
            roomScheduleMovie = roomScheduleMovieDAO.getRoomScheduleMovieByScheduleId(curentSchedule.getScheduleId());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlChoNgoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cinemaName = "DDL CINEMA";
        String movieTitle = roomScheduleMovie.getMovieName();
        String timeBooking = "";
        String schedule =  curentSchedule.getScheduleStart() + ", " + curentSchedule.getScheduleDate(); // "20:00, Ngày 19/11/2024";
        String customerName = currentUser.getFullname();
        String room = roomScheduleMovie.getRoomName();
        String address = "234 Hoàng Quốc Việt, Hà Nội";
        int bookingId;

        List<String[]> servicePrice = new ArrayList<>();
        
        
        try{
            // Lấy userId và scheduleId roomId
            int userId = currentUser.getUserId();
            int scheduleId = curentSchedule.getScheduleId();
            int roomId = curentSchedule.getRoomId();
            // Tính tổng tiền:
            float totalAmount = 0;
            for(int i : selectedSeats){
                String[] servicePriceItem = null;
                if(i <= 10){
                    totalAmount += 50000;
                    servicePriceItem = new String[] {"Ghế " + i, "50000"};
                } else if(i <= 20){
                    totalAmount += 60000;
                    servicePriceItem = new String[] {"Ghế " + i, "60000"};
                }
                else if(i <=25){
                    totalAmount += 70000;
                    servicePriceItem = new String[] {"Ghế " + i, "70000"};
                }
//                seatInfo += " ," + i;
                servicePrice.add(servicePriceItem);
            }
            // Xử lý điểm của User
            if(chkDiem.isSelected()){
                int point = (int) tongTienThanhToan * 5 / 100;
                UserDAO UserDAO = new UserDAO();
                UserDAO.updatePointByUserId(userId, point);
            }
            
            // Thêm đồ ăn vào 
            if(bong > 0){
                float total = bong * 90000;
                servicePrice.add(new String[] { bong + " bỏng ngô ", total + ""});
            }
            if(nuoc > 0){
                float total = nuoc * 50000;
                servicePrice.add(new String[] { nuoc + " bỏng nước ", total + ""});
            }
            if(combo1 > 0){
                float total = combo1 * 120000;
                servicePrice.add(new String[] { combo1 + " combo 1 bỏng 1 nước ", total + ""});
            }
            if(combo2 > 0){
                float total = combo2 * 150000;
                servicePrice.add(new String[] { combo2 + " combo 2 bỏng 1 nước ", total + ""});
            }
            
            // Thêm dữ liệu vào bảng booking
            BookingDAO bookingDAO = new BookingDAO();
            SeatDAO seatDao = new SeatDAO();
            BookingDetailsDAO bookingDetailsDAO = new BookingDetailsDAO();
            LocalDate bookingDate = LocalDate.now();
            LocalTime bookingTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
            timeBooking = bookingDate.toString()+", " +  bookingTime.toString() + "";
            Booking booking = new Booking(userId, scheduleId, bookingDate, bookingTime, totalAmount, "Đặt Online", false);
//            boolean rsBooking = bookingDAO.addBooking(booking);
//            if(rsBooking){
//                System.out.println("Thêm booking thành công!");
//            }
            bookingId = bookingDAO.addBooking(booking);
            if(bookingId > 0)
                System.out.println("Add booking successfully!");
            // Lấy mã booking từ userId và scheduleId
//            int bookingId = bookingDAO.getBookingByUserIdAndScheduleId(userId, scheduleId).getBookingId();
            
            // Xử lý add FoodDetail
            FoodDetailsDAO FoodDetailsDAO = new FoodDetailsDAO();
            //int bookingId, int userId, String foodName, double price, int quantity, String description
            if(bong > 0){
               if(FoodDetailsDAO.addFoodBooking(bookingId, userId, "Bỏng ngô", bong * 90000, bong, "")){
                   System.out.println("Add FooodBooking successfully!");
               }
            }
            if(nuoc > 0){
               FoodDetailsDAO.addFoodBooking(bookingId, userId, "Nước", nuoc * 50000, nuoc, "");
                
            }
            if(combo1 > 0){
               FoodDetailsDAO.addFoodBooking(bookingId, userId, "Combo1", combo1 * 120000, combo1, "");
                
            }
            if(combo2 > 0){
               FoodDetailsDAO.addFoodBooking(bookingId, userId, "Combo2", combo2 * 150000, combo2, "");
                
            }
            // Xử lý add Seat and Booking_detail (Nhiều seat)
            for(int i : selectedSeats){
                // i = seatId
                // Xử lý tạo Seat và Booking_detail
                String type = "";
                float seatPrice = 0;
                if(i <= 10){
                   type = "Ghế thường";
                   seatPrice = 50000;
                } else if(i <= 20){
                    seatPrice = 60000;
                    type = "Ghế vip";
                } else if(i <=25){
                    type = "XVIP";
                    seatPrice = 70000;
                }
                // number = i

                Seat seat = new Seat(type, roomId, scheduleId, i, 0, false);
                int seatId = seatDao.addSeat(seat); // Hàm thêm seat và trả về seatId đã thêm
                if(seatId > 0){
                    System.out.println("Add seat" + i + " successfully!!!");
                }
                
                // Xử lý tạo Booking_Detail
                // Đã có bookingId, roomId, seatId, 
                BookingDetails BookingDetails = new BookingDetails(bookingId, seatId, seatPrice);
                boolean result = bookingDetailsDAO.addBookingDetail(BookingDetails);
                if(result){
                    System.out.println("Add BookingDetail Successfully!");
                }
            }
            
            String filePath = "";
            // Tạo JFileChooser để mở cửa sổ chọn file
            JFileChooser fileChooser = new JFileChooser();

            // Cấu hình JFileChooser để cho phép chọn thư mục lưu file
            fileChooser.setDialogTitle("Chọn vị trí lưu file");
            fileChooser.setSelectedFile(new File("movie_bill_DDL_" + bookingId +".pdf")); // Tên tệp mặc định

            // Mở cửa sổ chọn file và kiểm tra nếu người dùng chọn tệp
            int userSelection = fileChooser.showSaveDialog(null);
            // Kiểm tra kết quả chọn file
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Lấy đường dẫn tệp người dùng chọn
                File fileToSave = fileChooser.getSelectedFile();
                filePath = fileToSave.getAbsolutePath();
            }
            BillDAO billDAO = new BillDAO();
            boolean resultFinal = billDAO.createInvoice(filePath, cinemaName, movieTitle, timeBooking, room, schedule, address, customerName, bookingId, servicePrice, tongTienThanhToan);
            if(resultFinal){
                int response = JOptionPane.showConfirmDialog(
                    this,
                    "Đã tạo hóa đơn của bạn thành công!!!",
                    "Xác nhận",
                    JOptionPane.DEFAULT_OPTION, // Thay OK_OPTION bằng DEFAULT_OPTION
                    JOptionPane.INFORMATION_MESSAGE
                );
                // Kiểm tra nếu người dùng chọn "OK"
                if (response == JOptionPane.OK_OPTION) {
                    btnThanhToan.setEnabled(false);
//                    pnlMain.setEnabled(false);
                // Reset giá trị
                spBong.setValue(0);
                spNuoc.setValue(0);
                spCombo1.setValue(0);
                spCombo2.setValue(0);
                tongDoAn = 0; tongVe = 0;
                lblTongDoAn.setText("Tổng tiền chỗ ngồi: 0.0");
                lblTongTienGhe.setText("Tổng tiền đồ ăn kèm: 0.0");
                lblTongTienThanhToan.setText("Tổng tiền thanh toán: 0.0");
                
                // Xử lý ghế đang đặt
                initLabels(scheduleId, currentUser);
//                for(int i : selectedSeats){
//                    
//                }
                
//                updateTotalSelecting();
                }
            }
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void spBongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spBongStateChanged
        // TODO add your handling code here:
        int count = Integer.parseInt(spBong.getValue().toString());
        if(count < 0){
            spBong.setValue(0);
            return;
        }
        bong = count;
        updateTotalSelecting();
    }//GEN-LAST:event_spBongStateChanged

    private void spNuocStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spNuocStateChanged
        // TODO add your handling code here:
        int count = Integer.parseInt(spNuoc.getValue().toString());
        if(count < 0){
            spNuoc.setValue(0);
            return;
        }
        nuoc = count;
        updateTotalSelecting();
    }//GEN-LAST:event_spNuocStateChanged

    private void spCombo1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spCombo1StateChanged
        // TODO add your handling code here:
        int count = Integer.parseInt(spCombo1.getValue().toString());
        if(count < 0){
            spCombo1.setValue(0);
            return;
        }
        combo1 = Integer.parseInt(spCombo1.getValue().toString());
        updateTotalSelecting();
    }//GEN-LAST:event_spCombo1StateChanged

    private void spCombo2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spCombo2StateChanged
        // TODO add your handling code here:spCombo1
        int count = Integer.parseInt(spCombo2.getValue().toString());
        if(count < 0){
            spCombo2.setValue(0);
            return;
        }
        combo2 = Integer.parseInt(spCombo2.getValue().toString());
        updateTotalSelecting();
    }//GEN-LAST:event_spCombo2StateChanged

    private void chkDiemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkDiemStateChanged
        // TODO add your handling code here:
        if(tongVe == 0){
            return;
        }
        updateTotalPay();
    }//GEN-LAST:event_chkDiemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JCheckBox chkDiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTongDoAn;
    private javax.swing.JLabel lblTongTienGhe;
    private javax.swing.JLabel lblTongTienThanhToan;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JSpinner spBong;
    private javax.swing.JSpinner spCombo1;
    private javax.swing.JSpinner spCombo2;
    private javax.swing.JSpinner spNuoc;
    // End of variables declaration//GEN-END:variables
}
