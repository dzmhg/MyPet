package nam.b1401161.mypet.View.TrangChu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nam.b1401161.mypet.Adapter.AdapterThuCung;
import nam.b1401161.mypet.Adapter.AdapterThuongHieuLonThuCung;
import nam.b1401161.mypet.Adapter.AdapterTopChoThuCung;
import nam.b1401161.mypet.Model.ObjectClass.SanPham;
import nam.b1401161.mypet.Model.ObjectClass.ThuCung;
import nam.b1401161.mypet.Model.ObjectClass.ThuongHieu;
import nam.b1401161.mypet.Presenter.TrangChu_ThuCung.PresenteLogicThuCung;
import nam.b1401161.mypet.R;
import nam.b1401161.mypet.View.TrangChu.ViewThuCung;

public class FragmentThuCung extends Fragment implements ViewThuCung {
    RecyclerView recyclerView, recyclerTopCacThuongHieuLon, recyclerHangMoiVe;
    List<ThuCung> linhKienList;
    PresenteLogicThuCung presenteLogicThuCung;
    ImageView imSanPham1,imSanPham2,imSanPham3;
    TextView txtSanPham1,txtSanPham2,txtSanPham3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_thucung, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerThuCung);
        recyclerTopCacThuongHieuLon = (RecyclerView) view.findViewById(R.id.recylerTopCacThuongHieuLon);
        recyclerHangMoiVe = (RecyclerView) view.findViewById(R.id.recylerHangMoiVe);

        imSanPham1 = (ImageView) view.findViewById(R.id.imSanPham1);
        imSanPham2 = (ImageView) view.findViewById(R.id.imSanPham2);
        imSanPham3 = (ImageView) view.findViewById(R.id.imSanPham3);

        txtSanPham1 = (TextView) view.findViewById(R.id.txtSanPham1);
        txtSanPham2 = (TextView) view.findViewById(R.id.txtSanPham2);
        txtSanPham3 = (TextView) view.findViewById(R.id.txtSanPham3);

        presenteLogicThuCung = new PresenteLogicThuCung(this);

        linhKienList = new ArrayList<>();

        presenteLogicThuCung.LayDanhSachThuCung();
        presenteLogicThuCung.LayDanhSachLogoThuongHieu();
        presenteLogicThuCung.LayDanhSachSanPhamMoi();

        return view;
    }

    @Override
    public void HienThiDanhSach(List<ThuCung> linhKiens) {

        linhKienList = linhKiens;

        AdapterThuCung adapterLinhKien = new AdapterThuCung(getContext(), linhKienList);//teclass.this
        // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterLinhKien);

        adapterLinhKien.notifyDataSetChanged();


    }

    @Override
    public void HienThiLogoThuongHieu(List<ThuongHieu> thuongHieus) {
        AdapterThuongHieuLonThuCung adapterThuongHieuLonLinhKien = new AdapterThuongHieuLonThuCung(getContext(), thuongHieus);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false);

        recyclerTopCacThuongHieuLon.setLayoutManager(layoutManager);
        recyclerTopCacThuongHieuLon.setAdapter(adapterThuongHieuLonLinhKien);
        adapterThuongHieuLonLinhKien.notifyDataSetChanged();
    }

    @Override
    public void LoiLayDuLieu() {

    }

    @Override
    public void HienThiSanPhamMoiVe(List<SanPham> sanPhams) {
        AdapterTopChoThuCung adapterTopChuotLinhKien = new AdapterTopChoThuCung(getContext(), R.layout.custom_layout_topchovameo, sanPhams);
        RecyclerView.LayoutManager layoutManagerTop = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerHangMoiVe.setLayoutManager(layoutManagerTop);
        recyclerHangMoiVe.setAdapter(adapterTopChuotLinhKien);

        adapterTopChuotLinhKien.notifyDataSetChanged();

        Random random = new Random();
        int vitri = random.nextInt(sanPhams.size());

        // Picasso.get().load(thuongHieu.getHINHTHUONGHIEU()).resize(180,90).centerInside().into(holder.imLogoThuongHieuLon);
        Picasso.get().load(sanPhams.get(vitri).getANHLON()).fit().centerInside().into(imSanPham1);
        txtSanPham1.setText(sanPhams.get(vitri).getTENSP());

        int vitri1 = random.nextInt(sanPhams.size());
        Picasso.get().load(sanPhams.get(vitri1).getANHLON()).fit().centerInside().into(imSanPham2);
        txtSanPham2.setText(sanPhams.get(vitri1).getTENSP());

        int vitri2 = random.nextInt(sanPhams.size());
        Picasso.get().load(sanPhams.get(vitri2).getANHLON()).fit().centerInside().into(imSanPham3);
        txtSanPham3.setText(sanPhams.get(vitri2).getTENSP());
    }
}
