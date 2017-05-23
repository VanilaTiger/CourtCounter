package com.example.android.courtcounter;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public int ScoreA = 0;
    public int BallWonA = 0;
    public int AsServiceA = 0;
    public int DoubleFoulA = 0;
    public int AdvScoreA = 0;
    public int GemsA = 0;
    public int ScoreB = 0;
    public int BallWonB = 0;
    public int AsServiceB = 0;
    public int DoubleFoulB = 0;
    public int AdvScoreB = 0;
    public int GemsB = 0;
    public boolean Advantages = false;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void NewGem() {

        Advantages = false;
        ScoreA = 0;
        AdvScoreA = 0;
        ScoreB = 0;
        AdvScoreB = 0;
        displayForTeamA(0);
        displayForTeamB(0);

    }

    //Display the score for TeamA
    public void displayGemsForTeamA(int score) {
        TextView scoreGemsView = (TextView) findViewById(R.id.ScoreGemA);
        scoreGemsView.setText("" + score);
    }

    public void displayBallWonForTeamA(int score) {
        TextView scoreAsServiceView = (TextView) findViewById(R.id.BBallWonA);
        scoreAsServiceView.setText("Ball Won: " + score);
    }

    public void displayAsServiceForTeamA(int score) {
        TextView scoreAsServiceView = (TextView) findViewById(R.id.BAsServiceA);
        scoreAsServiceView.setText("As Service: " + score);
    }

    public void displayDoubleFoulForTeamA(int score) {

        TextView scoreView = (TextView) findViewById(R.id.BDoubleFoulA);
        scoreView.setText("Double Foul: " + score);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.ScoreTextA);

        if (ScoreA > 40 && ScoreB > 40) {
            Advantages = true;
        }

        if (score < 40) scoreView.setText("" + score);

        if (score == 45) {
            score = 40;
            scoreView.setText("" + score);
        }

        if ((score > 50) && (Advantages == false)) {
            GemsA = GemsA + 1;
            displayGemsForTeamA(GemsA);
            NewGem();
        }
    }

    public void displayAdvantageTeamA(int Calc, String adv) {
        TextView scoreView = (TextView) findViewById(R.id.ScoreTextA);

        if ((AdvScoreA - AdvScoreB == 0) && (Calc == 1)) {
            scoreView.setText("-");
            displayAdvantageTeamB(0, "-");
        }

        if ((AdvScoreA - AdvScoreB == 1) && (Calc == 1)) {
            scoreView.setText("Adv");
            displayAdvantageTeamB(0, "-");
        }

        if ((AdvScoreA - AdvScoreB == 2) && (Calc == 1)) {
            GemsA = GemsA + 1;
            displayGemsForTeamA(GemsA);
            NewGem();
        }

        if (Calc == 0) {
            scoreView.setText(adv);
        }

    }

    public void AddPointA(View view) {
        BallWonA = BallWonA + 1;
        displayBallWonForTeamA(BallWonA);

        if (ScoreA > 40 && ScoreB > 40) Advantages = true;
        if (!Advantages) {
            ScoreA = ScoreA + 15;
            displayForTeamA(ScoreA);
        } else {
            AdvScoreA = AdvScoreA + 1;
            displayAdvantageTeamA(1, "");
        }

    }

    public void AddServiceA(View view) {
        AsServiceA = AsServiceA + 1;
        AddPointA(view);

        TextView scoreAsServiceView = (TextView) findViewById(R.id.BAsServiceA);
        scoreAsServiceView.setText("As Service: " + AsServiceA);
    }

    public void AddDoubleFoulA(View view) {
        DoubleFoulA = DoubleFoulA + 1;
        AddPointB(view);

        TextView scoreView = (TextView) findViewById(R.id.BDoubleFoulA);
        scoreView.setText("Double Foul: " + DoubleFoulA);
    }

    //Display the score for TeamB

    public void displayGemsForTeamB(int score) {
        TextView scoreGemsView = (TextView) findViewById(R.id.ScoreGemB);
        scoreGemsView.setText("" + score);
    }

    public void displayBallWonForTeamB(int score) {

        TextView scoreAsServiceView = (TextView) findViewById(R.id.BBallWonB);
        scoreAsServiceView.setText("Ball Won: " + score);
    }

    public void displayAsServiceForTeamB(int score) {

        TextView scoreAsServiceView = (TextView) findViewById(R.id.BAsServiceB);
        scoreAsServiceView.setText("As Service: " + score);
    }

    public void displayDoubleFoulForTeamB(int score) {

        TextView scoreView = (TextView) findViewById(R.id.BDoubleFoulB);
        scoreView.setText("Double Foul: " + score);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.ScoreTextB);

        if (score < 40) scoreView.setText("" + score);

        if (score == 45) {
            score = 40;
            scoreView.setText("" + score);
        }

        if ((score > 50) && (Advantages == false)) {
            GemsB = GemsB + 1;
            displayGemsForTeamB(GemsB);
            NewGem();
        }
    }
    public void displayAdvantageTeamB(int Calc, String adv) {
        TextView scoreView = (TextView) findViewById(R.id.ScoreTextB);

        if ((AdvScoreB - AdvScoreA == 0) && (Calc == 1)) {
            scoreView.setText("-");
            displayAdvantageTeamA(0, "-");
        }

        if ((AdvScoreB - AdvScoreA == 1) && (Calc == 1)) {
            scoreView.setText("Adv");
            displayAdvantageTeamA(0, "-");
        }

        if ((AdvScoreB - AdvScoreA == 2) && (Calc == 1)) {
            GemsB = GemsB + 1;
            displayGemsForTeamB(GemsB);
            NewGem();
        }

        if (Calc == 0) {
            scoreView.setText(adv);
        }
    }

    public void AddPointB(View view) {
        BallWonB = BallWonB + 1;
        displayBallWonForTeamB(BallWonB);

        if (ScoreA > 40 && ScoreB > 40) Advantages = true;
        if (!Advantages) {
            ScoreB = ScoreB + 15;
            displayForTeamB(ScoreB);
        } else {
            AdvScoreB = AdvScoreB + 1;
            displayAdvantageTeamB(1, "");
        }
    }

    public void AddServiceB(View view) {
        AsServiceB = AsServiceB + 1;
        AddPointB(view);

        displayAsServiceForTeamB(AsServiceB);
    }

    public void AddDoubleFoulB(View view) {
        DoubleFoulB = DoubleFoulB + 1;
        AddPointA(view);

        displayDoubleFoulForTeamB(DoubleFoulB);
    }

    public void ResetScore(View view) {
        ScoreA = 0;
        ScoreB = 0;
        BallWonA = 0;
        BallWonB = 0;
        DoubleFoulA = 0;
        DoubleFoulB = 0;
        AsServiceA = 0;
        AsServiceB = 0;
        GemsA = 0;
        GemsB = 0;
        Advantages = false;
        displayForTeamA(0);
        displayGemsForTeamA(0);
        displayBallWonForTeamA(0);
        displayAsServiceForTeamA(0);
        displayDoubleFoulForTeamA(0);
        displayForTeamB(0);
        displayGemsForTeamB(0);
        displayBallWonForTeamB(0);
        displayAsServiceForTeamB(0);
        displayDoubleFoulForTeamB(0);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
