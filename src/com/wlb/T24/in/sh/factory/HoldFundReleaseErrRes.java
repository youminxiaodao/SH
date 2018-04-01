package com.wlb.T24.in.sh.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HoldFundReleaseErrRes implements HoldFundRelease {
	HashMap<String, String> map = null;
	MapEntity mapEntity = null;
	int rowPos = 0;
	int colPos = 0;
	String fieldBody = "";
	String msgFieldB = "";
	String retoutMsg = "";

	@Override
	public String retMsg(String outMsg) {
		// TODO Auto-generated method stub
		/*
		 * HashMap<String, String> map = new HashMap<String, String>(); //
		 * HashMap<String, Entity> hashMap = new HashMap<String, Entity>(); //
		 * map.put("", outMsg); String[] testS = outMsg.split(","); long
		 * testSLength = testS.length; for (int i = 0; i < testSLength; i++) {
		 * String[] data = testS[i].split("=", -1); map.put(data[0], data[1]); }
		 */
//		HashMap<String, MapEntity> retMapMsg = retMapMsg(outMsg);
		HashMap<String, List> retMapMsg = retMapMsgM(outMsg);
//		System.out.println(retMapMsg.keySet());
//		System.out.println(retMapMsg);
		String msgB = getMsgB(retMapMsg,"ACCOUNT.CATEGORY",0);
		
		String proCategory = getMsgB(retMapMsg,"ACCOUNT.CATEGORY",0);

		String proCode = getMsgB(retMapMsg,"ACCOUNT.PRODUCT.CODE",0);

		String proTpCode = proCode.substring(0, 3);

		String prodPlan = "1";

		String shortName = "                  ";

		String accStatusString = getMsgB(retMapMsg,"ACCOUNT.STATUS",0);

		String lastFinancialDat = "          ";

		String balEntryString = "  ";
		
//		MapEntity ccyEntity = (MapEntity) retMapMsg.get("ACCOUNT.CURRENCY");
		

		String holdPlaceDate;
		try {
			holdPlaceDate = getMsgB(retMapMsg,"EXT.TXN.TIME",0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			holdPlaceDate = "";
		}
		if (holdPlaceDate == null) {
			holdPlaceDate = "";
		}
		if ("".equals(holdPlaceDate)) {
			holdPlaceDate = "          ";
		} else {
			String hdPlDtSub = holdPlaceDate.substring(0, 7);
			holdPlaceDate = "20" + hdPlDtSub.substring(0, 2) + "-" + hdPlDtSub.substring(2, 4) + "-"
					+ hdPlDtSub.substring(5, 7);
		}
		String Filter = "                 ";
		String retMsgString = "  ";
		String msgTyeString = " ";
		String msgCodeString = "";

		int cycleInt = retMapMsg.get("ACCOUNT.CURRENCY").size();
		String cycleCnt = "01";
		if (cycleInt<10){
			cycleCnt = "0"+cycleInt;
		}
		else{
			cycleCnt = String.valueOf(cycleInt);
		}
		retoutMsg = "DD " + proTpCode + proCode + "  " + shortName + accStatusString + lastFinancialDat + balEntryString
				+ cycleCnt;
		String mMsgB = getMMsgB(retMapMsg, 0);
		retoutMsg = retoutMsg+mMsgB;
		/*retoutMsg = retoutMsg + ccyCode + ledgerBalance + ledgerBalanceSign + availableBalance + availableBalanceSign
				+ totalFloatAmount + totalFloatAmountSign + totalHoldAmount + totalHoldAmountSign + CRLimit
				+ CRLimitSign;*/
		if (cycleInt == 1) {
			for (int i = 0; i < 19; i++) {
				retoutMsg = retoutMsg + "   " + "             " + "             " + "             " + "             "
						+ "             ";
			}
			retoutMsg = retoutMsg + holdPlaceDate + Filter + retMsgString + msgTyeString + msgCodeString;
		} else {
			for (int i = 1; i < cycleInt; i++) {
				retoutMsg = retoutMsg + getMMsgB(retMapMsg, i);
			}
			for (int i = 0; i < 19-cycleInt; i++) {
				retoutMsg = retoutMsg + "   " + "             " + "             " + "             " + "             "
						+ "             ";
			}
			retoutMsg = retoutMsg + holdPlaceDate + Filter + retMsgString + msgTyeString + msgCodeString;

		}
		return retoutMsg;
	}

	@Override
	public HashMap<String, MapEntity> retMapMsg(String msg) {
		// TODO Auto-generated method stub
//		map = new HashMap<String, String>();
		HashMap<String,MapEntity> hashMap = new HashMap<String,MapEntity>();
		// HashMap<String, Entity> hashMap = new HashMap<String, Entity>();
		// map.put("", outMsg);
		String[] testS = msg.split(",");
		long testSLength = testS.length;
		for (int i = 0; i < testSLength; i++) {
			// ------------------------------
			mapEntity = new MapEntity();
			String string = testS[i];
			String[] fieldSplit = string.split(":");
			String mapKey = fieldSplit[0];
//			String mapKey = string.split("=",-1)[0];
			String[] fieldDetSplit = fieldSplit[2].split("=",-1);
			rowPos = Integer.parseInt(fieldSplit[1]);
			colPos = Integer.parseInt(fieldDetSplit[0]);
			fieldBody = fieldDetSplit[1];
			mapEntity.setRowPos(rowPos);
			mapEntity.setColPos(colPos);
			mapEntity.setContentString(fieldBody);
			// ------------------------------
			/*String[] data = testS[i].split("=", -1);
			map.put(data[0], data[1]);*/
//			System.out.println("mapKey[i]:"+mapKey[i]);
//			System.out.println("---mapKey:"+mapKey+"  ,mapEntity:"+mapEntity);
			hashMap.put(mapKey, mapEntity);
		}
		return hashMap;
	}
	public HashMap<String, List> retMapMsgM(String msg) {
		HashMap<String,List> hashMap = new HashMap<String,List>();
		// HashMap<String, Entity> hashMap = new HashMap<String, Entity>();
		// map.put("", outMsg);
		String[] testS = msg.split(",");
		long testSLength = testS.length;
		for (int i = 0; i < testSLength; i++) {
			// ------------------------------
			MapEntity mapEntity = new MapEntity();
			ArrayList arrayList = new ArrayList();
			String string = testS[i];
			String[] fieldSplit = string.split(":");
			String mapKey = fieldSplit[0];
//			String mapKey = string.split("=",-1)[0];
			String[] fieldDetSplit = fieldSplit[2].split("=",-1);
			rowPos = Integer.parseInt(fieldSplit[1]);
			colPos = Integer.parseInt(fieldDetSplit[0]);
			fieldBody = fieldDetSplit[1];
			mapEntity.setRowPos(rowPos);
			mapEntity.setColPos(colPos);
			mapEntity.setContentString(fieldBody);
			if(hashMap.containsKey(mapKey)){
				hashMap.get(mapKey).add(mapEntity);
			}
			else{
				arrayList = new ArrayList();
				arrayList.add(mapEntity);
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
	
	public String getMsgB(HashMap<String, List> retMapMsg,String msgB,int i){
		msgFieldB = ((MapEntity) retMapMsg.get(msgB).get(i)).getContentString();
		return msgFieldB;
	}
	
	public String getMMsgB(HashMap<String, List> retMapMsg, int i){
		String ret = "";
		String ccyCode = getMsgB(retMapMsg,"ACCOUNT.CURRENCY",i);

		String ledgerBalance = getMsgB(retMapMsg,"LEDGER.BALANCE",i).replace(".", "");
		while (ledgerBalance.length() < 15) {
			ledgerBalance = "0" + ledgerBalance;
		}
		String ledgerBalanceSign = "+";

		String availableBalance = getMsgB(retMapMsg,"AVAILABLE.BALANCE",i).replace(".", "");
		while (availableBalance.length() < 15) {
			availableBalance = "0" + availableBalance;
		}
		String availableBalanceSign = "+";

		String totalFloatAmount = getMsgB(retMapMsg,"FLOAT.AMOUNT",i).replace(".", "");
		while (totalFloatAmount.length() < 15) {
			totalFloatAmount = "0" + totalFloatAmount;
		}
		String totalFloatAmountSign = "+";

		String totalHoldAmount;
		try {
			totalHoldAmount = getMsgB(retMapMsg,"ACC.T.HOLD.AMT",i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			totalHoldAmount = "";
		}
		if (totalHoldAmount == null) {
			totalHoldAmount = "0";
		}
		totalHoldAmount = totalHoldAmount.replace(".", "");
		while (totalHoldAmount.length() < 15) {
			totalHoldAmount = "0" + totalHoldAmount;
		}
		String totalHoldAmountSign = "+";

		String CRLimit = getMsgB(retMapMsg,"OD.LIMIT",i).replace(".", "");
		if (CRLimit == null) {
			CRLimit = "0";
		}
		while (CRLimit.length() < 15) {
			CRLimit = "0" + CRLimit;
		}
		String CRLimitSign = "+";
		ret = ccyCode + ledgerBalance + ledgerBalanceSign + availableBalance + availableBalanceSign
		+ totalFloatAmount + totalFloatAmountSign + totalHoldAmount + totalHoldAmountSign + CRLimit
		+ CRLimitSign;
		return ret;
	}

}
