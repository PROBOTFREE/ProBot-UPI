package a;

import com.mintoak.paylater.PayLaterTransactionDetail;
import com.mintoak.paylater.filter.interfaces.LocationFilterApplyCallBack;
import com.mintoak.paylater.filter.model.CidLevelModel;
import com.mintoak.paylater.filter.model.CityLevelModel;
import com.mintoak.paylater.filter.model.DbaLevelModel;
import com.mintoak.paylater.filter.model.MidLevelModel;
import com.mintoak.paylater.filter.model.TerminalLevelModel;
import com.mintoak.paylater.util.LoggerUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class k implements LocationFilterApplyCallBack {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PayLaterTransactionDetail f14a;

    public k(PayLaterTransactionDetail payLaterTransactionDetail) {
        this.f14a = payLaterTransactionDetail;
    }

    public void allSelectedData(CidLevelModel cidLevelModel, List<DbaLevelModel> list, List<CityLevelModel> list2, List<MidLevelModel> list3, List<TerminalLevelModel> list4) {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        if (this.f14a.U.getProjectType() == 8) {
            arrayList.add(this.f14a.U.getTerminalId());
        } else {
            for (int i10 = 0; i10 < list3.size(); i10++) {
                MidLevelModel midLevelModel = list3.get(i10);
                for (int i11 = 0; i11 < midLevelModel.getTerminalLevelModels().size(); i11++) {
                    arrayList.add(midLevelModel.getTerminalLevelModels().get(i11).getTid());
                }
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(arrayList);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tidList", jSONArray.toString());
            jSONObject.put("custId", this.f14a.E);
            PayLaterTransactionDetail payLaterTransactionDetail = this.f14a;
            payLaterTransactionDetail.K.getPLCustDetails(jSONObject, payLaterTransactionDetail.U);
        } catch (Exception e10) {
            LoggerUtils.E("PayLaterTransactionDetail", "Exception111:" + e10.toString());
        }
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
