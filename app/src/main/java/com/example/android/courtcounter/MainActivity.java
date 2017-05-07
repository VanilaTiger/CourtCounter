package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public int ScoreA=0;
    public int ScoreB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //displayForTeamA(8);
    }

    //Display the score for TeamA

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.ScoreTextA);
        scoreView.setText(""+score);
    }

    public void Add3Points (View view) {
        ScoreA=ScoreA+3;
        displayForTeamA(ScoreA);
    }

    public void Add2Points (View view) {
        ScoreA=ScoreA+2;
        displayForTeamA(ScoreA);
    }

    public void AddFreePoints (View view) {
        ScoreA=ScoreA+1;
        displayForTeamA(ScoreA);
    }

    //Display the score for TeamB

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.ScoreTextB);
        scoreView.setText(""+score);
    }

    public void Add3PointsB (View view) {
        ScoreB=ScoreB+3;
        displayForTeamB(ScoreB);
    }

    public void Add2PointsB (View view) {
        ScoreB=ScoreB+2;
        displayForTeamB(ScoreB);
    }

    public void AddFreePointsB (View view) {
        ScoreB=ScoreB+1;
        displayForTeamB(ScoreB);
    }

    public void ResetScore (View view) {
        ScoreA=0;
        ScoreB=0;
        displayForTeamA(ScoreA);
        displayForTeamB(ScoreB);
    }

}
