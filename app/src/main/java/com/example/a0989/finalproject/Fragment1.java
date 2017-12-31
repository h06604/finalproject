package com.example.a0989.finalproject;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.icu.math.BigDecimal;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    private View view;
    Button bt5;
    TextView tv1,tv2,tv3;
    Integer year=0,heart1=0,heart2=0;
    Double  BMI=0.0,BASE=0.0,RRE=0.0,weight=0.0,tall=0.0;
    String[] messageData1 = new String[]{"","","","",""};
    String[] fat=new String[]{"過輕","正常","過重","輕度肥胖","中度肥胖","重度肥胖"};
    String fatdegree="";
    String[] sport=new String[]{"全身","胸部､背部","胸部､背部","腹部､腿部","腹部､腿部","腹部､腿部"};
    String sportdegree="";
    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fragment1, container, false);
        final SharedPreferences preferences = this.getActivity().getSharedPreferences("data", MODE_PRIVATE);
        tv1=(TextView) view.findViewById(R.id.sportwhere);
        for(int i=0;i<5;i++){
            if(i==0){
                messageData1[i]="BMI:"+preferences.getString("BMI","");
            }
            else if(i==1){
                messageData1[i]="每日基礎代謝:"+preferences.getString("BASE","");
            }
            else if(i==2){
                messageData1[i]="靜態能量消耗值:"+preferences.getString("RRE","");
            }
            else if(i==3){
                messageData1[i]="燃脂運動心率:"+preferences.getString("heart1","")+"次/分~"+preferences.getString("heart2","")+"次/分";
            }
            else if(i==4){
                messageData1[i]="肥胖程度:"+preferences.getString("fatdegree","");
            }
        }
        showList();
        sportdegree=preferences.getString("sportdegree","");
        tv1.setText(sportdegree);


        bt5=(Button)view.findViewById(R.id.button5);
        bt5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                final View a=inflater.inflate(R.layout.input,null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setView(a).setTitle("請輸入正確資訊").setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        EditText userInput1=(EditText) a.findViewById(R.id.editText1);
                        EditText userInput2=(EditText) a.findViewById(R.id.editText2);
                        EditText userInput3=(EditText) a.findViewById(R.id.editText3);
                        if(userInput1.getText().toString().equals("")||userInput2.getText().toString().equals("")||userInput3.getText().toString().equals("")){
                            Toast.makeText(getContext(),"資料輸入不完全",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            tall=Double.parseDouble(userInput1.getText().toString());
                            weight=Double.parseDouble(userInput2.getText().toString());
                            year=Integer.parseInt(userInput3.getText().toString());
                            BMI=weight/((tall/100)*(tall/100));
                            BASE=(13.7*weight)+(5*tall)-(6.8*year)+66;
                            RRE=(10*weight)+(6.5*tall)-(5*year)+5;
                            heart1=(220-year)*6/10;
                            heart2=(220-year)*8/10;
                            java.text.DecimalFormat decimalFormat1=new java.text.DecimalFormat("0.0");
                            String heart1tmp=heart1.toString();
                            String heart2tmp=heart2.toString();
                            String  basetmp=decimalFormat1.format(BASE);
                            String  bmitmp=decimalFormat1.format(BMI);
                            String  rretmp=decimalFormat1.format(RRE);
                            if(BMI>=35){
                                fatdegree=fat[5];
                                sportdegree=sport[5];
                            }
                            else if(35>BMI && BMI>=30){
                                fatdegree=fat[4];
                                sportdegree=sport[4];
                            }
                            else if(30>BMI && BMI>=27){
                                fatdegree=fat[3];
                                sportdegree=sport[3];
                            }
                            else if(27>BMI && BMI>=24){
                                fatdegree=fat[2];
                                sportdegree=sport[2];
                            }
                            else if(24>BMI && BMI>=18.5){
                                fatdegree=fat[1];
                                sportdegree=sport[1];
                            }
                            else if(18.5>BMI){
                                fatdegree=fat[0];
                                sportdegree=sport[0];
                            }
                            for(int i=0;i<5;i++){
                                if(i==0){
                                    messageData1[i]="BMI:"+bmitmp;
                                }
                                else if(i==1){
                                    messageData1[i]="每日基礎代謝:"+basetmp;
                                }
                                else if(i==2){
                                    messageData1[i]="靜態能量消耗值:"+rretmp;
                                }
                                else if(i==3){
                                    messageData1[i]="燃脂運動心率:"+heart1tmp+"次/分~"+heart2tmp+"次/分";
                                }
                                else if(i==4){
                                    messageData1[i]="肥胖程度:"+fatdegree;
                                }
                            }

                            preferences.edit().putString("BMI",bmitmp).putString("BASE",basetmp).putString("RRE",rretmp).putString("heart1",heart1tmp)
                                    .putString("heart2",heart2tmp).putString("fatdegree",fatdegree).putString("sportdegree",sportdegree).apply();
                            tv1.setText(sportdegree);
                            showList();
                        }
                    }
                }).setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                        Toast.makeText(getContext(),"取消" , Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });



        return view;
    }
    public void showList(){
        ArrayAdapter<String> messageAdapter= new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,messageData1);
        ListView listView=(ListView)view.findViewById(R.id.listview);
        listView.setAdapter(messageAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                if(messageData1[position].equals("")){

                }
                else{
                    if(position==0){
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        final View a=inflater.inflate(R.layout.bmiinformation,null);
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                        alertDialogBuilder.setView(a).setTitle("身體質量指數(BMI)").setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which){
                                Toast.makeText(getContext(),"OOKK",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                    }
                    else if(position==1){
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        final View a=inflater.inflate(R.layout.bmrinformation,null);
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                        alertDialogBuilder.setView(a).setTitle("基礎代謝率(BMR)").setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which){
                                Toast.makeText(getContext(),"OOKK",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                    }
                    else if(position==2){
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        final View a=inflater.inflate(R.layout.rreinformation,null);
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                        alertDialogBuilder.setView(a).setTitle("靜態能量消耗值(REE)").setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which){
                                Toast.makeText(getContext(),"OOKK",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                    }
                    else if(position==3){
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        final View a=inflater.inflate(R.layout.heartinformation,null);
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                        alertDialogBuilder.setView(a).setTitle("燃脂運動最佳心率").setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which){
                                Toast.makeText(getContext(),"OOKK",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                    }
                }
            }
        });

    }


}
