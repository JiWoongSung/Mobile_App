import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jiwoong.a4week.R;

/**
 * Created by jiwoong on 2017. 3. 30..
 */

public class fragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View fragview = inflater.inflate(R.layout.fragment, container, false);




        return fragview;


    }
}
