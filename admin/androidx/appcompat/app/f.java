package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.c;

public class f extends c {
    public Dialog onCreateDialog(Bundle bundle) {
        return new e(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i10) {
        if (dialog instanceof e) {
            e eVar = (e) dialog;
            if (!(i10 == 1 || i10 == 2)) {
                if (i10 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            eVar.d(1);
            return;
        }
        super.setupDialog(dialog, i10);
    }
}
