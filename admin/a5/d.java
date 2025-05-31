package a5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import c5.g;

public class d extends c {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f126a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f127b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f128c;

    public static d h(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        d dVar = new d();
        Dialog dialog2 = (Dialog) g.k(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        dVar.f126a = dialog2;
        if (onCancelListener != null) {
            dVar.f127b = onCancelListener;
        }
        return dVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f127b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f126a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f128c == null) {
            this.f128c = new AlertDialog.Builder((Context) g.j(getContext())).create();
        }
        return this.f128c;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
