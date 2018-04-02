package com.wlb.T24.in.sh.factory;

import java.util.HashMap;

public interface HoldFundRelease {
	public String retrRMsg(String inMsg);
	public String retMsg(String inMsg,String filePath);
	public HashMap<String, MapEntity> retMapMsg(String msg);
}
