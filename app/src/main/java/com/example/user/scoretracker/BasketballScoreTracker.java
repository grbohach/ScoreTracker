package com.example.user.scoretracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BasketballScoreTracker extends AppCompatActivity implements View.OnClickListener {

    private Button homeOne;
    private Button homeTwo;
    private Button homeThree;
    private Button awayOne;
    private Button awayTwo;
    private Button awayThree;
    private TextView homeScore;
    private TextView awayScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball_score_tracker);
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
                homeScore.setText("0");
                awayScore.setText("0");
                break;
            case R.id.decreaseHome:
                int oldScore = Integer.parseInt(homeScore.getText().toString());
                if (oldScore > 0){
                    Toast.makeText(this, "Home score reduced by 1", Toast.LENGTH_SHORT).show();
                    oldScore--;
                }
                homeScore.setText(Integer.toString(oldScore));
                break;
            case R.id.decreaseAway:
                oldScore = Integer.parseInt(awayScore.getText().toString());
                if(oldScore > 0) {
                    Toast.makeText(this, "Away score reduced by 1", Toast.LENGTH_SHORT).show();
                    oldScore--;
                }
                awayScore.setText(Integer.toString(oldScore));
                break;
            case R.id.Soccer:
                Intent newIntent = new Intent(BasketballScoreTracker.this, MainActivity.class);
                startActivity(newIntent);
                this.finish();
                break;
        }

        return true;
    }

    private void setupButtons(){
        homeOne = (Button) this.findViewById(R.id.btnHomeOne);
        homeOne.setOnClickListener(this);
        homeTwo = (Button) this.findViewById(R.id.btnHomeTwo);
        homeTwo.setOnClickListener(this);
        homeThree = (Button) this.findViewById(R.id.btnHomeThree);
        homeThree.setOnClickListener(this);
        awayOne = (Button) this.findViewById(R.id.btnAwayOne);
        awayOne.setOnClickListener(this);
        awayTwo = (Button) this.findViewById(R.id.btnAwayTwo);
        awayTwo.setOnClickListener(this);
        awayThree = (Button) this.findViewById(R.id.btnAwayThree);
        awayThree.setOnClickListener(this);
        homeScore = (TextView) this.findViewById(R.id.txtHomeScore);
        awayScore = (TextView) this.findViewById(R.id.txtAwayScore);
    }

    @Override
    public void onClick(View v) {
        Button thisButton = (Button) v;
        TextView thisText;
        int addAmount = Integer.parseInt(thisButton.getText().toString());
        if((Button)v == homeOne || (Button)v == homeTwo || (Button)v == homeThree)
        {
            thisText = homeScore;
        }
        else
        {
            thisText = awayScore;
        }
        int currentScore = Integer.parseInt(thisText.getText().toString());
        currentScore += addAmount;
        thisText.setText(Integer.toString(currentScore));
    }
}