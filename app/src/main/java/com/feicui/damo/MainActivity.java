package com.feicui.damo;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends Activity {
    private Chronometer timer;
    private Button mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获得计时器对象
          timer= (Chronometer)this.findViewById(R.id.chronometer);
        mStart = (Button) findViewById(R.id.start);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
                mStart.setEnabled(false);
            }
        });
        //为Chronometer做事件监听器
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer ch) {
                //20秒停止
                if (SystemClock.elapsedRealtime()-ch.getBase()>20*1000){
                    ch.stop();
                    mStart.setEnabled(true);
                }
            }
        });
    }
//    //创建上下文菜单
//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v,
//                                    ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        // ContextMenu的Item不支持Icon，所以不用再资源文件中，为它们设定图标
//        if (v.getId()==R.id.chronometer){
//            //加载xml菜单布局文件
//            this.getMenuInflater().inflate(R.menu.context_menu,menu);
//            // 设定头部图标
//            menu.setHeaderIcon(R.mipmap.ic_launcher);
//            // 设定头部标题
//            menu.setHeaderTitle("计时器控制选项");
//        }
//        //选择菜单项后的响应
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.timer_start:
//                // 将计时器清零
//                timer.setBase(SystemClock.elapsedRealtime());
//                //开始计时
//                timer.start();
//                break;
//            case R.id.timer_stop:
//                //停止计时
//                timer.start();
//                break;
//            case R.id.timer_reset:
//                //将计时器清零
//                timer.setBase(SystemClock.elapsedRealtime());
//                break;
//        }
//        return super.onContextItemSelected(item);
//    }
}
