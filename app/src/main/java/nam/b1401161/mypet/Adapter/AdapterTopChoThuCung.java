package nam.b1401161.mypet.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import nam.b1401161.mypet.Model.ObjectClass.ChiTietKhuyenMai;
import nam.b1401161.mypet.Model.ObjectClass.SanPham;
import nam.b1401161.mypet.R;
import nam.b1401161.mypet.View.ChiTietSanPham.ChiTietSanPhamActivity;

public class AdapterTopChoThuCung extends RecyclerView.Adapter<AdapterTopChoThuCung.ViewHolderTopCho> {

    Context context;
    List<SanPham> sanPhamList;
    int layout;

    public AdapterTopChoThuCung(Context context, int layout, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
        this.layout = layout;
    }

    public class ViewHolderTopCho extends RecyclerView.ViewHolder  {
        ImageView imHinhSanPham;
        TextView txtTenSP, txtGiaTien, txtGiamGia;
        CardView cardView;

        public ViewHolderTopCho(View itemView) {
            super(itemView);

            imHinhSanPham = (ImageView) itemView.findViewById(R.id.imTopChoThuCung);
            txtTenSP = (TextView) itemView.findViewById(R.id.txtTieuDeTopChoThuCung);
            txtGiaTien = (TextView) itemView.findViewById(R.id.txtGiaThuCung);
            txtGiamGia = (TextView) itemView.findViewById(R.id.txtGiamGiaThuCung);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }

    @Override
    public ViewHolderTopCho onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layout, parent, false);

        ViewHolderTopCho viewHolderTopCho = new ViewHolderTopCho(view);

        return viewHolderTopCho;
    }

    @Override
    public void onBindViewHolder(ViewHolderTopCho holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        Log.d("hinhsanpham", sanPham.getANHLON());
        Picasso.get().load(sanPham.getANHLON()).resize(240, 240).centerInside().into(holder.imHinhSanPham);
        holder.txtTenSP.setText(sanPham.getTENSP());

        ChiTietKhuyenMai chiTietKhuyenMai = sanPham.getChiTietKhuyenMai();
        int giatien = sanPham.getGIA();

        if(chiTietKhuyenMai !=null) {
            int phantramkm = chiTietKhuyenMai.getPHANTRAMKM();

            NumberFormat numberFormat = new DecimalFormat("####,###");
            String gia = numberFormat.format(giatien);
            Log.d("giasanpham", gia);
            //holder.txtGiamGia.setVisibility(View.VISIBLE);
            //holder.txtGiamGia.setPaintFlags(holder.txtGiamGia.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.txtGiaTien.setText(gia + " VNĐ ");
           // holder.cardView.setTag(sanPham.getMASP());
           // giatien = giatien * phantramkm/100;


        }

        NumberFormat numberFormat = new DecimalFormat("###,###");
        //String gia = numberFormat.format(sanPham.getGIA()).toString();
        String gia = numberFormat.format(giatien);
        holder.txtGiaTien.setText(gia + " VNĐ");
        holder.cardView.setTag(sanPham.getMASP());

        //holder.cardView.setTag(sanPham.getMASP());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ){
                Intent iChitietsanpham = new Intent(context, ChiTietSanPhamActivity.class);
                iChitietsanpham.putExtra("masp", (int)v.getTag());
                context.startActivity(iChitietsanpham);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

}
