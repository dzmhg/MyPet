package nam.b1401161.mypet.Presenter.GioHang;

import android.content.Context;

import java.util.List;

import nam.b1401161.mypet.Model.GioHang.ModelGioHang;
import nam.b1401161.mypet.Model.ObjectClass.SanPham;
import nam.b1401161.mypet.View.GioHang.ViewGioHang;

public class PresenterLogicGioHang implements IPresenterGioHang {

    ModelGioHang modelGioHang;
    ViewGioHang viewGioHang;

    public PresenterLogicGioHang(ViewGioHang viewGioHang){
        modelGioHang = new ModelGioHang();
        this.viewGioHang = viewGioHang;
    }

    @Override
    public void LayDanhSachSanPhamTrongGioHang(Context context) {
        modelGioHang.MoKetNoiSQL(context);
        List<SanPham> sanPhamList = modelGioHang.LayDanhSachSanPhamTrongGioHang();
        if(sanPhamList.size() > 0){
            viewGioHang.HienThiDanhSachSanPhamTrongGioHang(sanPhamList);
        }
    }
}
