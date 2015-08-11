package matcom.dcf.junittestapp;

import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by dfinlay on 07/08/15.
 */

@RunWith(AndroidJUnit4.class)
public class Ju4  {
    //
    private MainActivity myactivity;
    private Button mClickMeButton;
    private TextView mFrom;

    //


    //
    @Rule
    public final ActivityRule<MainActivity> main = new ActivityRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {

        //Get references to all views
        mClickMeButton = (Button) main.get().findViewById(R.id.btnConvert);
        mFrom = (TextView) main.get().findViewById(R.id.txtFrom);

    }
   @Test
    public void testLaunchingSubActivityFiresIntentAndFinishesSelf() {
        //Retrieve the top-level window decor view
        final View decorView = main.get().getWindow().getDecorView();

        //Verify that the mClickMeButton is on screen
        assertNotNull(mClickMeButton);
    }

}