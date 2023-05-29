package pl.nobleprog.gus.snake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    private final List<SnakePoints> snakePointsList = new ArrayList<>();
    private SurfaceView surfaceView;
    private TextView scoreTV;


    private SurfaceHolder surfaceHolder;
    // snake moving posotion. Values must be right, left, top, bottom
    // by defalut snake move to right
    private String movingPosition ="right";

    //score
    private int score = 0;

    //snake size / point size
    private static final int pointSize = 28;

    // defalut snake tale
    private static final int defaultTalePoints = 3;

    private static final int snakeColor = Color.YELLOW;

    private static final int snakeMovingSpeed = 800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting surfaceview and score TextView from xml file
        surfaceView = findViewById(R.id.surfaceView);
        scoreTV = findViewById(R.id.scoreTV);

        //getting ImageButtons from xml file
        final AppCompatImageButton topBtn = findViewById(R.id.topBtn);
        final AppCompatImageButton leftBtn = findViewById(R.id.leftBtn);
        final AppCompatImageButton rightBtn = findViewById(R.id.rightBtn);
        final AppCompatImageButton bottomBtn = findViewById(R.id.bottomBtn);

        // adding callback to surfaceview
        surfaceView.getHolder().addCallback(this);

        topBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!movingPosition.equals("bottom")) {
                    movingPosition = "top";
                }
            }
        });

        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!movingPosition.equals("left")) {
                    movingPosition = "right";
                }
            }
        });

        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!movingPosition.equals("right")) {
                    movingPosition = "left";
                }

            }
        });

        bottomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!movingPosition.equals("top")) {
                    movingPosition = "bottom";
                }
            }
        });
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

        this.surfaceHolder = surfaceHolder;

        // init data for snake
        init();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    private void init(){


        snakePointsList.clear();
        // defalut score
        scoreTV.setText("0");

        score = 0;
        //defalut moving position
        movingPosition = "rigth";

        int startPositionX = (pointSize) * defaultTalePoints;

        // making snakes defalut length
        for (int i = 0; i < defaultTalePoints; i++) {

            //adding points to snakes tale
            SnakePoints snakePoints = new SnakePoints(startPositionX, pointSize);
            snakePointsList.add(snakePoints);
        }
    }
}