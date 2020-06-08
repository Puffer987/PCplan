package com.adolf.pcplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectLevel(View view) {
        switch (view.getId()) {
            case R.id.level1: {
                VibParams breakOut = new VibParams("1500 1500 1500 1500", 10); // 爆发
                VibParams endurance = new VibParams("3000 3000 3000 3000", 5); // 耐力
                VibParams gradual = new VibParams("3000 500 1000 500 1000 2000 1000 500 1000 500", 5);// 渐进
                Intent i = new Intent(this, Vibrate.class);

                i.putExtra("breakOut",breakOut);
                i.putExtra("endurance",endurance);
                i.putExtra("gradual",gradual);
                startActivity(i);
                break;
            }
            case R.id.level2: {
                VibParams breakOut = new VibParams("1500 1500 1500 1500", 10); // 爆发
                VibParams endurance = new VibParams("5000 5000 5000 5000", 5); // 耐力
                VibParams gradual = new VibParams("3000 500 1000 500 1000 2000 1000 500 1000 500", 5);// 渐进
                Intent i = new Intent(this, Vibrate.class);

                i.putExtra("breakOut",breakOut);
                i.putExtra("endurance",endurance);
                i.putExtra("gradual",gradual);

                Intent i2 = new Intent(this, Vibrate.class);
                startActivity(i2);
                break;
            }
            case R.id.level3: {
                VibParams breakOut = new VibParams("1500 1500 1500 1500", 10); // 爆发
                VibParams endurance = new VibParams("5000 7000 5000 7000", 5); // 耐力
                VibParams gradual = new VibParams("3000 500 1000 500 1000 2000 1000 500 1000 500", 10);// 渐进
                Intent i = new Intent(this, Vibrate.class);

                i.putExtra("breakOut",breakOut);
                i.putExtra("endurance",endurance);
                i.putExtra("gradual",gradual);

                Intent i3 = new Intent(this, Vibrate.class);
                startActivity(i3);
                break;
            }
        }
    }
}