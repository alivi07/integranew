package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.adapter.AdapterInfo;
import com.example.myapplication.data.DataInfo;
import com.example.myapplication.model.ModelInfo;
import com.example.myapplication.model.User;
import com.example.myapplication.util.PrefUtil;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    Intent intent, i;
    private TextView tvUsername, tvInstansi, tvKontak;
    private RecyclerView rvListInfo;
    private ArrayList<ModelInfo> listInfo = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        intent = new Intent(getActivity(), scanner.class);
        final Button btn_scan = (Button) view.findViewById(R.id.scan);
        i = new Intent(getActivity(), qrcode.class);
        final Button btb_qr = (Button) view.findViewById(R.id.qrcode);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        btb_qr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(i);
            }
        });
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        User user = PrefUtil.getUser(getContext(), PrefUtil.USER_SESSION);

        tvUsername = view.findViewById(R.id.tv_username);
        tvInstansi = view.findViewById(R.id.tv_instansi);
        tvKontak = view.findViewById(R.id.tv_kontak);

        //set profil
        tvUsername.setText(user.getNama());
        tvInstansi.setText(user.getInstansi());
        tvKontak.setText(user.getEmail());
    }
}