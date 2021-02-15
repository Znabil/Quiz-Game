package go.team.quizgame;


import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.ref.WeakReference;

public class GameActivity extends AppCompatActivity {
    private ProgressBar pb;
    private int current = 0;
    private final int MAX = 100;
    private Handler handler1 = new MyHandler(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view);

        //pb = findViewById(R.id.progressBar);


        //new MyThread().start();
    }


    private class MyHandler extends Handler {
        private final WeakReference<GameActivity> mTarget;

        public MyHandler(GameActivity activity) {
            mTarget = new WeakReference<GameActivity>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                GameActivity ga = mTarget.get();
                ga.pb.setProgress(current);
                current+=10;
            }
        }
    }
//    class MyHandler extends Handler {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            int code = msg.what;
//            switch (code){
//                case 1:
//                    current+=10;
//                    pb.setProgress(current);
//                    break;
//            }
//        }
//    }

    class MyThread extends Thread{
        public void run(){
            super.run();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            while(current<=MAX){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler1.sendEmptyMessage(1);
                //myHandler.sendMessage(msg);
            }
        }
    }


}
