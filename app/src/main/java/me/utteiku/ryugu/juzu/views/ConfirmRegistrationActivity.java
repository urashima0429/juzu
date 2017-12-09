package me.utteiku.ryugu.juzu.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import me.utteiku.ryugu.juzu.R;

/**
 * Created by ryugu on 2017/08/19.
 */

public class ConfirmRegistrationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_registration);

        final Button button = (Button)findViewById(R.id.signUpwithLineButton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // クリック時の処理
                startActivity(RegistrationActivity.createIntent(getApplicationContext(), 1));
            }
        });
    }
}


