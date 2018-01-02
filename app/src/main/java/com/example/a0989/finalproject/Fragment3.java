package com.example.a0989.finalproject;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {
    private View view;
    TextView text,watch;
    Button reset;
    CalendarView cv;
    String[] bt = new String[]{"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        final SharedPreferences preferences = this.getActivity().getSharedPreferences("data", MODE_PRIVATE);
        text = (TextView)view.findViewById(R.id.textView1);
        watch = (TextView)view.findViewById(R.id.textView2);
        reset = (Button)view.findViewById(R.id.reset1);
        cv = (CalendarView)view.findViewById(R.id.calendarView1);
        if(reset!=null){
            reset.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    resetall();
                }
            });
        }
        for(int i=0;i<31;i++){
            if(i==0) {
                bt[0] = preferences.getString("m1day1","");
            }
            if(i==1){
                bt[1] = preferences.getString("day2","");
            }
            if(i==2){
                bt[2] = preferences.getString("day3","");
            }
            if(i==3){
                bt[3] = preferences.getString("day4","");
            }
            if(i==4) {
                bt[4] = preferences.getString("day5","");
            }
            if(i==5){
                bt[5] = preferences.getString("day6","");
            }
            if(i==6){
                bt[6] = preferences.getString("day7","");
            }
            if(i==7){
                bt[7] = preferences.getString("day8","");
            }
            if(i==8) {
                bt[8] = preferences.getString("day9","");
            }
            if(i==9){
                bt[9] = preferences.getString("day10","");
            }
            if(i==10){
                bt[10] = preferences.getString("day11","");
            }
            if(i==11){
                bt[11] = preferences.getString("day12","");
            }
            if(i==12) {
                bt[12] = preferences.getString("day13","");
            }
            if(i==13){
                bt[13] = preferences.getString("day14","");
            }
            if(i==14){
                bt[14] = preferences.getString("day15","");
            }
            if(i==15){
                bt[15] = preferences.getString("day16","");
            }
            if(i==16) {
                bt[16] = preferences.getString("day17","");
            }
            if(i==17){
                bt[17] = preferences.getString("day18","");
            }
            if(i==18){
                bt[18] = preferences.getString("day19","");
            }
            if(i==19){
                bt[19] = preferences.getString("day20","");
            }
            if(i==20) {
                bt[20] = preferences.getString("day21","");
            }
            if(i==21){
                bt[21] = preferences.getString("day22","");
            }
            if(i==22){
                bt[22] = preferences.getString("day23","");
            }
            if(i==23){
                bt[23] = preferences.getString("day24","");
            }
            if(i==24) {
                bt[24] = preferences.getString("day25","");
            }
            if(i==25){
                bt[25] = preferences.getString("day26","");
            }
            if(i==26){
                bt[26] = preferences.getString("day27","");
            }
            if(i==27){
                bt[27] = preferences.getString("day28","");
            }
            if(i==28) {
                bt[28] = preferences.getString("day29","");
            }
            if(i==29){
                bt[29] = preferences.getString("day30","");
            }
            if(i==30){
                bt[30] = preferences.getString("day31","");
            }
        }

        cv.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            final int dayOfMonth) {
                // TODO Auto-generated method stub
                    final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                    dialog.setTitle("請選擇功能");
                    dialog.setMessage(" ");
                    /*Myear = year;
                    Mmonth = month;
                    Mday = dayOfMonth;*/
                    dialog.setNeutralButton("取消新增", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getContext(), "查看進度", Toast.LENGTH_SHORT).show();
                        }
                    });
                    dialog.setPositiveButton("運動項目", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            shshow(dayOfMonth, preferences);
                        }
                    });
                    dialog.show();


                text.setText(new StringBuilder().append(year).append("-").
                        append(month+1).append("-").append(dayOfMonth));
                watch.setText(bt[dayOfMonth-1]);
                preferences.edit().putString("m1day1",bt[0]).putString("day2",bt[1]).putString("day3",bt[2]).putString("day4",bt[3])
                            .putString("day5",bt[4]).putString("day6",bt[5]).putString("day7",bt[6]).putString("day8",bt[7]).putString("day9",bt[8])
                            .putString("day10",bt[9]).putString("day11",bt[10]).putString("day12",bt[11]).putString("day13",bt[12]).putString("day14",bt[13])
                            .putString("day15",bt[14]).putString("day16",bt[15]).putString("day17",bt[16]).putString("day18",bt[17]).putString("day19",bt[18])
                            .putString("day20",bt[19]).putString("day21",bt[20]).putString("day22",bt[21]).putString("day23",bt[22]).putString("day24",bt[23])
                            .putString("day25",bt[24]).putString("day26",bt[25]).putString("day27",bt[26]).putString("day28",bt[27]).putString("day29",bt[28])
                            .putString("day30",bt[29]).putString("day31",bt[30]).apply();
                        /*.putString("m2day1",bt[1][0]).putString("m2day2",bt[1][1]).putString("m2day3",bt[1][2]).putString("m2day4",bt[1][3])
                        .putString("m2day5",bt[1][4]).putString("m2day6",bt[1][5]).putString("m2day7",bt[1][6]).putString("m2day8",bt[1][7]).putString("m2day9",bt[1][8])
                        .putString("m2day10",bt[1][9]).putString("m2day11",bt[1][10]).putString("m2day12",bt[1][11]).putString("m2day13",bt[1][12]).putString("m2day14",bt[1][13])
                        .putString("m2day15",bt[1][14]).putString("m2day16",bt[1][15]).putString("m2day17",bt[1][16]).putString("m2day18",bt[1][17]).putString("m2day19",bt[1][18])
                        .putString("m2day20",bt[1][19]).putString("m2day21",bt[1][20]).putString("m2day22",bt[1][21]).putString("m2day23",bt[1][22]).putString("m2day24",bt[1][23])
                        .putString("m2day25",bt[1][24]).putString("m2day26",bt[1][25]).putString("m2day27",bt[1][26]).putString("m2day28",bt[1][27]).putString("m2day29",bt[1][28])
                        .putString("m2day30",bt[1][29]).putString("m2day31",bt[1][30])
                        .putString("m3day1",bt[2][0]).putString("m3day2",bt[2][1]).putString("m3day3",bt[2][2]).putString("m3day4",bt[2][3])
                        .putString("m3day5",bt[2][4]).putString("m3day6",bt[2][5]).putString("m3day7",bt[2][6]).putString("m3day8",bt[2][7]).putString("m3day9",bt[2][8])
                        .putString("m3day10",bt[2][9]).putString("m3day11",bt[2][10]).putString("m3day12",bt[2][11]).putString("m3day13",bt[2][12]).putString("m3day14",bt[2][13])
                        .putString("m3day15",bt[2][14]).putString("m3day16",bt[2][15]).putString("m3day17",bt[2][16]).putString("m3day18",bt[2][17]).putString("m3day19",bt[2][18])
                        .putString("m3day20",bt[2][19]).putString("m3day21",bt[2][20]).putString("m3day22",bt[2][21]).putString("m3day23",bt[2][22]).putString("m3day24",bt[2][23])
                        .putString("m3day25",bt[2][24]).putString("m3day26",bt[2][25]).putString("m3day27",bt[2][26]).putString("m3day28",bt[2][27]).putString("m3day29",bt[2][28])
                        .putString("m3day30",bt[2][29]).putString("m3day31",bt[2][30])
                        .putString("m4day1",bt[3][0]).putString("m4day2",bt[3][1]).putString("m4day3",bt[3][2]).putString("m4day4",bt[3][3])
                        .putString("m4day5",bt[3][4]).putString("m4day6",bt[3][5]).putString("m4day7",bt[3][6]).putString("m4day8",bt[3][7]).putString("m4day9",bt[3][8])
                        .putString("m4day10",bt[3][9]).putString("m4day11",bt[3][10]).putString("m4day12",bt[3][11]).putString("m4day13",bt[3][12]).putString("m4day14",bt[3][13])
                        .putString("m4day15",bt[3][14]).putString("m4day16",bt[3][15]).putString("m4day17",bt[3][16]).putString("m4day18",bt[3][17]).putString("m4day19",bt[3][18])
                        .putString("m4day20",bt[3][19]).putString("m4day21",bt[3][20]).putString("m4day22",bt[3][21]).putString("m4day23",bt[3][22]).putString("m4day24",bt[3][23])
                        .putString("m4day25",bt[3][24]).putString("m4day26",bt[3][25]).putString("m4day27",bt[3][26]).putString("m4day28",bt[3][27]).putString("m4day29",bt[3][28])
                        .putString("m4day30",bt[3][29]).putString("m4day31",bt[3][30])
                        .putString("m5day1",bt[4][0]).putString("m5day2",bt[4][1]).putString("m5day3",bt[4][2]).putString("m5day4",bt[4][3])
                        .putString("m5day5",bt[4][4]).putString("m5day6",bt[4][5]).putString("m5day7",bt[4][6]).putString("m5day8",bt[4][7]).putString("m5day9",bt[4][8])
                        .putString("m5day10",bt[4][9]).putString("m5day11",bt[4][10]).putString("m5day12",bt[4][11]).putString("m5day13",bt[4][12]).putString("m5day14",bt[4][13])
                        .putString("m5day15",bt[4][14]).putString("m5day16",bt[4][15]).putString("m5day17",bt[4][16]).putString("m5day18",bt[4][17]).putString("m5day19",bt[4][18])
                        .putString("m5day20",bt[4][19]).putString("m5day21",bt[4][20]).putString("m5day22",bt[4][21]).putString("m5day23",bt[4][22]).putString("m5day24",bt[4][23])
                        .putString("m5day25",bt[4][24]).putString("m5day26",bt[4][25]).putString("m5day27",bt[4][26]).putString("m5day28",bt[4][27]).putString("m5day29",bt[4][28])
                        .putString("m5day30",bt[4][29]).putString("m5day31",bt[4][30])
                        .putString("m1day1",bt[5][0]).putString("m1day2",bt[5][1]).putString("m1day3",bt[5][2]).putString("m1day4",bt[5][3])
                        .putString("m1day5",bt[5][4]).putString("m1day6",bt[5][5]).putString("m1day7",bt[5][6]).putString("m1day8",bt[5][7]).putString("m1day9",bt[5][8])
                        .putString("m1day10",bt[5][9]).putString("m1day11",bt[5][10]).putString("m1day12",bt[5][11]).putString("m1day13",bt[5][12]).putString("m1day14",bt[5][13])
                        .putString("m1day15",bt[5][14]).putString("m1day16",bt[5][15]).putString("m1day17",bt[5][16]).putString("m1day18",bt[5][17]).putString("m1day19",bt[5][18])
                        .putString("m1day20",bt[5][19]).putString("m1day21",bt[5][20]).putString("m1day22",bt[5][21]).putString("m1day23",bt[5][22]).putString("m1day24",bt[5][23])
                        .putString("m1day25",bt[5][24]).putString("m1day26",bt[5][25]).putString("m1day27",bt[5][26]).putString("m1day28",bt[5][27]).putString("m1day29",bt[5][28])
                        .putString("m1day30",bt[5][29]).putString("m1day31",bt[5][30])
                        .putString("m1day1",bt[6][0]).putString("m1day2",bt[6][1]).putString("m1day3",bt[6][2]).putString("m1day4",bt[6][3])
                        .putString("m1day5",bt[6][4]).putString("m1day6",bt[6][5]).putString("m1day7",bt[6][6]).putString("m1day8",bt[6][7]).putString("m1day9",bt[6][8])
                        .putString("m1day10",bt[6][9]).putString("m1day11",bt[6][10]).putString("m1day12",bt[6][11]).putString("m1day13",bt[6][12]).putString("m1day14",bt[6][13])
                        .putString("m1day15",bt[6][14]).putString("m1day16",bt[6][15]).putString("m1day17",bt[6][16]).putString("m1day18",bt[6][17]).putString("m1day19",bt[6][18])
                        .putString("m1day20",bt[6][19]).putString("m1day21",bt[6][20]).putString("m1day22",bt[6][21]).putString("m1day23",bt[6][22]).putString("m1day24",bt[6][23])
                        .putString("m1day25",bt[6][24]).putString("m1day26",bt[6][25]).putString("m1day27",bt[6][26]).putString("m1day28",bt[6][27]).putString("m1day29",bt[6][28])
                        .putString("m1day30",bt[6][29]).putString("m1day31",bt[6][30])
                        .putString("m1day1",bt[7][0]).putString("m1day2",bt[7][1]).putString("m1day3",bt[7][2]).putString("m1day4",bt[7][3])
                        .putString("m1day5",bt[7][4]).putString("m1day6",bt[7][5]).putString("m1day7",bt[7][6]).putString("m1day8",bt[7][7]).putString("m1day9",bt[7][8])
                        .putString("m1day10",bt[7][9]).putString("m1day11",bt[7][10]).putString("m1day12",bt[7][11]).putString("m1day13",bt[7][12]).putString("m1day14",bt[7][13])
                        .putString("m1day15",bt[7][14]).putString("m1day16",bt[7][15]).putString("m1day17",bt[7][16]).putString("m1day18",bt[7][17]).putString("m1day19",bt[7][18])
                        .putString("m1day20",bt[7][19]).putString("m1day21",bt[7][20]).putString("m1day22",bt[7][21]).putString("m1day23",bt[7][22]).putString("m1day24",bt[7][23])
                        .putString("m1day25",bt[7][24]).putString("m1day26",bt[7][25]).putString("m1day27",bt[7][26]).putString("m1day28",bt[7][27]).putString("m1day29",bt[7][28])
                        .putString("m1day30",bt[7][29]).putString("m1day31",bt[7][30])
                        .putString("m1day1",bt[8][0]).putString("m1day2",bt[8][1]).putString("m1day3",bt[8][2]).putString("m1day4",bt[8][3])
                        .putString("m1day5",bt[8][4]).putString("m1day6",bt[8][5]).putString("m1day7",bt[8][6]).putString("m1day8",bt[8][7]).putString("m1day9",bt[8][8])
                        .putString("m1day10",bt[8][9]).putString("m1day11",bt[8][10]).putString("m1day12",bt[8][11]).putString("m1day13",bt[8][12]).putString("m1day14",bt[8][13])
                        .putString("m1day15",bt[8][14]).putString("m1day16",bt[8][15]).putString("m1day17",bt[8][16]).putString("m1day18",bt[8][17]).putString("m1day19",bt[8][18])
                        .putString("m1day20",bt[8][19]).putString("m1day21",bt[8][20]).putString("m1day22",bt[8][21]).putString("m1day23",bt[8][22]).putString("m1day24",bt[8][23])
                        .putString("m1day25",bt[8][24]).putString("m1day26",bt[8][25]).putString("m1day27",bt[8][26]).putString("m1day28",bt[8][27]).putString("m1day29",bt[8][28])
                        .putString("m1day30",bt[8][29]).putString("m1day31",bt[8][30])
                        .putString("m1day1",bt[9][0]).putString("m1day2",bt[9][1]).putString("m1day3",bt[9][2]).putString("m1day4",bt[9][3])
                        .putString("m1day5",bt[9][4]).putString("m1day6",bt[9][5]).putString("m1day7",bt[9][6]).putString("m1day8",bt[9][7]).putString("m1day9",bt[9][8])
                        .putString("m1day10",bt[9][9]).putString("m1day11",bt[9][10]).putString("m1day12",bt[9][11]).putString("m1day13",bt[9][12]).putString("m1day14",bt[9][13])
                        .putString("m1day15",bt[9][14]).putString("m1day16",bt[9][15]).putString("m1day17",bt[9][16]).putString("m1day18",bt[9][17]).putString("m1day19",bt[9][18])
                        .putString("m1day20",bt[9][19]).putString("m1day21",bt[9][20]).putString("m1day22",bt[9][21]).putString("m1day23",bt[9][22]).putString("m1day24",bt[9][23])
                        .putString("m1day25",bt[9][24]).putString("m1day26",bt[9][25]).putString("m1day27",bt[9][26]).putString("m1day28",bt[9][27]).putString("m1day29",bt[9][28])
                        .putString("m1day30",bt[9][29]).putString("m1day31",bt[9][30])
                        .putString("m1day1",bt[10][0]).putString("m1day2",bt[10][1]).putString("m1day3",bt[10][2]).putString("m1day4",bt[10][3])
                        .putString("m1day5",bt[10][4]).putString("m1day6",bt[10][5]).putString("m1day7",bt[10][6]).putString("m1day8",bt[10][7]).putString("m1day9",bt[10][8])
                        .putString("m1day10",bt[10][9]).putString("m1day11",bt[10][10]).putString("m1day12",bt[10][11]).putString("m1day13",bt[10][12]).putString("m1day14",bt[10][13])
                        .putString("m1day15",bt[10][14]).putString("m1day16",bt[10][15]).putString("m1day17",bt[10][16]).putString("m1day18",bt[10][17]).putString("m1day19",bt[10][18])
                        .putString("m1day20",bt[10][19]).putString("m1day21",bt[10][20]).putString("m1day22",bt[10][21]).putString("m1day23",bt[10][22]).putString("m1day24",bt[10][23])
                        .putString("m1day25",bt[10][24]).putString("m1day26",bt[10][25]).putString("m1day27",bt[10][26]).putString("m1day28",bt[10][27]).putString("m1day29",bt[10][28])
                        .putString("m1day30",bt[10][29]).putString("m1day31",bt[10][30])
                        .putString("m1day1",bt[11][0]).putString("m1day2",bt[11][1]).putString("m1day3",bt[11][2]).putString("m1day4",bt[11][3])
                        .putString("m1day5",bt[11][4]).putString("m1day6",bt[11][5]).putString("m1day7",bt[11][6]).putString("m1day8",bt[11][7]).putString("m1day9",bt[11][8])
                        .putString("m1day10",bt[11][9]).putString("m1day11",bt[11][10]).putString("m1day12",bt[11][11]).putString("m1day13",bt[11][12]).putString("m1day14",bt[11][13])
                        .putString("m1day15",bt[11][14]).putString("m1day16",bt[11][15]).putString("m1day17",bt[11][16]).putString("m1day18",bt[11][17]).putString("m1day19",bt[11][18])
                        .putString("m1day20",bt[11][19]).putString("m1day21",bt[11][20]).putString("m1day22",bt[11][21]).putString("m1day23",bt[11][22]).putString("m1day24",bt[11][23])
                        .putString("m1day25",bt[11][24]).putString("m1day26",bt[11][25]).putString("m1day27",bt[11][26]).putString("m1day28",bt[11][27]).putString("m1day29",bt[11][28])
                        .putString("m1day30",bt[11][29]).putString("m1day31",bt[11][30]).apply();*/
            }
        });
        return view;
    }
    public void shshow(int Mday,final SharedPreferences preferences){
        final int a = Mday-1;
        //final int b = Mmonth-1;
        final String[] list_item = {"全身","背部","腹部","胸部","腿部"};
        AlertDialog.Builder dialog_list = new AlertDialog.Builder(getContext());
        dialog_list.setTitle("運動項目");
        dialog_list.setItems(list_item, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "你選的是" + list_item[i], Toast.LENGTH_SHORT).show();
               if(watch.getText().toString().equals("")) {
                   if (i == 0)
                       bt[a] = "訓練了:" + "全身";
                   if (i == 1)
                       bt[a] = "訓練了:" + "背部";
                   if (i == 2)
                       bt[a] = "訓練了:" + "腹部";
                   if (i == 3)
                       bt[a] = "訓練了:" + "胸部";
                   if (i == 4)
                       bt[a] = "訓練了:" + "腿部";
               }
               else{
                   if (i == 0)
                       bt[a]+= "\r" + "全身";
                   if (i == 1)
                       bt[a]+= "\r" + "背部";
                   if (i == 2)
                       bt[a]+= "\r" + "腹部";
                   if (i == 3)
                       bt[a]+= "\r" + "胸部";
                   if (i == 4)
                       bt[a]+= "\r" + "腿部";
               }
            }
        });
        dialog_list.show();
    }
    public void resetall(){

            for (int i = 0; i < 31; i++) {
                bt[i]="";
            }
    }
}
