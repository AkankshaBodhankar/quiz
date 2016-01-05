package quiz.example.akankshabodhankar.quiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

/**
 * Created by akanksha bodhankar on 29-07-2015.
 */
public class first extends Activity {
    RadioGroup r;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;

    TextView scoretv;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        bt = (Button) findViewById(R.id.bq1);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);

        scoretv = (TextView) findViewById(R.id.score);
        r = (RadioGroup) findViewById(R.id.radioGroup);
        r.setOnCheckedChangeListener(c);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),second.class);

                startActivity(i);

            }
        });

    }

    RadioGroup.OnCheckedChangeListener c = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (r1.isChecked()) {
                Toast.makeText(getApplicationContext(), "Sorry your answer is wrong", Toast.LENGTH_LONG).show();


            } else if (r2.isChecked()) {
                if (r1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Sorry your answer is wrong", Toast.LENGTH_LONG).show();

                }
            } else if (r4.isChecked()) {
                if (r1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Sorry your answer is wrong", Toast.LENGTH_LONG).show();



                }
            } else if (r3.isChecked()) {
                MainActivity.score += 100;

                Toast.makeText(getApplicationContext(), "Your Answer is correct", Toast.LENGTH_LONG).show();



            } else {
                Toast.makeText(getApplicationContext(), "Please select an option", Toast.LENGTH_LONG).show();
            }
        }

    };
}

