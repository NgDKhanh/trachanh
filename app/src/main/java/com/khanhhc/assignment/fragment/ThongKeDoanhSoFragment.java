package com.khanhhc.assignment.fragment;

import android.app.DatePickerDialog;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.khanhhc.assignment.R;
import com.khanhhc.assignment.dao.ChiTietHoaDonDAO;

import java.util.Calendar;


public class ThongKeDoanhSoFragment extends Fragment {
    Button btnTuNgay, btnDenNgay, btnTK;
    TextView tvTongDoanhThu, tvHead, tvSmall;
    ChiTietHoaDonDAO dao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thong_ke_doanh_so, container, false);

        //
        tvTongDoanhThu = view.findViewById(R.id.tvTongDoanhThu);
        btnTuNgay = view.findViewById(R.id.btnTuNgay);
        btnDenNgay = view.findViewById(R.id.btnDenNgay);
        btnTK = view.findViewById(R.id.btnTK);
        tvHead = view.findViewById(R.id.tvHeadTK);
        tvSmall = view.findViewById(R.id.tvSmallTK);
        //

        //
        final Calendar cldr = Calendar.getInstance();
        final int day = cldr.get(Calendar.DAY_OF_MONTH);
        final int month = cldr.get(Calendar.MONTH);
        final int year = cldr.get(Calendar.YEAR);
        //

        // dinh dang font chu
        Typeface fontHead = Typeface.createFromAsset(getActivity().getAssets(), "RosewoodStd-Regular.otf");
        Typeface fontSmall = Typeface.createFromAsset(getActivity().getAssets(), "segoesc.ttf");
        tvHead.setTypeface(fontHead);
        tvSmall.setTypeface(fontSmall);
        //

        btnTuNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker = new DatePickerDialog(getContext(), R.style.DatePicker, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        if(monthOfYear < 9 && dayOfMonth < 10){
                            btnTuNgay.setText(year+"/"+"0"+(monthOfYear+1)+"/"+"0"+dayOfMonth);
                        } else if(monthOfYear < 9){
                            btnTuNgay.setText(year+"/"+"0"+(monthOfYear+1)+"/"+dayOfMonth);
                        }else if(dayOfMonth < 10){
                            btnTuNgay.setText(year+"/"+(monthOfYear+1)+"/"+"0"+dayOfMonth);
                        }else{
                            btnTuNgay.setText(year+"/"+(monthOfYear+1)+"/"+dayOfMonth);
                        }
                    }
                }, year, month, day);
                datePicker.show();
            }
        });

        btnDenNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker = new DatePickerDialog(getContext(), R.style.DatePicker, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        if(monthOfYear < 9 && dayOfMonth < 10){
                            btnDenNgay.setText(year+"/"+"0"+(monthOfYear+1)+"/"+"0"+dayOfMonth);
                        } else if(monthOfYear < 9){
                            btnDenNgay.setText(year+"/"+"0"+(monthOfYear+1)+"/"+dayOfMonth);
                        }else if(dayOfMonth < 10){
                            btnDenNgay.setText(year+"/"+(monthOfYear+1)+"/"+"0"+dayOfMonth);
                        }else{
                            btnDenNgay.setText(year+"/"+(monthOfYear+1)+"/"+dayOfMonth);
                        }
                    }
                }, year, month, day);
                datePicker.show();
            }
        });

        btnTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao = new ChiTietHoaDonDAO(getContext());
                double TongDS = dao.getDoanhThu(btnTuNgay.getText().toString(), btnDenNgay.getText().toString());
                tvTongDoanhThu.setText("Tổng doanh thu: "+TongDS);
            }
        });


        return view;
    }
}
