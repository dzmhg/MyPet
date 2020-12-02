package nam.b1401161.mypet.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nam.b1401161.mypet.Model.ObjectClass.KhuyenMai;
import nam.b1401161.mypet.R;


public class AdapterDanhSachKhuyenMai extends RecyclerView.Adapter<AdapterDanhSachKhuyenMai.ViewHolderKhuyenMai> {

    Context context;
    List<KhuyenMai> khuyenMaiList;

    public AdapterDanhSachKhuyenMai(Context context, List<KhuyenMai> khuyenMaiList){
        this.context = context;
        this.khuyenMaiList = khuyenMaiList;
    }

    public class ViewHolderKhuyenMai extends RecyclerView.ViewHolder {

        RecyclerView recyclerItemKhuyenMai;
        TextView txtTieuDeKhuyenmai;
        public ViewHolderKhuyenMai(View itemView) {
            super(itemView);

            recyclerItemKhuyenMai = (RecyclerView) itemView.findViewById(R.id.recyclerItemKhuyenMai);
            txtTieuDeKhuyenmai = (TextView) itemView.findViewById(R.id.txtTieuDeKhuyenMai);
        }
    }

    @Override
    public ViewHolderKhuyenMai onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout_itemkhuyenmai,parent,false);

        ViewHolderKhuyenMai viewHolderKhuyenMai = new ViewHolderKhuyenMai(view);
        return viewHolderKhuyenMai;
    }

    @Override
    public void onBindViewHolder(ViewHolderKhuyenMai holder, int position) {
        KhuyenMai khuyenMai = khuyenMaiList.get(position);

        holder.txtTieuDeKhuyenmai.setText(khuyenMai.getTENLOAISP());

        AdapterTopChoThuCung adapterTopChoThuCung =new AdapterTopChoThuCung(context, R.layout.custom_layout_topchovameo, khuyenMai.getDanhSachSanPhamKhuyenMai());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerItemKhuyenMai.setLayoutManager(layoutManager);
        holder.recyclerItemKhuyenMai.setAdapter(adapterTopChoThuCung);
    }

    @Override
    public int getItemCount() {
        return khuyenMaiList.size();
    }


}
