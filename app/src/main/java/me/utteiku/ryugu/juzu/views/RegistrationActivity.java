package me.utteiku.ryugu.juzu.views;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

        final EditText nameEditer = (EditText) findViewById(R.id.name_editer);
        final DatePicker birtydayPicker = (DatePicker) findViewById(R.id.birthdayPicker);
        final Spinner sexSpinner = (Spinner) findViewById(R.id.sex_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sex_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexSpinner.setAdapter(adapter);

        final Button button = (Button)findViewById(R.id.signUpButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // on clicked
                startActivity(EditIconActivity.createIntent(getApplicationContext()));
            }
        });
    }

    //toast
    private void toast(String text){
        if(text.isEmpty()) text = "";
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
