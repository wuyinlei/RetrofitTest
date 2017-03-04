package com.mingchu.retrofittest.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mingchu.retrofittest.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mFirstButton,
            mSecondButton,
            mThreeButton,
            mFourButton,
            mFiveButton,
            mSixButton;

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
        mThreeButton.setOnClickListener(this);
        mFourButton.setOnClickListener(this);
        mFiveButton.setOnClickListener(this);
        mSixButton.setOnClickListener(this);

    }

    private void initView() {

        mFirstButton = (Button) findViewById(R.id.button_one);
        mSecondButton = (Button) findViewById(R.id.button_two);
        mThreeButton = (Button) findViewById(R.id.button_three);
        mFourButton = (Button) findViewById(R.id.button_four);
        mFiveButton = (Button) findViewById(R.id.button_five);
        mSixButton = (Button) findViewById(R.id.button_six);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.button_one:
                intent.setClass(this, FirstActivity.class);
                break;

            case R.id.button_two:
                intent.setClass(this, SecondActivity.class);
                break;
            case R.id.button_three:

                intent.setClass(this, ThreeActivity.class);
                break;

            case R.id.button_four:

                intent.setClass(this, FourActivity.class);
                break;
            case R.id.button_five:

                intent.setClass(this, FiveActivity.class);
                break;

            case R.id.button_six:

                intent.setClass(this, SixActivity.class);
                break;


            default:
                break;

        }

        startActivity(intent);
    }
}
