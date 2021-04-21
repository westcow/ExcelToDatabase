package com.bjb.exceltodb.controller;

import com.bjb.exceltodb.entity.User;
import com.bjb.exceltodb.service.AreaService;
import com.bjb.exceltodb.service.UserService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Description
 * @Author XJT
 * @CreateDate
 * @Return
 * @Version
 */
@RestController
@RequestMapping("/read")
public class method {

    @Autowired
    private AreaService areaService;
    @Autowired
    private UserService userService;

    @PostMapping("/readExcelToDB")
    public String readExcelToDB(String path) {
        int i = 0;
        int rowsNum = 0;
        try {
            InputStream is = new FileInputStream(path);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
            //第一行不放数据，放标题
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            rowsNum = xssfSheet.getLastRowNum();
            for (i = 1; i < rowsNum+1; i++) {
                //获取行数据
                XSSFRow row = xssfSheet.getRow(i);
                //获取单元格数据
                User user = new User();
                user.setUserName(row.getCell(0).getStringCellValue());
                user.setIdCode(row.getCell(1).getStringCellValue());
                user.setIdMd5(row.getCell(2).getStringCellValue());
                user.setMobilePhone(row.getCell(3).getStringCellValue());
                user.setProvinceName(row.getCell(5).getStringCellValue());
                user.setProvinceCode(getAreaCodeByAreaName(user.getProvinceName(), 0));
                user.setCityName(row.getCell(6).getStringCellValue());
                user.setCityCode(getAreaCodeByAreaName(user.getCityName(), user.getProvinceCode()));
                user.setCountryName(row.getCell(7).getStringCellValue());
                user.setCountryCode(getAreaCodeByAreaName(user.getCountryName(), user.getCityCode()));
                user.setAddress(row.getCell(8).getStringCellValue());
                user.setGender(row.getCell(9).getStringCellValue());
                userService.addUser(user);
            }
            return "执行完毕，计划插入" + rowsNum + "条数据，实际插入" + i + "条数据";
        }catch (Exception e) {
            e.printStackTrace();
            return "计划插入" + rowsNum + "条数据，执行到第" + (i+1) + "条数据时失败，查看数据是否有误";
        }
    }

    private Integer getAreaCodeByAreaName(String areaName, Integer superAreaCode) {
        if (areaName.equals("澳门特别行政区")) {
            return 82;
        }
        return areaService.getAreaCodeByAreaName(areaName, superAreaCode);
    }
}
