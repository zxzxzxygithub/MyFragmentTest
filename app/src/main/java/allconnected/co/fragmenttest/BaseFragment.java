package allconnected.co.fragmenttest;

import android.support.v4.app.Fragment;


public class BaseFragment extends Fragment {
    private boolean mIsAdd;

    /**
     * 代替系统的isAdded
     *
     * @author michael
     * @time 16/12/14 下午2:14
     */
    public boolean isFragmentAdded() {
        return mIsAdd;
    }

    /**
     * 执行完add以及detach或者remove的时候记得设置
     *
     * @author michael
     * @time 16/12/14 下午2:15
     */
    public void setIsAdded(boolean isAdded) {

        mIsAdd = isAdded;

    }



}
