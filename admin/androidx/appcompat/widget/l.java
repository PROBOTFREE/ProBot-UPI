package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import w0.h;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1141a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f1142b;

    l(TextView textView) {
        this.f1141a = (TextView) h.e(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1142b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1141a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    public void b(TextClassifier textClassifier) {
        this.f1142b = textClassifier;
    }
}
