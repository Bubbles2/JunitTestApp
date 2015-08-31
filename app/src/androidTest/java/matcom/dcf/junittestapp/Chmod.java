package matcom.dcf.junittestapp;

import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;

abstract class Chmod {
    private static final Chmod INSTANCE;

    Chmod() {
    }

    static void chmodPlusR(File file) {
        INSTANCE.plusR(file);
    }

    static void chmodPlusRWX(File file) {
        INSTANCE.plusRWX(file);
    }

    protected abstract void plusR(File var1);

    protected abstract void plusRWX(File var1);

    static {
        if(VERSION.SDK_INT >= 9) {
            INSTANCE = new Chmod.Java6Chmod();
        } else {
            INSTANCE = new Chmod.Java5Chmod();
        }

    }

    private static class Java6Chmod extends Chmod {
        private Java6Chmod() {
        }

        protected void plusR(File file) {
            file.setReadable(true, false);
        }

        protected void plusRWX(File file) {
            file.setReadable(true, false);
            file.setWritable(true, false);
            file.setExecutable(true, false);
        }
    }

    private static class Java5Chmod extends Chmod {
        private Java5Chmod() {
        }

        protected void plusR(File file) {
            try {
                Runtime.getRuntime().exec(new String[]{"chmod", "644", file.getAbsolutePath()});
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }

        protected void plusRWX(File file) {
            try {
                Runtime.getRuntime().exec(new String[]{"chmod", "777", file.getAbsolutePath()});
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }
    }
}
