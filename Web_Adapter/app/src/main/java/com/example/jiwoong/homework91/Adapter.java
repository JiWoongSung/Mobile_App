package com.example.jiwoong.homework91;

/**
 * Created by jiwoong on 2017. 5. 8..
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    //Adapter에서 사용할 ListItemData
    //Adapter에서 사용할 itemLayOut

    //ListItemData 선언
    private ArrayList<UrlData> urlDatas = new ArrayList<UrlData>();

    // ListViewAdapter의 생성자
    public Adapter(ArrayList<UrlData> urlData) {
        this.urlDatas = urlData;
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return urlDatas.size();
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Adapter에서 사용할 itemLayOut 선언
            convertView = inflater.inflate(R.layout.item, parent, false);
        }

        TextView titleTextView = (TextView) convertView.findViewById(R.id.textItemView);
        UrlData tmpUrlData = urlDatas.get(position);

        titleTextView.setText("이름 : " + tmpUrlData.getName() + "\n주소 : " + tmpUrlData.getAddress());
        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return urlDatas.get(position);
    }

    //item 삭제
    public void removeItem(int position) {
        urlDatas.remove(position);
        this.notifyDataSetChanged();
    }

    // 아이템 데이터 추가를 위한 함수.
    public void addItem(String url, String name) {
        UrlData item = new UrlData(url, name);
        urlDatas.add(item);
        this.notifyDataSetChanged();

    }

    //같은 url이 있는지 확인하는 함수
    public boolean findItem(String url) {
          /*for(int i = 0; i< urlData.size(); i ++){
                            if(urlData.get(i).getAddress().equals(url)){
                                urlSameMatch = true;
                                break;
                            }
                        }*/

        for (UrlData tmpUrlData : urlDatas) {
            if (tmpUrlData.getAddress().equals(url)) {
                return true;
            }
        }
        return false;
    }
}
