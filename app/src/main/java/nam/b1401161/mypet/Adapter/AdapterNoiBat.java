package nam.b1401161.mypet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nam.b1401161.mypet.R;

public class AdapterNoiBat extends RecyclerView.Adapter<AdapterNoiBat.ViewHolder>{

    Context context;
    List<String > stringList;

    public AdapterNoiBat(Context context, List<String > stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txtTieuDeNoiBat);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_recyclerview_noibat, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.textView.setText(stringList.get(position));
    }


    @Override
    public int getItemCount() {
        return stringList.size();
    }
}