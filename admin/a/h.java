package a;

import android.content.Intent;
import android.net.Uri;
import com.mintoak.paylater.PayLaterCustomersActivity;
import com.mintoak.paylater.util.LoggerUtils;
import com.mintoak.paylater.util.SwipeControllerActions;

public class h extends SwipeControllerActions {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PayLaterCustomersActivity f10a;

    public h(PayLaterCustomersActivity payLaterCustomersActivity) {
        this.f10a = payLaterCustomersActivity;
    }

    public void onLeftClicked(int i10) {
        LoggerUtils.E("onLeftSwipe");
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + this.f10a.f10990z.get(i10).getMobile()));
        this.f10a.startActivity(intent);
    }

    public void onRightClicked(int i10) {
        LoggerUtils.E("onRightSwipe");
        this.f10a.onClickWhatsApp(this.f10a.f10990z.get(i10));
    }
}
