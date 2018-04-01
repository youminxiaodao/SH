package com.wlb.T24.in.sh.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.wlb.T24.in.sh.util.Configuration;

public class HoldFundReleaseSucRes implements HoldFundRelease {
	HashMap<String, String> map = null;
	MapEntity mapEntity = null;
	int rowPos = 0;
	int colPos = 0;
	String fieldBody = "";
	String msgFieldB = "";
	String retoutMsg = "";
	String retMsgString = "";

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
		String autRetMsg = autRetMsg(retMapMsg);
		System.out.println("autRetMsg:"+autRetMsg);
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
		List ccyEntity = retMapMsg.get("ACCOUNT.CURRENCY");

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

		String totalHoldAmount = getMsgB(retMapMsg,"ACC.T.HOLD.AMT",i);
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
	public String autRetMsg(HashMap<String, List> retMapMsg){
		String proTpCode = "";
		String propertyB = "";
		String mapString = "";
		String cycle = "";
		int j =0;
		String[] valueSpe=null;
		int totalCycle = 0;
		int size  =0;
		Properties properties = Configuration.getProperites();
		int propertiesSize = properties.size();
		for (int i = 0; i < propertiesSize; i++) {
			//propertyB properties中对应的值
			propertyB = properties.getProperty(String.valueOf(i));
			mapString = propertyB.split(":")[0];
			
			//currnecy前的数字
			if(retMapMsg.containsKey(mapString)){
				if("ACCOUNT.CURRENCY".equals(mapString)){
					String cycleInt = "";
					int cycleCnt = retMapMsg.get(mapString).size();
					if(cycleCnt<10){
						cycleInt = "0"+cycleCnt;
					}
					else{
						cycleInt = String.valueOf(cycleCnt);
					}
					retMsgString = retMsgString+cycleInt;
				}
			}
			if("ACCOUNT.PRODUCT.CODE".equals(mapString)){
				MapEntity mapEntityM = (MapEntity) retMapMsg.get(mapString).get(0);
				proTpCode = mapEntityM.getContentString().substring(0,3);
				
			}
			
			//
//			valueSpe = properties.getProperty(String.valueOf(i)).split(":");
			valueSpe = propertyB.split(":");
			int splitLen = valueSpe.length;
			
			//copybook中的循环体
			if(splitLen==4){
				totalCycle = 0;
				cycle = valueSpe[3];
				
				//parseInt当前字段后循环体的个数
				int parseInt = Integer.parseInt(cycle);
//				System.out.println("-------"+valueSpe[0]+"--"+parseInt);
				/*for(j=0;j<parseInt+1;j++){
					System.out.println((i+j)+"-----"+properties.getProperty(String.valueOf(i+j)));
				}
				i=i+j;*/
//				System.out.println(i);
				
				//totalCycle总循环次数
				totalCycle = Integer.parseInt(valueSpe[1]);
//				System.out.println(totalCycle);
				
					propertyB = properties.getProperty(String.valueOf(i));
					valueSpe = propertyB.split(":");
					String property = properties.getProperty(String.valueOf(i));
					if(retMapMsg.containsKey(valueSpe[0])){
						size = retMapMsg.get(valueSpe[0]).size();
						getFiledMsg(size,retMapMsg,valueSpe,parseInt,i,properties);
					}
					else{
						String mapSpace = "";
						String string2 = property.split(":")[2];
						int fieldLen = Integer.parseInt(string2);
						for(int k=0;k<fieldLen;k++){
							mapSpace = mapSpace+" ";
						}
						
						for(int k=1;k<parseInt;k++){
							propertyB = properties.getProperty(String.valueOf(i+k));
							valueSpe = propertyB.split(":");
							if(retMapMsg.containsKey(valueSpe[0])){
								size = retMapMsg.get(valueSpe[0]).size();
								String filedMsg = getFiledMsg(size,retMapMsg,valueSpe,parseInt,i,properties);
								retMsgString += filedMsg;
							}
							else{
								for(int o=0;o<Integer.parseInt(valueSpe[2]);o++){
									mapSpace = mapSpace+" ";
								}
								retMsgString = retMsgString+mapSpace;
							}
						}
					}
					if(size < totalCycle){
						String mapSpace = "";
						int parseInt2 = Integer.parseInt(valueSpe[3]);
						for(int s=size;s<totalCycle;s++){
							for(int k=0;k<parseInt2;k++){
								int parseInt3 = Integer.parseInt(valueSpe[2]);
								for(int o=0;o<parseInt3;o++){
									mapSpace = mapSpace+" ";
								}
								retMsgString = retMsgString+mapSpace;
							}
						}
					}
			
				
				/*if(retMapMsg.containsKey(valueSpe[0])){
					int size = retMapMsg.get(valueSpe[0]).size();
					for(int h=0;h<size;h++){
						for(j=0;j<parseInt+1;j++){
//							System.out.println((i+j)+"-----"+properties.getProperty(String.valueOf(i+j)));
							String property = properties.getProperty(String.valueOf(i+j));
							String string = property.split(":")[0];
							if(retMapMsg.containsKey(string)){
								Object object = retMapMsg.get(string).get(h);
								String contentString = ((MapEntity) object).getContentString();
								retMsgString = retMsgString+contentString;
							}
							else{
								String mapSpace = "";
								String string2 = property.split(":")[2];
								int fieldLen = Integer.parseInt(string2);
								for(int k=0;k<fieldLen;k++){
									mapSpace = mapSpace+" ";
								}
								retMsgString = retMsgString+mapSpace;
							}
						}
					}
					retMsgString+="**";
					
					if(size<Integer.parseInt(valueSpe[1])){
						for(int l=0;l<20-size;l++){
//						System.out.println(l);
							String mapSpace = "";
							String string2 = properties.getProperty(String.valueOf(i)).split(":")[2];
							int fieldLen = Integer.parseInt(string2);
							for(int k=0;k<fieldLen;k++){
								mapSpace = mapSpace+" ";
							}
							retMsgString = retMsgString+mapSpace;	
						}
						
					}
				}*/
//				String propertyC = properties.getProperty(String.valueOf(i+Integer.parseInt(cycle)+1));
				i += Integer.parseInt(cycle)+1;
				propertyB = properties.getProperty(String.valueOf(i));
				mapString = propertyB.split(":")[0];
//				System.out.println("property--:"+propertyC);
			}
//			System.out.println("////:"+properties.getProperty(String.valueOf(i+Integer.parseInt(cycle))));
//			mapString=properties.getProperty(String.valueOf(i+Integer.parseInt(cycle))).split(":")[0];
			//
			
			if(retMapMsg.containsKey(mapString)){
				List list = retMapMsg.get(propertyB.split(":")[0]);
				Object mapEntityM = list.get(0);
				String contentString = ((MapEntity) mapEntityM).getContentString();
				if("EXT.TXN.TIME".equals(mapString)){
					String hdPlDtSub = contentString.substring(0, 7);
					contentString = "20" + hdPlDtSub.substring(0, 2) + "-" + hdPlDtSub.substring(2, 4) + "-"
							+ hdPlDtSub.substring(5, 7);
				}
				retMsgString = retMsgString + contentString;
			}
			else{
				String mapSpace = "";
				String string = propertyB.split(":")[2];
				int fieldLen = Integer.parseInt(string);
				for(int k=0;k<fieldLen;k++){
					mapSpace = mapSpace+" ";
				}
				retMsgString = retMsgString+mapSpace;
			}
		}
		return "DD "+proTpCode+retMsgString;
	}
	public String getFiledMsg(int size,HashMap<String, List> retMapMsg,String[] valueSpe,int parseInt,int i,Properties properties){
		size = retMapMsg.get(valueSpe[0]).size();
		int fieldLength = 0;
		String property = properties.getProperty(String.valueOf(i));
		for(int h=0;h<size;h++){
			for(int j=0;j<parseInt+1;j++){
//				System.out.println((i+j)+"-----"+properties.getProperty(String.valueOf(i+j)));
				property = properties.getProperty(String.valueOf(i+j));
				String string = property.split(":")[0];
				if(retMapMsg.containsKey(string)){
					
					Object object = retMapMsg.get(string).get(h);
					String contentString = ((MapEntity) object).getContentString();
					/*if(contentString.indexOf(".")>=0){
						contentString = contentString.replace(".", "");
						fieldLength = Integer.parseInt(property.split(":")[2]);
						while (contentString.length() < fieldLength) {
							contentString = "0" + contentString;
						}
					}*/
					try {
						if(Integer.parseInt(contentString)>=0){
							contentString = contentString.replace(".", "");
							fieldLength = Integer.parseInt(property.split(":")[2]);
							while (contentString.length() < fieldLength) {
								contentString = "0" + contentString;
							}
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						try {
							if(Float.parseFloat(contentString)>=0){
								contentString = contentString.replace(".", "");
								fieldLength = Integer.parseInt(property.split(":")[2]);
								while (contentString.length() < fieldLength) {
									contentString = "0" + contentString;
								}
							}
						} catch (NumberFormatException e1) {
							
						}
					}
					if(!"ACCOUNT.CURRENCY".equals(string)){
						contentString += "+";
					}
					retMsgString = retMsgString+contentString;
				}
				else{
					String mapSpace = "";
					String string2 = property.split(":")[2];
					int fieldLen = Integer.parseInt(string2);
					for(int k=0;k<fieldLen;k++){
						mapSpace = mapSpace+" ";
					}
					retMsgString = retMsgString+mapSpace+"+";
				}
			}
		}
		
		if(size<Integer.parseInt(valueSpe[1])){
			for(int l=0;l<20-size;l++){
//			System.out.println(l);
				String mapSpace = "";
				String string2 = properties.getProperty(String.valueOf(i)).split(":")[2];
				int fieldLen = Integer.parseInt(string2);
				for(int k=0;k<fieldLen;k++){
					mapSpace = mapSpace+" ";
				}
				retMsgString = retMsgString+mapSpace;	
			}
			
		}
		return retMsgString;
	}

}
