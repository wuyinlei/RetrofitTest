package com.mingchu.retrofittest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mFirstButton,mSecondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initListener() {
        mFirstButton.setOnClickListener(this);
        mSecondButton.setOnClickListener(this);

    }

    private void initView() {

        mFirstButton = (Button) findViewById(R.id.button_one);
        mSecondButton = (Button) findViewById(R.id.button_two);
    }

    @Override
    public void onClick(View v) {
        Intent  intent = new Intent();
        switch (v.getId()){
            case R.id.button_one:
                intent.setClass(this,FirstActivity.class);
                break;

            case R.id.button_two:
                intent.setClass(this,SecondActivity.class);
                break;

            default:
                break;

        }

        startActivity(intent);
    }
}
