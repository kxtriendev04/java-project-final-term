/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Laptop88
 */
public class UIHelper {
     public static void setAppProperties(JFrame frame, String title, String iconPath) {
        frame.setTitle(title); // Đặt tiêu đề
        ImageIcon icon = new ImageIcon(iconPath); // Tải ảnh
        frame.setIconImage(icon.getImage()); // Đặt biểu tượng
    }
     public static void setAppLogo(JFrame frame) {
        frame.setTitle("DDL Cinema"); // Đặt tiêu đề
        ImageIcon icon = new ImageIcon("/images/app_logo.png"); // Tải ảnh
        frame.setIconImage(icon.getImage()); // Đặt biểu tượng
    }
}
