package a;

import com.mintoak.paylater.PayLaterStoreListActivity;
import com.mintoak.paylater.filter.interfaces.LocationFilterApplyCallBack;
import com.mintoak.paylater.filter.model.CidLevelModel;
import com.mintoak.paylater.filter.model.CityLevelModel;
import com.mintoak.paylater.filter.model.DbaLevelModel;
import com.mintoak.paylater.filter.model.MidLevelModel;
import com.mintoak.paylater.filter.model.TerminalLevelModel;
import java.util.List;

public class j implements LocationFilterApplyCallBack {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PayLaterStoreListActivity f13a;

    public j(PayLaterStoreListActivity payLaterStoreListActivity) {
        this.f13a = payLaterStoreListActivity;
    }

    public void allSelectedData(CidLevelModel cidLevelModel, List<DbaLevelModel> list, List<CityLevelModel> list2, List<MidLevelModel> list3, List<TerminalLevelModel> list4) {
        PayLaterStoreListActivity payLaterStoreListActivity = this.f13a;
        int i10 = PayLaterStoreListActivity.f11004a;
        payLaterStoreListActivity.a(cidLevelModel, list3);
    }

    public void onCidSelected(CidLevelModel cidLevelModel) {
    }

    public void onCitySelected(List<CityLevelModel> list) {
    }

    public void onDBASelected(List<DbaLevelModel> list) {
    }

    public void onMidSelected(List<MidLevelModel> list) {
    }

    public void onTidSelected(List<TerminalLevelModel> list) {
    }
}
