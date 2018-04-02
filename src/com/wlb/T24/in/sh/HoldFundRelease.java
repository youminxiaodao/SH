package com.wlb.T24.in.sh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wlb.T24.in.sh.factory.HoldFundReleaseFactory;
import com.wlb.T24.in.sh.factory.MapEntityM;

public class HoldFundRelease {
	public static String inRoutineFormat(String inMsg) {
		String outMsg = "";
		if (!"".equals(inMsg)) {
			HoldFundReleaseFactory holdFundReleaseFactory = new HoldFundReleaseFactory();
			String type = inMsg.substring(0, 27);
			com.wlb.T24.in.sh.factory.HoldFundRelease objType = holdFundReleaseFactory
					.getType(type);
			outMsg = objType.retMsg(inMsg);
		}
		return outMsg;
	}

	public static String outRoutineFormat(String outMsg) {
		String retoutMsg = "";
		String type = "";
		System.out.println(outMsg);
		if(!"".equals(outMsg)){
			int msgLength = outMsg.length();
			HoldFundReleaseFactory holdFundReleaseFactory = new HoldFundReleaseFactory();
			if("ACLK".equals(outMsg.substring(0,4))){
				type = "ACLK";
				if(outMsg.indexOf("/-1/NO")>0){
//					type = "Err";
					outMsg = outMsg.substring(outMsg.indexOf("/-1/NO,")+7, msgLength);
				}
				else if(outMsg.indexOf("/1,")>0){
//					type = "Suc";
					outMsg = outMsg.substring(outMsg.indexOf("/1,")+3,msgLength);
				}
			}
			com.wlb.T24.in.sh.factory.HoldFundRelease objType = holdFundReleaseFactory.getType(type);
			retoutMsg = objType.retMsg(outMsg);
		}
		return retoutMsg;
	}

	public static String HoldFundReleaseTest(String inMsg) {
		String outMsg = "";
		if (!"".equals(inMsg)) {
			HoldFundReleaseFactory holdFundReleaseFactory = new HoldFundReleaseFactory();
			String type = inMsg.substring(0, 27);
			com.wlb.T24.in.sh.factory.HoldFundRelease type2 = holdFundReleaseFactory
					.getType(type);
			outMsg = type2.retMsg(inMsg);
		}
		return outMsg;
	}
	public String test(String T){
		return T;
	}

