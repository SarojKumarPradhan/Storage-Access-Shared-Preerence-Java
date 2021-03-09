package com.example.sharedpreferencesstorageaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences myprefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get reference to TextView
        TextView labelID = (TextView) findViewById(R.id.labelID);

        //get references to Name and Age EditTexts
        EditText nameID = (EditText) findViewById(R.id.nameID);
        EditText ageID = (EditText) findViewById(R.id.ageID);
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);

        myprefs = getSharedPreferences("PreID",MODE_PRIVATE);
        String name = myprefs.getString("nameKey","NO name");
        Integer age = myprefs.getInt("ageKey",0);
        labelID.setText(name+" -----> "+age);

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myprefs = getSharedPreferences("PreID",MODE_PRIVATE);
                        SharedPreferences.Editor editor = myprefs.edit();
                        editor.putString("nameKey",nameID.getText().toString());
                        editor.putInt("ageKey",Integer.parseInt(ageID.getText().toString()));
                        editor.apply();
                        String s = ageID.getText().toString();
                        labelID.setText("Save age = "+s);
                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str = nameID.getText().toString();
                        labelID.setText(str);
                    }

                });
    }
}



