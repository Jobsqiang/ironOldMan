package com.qiangjiang.ironOldMan;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qiangjiang.ironOldMan.controller.UserController;
import com.qiangjiang.ironOldMan.model.User;
import com.qiangjiang.ironOldMan.reomteService.TestService;
import com.qiangjiang.ironOldMan.reomteService.chinaUms.qrcode.QrcodePay;
import com.qiangjiang.ironOldMan.reomteService.chinaUms.refund.Refund;
import com.qiangjiang.ironOldMan.reomteService.wmhtService.WmhtNewCommonHttpRequest;
import com.qiangjiang.ironOldMan.reomteService.wmhtService.scan.SacnPay;
import com.qiangjiang.ironOldMan.utils.DateUtils;
import com.qiangjiang.ironOldMan.utils.SystemUtils;
import jxl.Sheet;
import jxl.Workbook;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
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
	@Autowired
	private QrcodePay qrcodePay;
	@Autowired
	private Refund refund;
	@Autowired
	private TestService testService;

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

        		String settleUnitID = sheet.getCell(4, i).getContents();
        		String companyShortName = sheet.getCell(3, i).getContents();
//        		String settleUnitID = sheet.getCell(0, i).getContents();
        		if(!StringUtils.isEmpty(settleUnitID)){
        			String url = "dohko.pay.checkup.api.hualala.com/settle/updateDocumentInfo.svc?settleUnitID="+settleUnitID+"&unitType=4&companyName="+companyShortName;

//					String url = "http://pay.checkup.api.hualala.com/settle/updateUnitInfo.svc?processStatus=4&settleUnitID="+settleUnitID;
//        		String url = "http://pay.checkup.api.hualala.com/settle/confirmMctAccredit.svc?settleUnitID="+settleUnitID;
//				String url = "http://pay.checkup.api.hualala.com/settle/mctAutoAccredit.svc?settleUnitID="+settleUnitID;
					String executeGetNew = httpRequest.executeGetNew(url, null);
					System.out.println("settleUnitID :"+settleUnitID+" :url :"+url);
					System.out.println("executeGetNew :"+executeGetNew);
//					System.out.println("executeGetNew :"+executeGetNew);
					System.out.println("第"+i+"个 settleUnitID:"+settleUnitID);
				}



			}
		}
	}




	@Test
	public void batchDocument() throws Exception{
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
				String groupID = sheet.getCell(1, i).getContents();
				String groupName = sheet.getCell(2, i).getContents();
				String appID = sheet.getCell(3, i).getContents();
				if(!StringUtils.isEmpty(settleUnitID)){
//					String url = "http://pay.checkup.api.hualala.com/settle/updateDocumentInfo.svc?settleUnitID="+settleUnitID+"&unitType=4&companyName="+companyShortName;
//					String url= "http://pay.checkup.api.hualala.com/settle/addConfig.svc?groupID=185172&groupName=上海世好餐饮管理有限公司&payMethod=WECHAT&configType=WX_BIND_PUB_NUM&configData=wx2d47e580c1c3cfa4&operator=蒋强&settleUnitID="+settleUnitID;


					String url= "http://pay.checkup.api.hualala.com/settle/addConfig.svc?groupID="+groupID+"&groupName="+groupName+"&payMethod=WECHAT&configType=WX_BIND_PUB_NUM&configData="+appID+"&operator=蒋强&settleUnitID="+settleUnitID;
					String executeGetNew = httpRequest.executeGetNew(url, null);
					System.out.println("settleUnitID :"+settleUnitID+" :url :"+url);
					System.out.println("executeGetNew :"+executeGetNew);
//					System.out.println("executeGetNew :"+executeGetNew);
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
		String str = "安徽古井贡酒股份有限公司/酿造管理中心";
		boolean b = str.contains("酿造管理中心");
		System.out.println(b);
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

	@Test
	public void testQrcode(){
		qrcodePay.qrcode();
	}

	@Test
	public void testRefund(){
		refund.refund();
	}


	@Test
	public void testQuery(){qrcodePay.query();}


//	@Test
//	public void testCloud() throws Exception {
//		while (true){
//			String url = "http://localhost:9001/consumer/get";
////		System.out.println("url:"+url);
//			String resData = httpRequest.executeGetNew(url, null);
////		ResData data = JSONObject.parseObject(resData, ResData.class);
////				System.out.println("data:"+new Gson().toJson(data));
//			System.out.println("data:"+ resData);
//		}
//	}

	@Test
	public void test() throws Exception{



	}

	public static String getCurrentDate() {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
	}




	@Test
	public void testRefund1() throws Exception {
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

				String wlbm = sheet.getCell(0, i).getContents();
				String wlmc1 = sheet.getCell(1, i).getContents();
				String wlmc = URLEncoder.encode(wlmc1, "UTF-8");
				String wllx = sheet.getCell(2, i).getContents();
				if(StringUtils.isEmpty(wlbm)){
					break;
				}
//				String url = "https://11111www.gujing.cn/r/w?sid=1c3ac823-313d-43b3-93ed-a3a9ca0cf90b&cmd=com.awspaas.user.apps.gujingshop_updateOrderForMerchant1&orderStatus=5&orderNo="+orderNo;
				String url = "https://www.gujing.cn/r/w?cmd=com.awspaas.user.apps.ad_addWineAddress&sid=5e8b45eb-2a09-4f2b-ac80-782e24e3a364&" +
						"wlbm="+wlbm+"&wlmc=" + wlmc+"&wllx=" + wllx;
//				String uuid = UUID.randomUUID().toString();
//				String url = "https://bpmdev.gujing.cn/r/w?cmd=com.awspaas.user.apps.gujingshop_addExchangeRecord&sid=99d317e5-db4d-4037-b6ff-87cef660ff15X0lbYXdzLW5vZGUjMV1JXw&codeId=85ef769d-4035-4055-a046-830496efb712&businessNo="+uuid+"&businesstype=IMPROVE_PROPOSAL";
				System.out.println("url:"+url);
				String resData = httpRequest.executeGetNew(url, null);
//				Map<String,String> map = new HashMap<>();
//				map.put("sid","be7edde5-1366-493a-9df5-2bcde6eb51f4X0lbYXdzLW5vZGUjMV1JXw");
//				map.put("cmd","com.awspaas.user.apps.ad_addWineAddress");
//				map.put("wlbm",wlbm);
//				map.put("wlmc",wlmc);
//				map.put("wllx",wllx);
//				Optional<String> optional = httpRequest.postJSON1("https://bpmdev.gujing.cn/r/jd", map.toString(), null,"UTF-8",String.class);
//				String s = optional.get();
//				System.out.println("------>"+s);

//				System.out.println("------>"+resData);
//				ResData data = JSONObject.parseObject(resData, ResData.class);
//				System.out.println("data:"+ new Gson().toJson(data));

			}
		}
	}


	@Test
	public void testRefund2() throws Exception {
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

				String code = sheet.getCell(0, i).getContents();
				String name = sheet.getCell(1, i).getContents();
				if(StringUtils.isEmpty(code)){
					break;
				}
				String sid = "fdcbf426-34a6-43ee-b2c4-265bd508d5c3X0lbYXdzLW5vZGUjMV1JXw";
				String http = "https://bpmdev.gujing.cn/r/w?";
				String cmd = "com.awspaas.user.apps.gujingpick_addMoveType";
				String url = http+"cmd="+cmd+"&sid="+sid+"&code="+code+"&name=" + name;
				System.out.println("url:"+url);
				String resData = httpRequest.executeGetNew(url, null);


			}
		}
	}

	@Test
	public void testRefund3() throws Exception {
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

				String code = sheet.getCell(0, i).getContents();
//				String name = sheet.getCell(1, i).getContents();
				if(StringUtils.isEmpty(code)){
					break;
				}
				String sid = "aac0f668-2387-46a7-99b1-c1ccff8f42e8X0lbYXdzLW5vZGUjMl1JXw";
				String http = "https://www.gujing.cn/r/w?";
				String cmd = "com.awspaas.user.apps.gujingPick_updateMaterialReserve";
				String url = http+"cmd="+cmd+"&sid="+sid+"&id="+code;
				System.out.println("url:"+url);
				String resData = httpRequest.executeGetNew(url, null);


			}
		}
	}