	public static void main(String[] args) {

		String string = "FSHHSHFSH              DAHFQAN2018-05-2511:50:34000000000000300220Y        N079                                                                       0630306010800000000000060220525776                                                                                                                   HKD000000000058304+          0013482955                                ";
		/*
		 * String inRoutineFormat = inRoutineFormat(string);
		 * System.out.println(inRoutineFormat);
		 * 
		 * System.out.println(string.length());
		 * System.out.println(string.indexOf("08")); System.out.println("tell:"
		 * + string.substring(159, 167)); System.out.println("term:" +
		 * string.substring(167, 171)); //
		 * System.out.println(string.indexOf("60220525776"));
		 * System.out.println("reference:" + string.substring(171, 173));
		 * System.out.println("acc.no:" + string.substring(173, 184));
		 * System.out.println("filter:" + string.substring(184, 231));
		 * System.out.println("remark:" + string.substring(231, 281));
		 * System.out.println("filter:" + string.substring(281, 299));
		 * System.out.println("ccy:" + string.substring(299, 302));
		 * System.out.println("hold amt:" + string.substring(302, 317));
		 * System.out.println("hold amt sign:" + string.substring(317, 318));
		 * System.out.println("hold fund release date:" + string.substring(318,
		 * 328)); System.out.println("hold fund reason:" + string.substring(328,
		 * 331));
		 */
//		String outMsg = "ACLK1733936205/I18032307190002198/1,ACCOUNT.NUMBER:1:1=60220525776,FROM.DATE:1:1=20171205,LOCKED.AMOUNT:1:1=58304,T.HLD.FND.CODE:1:1=001,T.ACC.NO:1:1=60220525776,T.CURRENCY:1:1=HKD,T.HLD.REASON:1:1=HOLD BY BILLS DEPT,T.TYPE:1:1=1,EXT.ITF.CODE:1:1=ITF002.0021.A,EXT.SYSTEM.NAME:1:1=SH,EXT.CHANNEL.ID:1:1=KB,EXT.TELLER.ID:1:1=08000000,EXT.TERM.ID:1:1=0000,EXT.REFERENCE:1:1=1803230719000,EXT.TXN.TIME:1:1=1803230719000,ACC.T.HOLD.AMT:1:3=000000000058304,CURR.NO:1:1=1,INPUTTER:1:1=10563_INPUTTER__WS___OFS_ITF.ONLINE.OFS,DATE.TIME:1:1=1803231923,AUTHORISER:1:1=10563_INPUTTER_WS____OFS_ITF.ONLINE.OFS,CO.CODE:1:1=HK0010108,DEPT.CODE:1:1=1,INACTIV.MARKER:1:1=,ACCOUNT.CATEGORY:1:1=6001,ACCOUNT.PRODUCT.CODE:1:1=SAV01,ACCOUNT.CURRENCY:1:3=HKD,ACCOUNT.STATUS:1:1=O,LEDGER.BALANCE:1:3=240943.33,AVAILABLE.BALANCE:1:3=124335.33,HOLD.AMOUNT:1:1=116608,FLOAT.AMOUNT:1:3=0,OD.LIMIT:1:3=0,ITF.RETURN.CODE:1:1=E-000000,ITF.RETURN.MSG:1:1=SUCCESS,ITF.REFERENCE:1:1=DFE183451056369792.00";
		String outMsg = "ACLK1733936205/I18032307190002198/1,ACCOUNT.NUMBER:1:1=60220525776,FROM.DATE:1:1=20171205,LOCKED.AMOUNT:1:1=58304,T.HLD.FND.CODE:1:1=001,T.ACC.NO:1:1=60220525776,T.CURRENCY:1:1=HKD,T.HLD.REASON:1:1=HOLD BY BILLS DEPT,T.TYPE:1:1=1,EXT.ITF.CODE:1:1=ITF002.0021.A,EXT.SYSTEM.NAME:1:1=SH,EXT.CHANNEL.ID:1:1=KB,EXT.TELLER.ID:1:1=08000000,EXT.TERM.ID:1:1=0000,EXT.REFERENCE:1:1=1803230719000,EXT.TXN.TIME:1:1=1803230719000,ACC.T.HOLD.AMT:1:1=000000000158304,ACC.T.HOLD.AMT:1:2=000000000258304,ACC.T.HOLD.AMT:1:3=000000000358304,CURR.NO:1:1=1,INPUTTER:1:1=10563_INPUTTER__WS___OFS_ITF.ONLINE.OFS,DATE.TIME:1:1=1803231923,AUTHORISER:1:1=10563_INPUTTER_WS____OFS_ITF.ONLINE.OFS,CO.CODE:1:1=HK0010108,DEPT.CODE:1:1=1,INACTIV.MARKER:1:1=,ACCOUNT.CATEGORY:1:1=6001,ACCOUNT.PRODUCT.CODE:1:1=SAV01,ACCOUNT.CURRENCY:1:1=HKD,ACCOUNT.CURRENCY:1:2=CNY,ACCOUNT.CURRENCY:1:3=USD,ACCOUNT.STATUS:1:1=O,LEDGER.BALANCE:1:1=2409430.33,LEDGER.BALANCE:1:2=2409431.33,LEDGER.BALANCE:1:3=2409432.33,AVAILABLE.BALANCE:1:1=1243350.33,AVAILABLE.BALANCE:1:2=1243351.33,AVAILABLE.BALANCE:1:3=1243352.33,HOLD.AMOUNT:1:1=116608,FLOAT.AMOUNT:1:1=0,FLOAT.AMOUNT:1:2=1,FLOAT.AMOUNT:1:3=2,OD.LIMIT:1:1=0,OD.LIMIT:1:2=1,OD.LIMIT:1:3=2,ITF.RETURN.CODE:1:1=E-000000,ITF.RETURN.MSG:1:1=SUCCESS,ITF.REFERENCE:1:1=DFE183451056369792.00";
		// String outMsg =
		// "ACLK1733921187/I18032710520124851/-1/NO,ACCOUNT.NUMBER:1:1=EB-MISSING.RECORD,LOCKED.AMOUNT:1:1=Bucket Error E-139218,T.TYPE:1:1=Bucket Error E-139218,ACCOUNT.NUMBER:1:1=EB.RTN.INP.MISS.3,ACCOUNT.NUMBER:1:1=EB-MISSING.RECORD,T.TYPE:1:1=EB-MISSING.RECORD,INACTIV.MARKER:1:1=,ACCOUNT.CATEGORY:1:1=6001,ACCOUNT.PRODUCT.CODE:1:1=SAV01,ACCOUNT.CURRENCY:1:1=HKD,ACCOUNT.STATUS:1:1=O,LEDGER.BALANCE:1:1=240943.33,AVAILABLE.BALANCE:1:1=124335.33,HOLD.AMOUNT:1:1=116608,FLOAT.AMOUNT:1:1=0,OD.LIMIT:1:1=0,ITF.RETURN.CODE:1:1=E-139636,ITF.RETURN.MSG:1:1=MISSING & - RECORD,ITF.REFERENCE:1:1=DFE183495008539133.00,EXT.REFERENCE:1:1=1803271052012";
		// outRoutineFormat(outMsg);
		// inRoutineFormat(string);
		// inRoutineFormat(string);
		String testString = "ACLK1733936205/I18032307190002198/1,ACCOUNT.NUMBER:1:1=60220525776,FROM.DATE:1:1=20171205,LOCKED.AMOUNT:1:1=58304,T.HLD.FND.CODE:1:1=001,T.ACC.NO:1:1=60220525776,T.CURRENCY:1:1=HKD,T.HLD.REASON:1:1=HOLD BY BILLS DEPT,T.TYPE:1:1=1,EXT.ITF.CODE:1:1=ITF002.0021.A,EXT.SYSTEM.NAME:1:1=SH,EXT.CHANNEL.ID:1:1=KB,EXT.TELLER.ID:1:1=08000000,EXT.TERM.ID:1:1=0000,EXT.REFERENCE:1:1=1803230719000,EXT.TXN.TIME:1:1=1803230719000,ACC.T.HOLD.AMT:1:1=000000000058304,CURR.NO:1:1=1,INPUTTER:1:1=10563_INPUTTER__WS___OFS_ITF.ONLINE.OFS,DATE.TIME:1:1=1803231923,AUTHORISER:1:1=10563_INPUTTER_WS____OFS_ITF.ONLINE.OFS,CO.CODE:1:1=HK0010108,DEPT.CODE:1:1=1,INACTIV.MARKER:1:1=,ACCOUNT.CATEGORY:1:1=6001,ACCOUNT.PRODUCT.CODE:1:1=SAV01,ACCOUNT.CURRENCY:1:1=HKD,ACCOUNT.STATUS:1:1=O,LEDGER.BALANCE:1:1=240943.33,AVAILABLE.BALANCE:1:1=124335.33,HOLD.AMOUNT:1:1=116608,FLOAT.AMOUNT:1:1=0,OD.LIMIT:1:1=0,ITF.RETURN.CODE:1:1=E-000000,ITF.RETURN.MSG:1:1=SUCCESS,ITF.REFERENCE:1:1=DFE183451056369792.00";
		/*
		 * HashMap<String, String> map = new HashMap<String, String>();
		 * HashMap<String, Entity> hashMap = new HashMap<String, Entity>(); //
		 * map.put("",testString); String substring =
		 * testString.substring(34,35); if("1".equals(substring)){ testString
		 * =testString.substring(36,testString.length());
		 * 
		 * } else{ testString =testString.substring(40,testString.length()); }
		 * String[] testS = testString.split(","); long testSLength =
		 * testS.length; for (int i = 0; i < testSLength; i++) { String[] data =
		 * testS[i].split("=",-1); map.put(data[0], data[1]);
		 * System.out.println(data[1]); } System.out.println(map);
		 */
		// inRoutineFormat(string);
//		 outMsg = "ACLK1733s921187/I18032710520124851/-1/NO,ACCOUNT.NUMBER:1:1=EB-MISSING.RECORD,LOCKED.AMOUNT:1:1=Bucket Error E-139218,T.TYPE:1:1=Bucket Error E-139218,ACCOUNT.NUMBER:1:1=EB.RTN.INP.MISS.3,ACCOUNT.NUMBER:1:1=EB-MISSING.RECORD,T.TYPE:1:1=EB-MISSING.RECORD,INACTIV.MARKER:1:1=,ACCOUNT.CATEGORY:1:1=6001,ACCOUNT.PRODUCT.CODE:1:1=SAV01,ACCOUNT.CURRENCY:1:1=HKD,ACCOUNT.STATUS:1:1=O,LEDGER.BALANCE:1:1=240943.33,AVAILABLE.BALANCE:1:1=124335.33,HOLD.AMOUNT:1:1=116608,FLOAT.AMOUNT:1:1=0,OD.LIMIT:1:1=0,ITF.RETURN.CODE:1:1=E-139636,ITF.RETURN.MSG:1:1=MISSING & - RECORD,ITF.REFERENCE:1:1=DFE183495008539133.00,EXT.REFERENCE:1:1=1803271052012";
		 /*String outRoutineFormat = outRoutineFormat(outMsg);
		 System.out.println("outRoutineFormat:"+outRoutineFormat);*/
//		String inRoutineFormatString = inRoutineFormat("FSHHSHFSH              DARFQAN2018-04-3018:47:17000000000000300235Y        N088                                                                       0630326010800000000000060118022477                                                                                                                   HKD000000075194775+          0082018-04-30601083479662                  ACLK1812080854");
//		System.out.println("inRoutineFormatString:" + inRoutineFormatString);
//		 String msg = "ACLK1733936205/I18032307190002198/1,ACCOUNT.NUMBER:1:1=60220525776,FROM.DATE:1:1=20171205,LOCKED.AMOUNT:1:1=58304,T.HLD.FND.CODE:1:1=001,T.ACC.NO:1:1=60220525776,T.CURRENCY:1:1=HKD,T.HLD.REASON:1:1=HOLD BY BILLS DEPT,T.TYPE:1:1=1,EXT.ITF.CODE:1:1=ITF002.0021.A,EXT.SYSTEM.NAME:1:1=SH,EXT.CHANNEL.ID:1:1=KB,EXT.TELLER.ID:1:1=08000000,EXT.TERM.ID:1:1=0000,EXT.REFERENCE:1:1=1803230719000,EXT.TXN.TIME:1:1=1803230719000,ACC.T.HOLD.AMT:1:1=000000000158304,ACC.T.HOLD.AMT:1:2=000000000258304,ACC.T.HOLD.AMT:1:3=000000000358304,CURR.NO:1:1=1,INPUTTER:1:1=10563_INPUTTER__WS___OFS_ITF.ONLINE.OFS,DATE.TIME:1:1=1803231923,AUTHORISER:1:1=10563_INPUTTER_WS____OFS_ITF.ONLINE.OFS,CO.CODE:1:1=HK0010108,DEPT.CODE:1:1=1,INACTIV.MARKER:1:1=,ACCOUNT.CATEGORY:1:1=6001,ACCOUNT.PRODUCT.CODE:1:1=SAV01,ACCOUNT.CURRENCY:1:1=HKD,ACCOUNT.CURRENCY:1:2=CNY,ACCOUNT.CURRENCY:1:3=USD,ACCOUNT.STATUS:1:1=O,LEDGER.BALANCE:1:1=2409430.33,LEDGER.BALANCE:1:2=2409431.33,LEDGER.BALANCE:1:3=2409432.33,AVAILABLE.BALANCE:1:1=1243350.33,AVAILABLE.BALANCE:1:2=1243351.33,AVAILABLE.BALANCE:1:3=1243352.33,HOLD.AMOUNT:1:1=116608,FLOAT.AMOUNT:1:1=0,FLOAT.AMOUNT:1:2=1,FLOAT.AMOUNT:1:3=2,OD.LIMIT:1:1=0,OD.LIMIT:1:2=1,OD.LIMIT:1:3=2,ITF.RETURN.CODE:1:1=E-000000,ITF.RETURN.MSG:1:1=SUCCESS,ITF.REFERENCE:1:1=DFE183451056369792.00";
//		 outMsg = "ACLK1803804716/I18011010124703006/-1/NO,@ID:1:1=Bucket Error E-138650,INACTIV.MARKER:1:1=,ACCOUNT.CATEGORY:1:1=1001,ACCOUNT.PRODUCT.CODE:1:1=CUR01,ACCOUNT.CURRENCY:1:1=HKD,ACCOUNT.STATUS:1:1=O,LEDGER.BALANCE:1:1=1398.88,AVAILABLE.BALANCE:1:1=900,HOLD.AMOUNT:1:1=498.88,FLOAT.AMOUNT:1:1=0,OD.LIMIT:1:1=0,ITF.RETURN.CODE:1:1=E-999999,ITF.RETURN.MSG:1:1=Bucket Error E-138650,ITF.REFERENCE:1:1=DFE182735970149404.00,EXT.REFERENCE:1:1=B18011010124703006";
		 String msg = outMsg;
//		 System.out.println(outRoutineFormat(msg));
		 System.out.println(outRoutineFormat("ACLK1803885483/I18011018184704302/1,ACCOUNT.NUMBER:1:1=EB.RTN.INP.MISS.3,LOCKED.AMOUNT:1:1=EB.RTN.INP.MISS.3,INACTIV.MARKER:1:1=,20180207,ACCOUNT.CATEGORY:1:1=6001,ACCOUNT.PRODUCT.CODE:1:1=SAV01,ACCOUNT.CURRENCY:1:1=HKD,ACCOUNT.STATUS:1:1=O,LEDGER.BALANCE:1:1=183243.94,AVAILABLE.BALANCE:1:1=107822.27,HOLD.AMOUNT:1:1=75421.67,FLOAT.AMOUNT:1:1=0,OD.LIMIT:1:1=0,EXT.REFERENCE:1:1=B18011018184704302,EXT.ITF.CODE:1:1=ITF002.0022.A,EXT.TXN.TIME:1:1=180207181847,ITF.RETURN.CODE:1:1=E-999998,ITF.RETURN.MSG:1:1=INPUT MISSING,ITF.REFERENCE:1:1=DFE182736806738993.00,EXT.REFERENCE:1:1=B18011018184704302"));
		 /*HashMap<String, List> retMapMsgM = retMapMsgM(msg);
		 System.out.println("--------------------");
		 System.out.println("retMapMsgM:"+retMapMsgM);
		 MapEntityM mapEntityM = (MapEntityM) retMapMsgM.get("ACCOUNT.CURRENCY").get(2);
		 System.out.println(mapEntityM.getContentString());*/
	}
	private static int rowPos;
	private static int colPos;
	private static String fieldBody;
	public static HashMap<String, List> retMapMsgM(String msg) {
		HashMap<String,List> hashMap = new HashMap<String,List>();
		// HashMap<String, Entity> hashMap = new HashMap<String, Entity>();
		// map.put("", outMsg);
		String[] testS = msg.split(",");
		long testSLength = testS.length;
		for (int i = 0; i < testSLength; i++) {
			// ------------------------------
			MapEntityM mapEntityM = new MapEntityM();
			ArrayList arrayList = new ArrayList();
			String string = testS[i];
			String[] fieldSplit = string.split(":");
			String mapKey = fieldSplit[0];
//			String mapKey = string.split("=",-1)[0];
			String[] fieldDetSplit = fieldSplit[2].split("=",-1);
			rowPos = Integer.parseInt(fieldSplit[1]);
			colPos = Integer.parseInt(fieldDetSplit[0]);
			fieldBody = fieldDetSplit[1];
			mapEntityM.setRowPos(rowPos);
			mapEntityM.setColPos(colPos);
			mapEntityM.setContentString(fieldBody);
			if(hashMap.containsKey(mapKey)){
				hashMap.get(mapKey).add(mapEntityM);
			}
			else{
				arrayList = new ArrayList();
				arrayList.add(mapEntityM);
				hashMap.put(mapKey, arrayList);
			}
			// ------------------------------
			/*String[] data = testS[i].split("=", -1);
			map.put(data[0], data[1]);*/
//			System.out.println("mapKey[i]:"+mapKey[i]);
//			System.out.println("---mapKey:"+mapKey+"  ,mapEntity:"+mapEntity);
//			hashMap.put(mapKey, arrayList);
/*			System.out.println("arrayList:"+arrayList);
			System.out.println("hashMap:"+hashMap);
*/		}
		return hashMap;
	}
}
