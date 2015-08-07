package matcom.dcf.junittestapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.view.View;

import junit.framework.TestCase;

/**
 * Created by dfinlay on 07/08/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    //
    private MainActivity activity;

    //
    public MainActivityTest() {
        super(MainActivity.class);
    }


    public void setUp() throws Exception {
        super.setUp();
        //
        // this must be called before getActivity()
        // disabling touch mode allows for sending key events
        setActivityInitialTouchMode(false);
        activity = getActivity();
    }
    //
    @UiThreadTest
    public void testLaunchingSubActivityFiresIntentAndFinishesSelf() {
         View button = activity.findViewById(R.id.btnConvert);
         button.performClick();
         assertNotNull(button);
    }

}