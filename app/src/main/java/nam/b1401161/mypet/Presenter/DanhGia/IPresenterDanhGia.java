package nam.b1401161.mypet.Presenter.DanhGia;

import android.widget.ProgressBar;

import nam.b1401161.mypet.Model.ObjectClass.DanhGia;

public interface IPresenterDanhGia {
    void ThemDanhGia(DanhGia danhGia);
    void LayDanhSachDanhGiaCuaSanPham(int masp, int limit, ProgressBar progressBar);
}
