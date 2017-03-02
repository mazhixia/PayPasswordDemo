package com.wsh.tinker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_pay = (TextView) findViewById(R.id.tv_pay);
        tv_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PasswordInputDialog passwordInputDialog = new PasswordInputDialog(MainActivity.this);
                passwordInputDialog.setDialogCallback(new PasswordInputDialog.DialogCallback() {
                    @Override
                    public void dialogOk(String passwd) {
                        Toast.makeText(MainActivity.this,passwd,Toast.LENGTH_LONG).show();
                    }
                });
                passwordInputDialog.show();
            }
        });
    }
}
