package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.c;
import androidx.navigation.NavController;
import androidx.navigation.fragment.a;
import androidx.navigation.l;
import androidx.navigation.p;
import androidx.navigation.q;
import androidx.navigation.t;

public class NavHostFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private l f3146a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f3147b = null;

    /* renamed from: c  reason: collision with root package name */
    private View f3148c;

    /* renamed from: d  reason: collision with root package name */
    private int f3149d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3150e;

    public static NavController i(Fragment fragment) {
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
            if (fragment2 instanceof NavHostFragment) {
                return ((NavHostFragment) fragment2).k();
            }
            Fragment z02 = fragment2.getParentFragmentManager().z0();
            if (z02 instanceof NavHostFragment) {
                return ((NavHostFragment) z02).k();
            }
        }
        View view = fragment.getView();
        if (view != null) {
            return p.a(view);
        }
        Dialog dialog = fragment instanceof c ? ((c) fragment).getDialog() : null;
        if (dialog != null && dialog.getWindow() != null) {
            return p.a(dialog.getWindow().getDecorView());
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
    }

    private int j() {
        int id2 = getId();
        return (id2 == 0 || id2 == -1) ? b.nav_host_fragment_container : id2;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public q<? extends a.C0032a> h() {
        return new a(requireContext(), getChildFragmentManager(), j());
    }

    public final NavController k() {
        l lVar = this.f3146a;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    /* access modifiers changed from: protected */
    public void l(NavController navController) {
        navController.i().a(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
        navController.i().a(h());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.f3150e) {
            getParentFragmentManager().m().v(this).j();
        }
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        ((DialogFragmentNavigator) this.f3146a.i().d(DialogFragmentNavigator.class)).h(fragment);
    }

    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        l lVar = new l(requireContext());
        this.f3146a = lVar;
        lVar.y(this);
        this.f3146a.z(requireActivity().getOnBackPressedDispatcher());
        l lVar2 = this.f3146a;
        Boolean bool = this.f3147b;
        int i10 = 0;
        lVar2.b(bool != null && bool.booleanValue());
        Bundle bundle3 = null;
        this.f3147b = null;
        this.f3146a.A(getViewModelStore());
        l(this.f3146a);
        if (bundle != null) {
            bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
            if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                this.f3150e = true;
                getParentFragmentManager().m().v(this).j();
            }
            this.f3149d = bundle.getInt("android-support-nav:fragment:graphId");
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.f3146a.t(bundle2);
        }
        int i11 = this.f3149d;
        if (i11 != 0) {
            this.f3146a.v(i11);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                i10 = arguments.getInt("android-support-nav:fragment:graphId");
            }
            if (arguments != null) {
                bundle3 = arguments.getBundle("android-support-nav:fragment:startDestinationArgs");
            }
            if (i10 != 0) {
                this.f3146a.w(i10, bundle3);
            }
        }
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(j());
        return fragmentContainerView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        View view = this.f3148c;
        if (view != null && p.a(view) == this.f3146a) {
            p.d(this.f3148c, (NavController) null);
        }
        this.f3148c = null;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(t.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.f3149d = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, c.NavHostFragment);
        if (obtainStyledAttributes2.getBoolean(c.NavHostFragment_defaultNavHost, false)) {
            this.f3150e = true;
        }
        obtainStyledAttributes2.recycle();
    }

    public void onPrimaryNavigationFragmentChanged(boolean z10) {
        l lVar = this.f3146a;
        if (lVar != null) {
            lVar.b(z10);
        } else {
            this.f3147b = Boolean.valueOf(z10);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle u10 = this.f3146a.u();
        if (u10 != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", u10);
        }
        if (this.f3150e) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i10 = this.f3149d;
        if (i10 != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i10);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            p.d(view, this.f3146a);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.f3148c = view2;
                if (view2.getId() == getId()) {
                    p.d(this.f3148c, this.f3146a);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }
}
