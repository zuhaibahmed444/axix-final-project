package com.zuhaib.FinalCaseAxis.service.Impl;

import com.zuhaib.FinalCaseAxis.helper.CSVUtils;
import com.zuhaib.FinalCaseAxis.model.helper.RevokeRequestModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVServiceImpl {

    private CSVUtils csvUtils;

    public List<RevokeRequestModel> uploadMultipart(MultipartFile file) throws IOException {
        var ot = csvUtils.read(RevokeRequestModel.class, file.getInputStream());
        System.out.println(ot);
        return ot;
    }

}
