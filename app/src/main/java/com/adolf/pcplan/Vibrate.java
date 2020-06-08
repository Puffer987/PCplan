package com.adolf.pcplan;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Vibrate extends AppCompatActivity {

    private Vibrator vib;

    private VibParams breakOut;
    private VibParams endurance;
    private VibParams gradual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        vib = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);

        Intent intent = getIntent();
        if (intent != null) {
            breakOut = (VibParams) intent.getSerializableExtra("breakOut");
            endurance = (VibParams) intent.getSerializableExtra("endurance");
            gradual = (VibParams) intent.getSerializableExtra("gradual");

            EditText bModel = findViewById(R.id.bModel);
            bModel.setText(breakOut.getModel());
            EditText bLoop = findViewById(R.id.bLoop);
            bLoop.setText(breakOut.getLoop()+"");

            EditText eModel = findViewById(R.id.eModel);
            eModel.setText(endurance.getModel());
            EditText eLoop = findViewById(R.id.eLoop);
            eLoop.setText(endurance.getLoop()+"");

            EditText gModel = findViewById(R.id.gModel);
            gModel.setText(gradual.getModel());
            EditText gLoop = findViewById(R.id.gLoop);
            gLoop.setText(gradual.getLoop()+"");
        }
    }

    public void stop(View v) {
        vib.vibrate(new long[]{200, 200}, -1);
        vib.cancel();
    }

    public void start(View v) {
        try {
            EditText model;
            EditText loop;
            switch (v.getId()) {
                case R.id.bStart: {
                    model = findViewById(R.id.bModel);
                    loop = findViewById(R.id.bLoop);

                    break;
                }
                case R.id.eStart: {
                    model = findViewById(R.id.eModel);
                    loop = findViewById(R.id.eLoop);

                    break;
                }
                case R.id.gStart: {
                    model = findViewById(R.id.gModel);
                    loop = findViewById(R.id.gLoop);

                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());
            }
            String strPattern = model.getText().toString();
            int iLoop = Integer.parseInt(loop.getText().toString());
            long[] pattern = str2long(strPattern, iLoop);
            vib.vibrate(pattern, -1);

        } catch (Exception e) {
            Toast.makeText(Vibrate.this, "请输入正确格式", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }


    public long[] str2long(String inStr, int loop) throws Exception {
        String sumStr = "";
        for (int i = 0; i < loop; i++) {
            sumStr = sumStr + " " + inStr;
        }

        String[] s = sumStr.trim().split(" ");
        long[] patten = new long[s.length];

        for (int i = 0; i < s.length; i++) {
            Pattern pattern = Pattern.compile("[0-9]*");
            boolean isNum = pattern.matcher(s[i]).matches();
            if (!isNum) {
                throw new Exception();
            }
            patten[i] = Long.valueOf(s[i]);
        }

        return patten;
    }

}