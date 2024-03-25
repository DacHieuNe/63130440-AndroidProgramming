import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BMICalculator extends JFrame implements ActionListener {

    private static final String[] unitsHeight = {"Mét (m)", "Inch (in)"};
    private static final String[] unitsWeight = {"Kilogram (kg)", "Pound (lb)"};

    private JLabel lblHeight, lblWeight, lblBMI, lblResult;
    private JTextField txtHeight, txtWeight;
    private JButton btnCalculate, btnSave;
    private JTextArea txtResultArea;
    private JList<String> unitListHeight, unitListWeight;

    private double heightValue = 0;
    private double weightValue = 0;
    private String selectedUnitHeight = unitsHeight[0]; // Default unit
    private String selectedUnitWeight = unitsWeight[0]; // Default unit

    public BMICalculator() {
        setTitle("Tính chỉ số BMI");
        setSize(500, 350); // Adjust size as needed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        lblHeight = new JLabel("Chiều cao:");
        lblWeight = new JLabel("Cân nặng:");
        lblBMI = new JLabel("Chỉ số BMI:");
        lblResult = new JLabel("Kết quả:");

        // Text fields
        txtHeight = new JTextField(10);
        txtWeight = new JTextField(10);

        // Buttons
        btnCalculate = new JButton("Tính toán");
        btnCalculate.addActionListener(this);
        btnSave = new JButton("Lưu kết quả");
        btnSave.addActionListener(this);

        // Text area
        txtResultArea = new JTextArea();
        txtResultArea.setEditable(false);

        // Unit selection (JList)
        unitListHeight = new JList<>(unitsHeight);
        unitListHeight.setSelectedIndex(0); // Select default unit
        unitListWeight = new JList<>(unitsWeight);
        unitListWeight.setSelectedIndex(0); // Select default unit

        // Panel layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblHeight, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtHeight, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(unitListHeight, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblWeight, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtWeight, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(unitListWeight, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(btnCalculate, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Span 2 columns
        panel.add(btnSave, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Reset span
        panel.add(lblBMI, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(txtResultArea, gbc);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            try {
                // Get values and units
                heightValue = Double.parseDouble(txtHeight.getText());
                weightValue = Double.parseDouble(txtWeight.getText());
                selectedUnitHeight = unitListHeight.getSelectedValue();
                selectedUnitWeight = unitListWeight.getSelectedValue();

                // Convert values based on selected units
                convertUnits(selectedUnitHeight, selectedUnitWeight);

                // Calculate BMI
                double bmi = weightValue / (heightValue * heightValue);

                // Classify BMI
                String result = ""; if (bmi < 18.5) {
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
                JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnSave) {
            // Lưu kết quả vào file
            try {
                String resultText = txtResultArea.getText();
                String filePath = "bmi_result_" + System.currentTimeMillis() + ".txt";
                File file = new File(filePath);

                // Ghi kết quả vào file
                FileWriter writer = new FileWriter(file);
                writer.write(resultText);
                writer.close();

                // Hiển thị thông báo thành công
                JOptionPane.showMessageDialog(this, "Kết quả đã được lưu vào file: " + filePath, "Lưu thành công", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                // Hiển thị thông báo lỗi
                JOptionPane.showMessageDialog(this, "Lỗi khi lưu kết quả!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void convertUnits(String selectedUnitHeight, String selectedUnitWeight) {
        if (selectedUnitHeight.equals(unitsHeight[1])) {
            // Convert from inches to meters
            heightValue *= 0.0254;
            txtHeight.setText(String.format("%.2f", heightValue)); // Cập nhật giá trị hiển thị
        }

        if (selectedUnitWeight.equals(unitsWeight[1])) {
            // Convert from pounds to kilograms
            weightValue *= 0.453592;
            txtWeight.setText(String.format("%.2f", weightValue)); // Cập nhật giá trị hiển thị
        }
    }

    public static void main(String[] args) {
        new BMICalculator().setVisible(true);
    }
}