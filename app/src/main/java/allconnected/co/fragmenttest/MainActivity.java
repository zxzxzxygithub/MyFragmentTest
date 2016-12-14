package allconnected.co.fragmenttest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentOne mFOne;
    private FragmentManager mFm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mFm = getSupportFragmentManager();
//       通过日志查看savedinstancestate里面保存的内容
        Log.d("FragmentOne", "onCreate: " + savedInstanceState);
//       每一个fragment的操作都启用一个事务，保证事务的原子性
//        if (savedInstanceState == null) {
        mFOne=new FragmentOne();
//        执行了executePendingTransactions，isAdded才会生效
        if (!mFOne.isFragmentAdded()){
            mFm.beginTransaction().add(R.id.content_main,mFOne,"mOne").commit();
            mFOne.setIsAdded(true);
        }
        if (!mFOne.isFragmentAdded()){
            mFm.beginTransaction().add(R.id.content_main,mFOne,"mOne").commit();
            mFOne.setIsAdded(true);
        }
//        tx = fm.beginTransaction();
//        tx.add(R.id.content_main, mFOne, "ONE");
//        tx.attach(mFOne);
//        tx.attach(mFOne);
//        tx.attach(mFOne);
//        tx.commit();
//        fm.executePendingTransactions();


        List<Fragment> fragments = mFm.getFragments();
//        如果想屏幕翻转的时候fragments列表为空则注释掉这行，不进行保存
//        super.onSaveInstanceState(outState);
//        或者在add fragment的时候判断savedInstanceState为空的时候再进行add操作
        if (fragments != null && fragments.size() > 0)

        {
            Toast.makeText(this, "we have " + fragments.size() + " fragmentOne(s) ", Toast.LENGTH_SHORT).show();
        }

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction tx;
                if (mFOne == null) {
                    mFOne = new FragmentOne();
                    tx = mFm.beginTransaction();
                    tx.add(R.id.content_main, mFOne, "ONE");
                    tx.commit();
                    mFm.executePendingTransactions();
                } else {
                    if (mFOne.isAdded()) {
                        tx = mFm.beginTransaction();
                        tx.show(mFOne).commit();
                    } else {
                        tx = mFm.beginTransaction();
                        tx.remove(mFOne).commit();
//
                        mFOne = new FragmentOne();
                        tx = mFm.beginTransaction();
                        tx.add(R.id.content_main, mFOne, "ONE");
                        tx.commit();
                        mFm.executePendingTransactions();
                    }
                }

            }
        });

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        注释掉这行，不进行保存
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_one:
                mFOne = null;
                Toast.makeText(this, "this is from fragment", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
