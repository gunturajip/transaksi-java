package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.PaymentHistoryRepository;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransaksiPaymentImple implements TransaksiService {

    @Autowired
    public TransaksiRepository transaksiRepository;

    @Autowired
    public PaymentHistoryRepository paymentHistoryRepository;

    @Override
    public Map save(Transaksi obj) {
        Map map = new HashMap();
        try {

            Transaksi save = transaksiRepository.save(obj);
            map.put("data", save);
            map.put("statusCode", 200);
            map.put("statusMessage", "Get Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map updateStatus(Transaksi obj) {
        Map map = new HashMap();
        try {
            Transaksi find = transaksiRepository.getByID(obj.getId());
            if(find != null){
                find.setStatus("lunas");
                transaksiRepository.save(find);
            }
            map.put("data", find);
            map.put("statusCode", 200);
            map.put("statusMessage", "Get Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }
}
