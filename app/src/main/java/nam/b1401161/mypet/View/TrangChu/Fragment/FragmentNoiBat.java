package nam.b1401161.mypet.View.TrangChu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nam.b1401161.mypet.Adapter.AdapterNoiBat;
import nam.b1401161.mypet.R;

public class FragmentNoiBat extends Fragment {
    RecyclerView recyclerView;
    AdapterNoiBat adapterNoiBat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_noibat, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyleNoiBat);
        List<String> dulieu = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            String ten = "Nổi bật " + i;
            dulieu.add(ten);
        }

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        adapterNoiBat = new AdapterNoiBat(getActivity(), dulieu);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterNoiBat);

        adapterNoiBat.notifyDataSetChanged();


        return view;
    }
}
