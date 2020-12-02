package nam.b1401161.mypet.View.ThanhToan;

import java.util.List;

import nam.b1401161.mypet.Model.ObjectClass.SanPham;

public interface ViewThanhToan {
    void DatHangThanhCong();
    void DatHangThatBai();
    void LayDanhSachSanPhamTrongGioHang(List<SanPham> sanPhamList);
}
