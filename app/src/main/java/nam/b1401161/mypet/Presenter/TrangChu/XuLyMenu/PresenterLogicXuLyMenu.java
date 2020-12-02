package nam.b1401161.mypet.Presenter.TrangChu.XuLyMenu;

import android.util.Log;

//import com.facebook.AccessToken;

import com.facebook.AccessToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import nam.b1401161.mypet.Connectinternet.DownloadJSON;
import nam.b1401161.mypet.Model.DangNhap_DangKy.ModelDangNhap;
import nam.b1401161.mypet.Model.ObjectClass.LoaiSanPham;
import nam.b1401161.mypet.Model.TrangChu.XuLyMenu.XuLyJSONMenu;
import nam.b1401161.mypet.View.TrangChu.TrangChuActivity;
import nam.b1401161.mypet.View.TrangChu.ViewXuLyMenu;

public class PresenterLogicXuLyMenu implements IPresenterXuLyMenu {

    ViewXuLyMenu viewXuLyMenu;
    String tennguoidung = "";


    public PresenterLogicXuLyMenu(ViewXuLyMenu viewXuLyMenu){
        this.viewXuLyMenu = viewXuLyMenu;
    }

    @Override
    public void LayDanhSachMenu() {
        List<LoaiSanPham> loaiSanPhamList;
        String dataJSON = "";
        List<HashMap<String, String>> attrs = new ArrayList<>();

        //Lấy bằng phương thức get
        //String duongdan = "http://192.168.1.35:81/petsv/api/loaisanpham.php?maloaicha=0";

        //DownloadJSON downloadJSON = new DownloadJSON(duongdan);
        // end phương thức get

        //Lấy bằng phương thức post
        String duongdan = TrangChuActivity.SERVER_NAME;

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", "LayDanhSachMenu");
//
        HashMap<String, String> hsMaLoaiCha = new HashMap<>();
        hsMaLoaiCha.put("maloaicha", "0");
//
        attrs.add(hsMaLoaiCha);
        attrs.add(hsHam);

        DownloadJSON downloadJSON = new DownloadJSON(duongdan, attrs);
        //end phương thức post
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();
//            xuLyJSONMenu.ParserJSONMenu(dataJSON);
            loaiSanPhamList = xuLyJSONMenu.ParserJSONMenu(dataJSON);
            Log.d("^_^ :",loaiSanPhamList.toString());
            viewXuLyMenu.HienThiDanhSachMenu(loaiSanPhamList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public AccessToken LayTokenDungFacebook() {
        ModelDangNhap modelDangNhap = new ModelDangNhap();
        AccessToken accessToken = modelDangNhap.LayTokenFacebookHienTai();
        return accessToken;
    }

}
