package matcom.dcf.junittestapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.TestCase;

/**
 * Created by dfinlay on 07/08/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    //
    private MainActivity myactivity;
    private Button mClickMeButton;
    private TextView mFrom;

    //


    //
    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //
        // this must be called before getActivity()
        // disabling touch mode allows for sending key events
        setActivityInitialTouchMode(true);
        // Start the main activity of the application under test
         myactivity = getActivity();
        //
        //Get references to all views
        mClickMeButton = (Button) myactivity.findViewById(R.id.btnConvert);
        mFrom = (TextView) myactivity.findViewById(R.id.txtFrom);

    }
    //
    @UiThreadTest
    public void testLaunchingSubActivityFiresIntentAndFinishesSelf() {
        //Retrieve the top-level window decor view
        final View decorView = myactivity.getWindow().getDecorView();

        //Verify that the mClickMeButton is on screen
        assertNotNull(mClickMeButton);
    }

}