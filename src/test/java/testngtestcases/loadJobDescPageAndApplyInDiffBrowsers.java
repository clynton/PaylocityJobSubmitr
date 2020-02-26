package testngtestcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import utilities.browserProvider;
import utilities.buttonClicker;
import utilities.configSettings;
import utilities.configSettings.Browser;
import utilities.configSettings.OtherUsefulFiles;
import utilities.logCollector;
import utilities.pageElementLocators;
import utilities.pageElementSelectors;
import utilities.testData;
import utilities.testDataFromPropertyFile;

public class loadJobDescPageAndApplyInDiffBrowsers {

	@Test(dataProvider = "testWhichBrowsers")
	public void gotoHomePages(Browser browser) {

		logCollector.debug("Getting Browser: " + browser);

		WebDriver driver = browserProvider.getBrowser(browser);

		if (driver == null) {

			System.out.println("Note: '" + browser + "' Driver not set. Can, but won't assert right now");
			return;
		}

		// go straight to the job page for now - save a click
		// String linkPropertyVal =
		// testData.JobListingPage.UrlPropertyNameInDataFileJobListingPageUrl;
		String linkPropertyVal = testData.JobListingPage.UrlPropertyNameInDataFileJobAppPage;

		String mainPageUrl = testDataFromPropertyFile.getPropertyVal(linkPropertyVal);
		if (mainPageUrl == null || mainPageUrl == "") {
			Assert.fail("Property '" + linkPropertyVal + "' apparently missing from Property File: '" + OtherUsefulFiles.TestDataPropertyFile + "'");
		}

		logCollector.debug("Loading page '" + mainPageUrl + "' - in driver: " + Keys.TAB + driver.toString());

		// for some reason, get(page) is saying times out in ie - even though it works
		try {
			if (browser == Browser.IE) {

				int pageLoadTimeoutForIE_s = configSettings.SeleniumBrowserDelayTimes.PageLoadTimeoutForIE_s;
				if (pageLoadTimeoutForIE_s > 0) {
					System.out.println("setting page load timer for IE browser to " + pageLoadTimeoutForIE_s + " seconds...");
					driver.manage().timeouts().pageLoadTimeout(pageLoadTimeoutForIE_s, TimeUnit.SECONDS);
				}

				int delayBeforeLoadingUrlInIE_s = configSettings.SeleniumBrowserDelayTimes.DelayBeforeLoadingUrlInIE_s;
				if (delayBeforeLoadingUrlInIE_s > 0) {
					System.out.println("about to load page in IE browser... waiting " + delayBeforeLoadingUrlInIE_s + " seconds...");

					try {
						// System.out.println("sleeping in");
						Thread.sleep(delayBeforeLoadingUrlInIE_s * 1000);
					} catch (InterruptedException e) {
						// e.printStackTrace();
						System.out.println(e.getMessage());
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}

			driver.get(mainPageUrl);

		} catch (Exception ex) {
			//
			System.out.println(ex);

//			org.openqa.selenium.TimeoutException: Timed out waiting for page to load.
//			Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:25:48'
//			System info: host: '...', ip: '...', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '13.0.1'
//			Driver info: org.openqa.selenium.ie.InternetExplorerDriver
//			Capabilities {acceptInsecureCerts: false, browserName: internet explorer, browserVersion: 11, javascriptEnabled: true, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), se:ieOptions: {browserAttachTimeout: 0, elementScrollBehavior: 0, enablePersistentHover: true, ie.browserCommandLineSwitches: , ie.edgechromium: false, ie.edgepath: , ie.ensureCleanSession: false, ie.fileUploadDialogTimeout: 3000, ie.forceCreateProcessApi: false, ignoreProtectedModeSettings: false, ignoreZoomSetting: false, initialBrowserUrl: http://localhost:40789/, nativeEvents: true, requireWindowFocus: false}, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}

			// continue anyway
		}

		// in some browsers, might need Thread.sleep after loading the URL before
		// By.xpath and By.cssSelector work
		int delayAfterLoadingUrl_s = configSettings.SeleniumBrowserDelayTimes.DelayAfterLoadingUrl_s;
		if (delayAfterLoadingUrl_s > 0) {
			System.out.println("just loaded page... waiting " + delayAfterLoadingUrl_s + " seconds...");

			try {
				// System.out.println("sleeping in");
				Thread.sleep(delayAfterLoadingUrl_s * 1000);
			} catch (InterruptedException e) {
				// e.printStackTrace();
				System.out.println(e.getMessage());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		/*
		 * skip page validation from main and click to job page... we are now going straight to it...
		 * 
		 * // check that we got to the page... String expectedTitle = testData.JobListingPage.Title; String actualTitle = driver.getTitle();
		 * 
		 * logCollector.debug("Loaded page - got title: '" + actualTitle + "'");
		 * 
		 * AssertJUnit.assertEquals(actualTitle, expectedTitle);
		 * 
		 * // Click a link button - found using xpath or css or whatever // returns exception message if not there, but we can check for something else String clickResult = buttonClicker.Click(driver, pageElementLocators.JobListingPage.ApplyLinkBtn, configSettings.SeleniumBrowserDelayTimes.DelayAfterClickButton_ms); AssertJUnit.assertEquals(clickResult, "");
		 */

		submitJobApplication(driver);
	}

	@DataProvider
	public Object[][] testWhichBrowsers() {
		return testData.browsersToTest();
	}

	@BeforeTest
	public void getBrowsers() {
		// BeforeMethod called before each Test method
		// BeforeTest called once only (before all Test methods)

		// loop over testData.browsersToTest()
		// - so not launching browsers we don't need
		logCollector.debug("getBrowsers... ");

		Object[][] browsers = testData.browsersToTest();
		for (int i = 0; i < browsers.length && i < 2000; i++) // no infiniloops
		{
			browserProvider.getBrowser((Browser) browsers[i][0]);
		}

	}

	@AfterTest
	public void closeBrowsers() {

		logCollector.debug("closeBrowsers... ");

//		browserProvider.closeBrowsers();
	}

	private void submitJobApplication(WebDriver driver) {
		fillOutPage1AndMoveToNext(driver);		
	}

	private void fillOutPage1AndMoveToNext(WebDriver driver) {
		// TO-DO: error handling

		// driver.switchTo().frame("frameName"); // in case it's within an iframe...
		WebElement el;

		/*
		 * // See what elements we get... List<WebElement> elems = driver.findElements(pageElementLocators.JobAppPage1.FillAppUsingResumeChkBx); // List<WebElement> elems = driver.findElements(pageElementLocators.JobAppPage1.FirstName); // List<WebElement> elems = driver.findElements(By.cssSelector("*")); int numElems = elems.size(); System.out.println("Got " + numElems + " Elements..."); if (numElems > 500) { numElems = 500; } for (int ix = 0; ix < numElems; ix++) { WebElement elem = elems.get(ix); System.out.println("Got Element: " + ix + " - " + elem.getTagName() + " - " + elem.getText()); }
		 */

		// uncheck "Fill out application with my resume" checkbox - two options
		// A. click to deselect
		// clickResult = buttonClicker.Click(driver,
		// pageElementLocators.JobAppPage1.FillAppUsingResumeChkBx);
		// B. it has attribute "checked=''" when checked - remove it to be sure - using
		// javascript
		// WebElement checkbox =
		// driver.findElement(pageElementLocators.JobAppPage1.FillAppUsingResumeChkBx);
		// String checkedAttrib = checkbox.getAttribute("checked"); // there is no
		// setAttrib or removeAttrib
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.getElementById('" + pageElementSelectors.JobAppPage1.id4FillAppUsingResumeChkBx + "').checked = false");
		// js.executeScript("document.getElementById('" +
		// pageElementSelectors.JobAppPage1.id4FillAppUsingResumeChkBx +
		// "').setAttribute('attr', '10')"); // if had to set an attribute...

		// there may be some js stuff needed - do it using the keyboard...
		 driver.findElement(pageElementLocators.JobAppPage1.FillAppUsingResumeChkBx).sendKeys("" + Keys.SPACE);
				
		//========================================================================================================================
		// resume and cover letter upload
	
		// add resume file... simply set the file path... start at the next input and tab backwards if it's within a section that needs expanding first
		// make it visible first else we'll get an error
	    el = driver.findElement(pageElementLocators.JobAppPage1.ResumePdfOrDocUploadField);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", el);
	    //el.clear(); // empty it first
		driver.findElement(pageElementLocators.JobAppPage1.ResumePdfOrDocUploadField).sendKeys(testData.JobAppPage1Text.PathToResumePdfOrDoc);

		// note... path can't have a tab in it to tab away after setting...
		
		// Sweet!!! Their file acceptor was having some problems - showing an error in the UI... TO-DO: Look for it and assert :)
		// - look at that... already providing them value and didn't even apply yet :D
		
		// add cover letter file...
		// make it visible first else we'll get an error
	    el = driver.findElement(pageElementLocators.JobAppPage1.CoverLetterPdfOrDocUploadField);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", el);
	    //el.clear(); // empty it first
		driver.findElement(pageElementLocators.JobAppPage1.CoverLetterPdfOrDocUploadField).sendKeys(testData.JobAppPage1Text.PathToCoverLetterPdfOrDoc);
		
		// end resume and cover letter upload
		//========================================================================================================================


		// give it some time to setup - it still fills the resume fields...
		utilities.helpers.pauseThread(configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms * 3);

		////------------------------------------------------------------
		////------------------------------------------------------------
		//// we said don't pull out the work history from the resume but it still did... so delete all current work history entries...
		//// needed to use the keyboard way to say don't do it :D so no need to delete bad entries anymore ... 
		//// TO-DO: the final version of this is not fully tested - it may have still left stuff in some fields or left 1 work history field-set
		//int numWorkHistoriesToDelete = 10; // the click will try and not break if there are more
		//String clickRes;
		//for (int i = 0; i < numWorkHistoriesToDelete; i++) {
		//	System.out.println("Trying to delete work history: " + pageElementLocators.JobAppPage1.RestOfJumpBtnsB4WorkHistoryBtn(i));
		//	
		//	clickRes = buttonClicker.Click(driver, pageElementLocators.JobAppPage1.RestOfJumpBtnsB4WorkHistoryBtn(i), configSettings.SeleniumBrowserDelayTimes.DelayAfterClickButton_ms);
		//	if (clickRes != "") {break;} // done
		//}
		//
		//// clear other fields we already have data for
		//driver.findElement(pageElementLocators.JobAppPage1.FirstName).clear();
		//driver.findElement(pageElementLocators.JobAppPage1.LinkedInUrl).clear();
		//
		//driver.findElement(pageElementLocators.JobAppPage1.LastName).clear();
		//driver.findElement(pageElementLocators.JobAppPage1.Email).clear();
		//driver.findElement(pageElementLocators.JobAppPage1.CellPhone).clear();
		////------------------------------------------------------------
		////------------------------------------------------------------
		
		// text values
		driver.findElement(pageElementLocators.JobAppPage1.FirstName).sendKeys(testData.JobAppPage1Text.FirstName);
		driver.findElement(pageElementLocators.JobAppPage1.LinkedInUrl).sendKeys(testData.JobAppPage1Text.LinkedInUrl);

		driver.findElement(pageElementLocators.JobAppPage1.LastName).sendKeys(testData.JobAppPage1Text.LastName);
		driver.findElement(pageElementLocators.JobAppPage1.Email).sendKeys(testData.JobAppPage1Text.Email);
		driver.findElement(pageElementLocators.JobAppPage1.CellPhone).sendKeys(testData.JobAppPage1Text.CellPhone);

		// TO-DO: since the start at previous item the hit tab + enter is the same for work history 0 and 1 (just different previous elements)
		// can actually consolidate the following into a single loop and get right of  fields ending with "0"

	
		// head to the first work history entry
		driver.findElement(pageElementLocators.JobAppPage1.FirstJumpBtnB4WorkHistoryBtn).sendKeys(utilities.helpers.comboKeys.TabThenEnterKeys);

		// give it some time to setup...
		utilities.helpers.pauseThread(configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);

		// ---------------------------------------------------------------------------------------------------------------------------
		// NOTE: Work history dates had problems - typing too fast, skipping values -
		// it especially didn't like this current month... when selenium is the one that set it...
		// hacked by tabbing away and back again to reset to the same value :)
		// ---------------------------------------------------------------------------------------------------------------------------

		// work history
		driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryCompanyWithIdx(0)).sendKeys(testData.JobAppPage1Text.WorkHistoryCompany0);
		driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryPositionWithIdx(0)).sendKeys(testData.JobAppPage1Text.WorkHistoryPosition0);
		driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryResponsibilitiesTextAreaWithIdx(0)).sendKeys(testData.JobAppPage1Text.WorkHistoryResponsibilities0);
		driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryStartDateWithIdx(0)).sendKeys(utilities.helpers.getStringToDoubleSetValuesIntoField(testData.JobAppPage1Text.WorkHistoryStartDate0));
		driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryEndDateWithIdx(0)).sendKeys(utilities.helpers.getStringToDoubleSetValuesIntoField(testData.JobAppPage1Text.WorkHistoryEndDate0));
		driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryEndReasonWithIdx(0)).sendKeys(testData.JobAppPage1Text.WorkHistoryEndReason0);

		// give that last send message time to process, else this check attempt will fail :(
		utilities.helpers.pauseThread(configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);

		// ---------------------------------------------------------------------------------------------------------------------------
		// Investigated why not able to find the currently working checkbox - yet it's there if run on the console
		// with the longer pause, I saw it get set, but it still didn't keep... I guess some js had to run to disable other fields and set a bool...
		// Sweet - using Tab + spacebar worked... could also try clicking it...
		//driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryEndReasonWithIdx(0)).sendKeys("" + Keys.TAB);
		driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryEndReasonWithIdx(0)).sendKeys("" + Keys.TAB + Keys.SPACE);
		utilities.helpers.pauseThread(configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		//utilities.helpers.pauseThread(configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms * 5);
		
		// - also, this way of checking a box works elsewhere in here... so...
		//System.out.println("Trying to check: " + pageElementLocators.JobAppPage1.WorkHistoryCurrentJobChkWithIdx(0));
		//utilities.helpers.pauseThread(2000);
		//((JavascriptExecutor) driver).executeScript("document.getElementById('" + pageElementLocators.JobAppPage1.WorkHistoryCurrentJobChkWithIdx(0) + "').checked = true");
		//el = driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryCurrentJobChkWithIdx(0));
		//((JavascriptExecutor) driver).executeScript("console.log('element: ', arguments)", el);
		//((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", el);
		//System.out.println("Tried to write to console...");
		// ---------------------------------------------------------------------------------------------------------------------------

		// other work history entries
		for (int i = 0; i < testData.JobAppPage1Text.WorkHistoryCompanyAfter0.length; i++) {
			// head to the 2nd+ work history entry - these field names start at 0
			driver.findElement(pageElementLocators.JobAppPage1.RestOfJumpBtnsB4WorkHistoryBtn(i)).sendKeys(utilities.helpers.comboKeys.TabThenEnterKeys);

			// give it some time to setup...
			utilities.helpers.pauseThread(configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);

			// work history - these fields start at 1 - not 0
			driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryCompanyWithIdx(i + 1)).sendKeys(testData.JobAppPage1Text.WorkHistoryCompanyAfter0[i]);
			driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryPositionWithIdx(i + 1)).sendKeys(testData.JobAppPage1Text.WorkHistoryPositionAfter0[i]);

			driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryStartDateWithIdx(i + 1)).sendKeys(utilities.helpers.getStringToDoubleSetValuesIntoField(testData.JobAppPage1Text.WorkHistoryStartDateAfter0[i]));

			// date fields had issues - the driver was writing too fast in the browser
			// utilities.helpers.pauseThread(configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);

			driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryEndDateWithIdx(i + 1)).sendKeys(utilities.helpers.getStringToDoubleSetValuesIntoField(testData.JobAppPage1Text.WorkHistoryEndDateAfter0[i]));

			// date fields had issues - the driver was writing too fast in the browser
			// utilities.helpers.pauseThread(configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);

			driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryEndReasonWithIdx(i + 1)).sendKeys(testData.JobAppPage1Text.WorkHistoryEndReasonAfter0[i]);

			// special case for the text area - go to the previous item and then tab to it
			driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryPositionWithIdx(i + 1)).sendKeys(Keys.TAB);
			driver.findElement(pageElementLocators.JobAppPage1.WorkHistoryResponsibilitiesTextAreaWithIdx(i + 1)).sendKeys(testData.JobAppPage1Text.WorkHistoryResponsibilitiesAfter0[i]);
		}

		// head to the education entry
		driver.findElement(pageElementLocators.JobAppPage1.JumpBtnB4EducationBtn).sendKeys(utilities.helpers.comboKeys.TabThenEnterKeys);
		// give it some time to setup...
		utilities.helpers.pauseThread(configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);

		driver.findElement(pageElementLocators.JobAppPage1.EducationSchoolNameWithIdx(0)).sendKeys(testData.JobAppPage1Text.EducationSchoolName);
		driver.findElement(pageElementLocators.JobAppPage1.EducationAreaOfStudyWithIdx(0)).sendKeys(testData.JobAppPage1Text.EducationAreaOfStudy);

		// select the education type and graduation
		buttonClicker.Click(driver, pageElementLocators.JobAppPage1.OpenEducationTypeWithIdx(0), configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		buttonClicker.Click(driver, pageElementLocators.JobAppPage1.SelectEducationTypeUniversityWithIdx(0));

		buttonClicker.Click(driver, pageElementLocators.JobAppPage1.OpenEducationGraduateDropdownWithIdx(0), configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		buttonClicker.Click(driver, pageElementLocators.JobAppPage1.SelectEducationGraduateYesWithIdx(0));

		buttonClicker.Click(driver, pageElementLocators.JobAppPage1.OpenEducationDegreeDropdownWithIdx(0), configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		buttonClicker.Click(driver, pageElementLocators.JobAppPage1.SelectEducationDegreeBSWithIdx(0));

		driver.findElement(pageElementLocators.JobAppPage1.EducationGradDateWithIdx(0)).sendKeys(utilities.helpers.getStringToDoubleSetValuesIntoField(testData.JobAppPage1Text.EducationGradDate));

		// go to step 2
		// String clickResult =
		buttonClicker.Click(driver, pageElementLocators.JobAppPage1.NextStepBtn, configSettings.SeleniumBrowserDelayTimes.DelayAfterClickButton_ms);

		fillOutPage2AndMoveToNext(driver);
	}

	private void fillOutPage2AndMoveToNext(WebDriver driver) {
		// TO-DO: error handling/ validation

		// -----------------------------------------------------
		// step 2 - answer radio
		// a: findElement(By.id("multiQuestionAnswer1025_0/1")).click()
		// b: findElements(By.name("multiQuestionAnswer1025")).get(0/1).click()

		// answer questions
		// enhancements: search by text, then find the corresponding radio
		// - ex: find span element with text "Are you currently eligible to work for
		// Paylocity in the United States?"

		buttonClicker.Click(driver, pageElementLocators.JobAppPage2.PrevousInterviewRadioWithIdx(testData.JobAppPage2Text.RadioNoValue), configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		buttonClicker.Click(driver, pageElementLocators.JobAppPage2.USWorkEligibleRadioWithIdx(testData.JobAppPage2Text.RadioYesValue), configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		buttonClicker.Click(driver, pageElementLocators.JobAppPage2.NeedSponsorshipRadioWithIdx(testData.JobAppPage2Text.RadioNoValue), configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		buttonClicker.Click(driver, pageElementLocators.JobAppPage2.NonCompeteRadioWithIdx(testData.JobAppPage2Text.RadioNoValue), configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);

		// special case for the text area - go to the previous item and then tab to it
		driver.findElement(pageElementLocators.JobAppPage2.NonCompeteRadioWithIdx(testData.JobAppPage2Text.RadioNoValue)).sendKeys(Keys.TAB);
		driver.findElement(pageElementLocators.JobAppPage2.SalaryRequirementTextArea).sendKeys(testData.JobAppPage2Text.SalaryRange);

		buttonClicker.Click(driver, pageElementLocators.JobAppPage2.FoundOneIndeedCheckBx, configSettings.SeleniumBrowserDelayTimes.DelayAfterClickButton_ms);

		// go to step 3
		//String clickResult = 
		buttonClicker.Click(driver, pageElementLocators.JobAppPage2.NextStepBtn, configSettings.SeleniumBrowserDelayTimes.DelayAfterClickButton_ms);

		 fillOutPage3AndMoveToNext(driver);
	}

	private void fillOutPage3AndMoveToNext(WebDriver driver) {
		// click to make the dropdown available, then click to select an item from the
		// dropdown

		buttonClicker.Click(driver, pageElementLocators.JobAppPage3.OpenGenderDropdown, configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		buttonClicker.Click(driver, pageElementLocators.JobAppPage3.SelectMaleGender);

		buttonClicker.Click(driver, pageElementLocators.JobAppPage3.OpenEthnicGroupDropdown, configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		buttonClicker.Click(driver, pageElementLocators.JobAppPage3.SelectEthnicGroupBlack);

		buttonClicker.Click(driver, pageElementLocators.JobAppPage3.OpenMilitaryDropdown, configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		buttonClicker.Click(driver, pageElementLocators.JobAppPage3.SelectMilitaryNotAVet);

		buttonClicker.Click(driver, pageElementLocators.JobAppPage3.OpenDisabilityDropdown, configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		buttonClicker.Click(driver, pageElementLocators.JobAppPage3.SelectDisabilityNotDisabled);

		// other useful stuff... the dropdowns on this job page had different HTML
		// profiles - ex: ul+span instead of select
		// new Select(driver.findElement(By...).selectByIndex/etc());

		// go to step 4
		// String clickResult =
		buttonClicker.Click(driver, pageElementLocators.JobAppPage3.NextStepBtn, configSettings.SeleniumBrowserDelayTimes.DelayAfterClickButton_ms);

		fillOutPage4AndSubmit(driver);
	}

	private void fillOutPage4AndSubmit(WebDriver driver) {

		// "I accept..." checkbox - use this option to ensure we are enabling it
		//((JavascriptExecutor) driver).executeScript("document.getElementById('" + pageElementSelectors.JobAppPage4.id4AcceptSubmission + "').checked = true");
		//WebElement el = driver.findElement(pageElementLocators.JobAppPage4.AcceptSubmission);
		//((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", el);
		// that didn't work... so tab back to it and use the keyboard :D

		driver.findElement(pageElementLocators.JobAppPage4.AcceptSubmission).sendKeys("" + Keys.SPACE);
		// or driver.findElement(pageElementLocators.JobAppPage4.NextStepBtn).sendKeys(utilities.helpers.comboKeys.ShiftTabKeys + Keys.SPACE);
		utilities.helpers.pauseThread(configSettings.SeleniumBrowserDelayTimes.DelayAfterEnterValueInSlowField_ms);
		
		// waiting a while before final submit :) should be enough time to review and close the browser if something is wrong...
		int waitBeforeFinalSubmit_s = 10;
		String finalSubmitWarning = "Time before final Job Submit: " + waitBeforeFinalSubmit_s + "s";
		logCollector.debug(finalSubmitWarning);

		// give an alert in the browser too :D
		((JavascriptExecutor) driver).executeScript("alert('" + finalSubmitWarning + "');");
		
		utilities.helpers.pauseThread(waitBeforeFinalSubmit_s * 1000);
		
		
		// do the final job submit
		// String clickResult =
		buttonClicker.Click(driver, pageElementLocators.JobAppPage4.NextStepBtn, configSettings.SeleniumBrowserDelayTimes.DelayAfterClickButton_ms);

		// check result...
		// loking for this: <span class="success-text" style="font-size: 36px;">Your application has been received!</span>
//		AssertJUnit.assertEquals(clickResult, "");		

	}

}
