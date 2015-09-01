package matcom.dcf.junittestapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import junit.framework.TestCase;

import static android.test.ViewAsserts.assertLeftAligned;
import static android.test.ViewAsserts.assertOnScreen;

/**
 * Created by dfinlay on 07/08/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    //
    private MainActivity myactivity;
    private Button mClickMeButton;
    private EditNumber mFrom;
    private EditNumber mTo;

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
        mFrom = (EditNumber) myactivity.findViewById(R.id.txtFrom);
        mTo =  (EditNumber) myactivity.findViewById(R.id.txtTo);

    }

    /**
     *  Basic test fields and buttons exist
     */
    public final void testHasInputFields() {
        assertNotNull(mFrom);
        assertNotNull(mTo);
        assertNotNull(mClickMeButton);
    }

    /**
     *  Test fields start empty
     */
    public void testFieldsShouldStartEmpty() {
        assertEquals("", mFrom.getText().toString());
        assertEquals("", mTo.getText().toString());
    }

    /**
     * Test fields are screen
     * Should have import static android.test.ViewAsserts.assertOnScreen;
     */
    public void testFieldsOnScreen() {
        View origin = myactivity.getWindow().getDecorView();
        assertOnScreen(origin, mFrom);
        assertOnScreen(origin, mTo);
    }

    /**
     *  Test fields are aligned
     */
    public void testAlignment() {
        assertLeftAligned(mFrom, mTo);
    }
    //


    /**
     *  Test that from field is MATCH_Parent as per spec
     */
    public void testFromInputFieldCoversEntireScreen() {
        ViewGroup.LayoutParams lp;
        int expected = RelativeLayout.LayoutParams.MATCH_PARENT;
        lp = mFrom.getLayoutParams();
        assertEquals("From width is not MATCH_PARENT",
                expected, lp.width);
    }

    /**
     *  Test font size is correct
     */
    public void testFontSizes() {
        float pixelSize = 36f;
        assertEquals(pixelSize, mFrom.getTextSize());
        assertEquals(pixelSize, mTo.getTextSize());
////        // use the sp value in the test
//        float pixelSize = getFloatPixelSize(R.dimen.label_text_size);
//        assertEquals(pixelSize, mFrom.getTextSize());
//        assertEquals(pixelSize, mTo.getTextSize());
    }

    /**
     *  Test margins
     */
    public void testFromInputMargins() {
        RelativeLayout.LayoutParams lp =
                (RelativeLayout.LayoutParams) mFrom.getLayoutParams();
        assertEquals(74, lp.leftMargin);
    }
    //

    /**
     *  Test Gravity has been correctly set
     */
    public void testFromInputJustification() {
        int expectedGravity = Gravity.END | Gravity.CENTER_VERTICAL;
        int actual = mFrom.getGravity();
        String errorMessage = String.format(
                "Expected 0x%02x but was 0x%02x", expectedGravity, actual);
        assertEquals(errorMessage, expectedGravity, actual);
    }
    //

    /**
     *  Test space is available for keyboard
     *  Should probably put in a scroll view
     */
    public void testVirtualKeyboardSpaceReserved() {
        int expected = getIntPixelSize(R.dimen.keyboard_space);
        int actual = mTo.getBottom();
        String errorMessage =
                "Space not reserved, expected " + expected + " actual " + actual;
        assertTrue(errorMessage, actual <= expected);
    }
    @UiThreadTest
    /**
     *  Test conversion
     */
    public void testFahrenheitToCelsiusConversion() {
        mFrom.clear();
        mTo.clear();
        mFrom.requestFocus();
        mFrom.setText("32.5");
        mTo.requestFocus();
        double f = 32.5;
        double expectedC = TemperatureConverter.fahrenheitToCelsius(f);
        double actualC = mFrom.getNumber();
        double delta = Math.abs(expectedC - actualC);
        String msg = "" + f + "F -> " + expectedC + "C but was "
                + actualC + "C (delta " + delta + ")";
        assertTrue(msg, delta < 0.005);
    }

    @UiThreadTest
    public void testLaunchingSubActivityFiresIntentAndFinishesSelf() {
        //Retrieve the top-level window decor view
        final View decorView = myactivity.getWindow().getDecorView();
        //Spoon.screenshot(myactivity, "initial_state");
        //Verify that the mClickMeButton is on screen
        assertNotNull(mClickMeButton);
    }

    /**
     * Convenience method to convert pixel size to in
     *
     * @param dimensionResourceId
     * @return
     */
    private int getIntPixelSize(int dimensionResourceId) {
        return (int) getFloatPixelSize(dimensionResourceId);
    }
    private float getFloatPixelSize(int dimensionResourceId) {
        return getActivity().getResources()
                .getDimensionPixelSize(dimensionResourceId);
    }

}