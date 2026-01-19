import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class lab4 {


    public static void main(String[] args) {


        // สร้าง Frame
        JFrame frame = new JFrame("Progam with JTextArea");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // สร้าง TextArea
        JTextArea textArea = new JTextArea(8, 30);
        textArea.setLineWrap(true);       // ตัดบรรทัดอัตโนมัติ
        textArea.setWrapStyleWord(true);  // ตัดตามคำ


        // ใส่ ScrollBar ให้ TextArea
        JScrollPane scrollPane = new JScrollPane(textArea);


        // สร้างปุ่ม
        JPanel p1 = new JPanel();
        JButton button = new JButton("Show message");
        JButton Save = new JButton("Save");
        p1.add(button);
        p1.add(Save);


        // เมื่อกดปุ่ม
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                JOptionPane.showMessageDialog(frame, text,
                        "Your message: ", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();


                File dir = new File("D:\\68160018");
                if (!dir.exists()) {
                    dir.mkdirs(); // สร้างโฟลเดอร์
                }


                File file = new File(dir, "Message.txt");


                try {
                    FileWriter fw = new FileWriter(file);
                    fw.write(text);
                    fw.close();


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        // จัด Layout
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(p1, BorderLayout.SOUTH);


        // แสดงหน้าจอ
        frame.setVisible(true);
    }
}