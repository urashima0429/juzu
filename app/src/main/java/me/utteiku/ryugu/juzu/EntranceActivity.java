package me.utteiku.ryugu.juzu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by ryugu on 2017/08/19.
 */

public class EntranceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_entrance);

        //Todo from DB
        Spinner spinner = (Spinner) findViewById(R.id.spinner_sex);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sex_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final Button button = (Button)findViewById(R.id.signUpButton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // クリック時の処理
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }




}
