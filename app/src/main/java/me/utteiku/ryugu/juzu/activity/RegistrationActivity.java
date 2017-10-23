package me.utteiku.ryugu.juzu.activity;

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

import me.utteiku.ryugu.juzu.DBProvider;
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
                // クリック時の処理
                try {
                    writeDB(nameEditer.getText().toString());
                    writeDB(birtydayPicker.toString());
                    writeDB(sexSpinner.toString());
                } catch (Exception e) {
                    toast("" + e);
                }
                //startActivity(EditIconActivity.createIntent(getApplicationContext()));
            }
        });


    }

    //DBprovider
    private void writeDB(String info) throws Exception{
        // コンテンツプロバイダが提供するデータベースが示すURI
        Uri uri = Uri.parse("content://me.utteiku.ryugu.juzu.dbprovider/");

        //コンテンツプロバイダが提供するデータベースへのアクセス
        ContentValues values = new ContentValues();
        values.put("id", "0");
        values.put("info",info);
        int num = getContentResolver().update(uri, values, null, null);
        if ( num == 0 ) getContentResolver().insert(uri, values);
    }

    private String readDB() throws Exception{
        // コンテンツプロバイダが提供するデータベースが示すURI
        Uri uri = Uri.parse("content://me.utteiku.ryugu.juzu.dbprovider/");

        //コンテンツプロバイダが提供するデータベースへのアクセス
        Cursor c = this.getContentResolver().query(uri, new String[]{"id", "info"}, "id='0'", null, null);
        if (c.getCount() == 0) throw new Exception();
        c.moveToFirst();
        String str = c.getString(1);
        c.close();
        return str;
    }

    //toast
    private void toast(String text){
        if(text.isEmpty()) text = "";
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
