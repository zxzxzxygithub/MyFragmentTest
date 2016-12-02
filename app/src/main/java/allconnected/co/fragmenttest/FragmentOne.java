package allconnected.co.fragmenttest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment
{
	private static final String TAG = "FragmentOne";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		Log.e(TAG, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_one, container, false);
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		Log.e(TAG, "onCreate");
	}

	@Override
	public void onDestroyView()
	{
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.e(TAG, "onDestroyView");
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e(TAG, "onDestroy");
	}

}
