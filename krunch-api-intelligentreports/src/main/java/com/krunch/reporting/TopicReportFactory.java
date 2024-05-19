package com.krunch.reporting;

import com.krunch.reporting.excel.ExcelHelper;

public class TopicReportFactory {

	public enum REPORT {
		
		REPORT_PPT(0), REPORT_EXCEL(1), REPORT_JSON(2), REPORT_PDF(3), REPORT_WORD(4), REPORT_CSV(5);

		private final int value;

		REPORT(final int newValue) {
			value = newValue;
		}

		public int getValue() {
			return value;
		}
	}

	public IntelligentReports generateTopicReport(int reportType) {

		if (REPORT.REPORT_EXCEL.getValue() == reportType) {

			return new ExcelHelper();
		}
		

		return null;
	}
}
