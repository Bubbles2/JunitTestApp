package matcom.dcf.junittestapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


/**
 *  Simple converter Activity
 */
public class MainActivity extends Activity {

    EditText from;
    EditText to;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This manages the conversion button
     *
     *  @param   view id of View
     * @return void
     */
    public void convert(View view) {
        from = (EditText) findViewById(R.id.txtFrom);
        to = (EditText)   findViewById(R.id.txtTo);
        result = (TextView) findViewById(R.id.txtResult);
        //
        int fr = Integer.parseInt(from.getText().toString());
        to.setText(""+(fr*2));
        //result.setText(""+(fr*2));


    }
}
