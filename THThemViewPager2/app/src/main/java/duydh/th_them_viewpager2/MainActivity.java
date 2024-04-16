package duydh.th_them_viewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ViewPager2 myViewPager2;
    Adapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewPager2 = findViewById(R.id.viewPager2);
        myAdapter = new Adapter(getSupportFragmentManager(), getLifecycle());
        myAdapter.addFragment(new FirstFragment());
        myAdapter.addFragment(new SecondFragment());
        myAdapter.addFragment(new ThirdFragment());
        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        myViewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                final float MIN_SCALE = 0.75f;
                int pageWidth = page.getWidth();
                if (position < -1) {
                    page.setAlpha(0f);
                } else if (position <= 0) {
                    page.setAlpha(1f);
                    page.setTranslationX(0f);
                    page.setScaleX(1f);
                    page.setScaleY(1f);
                } else if (position <= 1) {
                    page.setAlpha(1 - position);
                    page.setTranslationX(pageWidth * -position);
                    float scaleFactor = MIN_SCALE
                            + (1 - MIN_SCALE) * (1 - Math.abs(position));
                    page.setScaleX(scaleFactor);
                    page.setScaleY(scaleFactor);
                } else {
                    page.setAlpha(0f);
                }
            }
        });
        myViewPager2.setAdapter(myAdapter);

    }
}