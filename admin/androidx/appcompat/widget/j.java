package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import androidx.core.view.c;
import androidx.core.view.x;
import y0.b;
import y0.c;

final class j {

    class a implements b.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f1114a;

        a(View view) {
            this.f1114a = view;
        }

        public boolean a(c cVar, int i10, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 25 && (i10 & 1) != 0) {
                try {
                    cVar.d();
                    InputContentInfo inputContentInfo = (InputContentInfo) cVar.e();
                    bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                    bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
                } catch (Exception e10) {
                    Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e10);
                    return false;
                }
            }
            return x.g0(this.f1114a, new c.a(new ClipData(cVar.b(), new ClipData.Item(cVar.a())), 2).d(cVar.c()).b(bundle).a()) == null;
        }
    }

    private static final class b {
        /* JADX INFO: finally extract failed */
        static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                x.g0(textView, new c.a(dragEvent.getClipData(), 3).a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        static boolean b(DragEvent dragEvent, View view, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            x.g0(view, new c.a(dragEvent.getClipData(), 3).a());
            return true;
        }
    }

    static b.c a(View view) {
        return new a(view);
    }

    static boolean b(View view, DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null && x.F(view) != null) {
            Activity d10 = d(view);
            if (d10 == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    return view instanceof TextView ? b.a(dragEvent, (TextView) view, d10) : b.b(dragEvent, view, d10);
                }
            }
        }
        return false;
    }

    static boolean c(TextView textView, int i10) {
        int i11 = 0;
        if ((i10 != 16908322 && i10 != 16908337) || x.F(textView) == null) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            c.a aVar = new c.a(primaryClip, 1);
            if (i10 != 16908322) {
                i11 = 1;
            }
            x.g0(textView, aVar.c(i11).a());
        }
        return true;
    }

    static Activity d(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
