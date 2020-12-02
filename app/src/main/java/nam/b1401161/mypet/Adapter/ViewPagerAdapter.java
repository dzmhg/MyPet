package nam.b1401161.mypet.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import nam.b1401161.mypet.View.TrangChu.Fragment.FragmentChuongTrinhKhuyenMai;
import nam.b1401161.mypet.View.TrangChu.Fragment.FragmentNoiBat;
import nam.b1401161.mypet.View.TrangChu.Fragment.FragmentThuCung;
import nam.b1401161.mypet.View.TrangChu.Fragment.FragmentThuongHieu;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> listFragment = new ArrayList<Fragment>();
    List<String> titleFragment = new ArrayList<String>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        listFragment.add(new FragmentThuCung());
        listFragment.add(new FragmentNoiBat());
        listFragment.add(new FragmentChuongTrinhKhuyenMai());
        listFragment.add(new FragmentThuongHieu());

        titleFragment.add("Thú cưng");
        titleFragment.add("Nổi bật");
        titleFragment.add("Chương trình khuyến mãi");
        titleFragment.add("Thương hiệu");

    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }


    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}

