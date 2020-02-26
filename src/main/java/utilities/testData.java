package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import utilities.configSettings.Browser;

public class testData {

	public static class JobListingPage {
		public static final String Title = "Explore Open Sales Positions & Career Opportunities | Paylocity";
		
		// we can set the URL here... or we can pull it from a property file :)
		public static final String UrlPropertyNameInDataFileJobListingPageUrl = "JobListingPageUrl";
		public static final String UrlPropertyNameInDataFileJobAppPage = "JobAppPage";
		
	}

	public static class JobAppPage1Text {

		public static final String FirstName = "Clynton";
		public static final String LastName = "Caines";
		public static final String Email = "clyntoncaines@gmail.com";
		public static final String CellPhone = "757-751-1121";
		public static final String LinkedInUrl ="https://www.linkedin.com/in/clyntoncaines";

		// Note: This file upload stuff was working initially, now giving a server error
		public static final String PathToResumePdfOrDoc ="C:\\MyLocalProjects\\PaylocityJobSubmitr\\config\\ClyntonCaines.pdf";
		public static final String PathToCoverLetterPdfOrDoc ="C:\\MyLocalProjects\\PaylocityJobSubmitr\\config\\ClyntonCoverLetter.pdf";
				
		// Note: dates are MM/YYYY - tab added to make sure it is accepted...

		public static final String WorkHistoryCompany0 = "Forefront";
		public static final String WorkHistoryPosition0 = "Lead Engineer";
		public static final String WorkHistoryResponsibilities0 = "Developing front end software (using IBM and Google AI tools), and backend software using NodeJS cloud functions and Firebase Document DB.";
		
		// TODO: Work history dates have problems - typing too fast, skipping values - hack by tabbing away and back to reset...
		// it didn't like this current month... interesting
		public static final String WorkHistoryStartDate0 = "01/2020"; 
		
		public static final String WorkHistoryEndDate0 = "" + Keys.TAB; // no end date for current position
		public static final String WorkHistoryEndReason0 = "" + Keys.TAB; // no reason for now

		public static final String[] WorkHistoryCompanyAfter0 = {"Thinkful.com", "Babson College", "JoeLotto", "David Group", "Discover Technologies", "MyBarber", "MicroLink"};
		public static final String[] WorkHistoryPositionAfter0 = {"Mentor", "Advisor", "Developer", "Contractor", "Developer", "Developer", "Developer"};
		public static final String[] WorkHistoryResponsibilitiesAfter0 = {
				"Advised bootcamp students in the areas of troubleshooting and software development.",
				"Advised startup companies in the areas of tech and customer development.",
				"Developed front end software and operation tools for the startup.", 
				"Developed SharePoint tools for enterprise customers.", 
				"Developed front end and backend software for enterprise customers. Technologies included SharePoint, Active Directory and SQL Server.",
				"Developed front end, mobile and backend software for the startup. The mobile App was deployed to iTunes and Google Play",
				"Developed front end, middleware and backend software for enterprise customers. Developed and maintained SQL Server DBs with indexing, clustering and failover."};
		public static final String[] WorkHistoryStartDateAfter0 = {"10/2019", "05/2019", "07/2016", "08/2017", "08/2013", "10/2015", "11/2006"};
		public static final String[] WorkHistoryEndDateAfter0 = {"12/2019", "07/2019", "12/2018", "05/2018", "06/2017", "05/2017", "08/2013"}; 
		public static final String[] WorkHistoryEndReasonAfter0 = {"Entry level wage", "Summer only", "Startup closed", "Contract ended", "Downsized", "Startup closed", "Team moved to Discover"};
		
		public static final String EducationSchoolName = "UMass-Lowell";
		public static final String EducationAreaOfStudy = "Electrical Engineering";
		public static final String EducationGradDate = "05/1998" + Keys.TAB;
		// also see 'id4SelectEducationTypeUniversityWithIdx' - selected type: University, graduated:Yes, degree: BS
		
	}

	public static class JobAppPage2Text {
		public static final int RadioYesValue = 0;
		public static final int RadioNoValue = 1;
		public static final String SalaryRange = "50K-150K";
		
	}

//	private static Object[][] _browsersToTest = new Object[][] { new Object[] {
//	Browser.Chrome }, new Object[] { Browser.FireFox } };

	private static Object[][] _browsersToTest = new Object[][] { new Object[] { Browser.Chrome } };

	public static Object[][] browsersToTest() {
		return _browsersToTest;
	}

	/*
	 * if want to add a data provider to the test class, can implement using this...
	 * TestNG will auto call multiple tests using the provided data - can add other
	 * params like so:
	 *
	 * new Object[][] {new Object[ {Browser.Chrome, "p2", 3}, {Browser.FireFox...}
	 * 
	 * then change the test method like so:
	 * 
	 * testr(Browser b, String p2, int p3){}
	 * 
	 * ex: XPath not working on IE - even after thread.sleep, so don't ask for it
	 * 
	 * private static Object[][] _browsersToTest = new Object[][] { new Object[] {
	 * Browser.Chrome }, new Object[] { Browser.FireFox } };
	 */

}
