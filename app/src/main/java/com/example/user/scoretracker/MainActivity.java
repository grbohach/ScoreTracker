package com.example.user.scoretracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.user.scoretracker.R.id.activity_basketball_score_tracker;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ResetButton:
                Toast.makeText(this, "Reset Scores", Toast.LENGTH_SHORT).show();
                home.setText("0");
                away.setText("0");
                break;
            case R.id.decreaseHome:
                int oldScore = Integer.parseInt(home.getText().toString());
                if(oldScore > 0) {
                    Toast.makeText(this, "Home score reduced by 1", Toast.LENGTH_SHORT).show();
                    oldScore--;
                }
                home.setText(Integer.toString(oldScore));
                break;
            case R.id.decreaseAway:
                oldScore = Integer.parseInt(away.getText().toString());
                if(oldScore > 0) {
                    Toast.makeText(this, "Away score reduced by 1", Toast.LENGTH_SHORT).show();
                    oldScore--;
                }
                away.setText(Integer.toString(oldScore));
                break;
            case R.id.Basketball:
                Intent newIntent = new Intent(MainActivity.this, BasketballScoreTracker.class);
                startActivity(newIntent);
                this.finish();
                break;
        }

        return true;
    }

    private void setupButtons(){
        home = (Button) this.findViewById(R.id.btnHome);
        home.setOnClickListener(this);
        away = (Button) this.findViewById(R.id.btnAway);
        away.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button thisButton = (Button) v;
        int oldScore = Integer.parseInt(thisButton.getText().toString());
        oldScore++;
        thisButton.setText(Integer.toString(oldScore));
    }
}
