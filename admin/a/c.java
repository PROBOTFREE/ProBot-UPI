package a;

import android.view.View;
import com.mintoak.paylater.ActivityOtherPaymentCollection;

public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityOtherPaymentCollection f4a;

    public c(ActivityOtherPaymentCollection activityOtherPaymentCollection) {
        this.f4a = activityOtherPaymentCollection;
    }

    public void onClick(View view) {
        this.f4a.finish();
    }
}
