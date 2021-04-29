package com.fisco.apiProject.dto;

public class Covid19ItemDTO {
	private String createDt;// 생성날짜
	private int deathCnt;	// 누적 사망자 수
	private int incdeathCnt; // 전일대비 사망자 증감 수
	private int defCnt;		// **확진자 수
	private String gubun; 	// 지역 구분(한글)
	private	String gubunCn;	// 지역 구분(중국어)
	private String gubunEn;	// 지역 구분(영어)
	private int incDec;		// 전일대비 증감 수
	private int isolClearCnt; // 격리 해제 수
	private int incisoClearCnt; // 전일대비 격리 해제 증감 수
	private int isolIngCnt;	// **격리중 환자수
	private int incisoIngCnt; // 전일대비 격리 증감 수
	private int localOccCnt;// **지역발생 수
	private int overFlowCnt;// **해외유입 수
	private double qurRate; // 10만명당 발생률
	private int seq; 		// 게시글번호(국내 시도별 발생현황 고유값)
	private String stdDay;  // 기준일시
	private String updateDt;// 수정일시분초
	
	public Covid19ItemDTO(String createDt, int deathCnt, int defCnt, String gubun, String gubunCn, String gubunEn,
			int incDec, int isolClearCnt, int isolIngCnt, int localOccCnt, int overFlowCnt, double qurRate, int seq,
			String stdDay, String updateDt) {
		super();
		this.createDt = createDt;
		this.deathCnt = deathCnt;
		this.defCnt = defCnt;
		this.gubun = gubun;
		this.gubunCn = gubunCn;
		this.gubunEn = gubunEn;
		this.incDec = incDec;
		this.isolClearCnt = isolClearCnt;
		this.isolIngCnt = isolIngCnt;
		this.localOccCnt = localOccCnt;
		this.overFlowCnt = overFlowCnt;
		this.qurRate = qurRate;
		this.seq = seq;
		this.stdDay = stdDay;
		this.updateDt = updateDt;
	}

	public Covid19ItemDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIncdeathCnt() {
		return incdeathCnt;
	}

	public void setIncdeathCnt(int incdeathCnt) {
		this.incdeathCnt = incdeathCnt;
	}

	public int getIncisoClearCnt() {
		return incisoClearCnt;
	}

	public void setIncisoClearCnt(int incisoClearCnt) {
		this.incisoClearCnt = incisoClearCnt;
	}

	public int getIncisoIngCnt() {
		return incisoIngCnt;
	}

	public void setIncisoIngCnt(int incisoIngCnt) {
		this.incisoIngCnt = incisoIngCnt;
	}

	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public int getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
	}
	public int getDefCnt() {
		return defCnt;
	}
	public void setDefCnt(int defCnt) {
		this.defCnt = defCnt;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getGubunCn() {
		return gubunCn;
	}
	public void setGubunCn(String gubunCn) {
		this.gubunCn = gubunCn;
	}
	public String getGubunEn() {
		return gubunEn;
	}
	public void setGubunEn(String gubunEn) {
		this.gubunEn = gubunEn;
	}
	public int getIncDec() {
		return incDec;
	}
	public void setIncDec(int incDec) {
		this.incDec = incDec;
	}
	public int getIsolClearCnt() {
		return isolClearCnt;
	}
	public void setIsolClearCnt(int isolClearCnt) {
		this.isolClearCnt = isolClearCnt;
	}
	public int getIsolIngCnt() {
		return isolIngCnt;
	}
	public void setIsolIngCnt(int isolIngCnt) {
		this.isolIngCnt = isolIngCnt;
	}
	public int getLocalOccCnt() {
		return localOccCnt;
	}
	public void setLocalOccCnt(int localOccCnt) {
		this.localOccCnt = localOccCnt;
	}
	public int getOverFlowCnt() {
		return overFlowCnt;
	}
	public void setOverFlowCnt(int overFlowCnt) {
		this.overFlowCnt = overFlowCnt;
	}
	public double getQurRate() {
		return qurRate;
	}
	public void setQurRate(double qurRate) {
		this.qurRate = qurRate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getStdDay() {
		return stdDay;
	}
	public void setStdDay(String stdDay) {
		this.stdDay = stdDay;
	}
	public String getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}
	
	
	
}
