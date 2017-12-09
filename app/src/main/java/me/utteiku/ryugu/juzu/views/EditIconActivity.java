package me.utteiku.ryugu.juzu.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import me.utteiku.ryugu.juzu.R;

/**
 * Created by ryugu on 2017/10/16.
 */

public class EditIconActivity extends Activity{

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, EditIconActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(final Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_edit_icon);

        final Button button1 = (Button)findViewById(R.id.button_take_now);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // クリック時の処理
                startActivity(MainActivity.createIntent(getApplicationContext(), 1));
            }
        });

        final Button button2 = (Button)findViewById(R.id.button_from_camara_roll);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // クリック時の処理
                startActivity(MainActivity.createIntent(getApplicationContext(), 1));
            }
        });
    }


}
