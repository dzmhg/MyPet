package nam.b1401161.mypet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nam.b1401161.mypet.Model.ObjectClass.ThuCung;
import nam.b1401161.mypet.R;

public class AdapterThuCung extends RecyclerView.Adapter<AdapterThuCung.ViewHolderThuCung> {
    Context context;
    List<ThuCung> thuCungList;

    public AdapterThuCung(Context context, List<ThuCung> thuCungList) {
        this.context = context;
        this.thuCungList = thuCungList;
    }

    public class ViewHolderThuCung extends RecyclerView.ViewHolder {
        ImageView imHinhKhuyenMaiThuCung;
        RecyclerView recyclerViewThuongHieuLon, recyclerViewTopSanPham;
        TextView txtTieuDeSanPhamNoiBat, txtTopSanPhamNoiBat;

        public ViewHolderThuCung(View itemView) {
            super(itemView);

            recyclerViewThuongHieuLon = (RecyclerView) itemView.findViewById(R.id.recyclerThuongHieuLon);
            recyclerViewTopSanPham = (RecyclerView) itemView.findViewById(R.id.recyclerTopChovaMeo);
            imHinhKhuyenMaiThuCung = (ImageView) itemView.findViewById(R.id.imKhuyenMaiThuCung);
            txtTopSanPhamNoiBat = (TextView) itemView.findViewById(R.id.txtTenSanPhamNoiBat);
            txtTieuDeSanPhamNoiBat = (TextView) itemView.findViewById(R.id.txtTenTopSanPhamNoiBat);

        }

    }

    @Override
    public ViewHolderThuCung onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout_recyclerview_thucung, parent, false);

        ViewHolderThuCung viewHolderThuCung = new ViewHolderThuCung(view);

        return viewHolderThuCung;
    }

    @Override
    public void onBindViewHolder( ViewHolderThuCung holder, int position) {

        ThuCung thuCung = thuCungList.get(position);

        holder.txtTieuDeSanPhamNoiBat.setText(thuCung.getTennoibat().toString());
        holder.txtTopSanPhamNoiBat.setText(thuCung.getTentopnoibat().toString());

        //Xu ly hien thi danh sach thuong hieu lon Recyclerview Thuong Hieu Lon
        AdapterThuongHieuLon adapterThuongHieuLon = new AdapterThuongHieuLon(context, thuCung.getThuongHieus(), thuCung.isThuonghieu());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 3, GridLayoutManager.HORIZONTAL, false);

        holder.recyclerViewThuongHieuLon.setLayoutManager(layoutManager);

        holder.recyclerViewThuongHieuLon.setAdapter(adapterThuongHieuLon);
        adapterThuongHieuLon.notifyDataSetChanged();

        //Xu ly hien thi danh sach top san pham Recyclerview Top San Pham

        AdapterTopChoThuCung adapterTopChoThuCung = new AdapterTopChoThuCung(context, R.layout.custom_layout_topchovameo, thuCung.getSanPhams());

        RecyclerView.LayoutManager layoutManagerTop = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        holder.recyclerViewTopSanPham.setLayoutManager(layoutManagerTop);
        holder.recyclerViewTopSanPham.setAdapter(adapterTopChoThuCung);
    }

    @Override
    public int getItemCount() {
        return thuCungList.size();
    }
}
