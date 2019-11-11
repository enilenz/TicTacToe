package com.example.android.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int winningPositions[][] = {{0, 1, 2,}, {3, 4, 5,}, {6, 7, 8,}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameActive = true;
    int user = 1;

    public void isClicked(View view) {
        ImageView imageView = (ImageView) view;
        int tappedCounter = Integer.parseInt(imageView.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive) {
            gameState[tappedCounter] = user;
            if (user == 1) {
                imageView.setImageResource(R.drawable.xxx);
                user = 0;
            } else if (user == 0) {
                imageView.setImageResource(R.drawable.ooo);
                user = 1;


            }

            for (int[] winPos : winningPositions) {
                if (gameState[winPos[0]] == gameState[winPos[1]] && gameState[winPos[1]] == gameState[winPos[2]] && gameState[winPos[0]] != 2) {
                    gameActive = false;
                    String message = "";
                    if (gameState[winPos[0]] == gameState[winPos[1]] && gameState[winPos[0]] == gameState[winPos[2]] && gameState[winPos[0]] == 1) {
                        message = "X";
                    } else {
                        message = "O";
                    }

                    Button tryAgain = (Button) findViewById(R.id.playAgain);
                    TextView text = (TextView) findViewById(R.id.winnerTextview);
                    text.setText(message + " has won");
                    text.setVisibility(View.VISIBLE);
                    tryAgain.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playagain(View view) {
        Button tryAgain = (Button) findViewById(R.id.playAgain);
        TextView text = (TextView) findViewById(R.id.winnerTextview);
        text.setVisibility(View.INVISIBLE);
        tryAgain.setVisibility(View.INVISIBLE);

      GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        for (int i =0; i<gridLayout.getChildCount(); i++){
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
       for (int  i = 0; i<gameState.length; i++){
           gameState[i] = 2;
       }
        gameActive = true;
         user = 1;




    }
}