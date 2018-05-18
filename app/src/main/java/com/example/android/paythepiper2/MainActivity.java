package com.example.android.paythepiper2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.android.paythepiper2.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int n = 0, randoms;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActivityBackgroundColor(Color.parseColor("#7FE817"));
        final Button generate = (Button) findViewById(R.id.generate_price_button);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randoms = rand.nextInt(100);
                generate(randoms);
                colourChange();
            }
        });
        final Button one = (Button) findViewById(R.id.one_view);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(n+1<=randoms)
                n = n + 1;
                dontpaytoomuch();
                colourChange();
            }
        });
        final Button two = (Button) findViewById(R.id.two_view);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (n+2<=randoms)
                n = n + 2;
                dontpaytoomuch();
                colourChange();
            }
        });
        final Button five = (Button) findViewById(R.id.five_view);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(n+5<=randoms)
                n = n + 5;
                dontpaytoomuch();
                colourChange();
            }
        });
        final Button ten = (Button) findViewById(R.id.ten_view);
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(n+10<=randoms)
                n = n + 10;
                dontpaytoomuch();
                colourChange();
            }
        });
        final Button reset = (Button) findViewById(R.id.reset_view);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = 0;
                setActivityBackgroundColor(Color.parseColor("#7FE817"));
                display(n);
            }
        });

    }

    // Generate random integers in range 0 to 999
    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.amount_paid_view);
        quantityTextView.setText("\u20B9" + number);
    }

    private void generate(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.random_price_view);
        quantityTextView.setText("\u20B9" + number);
    }

    public void colourChange() {
        if (n == randoms) setActivityBackgroundColor(Color.parseColor("#43C6DB"));
        else setActivityBackgroundColor(Color.parseColor("#7FE817"));
    }

    public void dontpaytoomuch() {
        if (n <= randoms) {
            display(n);
            colourChange();
        }

    }
}
