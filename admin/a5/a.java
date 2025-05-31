package a5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import c5.g;

public class a extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f122a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f123b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f124c;

    public static a a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        a aVar = new a();
        Dialog dialog2 = (Dialog) g.k(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        aVar.f122a = dialog2;
        if (onCancelListener != null) {
            aVar.f123b = onCancelListener;
        }
        return aVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f123b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f122a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f124c == null) {
            this.f124c = new AlertDialog.Builder((Context) g.j(getActivity())).create();
        }
        return this.f124c;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
