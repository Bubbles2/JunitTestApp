package matcom.dcf.junittestapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by dfinlay on 31/08/15.
 */
public class EditNumber extends EditText {
    public EditNumber(Context context) {
        super(context);
    }

    public EditNumber(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }
    public EditNumber(Context context, AttributeSet attrs) {

        super(context, attrs); // This should be first line of constructor
    }

    public void clear() {
    }

    public double getNumber() {
        return 0;
    }
}


