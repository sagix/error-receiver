package com.nicolasmouchel.errorreceiver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nicolasmouchel.api.Api;

public class MainActivity extends AppCompatActivity {

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = Api.with(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();
        api.load();
    }
}
