package com.qiangjiang.ironOldMan;

import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IronOldManApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void mctApplyUpdateBatch() throws Exception {
		File file = new File("demo2.xls");
//		File file = new File("/Users/jiangqiang/code/qiangjiang/study/ironOldMan/demo2.xls ");
		// 创建输入流，读取Excel
		InputStream is = new FileInputStream(file.getAbsolutePath());
		// jxl提供的Workbook类
		Workbook wb = Workbook.getWorkbook(is);
		// Excel的页签数量
		int sheet_size = wb.getNumberOfSheets();
		for (int index = 0; index < sheet_size; index++) {
			List<List> outerList = new ArrayList<List>();
			// 每个页签创建一个Sheet对象
			Sheet sheet = wb.getSheet(index);
			// sheet.getRows()返回该页的总行数
			for (int i = 0; i < sheet.getRows(); i++) {
				// sheet.getColumns()返回该页的总列数
//        for (int j = 0; j < sheet.getColumns(); j++) {
				String settleUnitID = sheet.getCell(0, i).getContents();
				String merchantNo = sheet.getCell(1, i).getContents();
				String groupID = sheet.getCell(2, i).getContents();
				String unitType = sheet.getCell(3, i).getContents();


//				ChannelReport2Service.MctUpdateReqData reqData = new ChannelReport2Service.MctUpdateReqData();
//				reqData.setChannelCode("AINONG");
//				reqData.setSpMerchantNo("M100000801");
//				reqData.setMyMerchantNo(settleUnitID);
//				reqData.setMerchantNo(merchantNo);
//				reqData.setUnitType(Integer.valueOf(unitType));
//				reqData.setImgBusiEnv(groupID);
//
//
//				ChannelReport2Service report2Service  = rpcClient.getRpcClient(ChannelReport2Service.class);
//				report2Service.mctUpdate(reqData);
          System.out.print("settleUnitID :"+settleUnitID+"  ");
          System.out.print("merchantNo :"+merchantNo+"  ");
          System.out.print("groupID :"+groupID+"  ");
//          System.out.print("settleUnitName :"+settleUnitName+"  ");
//          System.out.print("version :"+version+"  ");
//        }
				System.out.println();
			}
		}
	}

}
