import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class lab8 {
    static File currentFile = null;
    public static void main(String[] args) {

        // สร้าง JFrame
        JFrame frame = new JFrame("Patcharapa Chu 68160160 n88");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ===== สร้าง Menu Bar =====
        JMenuBar menuBar = new JMenuBar();
        // เมนูหลัก
        JMenu menuFile = new JMenu("File");

        // เมนูย่อย
        JMenuItem itemNew = new JMenuItem("New");
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemSave = new JMenuItem("Save");
        JMenuItem itemSaveAs = new JMenuItem("Save As");
        JMenuItem itemExit = new JMenuItem("Quit");
        // เพิ่มเมนูย่อย
        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.add(itemSave);
        menuFile.add(itemSaveAs);
        menuFile.add(itemExit);
        // เพิ่มเมนูหลักเข้า MenuBar
        menuBar.add(menuFile);
        // ตั้งค่า MenuBar ให้ Frame
        frame.setJMenuBar(menuBar);


        // TextArea สำหรับแสดงข้อความ
        JTextArea textArea = new JTextArea();
        textArea.setEditable(true);

        // ใส่ ScrollBar
        JScrollPane scrollPane = new JScrollPane(textArea);


        frame.add(scrollPane, BorderLayout.CENTER);

        // เหตุการณ์เมื่อกดปุ่ม
        itemNew.addActionListener(e -> {
            textArea.setText("");
            currentFile = null;
            frame.setTitle("New File");
        });
        itemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {

                    File file = fileChooser.getSelectedFile();

                    try {
                        BufferedReader reader = new BufferedReader(
                                new FileReader(file)
                        );

                        textArea.setText(""); // ล้างข้อความเก่า
                        String line;

                        while ((line = reader.readLine()) != null) {
                            textArea.append(line + "\n");
                        }

                        reader.close();

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(
                                frame,
                                "Cannot read file.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            }
        });
        itemSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);


                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();


                    try {
                        PrintWriter writer = new PrintWriter(file);
                        writer.write(textArea.getText());
                        writer.close();


                        JOptionPane.showMessageDialog(frame,
                                "Save file successfully.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame,
                                "Error. Unable to save file.");
                    }
                }
            }
        });
        itemSaveAs.addActionListener(e -> {

            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {

                currentFile = fileChooser.getSelectedFile();

                try (PrintWriter writer = new PrintWriter(currentFile)) {
                    writer.write(textArea.getText());
                    JOptionPane.showMessageDialog(frame, "Save file successfully.");
                    frame.setTitle(currentFile.getName());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Unable to save file.");
                }
            }
        });
        itemExit.addActionListener(e -> {
            System.exit(0);
        });

        // แสดงหน้าต่าง
        frame.setVisible(true);
    }
}