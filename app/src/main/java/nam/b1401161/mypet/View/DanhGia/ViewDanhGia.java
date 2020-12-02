package nam.b1401161.mypet.View.DanhGia;

import java.util.List;

import nam.b1401161.mypet.Model.ObjectClass.DanhGia;

public interface ViewDanhGia {
    void DanhGiaThanhCong();
    void DanhGiaThatBai();
    void HienThiDanhSachDanhGiaTheoSanPham(List<DanhGia> danhGiaList);
}
