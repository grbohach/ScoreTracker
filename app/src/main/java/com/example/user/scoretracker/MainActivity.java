package com.example.user.scoretracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.user.scoretracker.R.id.home;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button home;
    private Button away;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtons();
    }

    private void setupButtons(){
        home = (Button) this.findViewById(R.id.btnHome);
        home.setOnClickListener(this);
        away = (Button) this.findViewById(R.id.btnAway);
        away.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btnHome:
                String sHome = home.getText().toString();
                int iHome = Integer.parseInt(sHome) + 1;
                home.setText(Integer.toString(iHome));
                break;
            case R.id.btnAway:
                String sAway = away.getText().toString();
                int iAway = Integer.parseInt(sAway) + 1;
                away.setText(Integer.toString(iAway));
                break;
        }
    }
}
