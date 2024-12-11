package Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartDAO {
    public ChartDAO(){
        
    }
    public void createChartInPn(JPanel pn, DefaultCategoryDataset dataset) {
        // Tạo dữ liệu cho biểu đồ
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Tạo biểu đồ cột
        JFreeChart barChart = ChartFactory.createBarChart(
//                "Biểu đồ thống kê doanh thu".toUpperCase(), // Tiêu đề
                "",
                "Tháng",
                "Việt Nam đồng", 
                dataset,
                PlotOrientation.VERTICAL,
                false, 
                true,
                false 
        );
        // Thêm biểu đồ vào ChartPanel
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setMouseWheelEnabled(false); // Cho phép zoom bằng chuột


        // Đảm bảo ChartPanel lấp đầy toàn bộ không gian trong pnMain
        chartPanel.setPreferredSize(new Dimension(pn.getWidth(), pn.getHeight())); // Đặt kích thước phù hợp với pnMain
        chartPanel.setMinimumSize(new Dimension(300, 200)); // Đặt kích thước tối thiểu nếu pnMain quá nhỏ

        // Thêm ChartPanel vào JPanel pnMain
        pn.setLayout(new BorderLayout());  // Đảm bảo layout của pnMain là BorderLayout
        pn.add(chartPanel, BorderLayout.CENTER); // Thêm chartPanel vào phần CENTER của pnMain

        // Cập nhật lại JPanel để hiển thị biểu đồ
        pn.revalidate();
        pn.repaint();
    }
}
