package a;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;
import com.mintoak.paylater.PayLaterCustomersActivity;
import com.mintoak.paylater.util.SwipeController;

public class i extends RecyclerView.o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwipeController f11a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PayLaterCustomersActivity f12b;

    public i(PayLaterCustomersActivity payLaterCustomersActivity, SwipeController swipeController) {
        this.f12b = payLaterCustomersActivity;
        this.f11a = swipeController;
    }

    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        this.f11a.onDraw(canvas, this.f12b);
    }
}
