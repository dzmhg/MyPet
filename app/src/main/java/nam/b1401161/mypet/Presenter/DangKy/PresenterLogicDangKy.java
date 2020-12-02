package nam.b1401161.mypet.Presenter.DangKy;

import nam.b1401161.mypet.Model.DangNhap_DangKy.ModelDangKy;
import nam.b1401161.mypet.Model.ObjectClass.NhanVien;
import nam.b1401161.mypet.View.DangNhap_DangKy.ViewDangKy;

public class PresenterLogicDangKy implements IPresenterDangKy{
    ViewDangKy viewDangKy;
    ModelDangKy modelDangKy;

    public PresenterLogicDangKy(ViewDangKy viewDangKy) {
        this.viewDangKy = viewDangKy;
        modelDangKy = new ModelDangKy();
    }

    @Override
    public void ThucHienDangKy(NhanVien nhanvien) {
       // modelDangKy.DangKyThanhVien(nhanvien);
        boolean kiemtra = modelDangKy.DangKyThanhVien(nhanvien);
        if (kiemtra) {
            viewDangKy.DangKyThanhCong();
        }else {
            viewDangKy.DangKyThatBai();
        }
    }
}
