package me.utteiku.ryugu.juzu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import me.utteiku.ryugu.juzu.R;

/**
 * Created by ryugu on 2017/08/19.
 */

public class RegistrationActivity extends Activity {


    private static String EXTRA_ITEM_ID = "extra_item_id";
    public static Intent createIntent(Context context, int itemId) {
        Intent intent = new Intent(context, RegistrationActivity.class);
        intent.putExtra(EXTRA_ITEM_ID, itemId);
        return intent;
    }

    @Override
    protected void onCreate(final Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_registration);

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
                startActivity(EditIconActivity.createIntent(getApplicationContext()));
            }
        });


    }




}
