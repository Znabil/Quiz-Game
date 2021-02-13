package go.team.quizgame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

class GameActivity extends AppCompatActivity {
    private ProgressBar pb;
    private int current = 0;
    private int MAX = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_view_);

        pb = findViewById(R.id.progressBar);

        new MyThread().start();
    }

    class MyThread extends Thread{
        public void run(){
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            while(true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(current == MAX){
                    break;
                }
                current+=10;
                pb.setProgress(current);
            }
        }
    }


}
