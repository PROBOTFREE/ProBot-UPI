package androidx.databinding;

import androidx.databinding.h;

public class a implements h {
    private transient m mCallbacks;

    public void addOnPropertyChangedCallback(h.a aVar) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new m();
            }
        }
        this.mCallbacks.a(aVar);
    }

    public void notifyChange() {
        synchronized (this) {
            m mVar = this.mCallbacks;
            if (mVar != null) {
                mVar.g(this, 0, null);
            }
        }
    }

    public void notifyPropertyChanged(int i10) {
        synchronized (this) {
            m mVar = this.mCallbacks;
            if (mVar != null) {
                mVar.g(this, i10, null);
            }
        }
    }

    public void removeOnPropertyChangedCallback(h.a aVar) {
        synchronized (this) {
            m mVar = this.mCallbacks;
            if (mVar != null) {
                mVar.n(aVar);
            }
        }
    }
}
