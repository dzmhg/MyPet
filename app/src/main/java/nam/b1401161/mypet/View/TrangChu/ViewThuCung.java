package nam.b1401161.mypet.View.TrangChu;

import java.util.List;

import nam.b1401161.mypet.Model.ObjectClass.SanPham;
import nam.b1401161.mypet.Model.ObjectClass.ThuCung;
import nam.b1401161.mypet.Model.ObjectClass.ThuongHieu;

public interface ViewThuCung {
    void HienThiDanhSach(List<ThuCung> linhKiens);
    void HienThiLogoThuongHieu(List<ThuongHieu> thuongHieus);
    void LoiLayDuLieu();
    void HienThiSanPhamMoiVe(List<SanPham> sanPhams);


}
