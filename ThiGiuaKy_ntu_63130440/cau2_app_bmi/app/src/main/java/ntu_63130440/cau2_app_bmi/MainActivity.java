package ntu_63130440.cau2_app_bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {
    

    private Button calculateButton;
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }
    public void calculateBMI(){
        String heightStr = heightInput.getText().toString();
        String weightStr = weightInput.getText().toString();
        if(heightStr.isEmpty() || weightStr.isEmpty()){
            resultText.setText("Hãy nhập chiều cao và cân nặng.");
            return;
        }
        float height = Float.parseFloat(heightStr)/100; // doi ve don vi met
        float weight = Float.parseFloat(weightStr);
        float bmi = weight/(height*height);
        String result;
        if(bmi < 18.5){
            result = "Bạn bị thiếu cân. BMI của bạn là "+bmi;
        } else if (bmi >= 18.5 && bmi < 25) {
            result = "Bạn bình thường. BMI của bạn là "+bmi;
        }else if (bmi >= 25 && bmi < 30) {
            result = "Bạn bị thừa cân. BMI của bạn là " + bmi;
        }else {
            result = "Bạn béo phì. BMI của bạn là "+bmi;
        }
        resultText.setText(result);
    }
}