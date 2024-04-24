package duydh.intent_vd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_sub1 extends AppCompatActivity {
    Button btn_sub1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        btn_sub1 = findViewById(R.id.btn_sub1);
        btn_sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMain = new Intent(Activity_sub1.this, MainActivity.class);
                startActivity(iMain);
            }
        });
    }
}