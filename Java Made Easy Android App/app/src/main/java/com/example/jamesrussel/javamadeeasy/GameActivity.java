package com.example.jamesrussel.javamadeeasy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This is the activity which has the game's logic.
 */
public class GameActivity extends AppCompatActivity {

    public static final String CATEGORY = "category";
    private static final String TAG = "GameActivity debug";
    private static final String TIME_LEFT = "savedTimeLeft";
    private DBHelper dbHelper;
    private TextView tvCategory;
    private TextView tvQuestion;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private ArrayList<QuestionQuiz> questionQuizs;
    private String correctAnswer;
    private String playersGuess;
    private int round = 0;
    private int showRound = 1;
    private int playerScore = 0;
    private TextView mTextField;
    private CountDownTimer countDown;
    private CountDownTimer timer;
    private CountDownTimer countDownAgain;
    private int pointsToRecieve = 5;
    private int numberOfCorrectAnswer = 0;
    private int time;
    private int minutes;
    private int seconds;
    private String getCategory;
    private TextView roundView;
    private MediaPlayer mp;
    private View view;
    private String timeLeft;
    private int defaultTime = 15100;
    private int savedTime;
    private MediaPlayer mpb;
    private MediaPlayer mpbw;
    private MediaPlayer mpbr;
    private Player player = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        timer = new CountDownTimer(300000, 1000) {

            public void onTick(long millisUntilFinished) {
                time = time + 1;
            }

            public void onFinish() {
            }
        }.start();

        mp = MediaPlayer.create(this, R.raw.quiz);
        mp.setLooping(true);
        mp.start();

        player = Player.getPlayerInstance("Guest");
        dbHelper = DBHelper.getDbHelperInstance(this);

        // gets String category from GameModeActivity and saves it in getCategory.
        Intent intent = getIntent();
        getCategory = (String) intent.getSerializableExtra(CATEGORY);

        tvCategory = (TextView) findViewById(R.id.category_field);
        tvCategory.setText(getCategory);

        // gets 5 random questionQuizs from the data base and sets them to the list of arrays "question"
        if (getCategory.equals("ALL")) {
            questionQuizs = dbHelper.getRandomFiveQuestions(0);
        } else {
            questionQuizs = dbHelper.getRandomFiveQuestions(dbHelper.getIdByCategoryName(getCategory));
        }

        tvQuestion = (TextView) findViewById(R.id.question);
        tvQuestion.setText(questionQuizs.get(round).getQuestion());

        buttonA = (Button) findViewById(R.id.buttonA);
        buttonA.setText(questionQuizs.get(round).getAlternative1());

        buttonB = (Button) findViewById(R.id.buttonB);
        buttonB.setText(questionQuizs.get(round).getAlternative2());

        buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setText(questionQuizs.get(round).getAlternative3());

        buttonD = (Button) findViewById(R.id.buttonD);
        buttonD.setText(questionQuizs.get(round).getAlternative4());

        correctAnswer = questionQuizs.get(round).getCorrectAnswer();

        roundView = (TextView) findViewById(R.id.round);
        roundView.setText("" + showRound );