//where "/BIC/Z_FLOW" !='F1001' AND "/BIC/Z_BPMJE" != '1.000'
	@Test
	public void testSql() throws Exception {
		String departmentId = "E0001-002-001-001-023";
		String sid = "2544ddc2-2dcf-4e62-a85b-935472350a84";
		String http = "https://bpmdev.gujing.cn/r/w?";
		String cmd = "com.awspaas.user.apps.gujingjiebao_test";
//		String sql="SELECT \"/BIC/Z_ACCOUNT\",\"/BIC/Z_ENT\",ZPROJID,Z_PROJDES,\"/BIC/Z_BPMJE\",\"/BIC/Z_FLOW\" FROM SAPHANADB.\"/BIC/AZGD_BPM42\"  where \"/BIC/Z_FLOW\" !='F1001' AND \"/BIC/Z_BPMJE\" != '1.000'";
		String sql="SELECT * FROM SAPHANADB.\"/BIC/AZGD_BPM12\"  where \"/BIC/Z_FLOW\" !='F1001' AND \"/BIC/Z_BPMJE\" != '1.000'";
		String sql1 = URLEncoder.encode(sql, "UTF-8");
		String url = http+"cmd="+cmd+"&sid="+sid+"&sql="+sql1;

		System.out.println("url:"+url);
		String str = httpRequest.executeGetNew(url, null);
		System.out.println("--------->"+str);
//		ResData1 resData1 = JSONObject.parseObject(str, ResData1.class);
//		List<Map<String, String>> datas = resData1.getData();
//		for (Map<String, String> data: datas) {
//			for (String key :data.keySet()) {
//				String s = data.get(key);
//				System.out.println(key+"---"+s);
//			}
//		}
//		System.out.println("-------->"+new Gson().toJson(resData1));

	}



	public static class ResData1{
		private String msg;
		private String result;
		private List<Map<String,String>> data;

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		public List<Map<String, String>> getData() {
			return data;
		}

		public void setData(List<Map<String, String>> data) {
			this.data = data;
		}
	}



	@Test
	public void testUpdateOrder() throws Exception {
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
				String code = sheet.getCell(0, i).getContents();
				String uuid = sheet.getCell(1, i).getContents();
				if(StringUtils.isEmpty(code)){
					break;
				}
				File oldFile = new File("小型材料图片/"+code+".jpg");
				File   newf   =null;
				if(file != null){
					newf   =   new   File("小型材料图片/"+uuid+".jpg");
					oldFile.renameTo(newf);
					System.out.println("------->"+"小型材料图片/"+uuid+".jpg");
				}

			}
		}
	}

	@Test
	public void testPicture() throws Exception {
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

				String department = sheet.getCell(0, i).getContents();
				String userNo = sheet.getCell(1, i).getContents();
				String userName = sheet.getCell(2, i).getContents();
				if(StringUtils.isEmpty(department)){
					break;
				}
				String sid = "c598bdbe-442c-4a10-8b57-12ac2925a32f";
				String http = "https://bpmcs.gujing.cn/r/jd?";
				String cmd = "com.awspaas.user.apps.gujingforklift_addUser";
				String url = http+"cmd="+cmd+"&sid="+sid+"&department="+department+"&userNo="+userNo+"&userName="+userName+"&roleType='3'";
				System.out.println("url:"+url);
				String resData = httpRequest.executeGetNew(url, null);
				System.out.println("-------->"+new Gson().toJson(resData));


			}
		}
	}

	@Test
	public void exportStation() throws Exception {
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

				String area = sheet.getCell(0, i).getContents();
				String workShop = sheet.getCell(1, i).getContents();
				String station = sheet.getCell(2, i).getContents();
				String price = sheet.getCell(3, i).getContents();
				if(StringUtils.isEmpty(area)){
					break;
				}
				String sid = "c598bdbe-442c-4a10-8b57-12ac2925a32f";
				String http = "https://bpmcs.gujing.cn/r/jd?";
				String cmd = "com.awspaas.user.apps.gujingforklift_addStation";
				String url = http+"cmd="+cmd+"&sid="+sid+"&area="+area+"&workShop="+workShop+"&station="+station+"&price="+price;
				System.out.println("url:"+url);
				String resData = httpRequest.executeGetNew(url, null);
				System.out.println("-------->"+new Gson().toJson(resData));


			}
		}
	}




	@Test
	public void testDK(){
		long l = System.currentTimeMillis();
		try {
			for (int i = 0 ;i <= 200 ;i++ ){
				Thread.sleep(30);
				System.out.println("-------------->"+i);
			}
		}catch (Exception e	){
			e.printStackTrace();
		}
		System.out.println("----------->"+(System.currentTimeMillis() -l));
	}

	@Test
	public void rename(){
		File file = new File("古8.png");
		File   newf   =null;
		if(file != null){
			newf   =   new   File("古20.png");

			file.renameTo(newf);
		}


	}



	@Test
	public void dakaBatch() throws Exception {
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
		long startTime = DateUtils.getCurrentDateTimeLong();
		for (int index = 0; index < sheet_size; index++) {
			List<List> outerList = new ArrayList<List>();
			// 每个页签创建一个Sheet对象
			Sheet sheet = wb.getSheet(index);
			// sheet.getRows()返回该页的总行数
			for (int i = 0; i < sheet.getRows(); i++) {
				// sheet.getColumns()返回该页的总列数
//        for (int j = 0; j < sheet.getColumns(); j++) {
				String settleUnitID = sheet.getCell(0, i).getContents();
//				String merchantNo = sheet.getCell(1, i).getContents();
//				String groupID = sheet.getCell(2, i).getContents();
//				String unitType = sheet.getCell(3, i).getContents();

				System.out.println("settleUnitID 【"+i+"】:"+settleUnitID+"  ");
//				System.out.print("merchantNo :"+merchantNo+"  ");
//				System.out.print("groupID :"+groupID+"  ");
//				TestService.dk(settleUnitID);


//        }
//				System.out.println("");
//				System.out.println();
			}
		}
		System.out.println("cost------->"+(DateUtils.getCurrentDateTimeLong() - startTime)+"ms");
	}

	public static List<String> list = new ArrayList<>();


	static {
//		list.add("NGHSP2021-01-07-024");
//		list.add("NGHSP2021-01-07-025");
//		list.add("NGHSP2021-01-08-001");
		list.add("NGHSP2021-01-08-008");
		String str = "[{\\\"merchantName\\\":\\\"测试商户002\\\",\\\"orderDetailList\\\":[{\\\"spId\\\":\\\"4f63651c-1bfd-4714-ab5b-dd8853c635cc\\\",\\\"name\\\":\\\"测试1\\\",\\\"num\\\":1,\\\"price\\\":1,\\\"pictureId\\\":\\\"2b2a8e46-adb1-45f4-bb14-806ec713ee86\\\",\\\"code\\\":\\\"No00000023\\\"}]}]";
//		list.add("NGHSP2021-01-07-021");
//		list.add("NGHSP2021-01-07-022");
	}
