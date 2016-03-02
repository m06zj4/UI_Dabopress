package com.example.yf.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements android.view.View.OnClickListener {
    private ViewPager mViewPager;// 用来放置界面切换
    private PagerAdapter mPagerAdapter;// 初始化View适配器
    private List<View> mViews = new ArrayList<View>();// 用来存放Tab01-04
    // 四个Tab，每个Tab包含一个按钮
    private LinearLayout mTabWeiXin;
    private LinearLayout mTabAddress;
    private LinearLayout mTabFrd;
    private LinearLayout mTabSetting;
    // 四个按钮
    private ImageButton mWeiXinImg;
    private ImageButton mAddressImg;
    private ImageButton mFrdImg;
    private ImageButton mSettingImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initViewPage();
        initEvent();


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
    private void initEvent() {
        mTabWeiXin.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *ViewPage左右滑动时
             */
            @Override
            public void onPageSelected(int arg0) {
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        resetImg();
                        mWeiXinImg.setImageResource(R.drawable.ic_home_black_24dp);
                        break;
                    case 1:
                        resetImg();
                        mAddressImg.setImageResource(R.drawable.ic_perm_identity_black_24dp);
                        break;
                    case 2:
                        resetImg();
                        mFrdImg.setImageResource(R.drawable.ic_settings_black_24dp);
                        break;
                    case 3:
                        resetImg();
                        mSettingImg.setImageResource(R.drawable.ic_home_black_24dp);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    /**
     * 初始化设置
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpage);
        // 初始化四个LinearLayout
        mTabWeiXin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);
        // 初始化四个按钮
        mWeiXinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
        mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_settings_img);
    }

    /**
     * 初始化ViewPage
     */
    private void initViewPage() {

        // 初妈化四个布局
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        View tab01 = mLayoutInflater.inflate(R.layout.tab01, null);
        View tab02 = mLayoutInflater.inflate(R.layout.tab02, null);
        View tab03 = mLayoutInflater.inflate(R.layout.tab03, null);
        View tab04 = mLayoutInflater.inflate(R.layout.tab04, null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        // 适配器初始化并设置
        mPagerAdapter = new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(mViews.get(position));

            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {

                return arg0 == arg1;
            }

            @Override
            public int getCount() {

                return mViews.size();
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }

    /**
     * 判断哪个要显示，及设置按钮图片
     */
    @Override
    public void onClick(View arg0) {

        switch (arg0.getId()) {
            case R.id.id_tab_weixin:
                mViewPager.setCurrentItem(0);
                resetImg();
                mWeiXinImg.setImageResource(R.drawable.ic_perm_identity_black_24dp);
                break;
            case R.id.id_tab_address:
                mViewPager.setCurrentItem(1);
                resetImg();
                mAddressImg.setImageResource(R.drawable.ic_perm_identity_black_24dp);
                break;
            case R.id.id_tab_frd:
                mViewPager.setCurrentItem(2);
                resetImg();
                mFrdImg.setImageResource(R.drawable.ic_settings_black_24dp);
                break;
            case R.id.id_tab_settings:
                mViewPager.setCurrentItem(3);
                resetImg();
                mSettingImg.setImageResource(R.drawable.ic_home_black_24dp);
                break;
            default:
                break;
        }
    }

    /**
     * 把所有图片变暗
     */
    private void resetImg() {
        mWeiXinImg.setImageResource(R.drawable.ic_home_black_24dp);
        mAddressImg.setImageResource(R.drawable.ic_settings_black_24dp);
        mFrdImg.setImageResource(R.drawable.ic_perm_identity_black_24dp);
        mSettingImg.setImageResource(R.drawable.ic_home_black_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
