package utilities;

import org.openqa.selenium.By;

public class pageElementLocators {

	public static class JobListingPage {
		public static final By ApplyLinkBtn = By.cssSelector(pageElementSelectors.JobListingPage.ApplyLinkCssPathSelector);
	}

	public static class JobAppPage1 {
		public static final By FillAppUsingResumeChkBx = By.id(pageElementSelectors.JobAppPage1.id4FillAppUsingResumeChkBx);

		public static final By ResumePdfOrDocUploadField = By.id(pageElementSelectors.JobAppPage1.id4ResumePdfOrDocUpload);
		public static final By CoverLetterPdfOrDocUploadField = By.id(pageElementSelectors.JobAppPage1.id4CoverLetterPdfOrDocUpload);
		
		
		public static final By ResumePdfOrDocUploadBtn = By.id(pageElementSelectors.JobAppPage1.css4ResumePdfOrDocUploadBtn);
		public static final By CoverLetterPdfOrDocUploadBtn = By.id(pageElementSelectors.JobAppPage1.css4CoverLetterPdfOrDocUploadBtn);

		public static final By FirstName = By.id(pageElementSelectors.JobAppPage1.id4FirstName);
		public static final By LastName = By.id(pageElementSelectors.JobAppPage1.id4LastName);
		public static final By Email = By.id(pageElementSelectors.JobAppPage1.id4Email);
		public static final By CellPhone = By.id(pageElementSelectors.JobAppPage1.id4CellPhone);
		public static final By LinkedInUrl = By.id(pageElementSelectors.JobAppPage1.id4LinkedInUrl);

		public static final By FirstJumpBtnB4WorkHistoryBtn = By.cssSelector(pageElementSelectors.JobAppPage1.css4FirstJumpBtnB4WorkHistoryBtn);

		public static final By RestOfJumpBtnsB4WorkHistoryBtn(Integer index) {
			return By.cssSelector(pageElementSelectors.JobAppPage1.css4RestOfJumpBtnsB4WorkHistoryBtnWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By WorkHistoryCompanyWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4WorkHistoryCompanyWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By WorkHistoryPositionWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4WorkHistoryPositionWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By WorkHistoryResponsibilitiesTextAreaWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4WorkHistoryResponsibilitiesTextAreaWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By WorkHistoryStartDateWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4WorkHistoryStartDateWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By WorkHistoryEndDateWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4WorkHistoryEndDateWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By WorkHistoryEndReasonWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4WorkHistoryEndReasonWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By WorkHistoryCurrentJobChkWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4WorkHistoryCurrentJobChkWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By OpenEducationDegreeDropdownWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4OpenEducationDegreeDropdownWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By SelectEducationDegreeBSWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4SelectEducationDegreeBSWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By EducationGradDateWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4EducationGradDateWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By JumpBtnB4EducationBtn = By.id(pageElementSelectors.JobAppPage1.id4JumpBtnB4EducationBtn);

		public static final By EducationSchoolNameWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4EducationSchoolNameWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By EducationAreaOfStudyWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4EducationAreaOfStudyWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By OpenEducationTypeWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4OpenEducationTypeWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By SelectEducationTypeUniversityWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4SelectEducationTypeUniversityWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By OpenEducationGraduateDropdownWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4OpenEducationGraduateDropdownWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By SelectEducationGraduateYesWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage1.id4SelectEducationGraduateYesWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By NextStepBtn = By.id(pageElementSelectors.JobAppPage1.id4NextStepBtn);
	}

	public static class JobAppPage2 {

		public static final By PrevousInterviewRadioWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage2.id4PrevousInterviewRadioWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By USWorkEligibleRadioWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage2.id4USWorkEligibleRadioWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By NeedSponsorshipRadioWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage2.id4NeedSponsorshipRadioWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By NonCompeteRadioWithIdx(Integer index) {
			return By.id(pageElementSelectors.JobAppPage2.id4NonCompeteRadioWithIdx.replace("INDEX_NUM", index.toString()));
		}

		public static final By SalaryRequirementTextArea = By.id(pageElementSelectors.JobAppPage2.id4SalaryRequirementTextArea);

		public static final By FoundOneIndeedCheckBx = By.id(pageElementSelectors.JobAppPage2.id4FoundOneIndeedCheckBx);

		public static final By NextStepBtn = By.id(pageElementSelectors.JobAppPage2.id4NextStepBtn);
	}

	public static class JobAppPage3 {

		public static final By OpenGenderDropdown = By.id(pageElementSelectors.JobAppPage3.id4OpenGenderDropdown);
		public static final By SelectMaleGender = By.id(pageElementSelectors.JobAppPage3.id4SelectMaleGender);

		public static final By OpenEthnicGroupDropdown = By.id(pageElementSelectors.JobAppPage3.id4OpenEthnicGroupDropdown);
		public static final By SelectEthnicGroupBlack = By.id(pageElementSelectors.JobAppPage3.id4SelectEthnicGroupBlack);

		public static final By OpenMilitaryDropdown = By.id(pageElementSelectors.JobAppPage3.id4OpenMilitaryDropdown);
		public static final By SelectMilitaryNotAVet = By.id(pageElementSelectors.JobAppPage3.id4SelectMilitaryNotAVet);

		public static final By OpenDisabilityDropdown = By.id(pageElementSelectors.JobAppPage3.id4OpenDisabilityDropdown);
		public static final By SelectDisabilityNotDisabled = By.id(pageElementSelectors.JobAppPage3.id4SelectDisabilityNotDisabled);

		public static final By NextStepBtn = By.id(pageElementSelectors.JobAppPage3.id4NextStepBtn);
	}

	public static class JobAppPage4 {

		public static final By AcceptSubmission = By.id(pageElementSelectors.JobAppPage4.id4AcceptSubmission);

		public static final By NextStepBtn = By.id(pageElementSelectors.JobAppPage4.id4NextStepBtn);
	}

}
