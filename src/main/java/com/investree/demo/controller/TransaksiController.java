package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {

    @Autowired
    public TransaksiService transaksiService;

    @Autowired
    public TransaksiRepository transaksiRepository;

    @PostMapping("")
    public ResponseEntity<Map> save(@RequestBody Transaksi objModel) {
        Map obj = transaksiService.save(objModel);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Map> updateStatus(@RequestBody Transaksi objModel ) {
        Map map = transaksiService.updateStatus(objModel);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Transaksi>> listByBama(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String status) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Transaksi> list = null;
        if(status != null){
            list = transaksiRepository.findByStatusLike("%"+status+"%",show_data);
        }else {
            list = transaksiRepository.getList(show_data);
        }
        return new ResponseEntity<Page<Transaksi>>(list, new HttpHeaders(), HttpStatus.OK);
    }

}
