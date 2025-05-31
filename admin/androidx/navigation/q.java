package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.i;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class q<D extends i> {

    public interface a {
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String value();
    }

    public abstract D a();

    public abstract i b(D d10, Bundle bundle, n nVar, a aVar);

    public void c(Bundle bundle) {
    }

    public Bundle d() {
        return null;
    }

    public abstract boolean e();
}