        //Starts the countDownTimer;
        countDownTimer(defaultTime);

    }

    /**
     * Starts 15 second countdown. Every 5 seconds the points received is reduced by 1 point.
     * When the count reaches 0, the next question is displayed.
     */

    private void countDownTimer(int time) {
        questionTimer(time);

    }

    @Override
    protected void onPause() {

        if(mp !=null){
            mp.pause();
            mp.stop();
        }
        super.onPause();
        Intent intent = new Intent(this, GameActivity.class);
        savedTime = Integer.parseInt(timeLeft);
        intent.putExtra(TIME_LEFT, savedTime);
        this.countDown.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        int newTime = intent.getIntExtra(TIME_LEFT, 15100);
        questionTimer(newTime);
    }

    /**
     * This method handles the game input and check if answer is correct.
     * If the answer is correct the button turns green and the player's score increases.
     * If not, the button turns red and the player receives no points.
     * Finally the method calls on the next question.
     *
     * @param view
     */
    public void gameInput(final View view) {

        countDown.cancel();

        switch (view.getId()) {
            case R.id.buttonA:
                playersGuess = "1";
                break;

            case R.id.buttonB:
                playersGuess = "2";
                break;

            case R.id.buttonC:
                playersGuess = "3";
                break;

            case R.id.buttonD:
                playersGuess = "4";
                break;
        }

        if (correctAnswer.equals(playersGuess)) {

            playClickSoundGlass();
            view.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btncorrect));

            numberOfCorrectAnswer++;

            // Player's score increases
            playerScore = playerScore + pointsToRecieve;

            TextView scoreView = (TextView) findViewById(R.id.score);
            scoreView.setText("" + playerScore);

        } else {
            playClickSoundDuck();
            view.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btnwrong));
        }

        round++;
        showRound++;

        new CountDownTimer(200, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                view.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btnblue));
                nextQuestion();
            }
        }.start();
    }


    public void nextQuestion() {

        if (round == questionQuizs.size()) {
            timer.cancel();
            minutes = time / 60;
            seconds = time % 60;
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(ResultActivity.FINAL_SCORE, playerScore);
            intent.putExtra(ResultActivity.CORRECT_ANSWERS, numberOfCorrectAnswer);
            intent.putExtra(ResultActivity.MINUTES, minutes);
            intent.putExtra(ResultActivity.SECONDS, seconds);
            intent.putExtra(ResultActivity.CATEGORY, getCategory);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            mp.stop();
            startActivity(intent);
        } else {

            tvQuestion.setText(questionQuizs.get(round).getQuestion());
            buttonA.setText(questionQuizs.get(round).getAlternative1());
            buttonB.setText(questionQuizs.get(round).getAlternative2());
            buttonC.setText(questionQuizs.get(round).getAlternative3());
            buttonD.setText(questionQuizs.get(round).getAlternative4());
            correctAnswer = questionQuizs.get(round).getCorrectAnswer();

            //TextView roundView = (TextView) findViewById(R.id.round);
            roundView.setText("" + showRound);
            pointsToRecieve = 5;

            questionTimer(defaultTime);
        }
    }



    public void questionTimer(int time) {

        if (countDown != null) {
            countDown.cancel();
            countDown = new CountDownTimer(time, 1000) {
                public void onTick(long millisUntilFinished) {
                    mTextField = (TextView) findViewById(R.id.timer);
                    timeLeft = "" + millisUntilFinished / 1000;
                    mTextField.setText(timeLeft);

                    if (millisUntilFinished < 10000) {
                        pointsToRecieve = 3;
                    }
                    if (millisUntilFinished < 5000) {
                        pointsToRecieve = 1;
                    }
                    if (millisUntilFinished <= 0) {
                        pointsToRecieve = 0;
                    }
                }

                public void onFinish() {
                    mTextField.setText("0");
                    round++;
                    showRound++;
                    cancel();
                    nextQuestion();
                }

            }.start();
        } else {

            countDown = new CountDownTimer(15100, 1000) {
                public void onTick(long millisUntilFinished) {
                    mTextField = (TextView) findViewById(R.id.timer);
                    timeLeft = "" + millisUntilFinished / 1000;
                    mTextField.setText(timeLeft);

                    if (millisUntilFinished < 10000) {
                        pointsToRecieve = 3;
                    } else if (millisUntilFinished < 5000) {
                        pointsToRecieve = 1;
                    } else if (millisUntilFinished <= 0) {
                        pointsToRecieve = 0;
                    }
                }

                public void onFinish() {
                    mTextField.setText("0");
                    round++;
                    showRound++;
                    cancel();
                    nextQuestion();
                }

            }.start();

        }

    }

    @Override
    public void onBackPressed(){
        //countDown.cancel();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit Game?");
        builder.setMessage("Your current progress will be lost");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (mp !=null)
                    mp.stop();
                    finish();
            }
        });
        builder.setNegativeButton("No", null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    /**
     * A method used for making the actionbar buttons do a sound when clicked.
     */
    public void playClickSound() {
        mpb = MediaPlayer.create(this, R.raw.test);
        mpb.start();
    }

    public void playClickSoundDuck() {
        mpbw = MediaPlayer.create(this, R.raw.wrong);
        mpbw.start();
    }

    public void playClickSoundGlass() {
        mpbr = MediaPlayer.create(this, R.raw.correct);
        mpbr.start();
    }




}
