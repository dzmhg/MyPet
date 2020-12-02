package nam.b1401161.mypet.View.TrangChu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import nam.b1401161.mypet.Adapter.AdapterDanhSachKhuyenMai;
import nam.b1401161.mypet.Model.ObjectClass.KhuyenMai;
import nam.b1401161.mypet.Presenter.KhuyenMai.PresenterLogicKhuyenMai;
import nam.b1401161.mypet.R;
import nam.b1401161.mypet.View.TrangChu.ViewKhuyenMai;

public class FragmentChuongTrinhKhuyenMai extends Fragment implements ViewKhuyenMai  {

    LinearLayout lnHinhKhuyenMai;
    RecyclerView recyclerDanhSachKhuyenMai;
    PresenterLogicKhuyenMai presenterLogicKhuyenMai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_chuongtrinhkhuyenmai,container,false);

        lnHinhKhuyenMai = (LinearLayout) view.findViewById(R.id.lnHinhKhuyenMai);
        recyclerDanhSachKhuyenMai = (RecyclerView) view.findViewById(R.id.recyclerDanhSachKhuyenMai);

        presenterLogicKhuyenMai = new PresenterLogicKhuyenMai((ViewKhuyenMai) this);
        presenterLogicKhuyenMai.LayDanhSachKhuyenMai();

        return view;
    }

    @Override
    public void HienThiDanhSachKhuyenMai(List<KhuyenMai> khuyenMaiList) {

        int demhinh = khuyenMaiList.size();
        if(demhinh > 5){
            demhinh = 5;
        }else {
            demhinh = khuyenMaiList.size();
        }

        lnHinhKhuyenMai.removeAllViews();
        for (int i = 0 ;i<demhinh ;i++){
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);
            layoutParams.setMargins(0,10,0,10);
            imageView.setLayoutParams(layoutParams);
            // Picasso.get().load(sanPhams.get(vitri1).getANHLON()).fit().centerInside().into(imSanPham2);

            Picasso.get().load(khuyenMaiList.get(i).getHINHKHUYENMAI()).resize(720,200).into(imageView);

            lnHinhKhuyenMai.addView(imageView);
        }

        AdapterDanhSachKhuyenMai adapterDanhSachKhuyenMai = new AdapterDanhSachKhuyenMai(getContext(),khuyenMaiList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerDanhSachKhuyenMai.setLayoutManager(layoutManager);
        recyclerDanhSachKhuyenMai.setAdapter(adapterDanhSachKhuyenMai);
        adapterDanhSachKhuyenMai.notifyDataSetChanged();
    }
}

