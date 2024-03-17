package duydh.ex3_simplesumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void XuLyCong(View view) {
        EditText editTextSoA = findViewById(R.id.edtA);
        EditText editTextSoB = findViewById(R.id.edtB);
        EditText editTextKetQua = findViewById(R.id.edtKQ);

        String strA = editTextSoA.getText().toString();
        String strB = editTextSoB.getText().toString();

        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        int ketQua = a + b;
          String strKetQua = String.valueOf(ketQua);
        editTextKetQua.setText(strKetQua);
    }
}