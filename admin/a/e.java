package a;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.mintoak.paylater.ActivityOtherPaymentCollection;

public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dialog f6a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActivityOtherPaymentCollection f7b;

    public e(ActivityOtherPaymentCollection activityOtherPaymentCollection, Dialog dialog) {
        this.f7b = activityOtherPaymentCollection;
        this.f6a = dialog;
    }

    public void onClick(View view) {
        this.f6a.dismiss();
        ActivityOtherPaymentCollection activityOtherPaymentCollection = this.f7b;
        if (!TextUtils.isEmpty(activityOtherPaymentCollection.f10938q)) {
            Intent intent = new Intent();
            intent.putExtra("goBack", true);
            activityOtherPaymentCollection.setResult(-1, intent);
            activityOtherPaymentCollection.finish();
            return;
        }
        activityOtherPaymentCollection.onBackPressed();
    }
}
