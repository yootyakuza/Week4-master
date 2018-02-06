package com.example.apple.week4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt1,bt2;
    EditText et1,et2,et3;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        et3 = (EditText)findViewById(R.id.editTextName);
        bt1 = (Button)findViewById(R.id.but1);
        bt2 = (Button)findViewById(R.id.but2);
        tv = (TextView)findViewById(R.id.textViewResult);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double a = Double.parseDouble(et1.getText().toString());
                Double b = Double.parseDouble(et2.getText().toString());
                Double result = a + b;
                String c = et3.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Activity2.class);
                intent.putExtra("result",result);
                intent.putExtra("name",c);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String geoCode = "google.streetview:cbll=13.7523959,100.4925838&cbp=1,150,,170,-5";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String message=data.getStringExtra("MESSAGE");
            tv.setText(message);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
