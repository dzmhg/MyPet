package nam.b1401161.mypet.View.ChiTietSanPham;

import java.util.List;

import nam.b1401161.mypet.Model.ObjectClass.DanhGia;
import nam.b1401161.mypet.Model.ObjectClass.SanPham;

public interface ViewChiTietSanPham {
    void HienChiTietSanPham(SanPham sanPham);
    void HienSliderSanPham(String[] linkhinhsanpham);
    void HienThiDanhGia(List<DanhGia> danhGiaList);
    void ThemGioHangThanhCong();
    void ThemGiohangThatBai();
}
