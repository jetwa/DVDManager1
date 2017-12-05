package com.bean;

public class DVD {
	private int dvdId;
	private String dvdName;
	private String dvdDate;
	private int lendCount;
	private int dvdStatus;

	public DVD() {
	}

	public DVD(int dvdId, String dvdName, String dvdDate, int lendCount, int dvdStatus) {
		this.dvdId = dvdId;
		this.dvdName = dvdName;
		this.dvdDate = dvdDate;
		this.lendCount = lendCount;
		this.dvdStatus = dvdStatus;
	}

	public int getDvdId() {
		return dvdId;
	}

	public void setDvdId(int dvdId) {
		this.dvdId = dvdId;
	}

	public String getDvdName() {
		return dvdName;
	}

	public void setDvdName(String dvdName) {
		this.dvdName = dvdName;
	}

	public String getDvdDate() {
		return dvdDate;
	}

	public void setDvdDate(String dvdDate) {
		this.dvdDate = dvdDate;
	}

	public int getLendCount() {
		return lendCount;
	}

	public void setLendCount(int lendCount) {
		this.lendCount = lendCount;
	}

	public int getDvdStatus() {
		return dvdStatus;
	}

	public void setDvdStatus(int dvdStatus) {
		this.dvdStatus = dvdStatus;
	}

	@Override
	public String toString() {
		return "DVD [dvdId=" + dvdId + ", dvdName=" + dvdName + ", dvdDate=" + dvdDate + ", lendCount=" + lendCount
				+ ", dvdStatus=" + dvdStatus + "]";
	}

}
