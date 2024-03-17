package com.example.ex5_addsubmuldiv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText soA, soB;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimView();
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(soA.getText().toString());
                double b = Double.parseDouble(soB.getText().toString());
                double kq = a + b;
                txtKetQua.setText(kq + "");
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(soA.getText().toString());
                double b = Double.parseDouble(soB.getText().toString());
                double kq = a - b;
                txtKetQua.setText(kq + "");
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(soA.getText().toString());
                double b = Double.parseDouble(soB.getText().toString());
                double kq = a * b;
                txtKetQua.setText(kq + "");
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(soA.getText().toString());
                double b = Double.parseDouble(soB.getText().toString());
                double kq = a / b;
                txtKetQua.setText(kq + "");
            }
        });
    }

//    View.OnClickListener boLangNghe_XuLyCong = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            double a = Double.parseDouble(soA.getText().toString());
//            double b = Double.parseDouble(soB.getText().toString());
//            double kq = a + b;
//            txtKetQua.setText("Kết quả: " + kq);
//        }
//    };
//
//    View.OnClickListener boLangNghe_XuLyTru = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            double a = Double.parseDouble(soA.getText().toString());
//            double b = Double.parseDouble(soB.getText().toString());
//            double kq = a - b;
//            txtKetQua.setText("Kết quả: " + kq);
//        }
//    };
//
//    View.OnClickListener boLangNghe_XuLyNhan = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            double a = Double.parseDouble(soA.getText().toString());
//            double b = Double.parseDouble(soB.getText().toString());
//            double kq = a * b;
//            txtKetQua.setText("Kết quả: " + kq);
//        }
//    };
//
//    View.OnClickListener boLangNghe_XuLyChia = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            double a = Double.parseDouble(soA.getText().toString());
//            double b = Double.parseDouble(soB.getText().toString());
//            double kq = a / b;
//            txtKetQua.setText("Kết quả: " + kq);
//        }
//    };
    void TimView(){
        soA = findViewById(R.id.txtA);
        soB = findViewById(R.id.txtB);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        txtKetQua = findViewById(R.id.txtKQ);
    }
}