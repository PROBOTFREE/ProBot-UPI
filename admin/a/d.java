package a;

import android.view.View;
import com.mintoak.paylater.ActivityOtherPaymentCollection;

public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityOtherPaymentCollection f5a;

    public d(ActivityOtherPaymentCollection activityOtherPaymentCollection) {
        this.f5a = activityOtherPaymentCollection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c5, code lost:
        r7.f10928g[r1].setError(r7.f10929h[r1]);
        r0 = r7.f10928g[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
        r0.requestFocus();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r7) {
        /*
            r6 = this;
            com.mintoak.paylater.ActivityOtherPaymentCollection r7 = r6.f5a
            r0 = 0
            r1 = r0
        L_0x0004:
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            int r2 = r2.length
            r3 = 1
            if (r1 >= r2) goto L_0x01b5
            java.lang.String[] r2 = r7.f10926e
            r2 = r2[r1]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "user_input:"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "USER_INPUT"
            com.mintoak.paylater.util.LoggerUtils.E((java.lang.String) r5, (java.lang.String) r4)
            r4 = 2
            if (r1 == r4) goto L_0x01b1
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0042
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            java.lang.String[] r2 = r7.f10929h
            r2 = r2[r1]
            r0.setError(r2)
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
        L_0x003c:
            r0.requestFocus()
        L_0x003f:
            r0 = r3
            goto L_0x01b5
        L_0x0042:
            if (r1 != 0) goto L_0x00d6
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            r2 = r2[r1]
            android.text.Editable r2 = r2.getText()
            java.util.Objects.requireNonNull(r2)
            android.text.Editable r2 = (android.text.Editable) r2
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            int r2 = r2.length()
            r4 = 10
            if (r2 < r4) goto L_0x00c5
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            r2 = r2[r1]
            android.text.Editable r2 = r2.getText()
            java.util.Objects.requireNonNull(r2)
            android.text.Editable r2 = (android.text.Editable) r2
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "9"
            boolean r2 = r2.startsWith(r4)
            if (r2 != 0) goto L_0x00d6
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            r2 = r2[r1]
            android.text.Editable r2 = r2.getText()
            java.util.Objects.requireNonNull(r2)
            android.text.Editable r2 = (android.text.Editable) r2
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "7"
            boolean r2 = r2.startsWith(r4)
            if (r2 != 0) goto L_0x00d6
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            r2 = r2[r1]
            android.text.Editable r2 = r2.getText()
            java.util.Objects.requireNonNull(r2)
            android.text.Editable r2 = (android.text.Editable) r2
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "8"
            boolean r2 = r2.startsWith(r4)
            if (r2 != 0) goto L_0x00d6
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            r2 = r2[r1]
            android.text.Editable r2 = r2.getText()
            java.util.Objects.requireNonNull(r2)
            android.text.Editable r2 = (android.text.Editable) r2
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "6"
            boolean r2 = r2.startsWith(r4)
            if (r2 != 0) goto L_0x00d6
        L_0x00c5:
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            java.lang.String[] r2 = r7.f10929h
            r2 = r2[r1]
            r0.setError(r2)
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            goto L_0x003c
        L_0x00d6:
            if (r1 != r3) goto L_0x01aa
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            r2 = r2[r1]
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "^[0-9]+\\.[0-9]{2}$"
            boolean r2 = r2.matches(r4)
            if (r2 != 0) goto L_0x0106
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            r0.requestFocus()
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.mintoak.paylater.R.string.please_enter_valid_amount
        L_0x00fd:
            java.lang.String r1 = r1.getString(r2)
            r0.setError(r1)
            goto L_0x003f
        L_0x0106:
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            r2 = r2[r1]
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            float r2 = java.lang.Float.parseFloat(r2)
            r4 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x012e
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            r0.requestFocus()
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.mintoak.paylater.R.string.amount_should_be_1_or_greater
            goto L_0x00fd
        L_0x012e:
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            r2 = r2[r1]
            android.text.Editable r2 = r2.getText()
            java.util.Objects.requireNonNull(r2)
            android.text.Editable r2 = (android.text.Editable) r2
            java.lang.String r2 = r2.toString()
            float r2 = java.lang.Float.parseFloat(r2)
            r4 = 1232348160(0x49742400, float:1000000.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x015c
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            r0.requestFocus()
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.mintoak.paylater.R.string.amount_should_be_1000000_or_less
            goto L_0x00fd
        L_0x015c:
            java.lang.String r2 = r7.f10932k
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0191
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            r2 = r2[r1]
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            float r2 = java.lang.Float.parseFloat(r2)
            java.lang.String r4 = r7.f10932k
            float r4 = java.lang.Float.parseFloat(r4)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0191
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            r0.requestFocus()
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.mintoak.paylater.R.string.please_enter_amount_less_than_outstanding
            goto L_0x00fd
        L_0x0191:
            boolean r2 = r7.validDecimal()
            if (r2 != 0) goto L_0x01aa
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            r0.requestFocus()
            com.google.android.material.textfield.TextInputEditText[] r0 = r7.f10928g
            r0 = r0[r1]
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.mintoak.paylater.R.string.please_enter_valid_dec_amount
            goto L_0x00fd
        L_0x01aa:
            com.google.android.material.textfield.TextInputEditText[] r2 = r7.f10928g
            r2 = r2[r1]
            com.mintoak.paylater.util.Utils.hideKeyboard(r2)
        L_0x01b1:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x01b5:
            if (r0 != 0) goto L_0x01cc
            boolean r0 = com.mintoak.paylater.util.Utils.isNetworkConnected(r7)
            if (r0 == 0) goto L_0x01c1
            r7.a()
            goto L_0x01cc
        L_0x01c1:
            int r0 = com.mintoak.paylater.R.string.no_internet
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r1 = ""
            com.mintoak.paylater.util.Utils.popUpDialog(r7, r1, r0)
        L_0x01cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.onClick(android.view.View):void");
    }
}
