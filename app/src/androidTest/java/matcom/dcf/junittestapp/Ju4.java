package matcom.dcf.junittestapp;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
    FileOutputStream fos;

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
       //
       // Get Screenshot
       Bitmap screenshot = InstrumentationRegistry.getInstrumentation().getUiAutomation().takeScreenshot();
//       File fldr = new File(Environment.getExternalStorageState()+"/DF");
//       if (!fldr.exists()) {
//           boolean success = fldr.mkdir();
//       }

       String file = saveToInternalSorage(screenshot);
       //
        //Retrieve the top-level window decor view
        final View decorView = main.get().getWindow().getDecorView();

        //Verify that the mClickMeButton is on screen
       Spoon.screenshot(main.get(), "initial_state");
        assertNotNull(mClickMeButton);
    }
    private String saveToInternalSorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(main.get());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");

        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream(mypath);

            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directory.getAbsolutePath();
    }

}