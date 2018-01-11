package com.example.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    // 0 = Red, 1 = Yellow
    int activePlayer=0;
    //inactive state, sets all 9(0-8) sqaures state to be 2 viz., gamestate[8]=2
    // An Array of the unfilled positions on the Grid
    int[] gameState={ 2, 2, 2, 2, 2, 2, 2, 2, 2 };

    //Winning positions
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {0,4,6}};

    public void dropIn(View view){
        ImageView counter= (ImageView) view; //the user's tap converted into exact ImgView
        //System.out.println(counter.getTag().toString());

        //tapped counter gets the Tag no on the grid
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        //if tapped counter is unplayed
        if(gameState[tappedCounter] == 2) {

            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.red); //displays red
                activePlayer = 1;  //sets active player to player 1

            } else {
                counter.setImageResource(R.drawable.yellow); //displays yellow
                activePlayer = 0;  //sets active player to player 0
            }
            counter.animate().rotationBy(180f);

            //Loop through all winning positions
            for(int[] winningPosition : winningPositions){

                if(gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[0]] == gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] != 2) {

                    System.out.println(gameState[winningPosition[0]]);

                    //Someone has won

                    LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.playAgain);
                    winnerLayout.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
