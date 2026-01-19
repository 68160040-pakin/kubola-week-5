import javax.swing.*;
public class lab2 {
    public static void main(String[] args) {
        // ===== สร้าง JFrame =====
        JFrame frame = new JFrame("GUI with Menu");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ===== สร้าง Menu Bar =====
        JMenuBar menuBar = new JMenuBar();
        // เมนูหลัก
        JMenu menuCalculate = new JMenu("Calculate");
        JMenu menuOther = new JMenu("Others");
        // เมนูย่อย
        JMenuItem itemAdd = new JMenuItem("Add");
        JMenuItem itemSub = new JMenuItem("Subtract");
        JMenuItem itemMultiply = new JMenuItem("Multiply");
        JMenuItem itemName = new JMenuItem("Greeting");
        JMenuItem itemExit = new JMenuItem("Quit");
        // เพิ่มเมนูย่อย
        menuCalculate.add(itemAdd);
        menuCalculate.add(itemSub);
        menuCalculate.add(itemMultiply);
        menuOther.add(itemName);
        menuOther.addSeparator();
        menuOther.add(itemExit);
        // เพิ่มเมนูหลักเข้า MenuBar
        menuBar.add(menuCalculate);
        menuBar.add(menuOther);
        // ตั้งค่า MenuBar ให้ Frame
        frame.setJMenuBar(menuBar);
        // ===== Action ของเมนู =====
        itemAdd.addActionListener(e -> {
            int a = Integer.parseInt(
                    JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(
                    JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Adding result = " + (a + b));
        });
        itemSub.addActionListener(e -> {
            int a = Integer.parseInt(
                    JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(
                    JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Subtract result = " + (a - b));

        });
        itemMultiply.addActionListener(e -> {
            int a = Integer.parseInt(
                    JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(
                    JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Multiply result = " + (a * b));

        });

        itemName.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter name");
            JOptionPane.showMessageDialog(frame, "Hello " + name);
        });
        itemExit.addActionListener(e -> {
            System.exit(0);
        });
        // ===== แสดงหน้าต่าง =====
        frame.setVisible(true);
    }
}