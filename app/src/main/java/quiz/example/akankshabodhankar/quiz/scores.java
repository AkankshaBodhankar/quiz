package quiz.example.akankshabodhankar.quiz;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by akanksha bodhankar on 17-08-2015.
 */
public class scores extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores);
        show();

    }
    public  void show()
    {
        Cursor result = MainActivity.db.rawQuery("select *from scores order by score",null);
        TableLayout tb = (TableLayout)findViewById(R.id.tablay);
        tb.removeAllViews();
        if(result.moveToFirst())  // true if only first row exists
        {
            do {
                TableRow tr = new TableRow(getApplicationContext());
                TextView t1 = new TextView(getApplicationContext());
                TextView t2 = new TextView(getApplicationContext());
                int score = result.getInt(0);
                String name = result.getString(1);
                t1.setText(score+"   ");
                t2.setText(name+"   ");
                t1.setTextColor(Color.RED);
                t2.setTextColor(Color.RED);
                t1.setTextSize(20);
                t2.setTextSize(20);
                tr.addView(t1);
                tr.addView(t2);
                tb.addView(tr);
                tb.setBackgroundColor(Color.WHITE);

            }
            while(result.moveToNext());

        }

    }
}
