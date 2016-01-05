package quiz.example.akankshabodhankar.quiz;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by akanksha bodhankar on 30-07-2015.
 */
public class result extends Activity {
    TextView tv,score;
    EditText et;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        int sco = MainActivity.score;
        insert();
        tv= (TextView)findViewById(R.id.retake);
        score= (TextView)findViewById(R.id.score);
        bt = (Button)findViewById(R.id.button5);
        score.setText("" + sco);
        MainActivity.score=0;
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });

    }
    public void insert(){

        int sco = MainActivity.score;
        et = (EditText)findViewById(R.id.editText);
        String name = et.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put("score",sco);
        cv.put("name", name);
        long r = MainActivity.db.insert("scores",null,cv);
        if(r==-1)
            Toast.makeText(getApplicationContext(), "Text not inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(),"Text inserted",Toast.LENGTH_LONG).show();


    }
}
