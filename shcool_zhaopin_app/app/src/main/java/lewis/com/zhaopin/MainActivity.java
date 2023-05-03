package lewis.com.zhaopin;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import butterknife.BindView;
import lewis.com.zhaopin.base.BaseActivity;
import lewis.com.zhaopin.ui.frg.HomeFrg;
import lewis.com.zhaopin.ui.frg.MineFrg;
import lewis.com.zhaopin.ui.frg.SheQuFrg;

//系统主页
public class MainActivity extends BaseActivity {

    //初始话控件
    @BindView(R.id.continer)
    RelativeLayout continer;
    @BindView(R.id.bnv_bottom_activity)
    BottomNavigationView bnvBottomActivity;
    private HomeFrg homeFrg;
//    private SheQuFrg sheQuFrg;
    private MineFrg bookJiaFrg;

    private Fragment[] fragments;
    private int lastfragment;//用于记录上个选择的Fragment
    private MenuItem lastItem;
    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initFragment();
    }

    @Override
    public void initData() {

    }
    //初始化fragment
    private void initFragment() {

        homeFrg = new HomeFrg();
//        sheQuFrg=new SheQuFrg();
        bookJiaFrg = new MineFrg();

        fragments = new Fragment[]{homeFrg, bookJiaFrg};
        lastfragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.continer, homeFrg).show(homeFrg).commit();


        bnvBottomActivity.setOnNavigationItemSelectedListener(changeFragment);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //切换fragment
            switch (item.getItemId()) {
                case R.id.home: {
                    if (lastfragment != 0) {
                        switchFragment(lastfragment, 0);
                        lastfragment = 0;

                    }

                    return true;
                }

//                case R.id.shequ: {
//                    if (lastfragment != 1) {
//                        switchFragment(lastfragment, 1);
//                        lastfragment = 1;
//
//                    }
//
//                    return true;
//                }
                case R.id.sj: {
                    if (lastfragment != 1) {
                        switchFragment(lastfragment, 1);
                        lastfragment = 1;

                    }

                    return true;
                }




            }


            return false;
        }
    };

    //切换Fragment
    private void switchFragment(int lastfragment, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if (fragments[index].isAdded() == false) {
            transaction.add(R.id.continer, fragments[index]);


        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }


    


}
