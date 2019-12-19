package com.qiangjiang.ironOldMan;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.qiangjiang.ironOldMan.controller.UserController;
import com.qiangjiang.ironOldMan.model.User;
import com.qiangjiang.ironOldMan.reomteService.wmhtService.WmhtNewCommonHttpRequest;
import com.qiangjiang.ironOldMan.reomteService.wmhtService.scan.SacnPay;
import com.qiangjiang.ironOldMan.utils.SystemUtils;
import jxl.Sheet;
import jxl.Workbook;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IronOldManApplicationTests {
	@Autowired
	private SacnPay sacnPay;
	@Autowired
	private WmhtNewCommonHttpRequest httpRequest;
	@Autowired
	private UserController userController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void mctApplyUpdateBatch() throws Exception {
		File file = new File("demo2.xls");
//		File file = new File("/Users/jiangqiang/code/qiangjiang/study/ironOldMan/demo2.xls ");
		String name = file.getName();
		System.out.println("name:"+name);
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
				System.out.println("");
				System.out.println();
			}
		}
	}

	@Test
	public void testScan(){
		sacnPay.scan();
	}

	@Test
	public void batchSign() throws Exception{
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

        		String settleUnitID = sheet.getCell(0, i).getContents();
        		if(!StringUtils.isEmpty(settleUnitID)){
					String url = "http://pay.checkup.api.hualala.com/settle/updateUnitInfo.svc?processStatus=4&settleUnitID="+settleUnitID;
//        		String url = "http://pay.checkup.api.hualala.com/settle/confirmMctAccredit.svc?settleUnitID="+settleUnitID;
//				String url = "http://pay.checkup.api.hualala.com/settle/mctAutoAccredit.svc?settleUnitID="+settleUnitID;
					String executeGetNew = httpRequest.executeGetNew(url, null);
					System.out.println("settleUnitID :"+settleUnitID+" :url :"+url);
					System.out.println("executeGetNew :"+executeGetNew);
					System.out.println("executeGetNew :"+executeGetNew);
					System.out.println("第"+i+"个 settleUnitID:"+settleUnitID);
				}



			}
		}
	}


	@Test
	public void testBatchSign() throws Exception {
		File file = new File("demo2.xls");
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
				String settleUnitID = sheet.getCell(0, i).getContents();
				if(StringUtils.isEmpty(settleUnitID)){
					break;
				}
				String url = "http://pay.checkup.api.hualala.com/settle/mctAutoAccredit.svc?settleUnitID=" + settleUnitID;
//				String url = "http://pay.checkup.api.hualala.com/settle/confirmMctAccredit.svc?settleUnitID=" + settleUnitID;
//				String url = "http://dohko.api.settleapi.hualala.com/delay/wechatAuthQuery?topic=wechat_real_auth_query\\&id=43072119890606373420190911113931\\&body=%7B%22licenseCode%22:%22430721198906063734%22,%22settleUnitID%22:113196,%22businessCode%22:%2243072119890606373420190911113931%22%7D";
				System.out.println("url:"+url);
//				System.out.println("第"+(i+1)+"个 settleUnitID:" + settleUnitID);
				String resData = httpRequest.executeGetNew(url, null);
				ResData data = JSONObject.parseObject(resData, ResData.class);
//				System.out.println("data:"+new Gson().toJson(data));
				System.out.println("data:"+ new Gson().toJson(data));
				User user = new User();
				user.setSettleUnitID(settleUnitID);
				user.setCode(data.getCode());
				user.setMessage(data.getMessage());
				user.setMessageParams(data.getMessageParams());
				user.setTraceID(data.getTraceID());
				userController.insert(user);
			}
		}
	}


	@Test
	public void testPayOrderNo() throws Exception {
		File file = new File("D:\\demo2.xls");
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
			int count = 0;
			for (int i = 0; i < sheet.getRows(); i++) {
				count++;
				String myOrderNo = sheet.getCell(0, i).getContents();
				String url = "http://pay.checkup.api.hualala.com/order/queryByPayOrderNo.svc?payOrderNo=" + myOrderNo;
				System.out.println("myOrderNo:" + myOrderNo);
				String resData = httpRequest.executeGetNew(url, null);
//				QueryMyOrderNoResData queryMyOrderNoResData = JSONObject.parseObject(resData, QueryMyOrderNoResData.class);
//				OrderPayQueryService.QueryPayDetail queryPayDetail = queryMyOrderNoResData.getPayMaster().getPayDetailList().get(0);
//				String payWayType = queryPayDetail.getPayWayType();
//				String payCode = queryPayDetail.getPayCode();
//				System.out.println(myOrderNo+":"+payCode);
////                if (!"WEIXIN_MINI".equals(payWayType)) {
//////                    System.out.println("个数："+count+"===="+myOrderNo + ":" + payWayType);
////                    System.out.println(myOrderNo+":"+payCode);
////                }else{
////                    System.out.println(myOrderNo+":"+payCode);
////                }
//				System.out.println("个数："+count+"===="+myOrderNo + ":" + payWayType);
//				User user = new User();
//				user.setMyOrderNo(myOrderNo);
//				user.setPayWayType(payWayType);
//				user.setExtra(payCode);
//				userController.insert(user);
			}
		}
	}


	@Test
	public void img(){
		String imgUrl = "https://hualala-quickpay.oss-cn-beijing.aliyuncs.com/036ddd0274984565bf1dc9faa7e04c70";
		if(imgUrl.toLowerCase().contains("https") || imgUrl.toLowerCase().contains("http")){
			System.out.println("1231231231231231231");
		}
		System.out.println("================");
	}


	@Test
	public void testmq(){

	}




	@Data
	static class ResData{
		private String code;
		private String traceID;
		private String messageParams;
		private String message;
	}



	@Test
	public void testFoodList(){
		IntStream.range(0, 3).forEach(i -> System.out.println(i));
	}


	@Test
	public  void test1() {
		List<String> strings = new ArrayList<>(Arrays.asList("".split(",")));
		if(!strings.contains("1111")){
			strings.add("1111");
		}
		if(!strings.contains("2222")){
			strings.add("2222");
		}
		String new_appid = strings.stream().collect(Collectors.joining(","));
		System.out.println("new_appid:"+new_appid);
	}


	@Test
	public  void test2() {
		String surprise = "\\u5410\\u53ee\\u7230\\u7683\\u7a0a\\u5e8e\\u5457\\u81f3\\u656b\\uff0b\\u627d\\u524c\\u53ef\\u5c0e\\u59cf\\u59cf\\u6708\\u60c9\\u559b\\uff00";
		System.out.println("结果："+unicodeToString(surprise));
	}

	private static String unicodeToString(String str) {

	Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");

    Matcher matcher = pattern.matcher(str);

	char ch;

	while (matcher.find()) {

		ch = (char) (Integer.parseInt(matcher.group(2), 16) + 1);

 		str = str.replace(matcher.group(1), ch + "");

	}

	return	str;
	}

}
