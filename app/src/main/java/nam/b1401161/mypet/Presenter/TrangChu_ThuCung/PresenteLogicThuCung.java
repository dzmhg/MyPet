package nam.b1401161.mypet.Presenter.TrangChu_ThuCung;

import java.util.ArrayList;
import java.util.List;

import nam.b1401161.mypet.Model.ObjectClass.SanPham;
import nam.b1401161.mypet.Model.ObjectClass.ThuCung;
import nam.b1401161.mypet.Model.ObjectClass.ThuongHieu;
import nam.b1401161.mypet.Model.TrangChu_ThuCung.ModelThuCung;
import nam.b1401161.mypet.View.TrangChu.ViewThuCung;

public class PresenteLogicThuCung implements IPresenterThuCung {

    ViewThuCung viewThuCung;
    ModelThuCung modelThuCung;

    public PresenteLogicThuCung(ViewThuCung viewThuCung) {
        this.viewThuCung = viewThuCung;
        modelThuCung = new ModelThuCung();
    }

    @Override
    public void LayDanhSachThuCung() {
        List<ThuCung> thuCungs = new ArrayList<>();

        List<ThuongHieu> thuongHieuList = modelThuCung.LayDanhSachThuongHieuLon("LayDanhSachCacThuongHieuLon", "DANHSACHTHUONGHIEU");

        List<SanPham> sanPhamList = modelThuCung.LayDanhSachSanPhamTOP("LayDanhSachTopChoVaMeo", "TOPCHOVAMEO");

        ThuCung thuCung = new ThuCung();
        thuCung.setThuongHieus(thuongHieuList);
        thuCung.setSanPhams(sanPhamList);

        thuCung.setTennoibat("Thương hiệu lớn");
        thuCung.setTentopnoibat("Top chó và mèo");
        thuCung.setThuonghieu(true);
        thuCungs.add(thuCung);

        List<SanPham> phukienList = modelThuCung.LayDanhSachSanPhamTOP("LayDanhSachTopPhuKien", "TOPPHUKIEN");
        List<ThuongHieu> topphukienList = modelThuCung.LayDanhSachThuongHieuLon("LayDanhSachPhuKien", "DANHSACHPHUKIEN");

        ThuCung thuCung1 = new ThuCung();
        thuCung1.setThuongHieus(topphukienList);
        thuCung1.setSanPhams(phukienList);
        thuCung1.setTennoibat("Phụ kiện");
        thuCung1.setTentopnoibat("Top phụ kiện");
        thuCung1.setThuonghieu(false);
        thuCungs.add(thuCung1);

        List<SanPham> tienichList = modelThuCung.LayDanhSachSanPhamTOP("LayTopTienIch", "TOPTIENICH");
        List<ThuongHieu> toptienichList = modelThuCung.LayDanhSachThuongHieuLon("LayDanhSachTienIch", "DANHSACHTIENICH");

        ThuCung thuCung2 = new ThuCung();
        thuCung2.setThuongHieus(toptienichList);
        thuCung2.setSanPhams(tienichList);
        thuCung2.setTennoibat("Tiện ích");
        thuCung2.setTentopnoibat("Top phụ kiện thú cưng");
        thuCung2.setThuonghieu(false);
        thuCungs.add(thuCung2);

        if (thuongHieuList.size() > 0 && sanPhamList.size() > 0) {
            viewThuCung.HienThiDanhSach(thuCungs);
        }
    }

    @Override
    public void LayDanhSachLogoThuongHieu() {
        List<ThuongHieu> thuongHieuList = modelThuCung.LayDanhSachThuongHieuLon("LayLogoThuongHieuLon", "DANHSACHTHUONGHIEU");
        if (thuongHieuList.size() >0) {
            viewThuCung.HienThiLogoThuongHieu(thuongHieuList);
        }else {
            viewThuCung.LoiLayDuLieu();
        }

    }

    @Override
    public void LayDanhSachSanPhamMoi() {
        List<SanPham> sanPhamList = modelThuCung.LayDanhSachSanPhamTOP("LayDanhSachSanPhamMoi", "DANHSACHSANPHAMMOIVE");
        if (sanPhamList.size() > 0) {
            viewThuCung.HienThiSanPhamMoiVe(sanPhamList);
        }else {
            viewThuCung.LoiLayDuLieu();
        }
    }
}
