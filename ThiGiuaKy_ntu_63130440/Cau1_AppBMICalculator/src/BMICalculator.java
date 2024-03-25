import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculator extends JFrame implements ActionListener {

    // ...
    private JLabel lblHeight, lblWeight, lblBMI, lblResult;
    private JTextField txtHeight, txtWeight;
    private JButton btnCalculate;
    private JTextArea txtResultArea;

    public BMICalculator() {
        setTitle("Tính chỉ số BMI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Khởi tạo các thành phần giao diện
        lblHeight = new JLabel("Chiều cao (m):");
        lblWeight = new JLabel("Cân nặng (kg):");
        lblBMI = new JLabel("Chỉ số BMI:");
        lblResult = new JLabel("Kết quả:");

        // Set wider text fields (adjust columns as needed)
        txtHeight = new JTextField(10);  // 10 columns wide
        txtWeight = new JTextField(10);

        btnCalculate = new JButton("Tính toán");
        btnCalculate.addActionListener(this);

        txtResultArea = new JTextArea();
        txtResultArea.setEditable(false);

        // Bố cục giao diện
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblHeight, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtHeight, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblWeight, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtWeight, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(btnCalculate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblBMI, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(txtResultArea, gbc);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Lấy dữ liệu từ giao diện
            double height = Double.parseDouble(txtHeight.getText());
            double weight = Double.parseDouble(txtWeight.getText());

            // Tính toán chỉ số BMI
            double bmi = weight / (height * height);

            // Phân loại mức độ béo phì
            String result = "";
            if (bmi < 18.5) {
                result = "Thiếu cân";
            } else if (bmi < 25) {
                result = "Bình thường";
            } else if (bmi < 30) {
                result = "Thừa cân";
            } else {
                result = "Béo phì";
            }

            // Hiển thị kết quả
            txtResultArea.setText("Chỉ số BMI của bạn là: " + String.format("%.2f", bmi) + "\n"
                    + "Kết quả: " + result);
        } catch (NumberFormatException ex) {
            // Hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào không hợp lệ! Vui lòng nhập số thực.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new BMICalculator().setVisible(true);
    }
}