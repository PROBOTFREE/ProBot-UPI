package a;

import android.text.Editable;
import android.text.TextWatcher;
import com.mintoak.paylater.PayLaterCustomersActivity;

public class g implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PayLaterCustomersActivity f9a;

    public g(PayLaterCustomersActivity payLaterCustomersActivity) {
        this.f9a = payLaterCustomersActivity;
    }

    public void afterTextChanged(Editable editable) {
        this.f9a.f10979o.filter(editable.toString());
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f9a.f10979o.filter(charSequence.toString());
    }
}
