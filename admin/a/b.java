package a;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import com.mintoak.paylater.ActivityOtherPaymentCollection;
import com.mintoak.paylater.R;
import com.mintoak.paylater.util.Utils;

public class b implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActivityOtherPaymentCollection f3b;

    public b(ActivityOtherPaymentCollection activityOtherPaymentCollection, int i10) {
        this.f3b = activityOtherPaymentCollection;
        this.f2a = i10;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f3b.f10926e[this.f2a] = charSequence.toString().trim();
        if (this.f2a == 0 && charSequence.length() == 10) {
            Utils.hideKeyboard(this.f3b.f10928g[this.f2a]);
        }
        if (this.f2a == 1) {
            if (charSequence.toString().length() == 0) {
                this.f3b.f10928g[this.f2a].setHint("0.00");
                ActivityOtherPaymentCollection activityOtherPaymentCollection = this.f3b;
                activityOtherPaymentCollection.f10928g[this.f2a].setHintTextColor(activityOtherPaymentCollection.getResources().getColor(R.color.burmudaGrey));
                Selection.setSelection(this.f3b.f10928g[this.f2a].getText(), this.f3b.f10928g[this.f2a].getText().toString().length());
            }
            if (charSequence.toString().length() == 1) {
                TextInputEditText textInputEditText = this.f3b.f10928g[this.f2a];
                textInputEditText.setText("0.0" + charSequence.toString());
                Selection.setSelection(this.f3b.f10928g[this.f2a].getText(), this.f3b.f10928g[this.f2a].getText().toString().length());
            }
            if (!charSequence.toString().matches("(\\d{1,3}(\\,\\d{3})*|(\\d+))(\\.\\d{2})?$")) {
                StringBuilder sb2 = new StringBuilder("" + charSequence.toString().replaceAll("[^\\d]", ""));
                while (sb2.length() > 3 && sb2.charAt(0) == '0') {
                    sb2.deleteCharAt(0);
                }
                while (sb2.length() < 3) {
                    sb2.insert(0, '0');
                }
                sb2.insert(sb2.length() - 2, '.');
                this.f3b.f10928g[this.f2a].setText(sb2.toString());
                Selection.setSelection(this.f3b.f10928g[this.f2a].getText(), sb2.toString().length());
            }
            if (charSequence.length() != 0) {
                Utils.checkAndSetDot(charSequence, this.f3b.f10928g[this.f2a]);
            }
            if (!this.f3b.validDecimal()) {
                ActivityOtherPaymentCollection activityOtherPaymentCollection2 = this.f3b;
                activityOtherPaymentCollection2.f10928g[this.f2a].setError(activityOtherPaymentCollection2.getResources().getString(R.string.please_enter_valid_dec_amount));
                return;
            }
            this.f3b.f10928g[this.f2a].setError((CharSequence) null);
        }
    }
}
