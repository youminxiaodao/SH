package com.wlb.T24.in.sh.factory;

public class HoldFundReleaseFactory {

	public HoldFundRelease getType(String type){
		if (type == null){
			return null;
		}
		if("FSHHSHFSH              DAHF".equalsIgnoreCase(type)){
			return new HoldFundReleaseReq();
			
		}
		else if("FSHHSHFSH              DARF".equalsIgnoreCase(type)){
			return new HoldFundReleaseReq();
		}
		else if("Suc".equalsIgnoreCase(type)){
			return new HoldFundReleaseSucRes();
		}
		else if("Err".equalsIgnoreCase(type)){
			return new HoldFundReleaseErrRes();
		}
		else if("ACLK".equalsIgnoreCase(type)){
			return new HoldFundReleaseSucRes();
		}
		return null;
	}
}