//
//	@Test
//	public void testBuy(){
//		while (true){
//			String urlbase ="https://www.gujing.cn/r/w?sid=d8fe49aa-d003-4b36-b66a-1675cf7fd136X0lbYXdzLW5vZGUjM11JXw&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=1&sp_bh=";
////			String urlbase1 ="https://bpmcs.gujing.cn/r/w?sid=b5bec434-c892-4ad2-9e00-83413e9183a9&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=1&sp_bh=";
//			String resData = null;
////			String resData1 = null;
//			long start = System.currentTimeMillis();
//			for (String str:list) {
//				String urllll = urlbase+str;
//				System.out.println("url------->"+urllll);
//				resData = httpRequest.executeGetNew(urllll, null);
////				resData1 = httpRequest.executeGetNew(urlbase1+str, null);
//				System.out.println("商品：【"+str+"】    返回------->"+resData);
////				System.out.println("商品：【"+str+"】    返回------->"+resData1);
//			}
//			System.out.println("花费："+(System.currentTimeMillis()-start));
//		}
//	}




    @Test
    public void testBuy(){
		int i ;
        for (i=0 ;i<10 ;i++){
			String uuid = UUID.randomUUID().toString();
			String url = "https://bpmdev.gujing.cn/r/w?cmd=com.awspaas.user.apps.gujingshop_addExchangeRecord&sid=443eb2ae-9cd6-43ab-ad44-8e1bb132c01fX0lbYXdzLW5vZGUjMV1JXw&codeId=85ef769d-4035-4055-a046-830496efb712&businessNo="+uuid+"&businesstype=IMPROVE_PROPOSAL";
			System.out.println("url:"+url);
			String resData = httpRequest.executeGetNew(url, null);
        }
    }

}
