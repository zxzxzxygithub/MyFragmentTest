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

        FragmentManager fm = getSupportFragmentManager();
//       通过日志查看savedinstancestate里面保存的内容
        Log.d("FragmentOne", "onCreate: " + savedInstanceState);
//       每一个fragment的操作都启用一个事务，保证事务的原子性
        if (savedInstanceState == null) {
            mFOne = new FragmentOne();
            FragmentTransaction tx;
            tx = fm.beginTransaction();
            tx.add(R.id.content_main, mFOne, "ONE");
            tx.commit();
            fm.executePendingTransactions();
            if (mFOne.isAdded()) {
                tx = fm.beginTransaction();
                tx.remove(mFOne);
                tx.commit();
                fm.executePendingTransactions();
            }
            tx = fm.beginTransaction();
            tx.add(R.id.content_main, mFOne, "ONE");
            tx.commit();
            fm.executePendingTransactions();//确保fragment是立刻提交的
        }
        List<Fragment> fragments = fm.getFragments();
//        如果想屏幕翻转的时候fragments列表为空则注释掉这行，不进行保存
//        super.onSaveInstanceState(outState);
//        或者在add fragment的时候判断savedInstanceState为空的时候再进行add操作
        if (fragments != null && fragments.size() > 0) {
            Toast.makeText(this, "we have " + fragments.size() + " fragmentOne(s) ", Toast.LENGTH_SHORT).show();
        }


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
                Toast.makeText(this, "this is from fragment", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
