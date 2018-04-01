package com.wlb.T24.in.sh.factory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class HoldFundReleaseReq implements HoldFundRelease {
	@Override
	public String retMsg(String inMsg) {
		String retMsg = "";
		String holdReasonString = "";
		String tellId = inMsg.substring(159, 167);
		String termId = inMsg.substring(167, 171);
		String reference = inMsg.substring(171, 173);
		String accNo = inMsg.substring(173, 184);
		String remark = inMsg.substring(231, 281);
		String ccy = inMsg.substring(299, 302);
		String holdAmt = inMsg.substring(302, 317);
		String holdAmtSign = inMsg.substring(317, 318);
		String holdFundReleaseDate = inMsg.substring(318, 328);
		String holdReasonCode = inMsg.substring(328, 331);
		int randInt = (int) (Math.random() * 9000 + 1000);
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyMMddhhmmsss");
		String dateTime = simpleDateFormat.format(date);
		String OriMsg = "AC.LOCKED.EVENTS,ACC.HLD.FUND/I/PROCESS/0/,//HK0010108,/I"
				+ dateTime
				+ randInt
				+ ",EXT.ITF.CODE:1:1=ITF002.0021.A,EXT.SYSTEM.NAME:1:1=SH,EXT.CHANNEL.ID:1:1=KB,";
		switch (Integer.parseInt(holdReasonCode)) {
		case 1:
			holdReasonString = "HOLD BY BILLS DEPT";
			break;
		case 2:
			holdReasonString = "HOLD BY DEPOSIT DEPT";
			break;
		case 3:
			holdReasonString = "HOLD BY I/P DEPT";
			break;
		case 5:
			holdReasonString = "HOLD BY LOANS DEPT";
			break;
		case 6:
			holdReasonString = "HOLD BY SAFE DEPOSIT BOX DEPT";
			break;
		case 7:
			holdReasonString = "HOLD BY TRUST DEPT";
			break;
		case 8:
			holdReasonString = "HOLD BY WING LUNG SECURITIES";
			break;
		case 9:
			holdReasonString = "HOLD BY TREASURY DEPT";
			break;
		case 10:
			holdReasonString = "HOLD BY SYNDICATED LOANS DEPT";
			break;
		case 32:
			holdReasonString = "HOLD BY CREDIT MANAGEMENT";
			break;
		case 34:
			holdReasonString = "HOLD BY CREDIT CARD CENTRE";
			break;
		case 41:
			holdReasonString = "UT IPO";
			break;
		case 80:
			holdReasonString = "HOLD BY WING LUNG SECURITY LTD";
			break;
		case 141:
			holdReasonString = "HOLD BY WEALTH MANAGEMENT";
			break;
		case 998:
			holdReasonString = "HOLD BY FORWARD VALUE F/D";
			break;
		}

		retMsg = OriMsg + "EXT.TELLER.ID:1:1=" + tellId + ",EXT.TERM.ID:1:1="
				+ termId + ",EXT.REFERENCE:1:1=" + dateTime
				+ ",EXT.TXN.TIME:1:1=" + dateTime + ",T.ACC.NO:1:1=" + accNo
				+ ",T.CURRENCY:1:1=" + ccy + ",T.HLD.FND.CODE:1:1="
				+ holdReasonCode + ",T.HLD.REASON:1:1=" + holdReasonString
				+ ",LOCKED.AMOUNT:1:1=" + holdAmt + ",ACC.T.HOLD.AMT:1:1="
				+ holdAmt + ",T.TYPE:1:1=1" + ",";
		return retMsg;
	}

	@Override
	public HashMap<String, MapEntity> retMapMsg(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
