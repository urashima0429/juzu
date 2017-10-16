package me.utteiku.ryugu.juzu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.activity.EntranceActivity;

/**
 * Created by ryugu on 2017/08/19.
 */

public class SignUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Button button = (Button)findViewById(R.id.signUpwithLineButton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // クリック時の処理
                startActivity(EntranceActivity.createIntent(getApplicationContext(), 1));
            }
        });
    }
}


