package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ViewModel.LaporanViewModel;
import com.example.myapplication.adapter.AdapterLaporan;
import com.example.myapplication.dialog.LoadingDialog;
import com.example.myapplication.model.AbsenItem;
import com.example.myapplication.model.User;
import com.example.myapplication.util.PrefUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MetodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MetodeFragment extends Fragment {
    //private EditText nameFragTxt;
    private Spinner myspinner;
    private AdapterLaporan adapterLaporan;
    private RecyclerView rvLaporan;
    private LaporanViewModel laporanViewModel;
    private Button btn_laporan;
    LoadingDialog loadingDialog;
    //String strSpinner, strEmail;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MetodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MetodeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MetodeFragment newInstance(String param1, String param2) {
        MetodeFragment fragment = new MetodeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_metode, container, false);
        //Populate the spinner in the fragment

        //btn_laporan = (ImageButton) view.findViewById(R.id.btn_lihatlaporan);
        //rvLaporan = view.findViewById(R.id.rv_laporan);

//        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int position,
//                                       long id) {
//                switch (position) {
//                    case 0:
//                       // strSpinner = "1";
//                        //sendData();
//                        break;
//
//                    case 1:
//                        //strSpinner = "2";
//                        //sendData();
//                        break;
//                    case 2:
//                       // strSpinner = "3";
//                        //sendData();
//                        break;
//                    case 3:
//                        //strSpinner = "4";
//                        //sendData();
//                        break;
//                    case 4:
//                      //  strSpinner = "5";
//                        //sendData();
//                        break;
//                    case 5:
//                       // strSpinner = "6";
//                        //sendData();
//                        break;
//                    case 6:
//                        String text = myspinner.getSelectedItem().toString();
//                        if(text == "Juli"){
//                            String strSpinner = "7";
//                      //  strSpinner.sendData();
//                        loadingDialog = new LoadingDialog(getActivity());
//                        loadingDialog.startLoadingDialog();
//                        User user = PrefUtil.getUser(getActivity().getApplicationContext(), PrefUtil.USER_SESSION);
//                        String strEmail = user.getData().getEmail();
//
////                        final LoadingDialog loadingDialog = new LoadingDialog(requireActivity());
////                        loadingDialog.startLoadingDialog();
//
//                        adapterLaporan = new AdapterLaporan(getActivity().getApplicationContext());
//                        adapterLaporan.notifyDataSetChanged();
//
//                        rvLaporan = view.findViewById(R.id.rv_laporan);
//                        rvLaporan.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1));
//
//                        laporanViewModel = new ViewModelProvider(getActivity()).get(LaporanViewModel.class);
//                        laporanViewModel.setDataLaporan(strEmail,strSpinner );
//                        laporanViewModel.getAbsen().observe(getActivity(), getAbsen);
//                        rvLaporan.setAdapter(adapterLaporan);
//                        }
//                        break;
//                    default:
//                        break;
//                }
//
//                Toast.makeText(parent.getContext(),
//                        "On Item Select : \n" + parent.getItemAtPosition(position).toString(),
//                        Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });

        //return view;
    }

//    public void sendData() {
//        //getActivity().setTitle("Laporan Presensi");
//
//        User user = PrefUtil.getUser(getActivity(), PrefUtil.USER_SESSION);
//        String strEmail = user.getData().getEmail();
//        String strSpinner =
//        final LoadingDialog loadingDialog = new LoadingDialog(requireActivity());
//        loadingDialog.startLoadingDialog();
//        adapterLaporan = new AdapterLaporan(getActivity().getAplicationContext());
//        adapterLaporan.notifyDataSetChanged();
//        rvLaporan.setLayoutManager(new GridLayoutManager(getActivity().getAplicationContext(), 1));
//
//        laporanViewModel = new ViewModelProvider(this).get(LaporanViewModel.class);
//        laporanViewModel.setDataLaporan(strEmail, strSpinner);
//        laporanViewModel.getAbsen().observe(this, getAbsen);
//        rvLaporan.setAdapter(adapterLaporan);
//        loadingDialog.dismissDialog();
//    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Laporan");

        myspinner = (Spinner) view.findViewById(R.id.sp);
        rvLaporan = view.findViewById(R.id.rv_laporan);
        String[] values =
                {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus",};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        myspinner.setAdapter(adapter);

        btn_laporan = (Button) view.findViewById(R.id.btn_laporan);
        btn_laporan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                User user = PrefUtil.getUser(getContext(), PrefUtil.USER_SESSION);
                String strEmail = user.getData().getEmail();
                final String text = myspinner.getSelectedItem().toString();
                laporanAct(strEmail, text);}
        });


    }

    void laporanAct(String strEmail, String text){
        if (text == "Juli") {
            String strSpinner = "7";
            //  strSpinner.sendData();
            loadingDialog = new LoadingDialog(getActivity());
            loadingDialog.startLoadingDialog();
            User user = PrefUtil.getUser(getActivity(), PrefUtil.USER_SESSION);
            //String strEmail = user.getData().getEmail();

            final LoadingDialog loadingDialog = new LoadingDialog(requireActivity());
            loadingDialog.startLoadingDialog();

            adapterLaporan = new AdapterLaporan(getActivity());
            adapterLaporan.notifyDataSetChanged();


            rvLaporan.setLayoutManager(new GridLayoutManager(getActivity(), 1));

            laporanViewModel = new ViewModelProvider(this).get(LaporanViewModel.class);
            laporanViewModel.setDataLaporan(strEmail, strSpinner);
            laporanViewModel.getAbsen().observe(this, getAbsen);
            rvLaporan.setAdapter(adapterLaporan);
        }
    }
    private Observer<List<AbsenItem>> getAbsen = new Observer<List<AbsenItem>>() {
        @Override
        public void onChanged(List<AbsenItem> absenItems) {
            if (absenItems != null)
                adapterLaporan.setData(absenItems);
        }
    };
}