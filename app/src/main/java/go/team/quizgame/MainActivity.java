package go.team.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.game_view_);
        Intent it=new Intent(this, GameActivity.class);
        startActivity(it);
        MainActivity.this.finish();
    }
}