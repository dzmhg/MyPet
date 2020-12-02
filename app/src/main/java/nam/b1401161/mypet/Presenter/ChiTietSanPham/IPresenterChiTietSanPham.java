package nam.b1401161.mypet.Presenter.ChiTietSanPham;

import android.content.Context;

import nam.b1401161.mypet.Model.ObjectClass.SanPham;

public interface IPresenterChiTietSanPham {
    void LayChiTietSanPham(int masp);
    void LayDanhSachDanhGiaTheoCuaSanPham(int masp, int limit);
    void ThemGioHang(SanPham sanPham, Context context);
}
