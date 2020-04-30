package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.GridLayout;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    boolean gameActive = true;
    int[] Status = {2,2,2,2,2,2,2,2,2};

    int[][] win = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void connect(View view) {

        ImageView iv = (ImageView) view;

        int tag = Integer.parseInt(iv.getTag().toString());
        if (gameActive == true) {
            if (Status[tag] == 2) {
                iv.setTranslationY(-1000f);

                if (activePlayer == 0) {
                    Status[tag] = 0;
                    iv.setImageResource(R.drawable.blue);
                    activePlayer = 1;

                } else
                    {
                    Status[tag] = 1;
                    iv.setImageResource(R.drawable.pink);
                    activePlayer = 0;
                }
                iv.animate().translationYBy(1000f).setDuration(200);

                for (int[] x : win) {
                    if (Status[x[0]] == Status[x[1]] && Status[x[1]] == Status[x[2]] && Status[x[0]] != 2) {
                        gameActive = false;

                        if (Status[x[0]] == 0) {

                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("Blue wins!");

                            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
                            linearLayout.setVisibility(View.VISIBLE);
                        } else {

                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("Pink wins!");

                            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
                            linearLayout.setVisibility(View.VISIBLE);
                        }

                    /*for (int j = 0; j < 9; j++)
                    {
                        Status[j] = 3;
                    }*/ //this is wrong!

                    } else {
                        int flag = 0;
                        for (int j = 0; j < 9; j++) {
                            if (Status[j] != 2) {
                                flag++;
                            }
                            if (flag == 9) {

                                TextView textView = (TextView) findViewById(R.id.textView);
                                textView.setText("It's a draw!");

                                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
                                linearLayout.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }
            }
        }

    }
        public void again (View view)
        {
            gameActive = true;
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
            linearLayout.setVisibility(View.INVISIBLE);
            activePlayer = 0;
            //boolean gameActive = true;

            for(int j = 0 ;j < Status.length ; j++)
            {
                Status[j] = 2;
            }

            androidx.gridlayout.widget.GridLayout grid = findViewById(R.id.grid);
            int g = grid.getChildCount();
            for (int i = 0; i < g; i++)
            {
                ((ImageView) grid.getChildAt(i)).setImageResource(0);


            }



        }



}
