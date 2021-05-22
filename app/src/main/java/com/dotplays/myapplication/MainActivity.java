package com.dotplays.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Khởi tọa màn hình mới với Intent
    // giới thiệu layout mới LinearLayout , RelativeLayout
    // giới thiệu layout ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOpen = findViewById(R.id.btnOpen);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hàm xảy ra sự kiện click vào nút
                // 1 : là màn hình hiện tại
                // 2 : là màn hình đích đến
                Intent i = new Intent(MainActivity.this
                        , MainActivity2.class);

                startActivity(i);
            }
        };
        btnOpen.setOnClickListener(listener);

        ListView lv = findViewById(R.id.lvList);

        String arr[] = {"A", "B", "C", "D", "A", "B", "C", "D", "A", "B", "C", "D", "A", "B", "C", "D"};

        // 1 : màn hình hiện tại
        // 2 : giao diện - layout cho 1 hàng - row
        // 3 : mảng dữ liệu khai báo ở dòng 40
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1, arr);

        lv.setAdapter(adapter);
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView,
                                            View view, int i, long l) {
                        // biến i ở dòng 54 là vị trí và người dùng click vòa listview
                        String item = arr[i];
                        Log.e(item, item);
                    }
                };
        lv.setOnItemClickListener(itemClickListener);

    }
}