package nam.b1401161.mypet.Presenter.TimKiem;

import java.util.List;

import nam.b1401161.mypet.Model.ObjectClass.SanPham;
import nam.b1401161.mypet.Model.TimKiem.ModelTimKiem;
import nam.b1401161.mypet.View.TimKiem.ViewTimKiem;

public class PresenterLogicTimKiem implements IPresenterTimKiem {

    ViewTimKiem viewTimKiem;
    ModelTimKiem modelTimKiem;

    public PresenterLogicTimKiem(ViewTimKiem viewTimKiem){
        this.viewTimKiem = viewTimKiem;
        modelTimKiem = new ModelTimKiem();
    }

    @Override
    public void TimKiemSanPhamTheoTenSP(String tensp, int limit) {
        List<SanPham> sanPhamList = modelTimKiem.TimKiemSanPhamTheoTen(tensp,"DANHSACHSANPHAM","TimKiemSanPhamTheoTenSP",limit);

        if(sanPhamList.size() > 0){
            viewTimKiem.TimKiemThanhCong(sanPhamList);

        }else{
            viewTimKiem.TimKiemThatBai();
        }
    }
}
