package com.example.apple.week4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {


    TextView t1,t2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        t1 = (TextView)findViewById(R.id.result);
        t2 = (TextView)findViewById(R.id.textView4);
        b1 = (Button)findViewById(R.id.button1);

        Intent intent = getIntent();
        Double a = intent.getDoubleExtra("result", 0);
        String b = intent.getStringExtra("name");
        t1.setText(Double.toString(a));
        t2.setText(b);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=editText1.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();//finishing activity
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }
}
