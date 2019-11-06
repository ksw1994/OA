package com.bootdo.system.service.impl;

import com.bootdo.common.excel.ReadExcel;
import com.bootdo.system.service.ExcelService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public String readExcelFile(MultipartFile file) {
        String result = "";
        //创建处理EXCEL的类
        ReadExcel readExcel = new ReadExcel();
        //解析excel，获取上传的事件单
        List<Map<String, Object>> userList = readExcel.getExcelInfo(file);
        //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
        if(userList != null && !userList.isEmpty()){
            result = "上传成功";
        }else{
            result = "上传失败";
        }
        return result;
    }
}
