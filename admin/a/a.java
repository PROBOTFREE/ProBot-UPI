package a;

import android.view.View;
import com.google.android.material.textfield.TextInputLayout;
import com.mintoak.paylater.ActivityOtherPaymentCollection;
import com.mintoak.paylater.R;

public class a implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f0a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActivityOtherPaymentCollection f1b;

    public a(ActivityOtherPaymentCollection activityOtherPaymentCollection, int i10) {
        this.f1b = activityOtherPaymentCollection;
        this.f0a = i10;
    }

    public void onFocusChange(View view, boolean z10) {
        TextInputLayout textInputLayout;
        int i10;
        ActivityOtherPaymentCollection activityOtherPaymentCollection = this.f1b;
        if (z10) {
            textInputLayout = activityOtherPaymentCollection.f10927f[this.f0a];
            i10 = activityOtherPaymentCollection.f10925d.getPrimaryTextColor();
        } else {
            textInputLayout = activityOtherPaymentCollection.f10927f[this.f0a];
            i10 = activityOtherPaymentCollection.getColor(R.color.box_stroke_color);
        }
        textInputLayout.setBoxStrokeColor(i10);
    }
}
