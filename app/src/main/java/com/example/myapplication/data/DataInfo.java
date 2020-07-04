package com.example.myapplication.data;

import com.example.myapplication.model.ModelInfo;

import java.util.ArrayList;

public class DataInfo {

    private static String[] katakunci = {
            "What is Cash Flow & NCF",
            "5 cost element in CF",
            "NCF and Profit",
            "NCF and tax",
            "Depresiation",
            "(Di)Straight Line",
            "(Di)Declining Balance",
            "(Di)Double Declining Balance",
            "(Di)Unit of Production",
            "(DI)Sum-of the Year",
            "NCF and Inflasi"

    };

    public static ArrayList<ModelInfo> getListData() {
        ModelInfo modelInfo = null;
        ArrayList<ModelInfo> list = new ArrayList<>();
        for (int i = 0; i < katakunci.length; i++) {
            modelInfo = new ModelInfo();
            modelInfo.setKataKunci(katakunci[i]);
            list.add(modelInfo);
        }
        return list;
    }
}
