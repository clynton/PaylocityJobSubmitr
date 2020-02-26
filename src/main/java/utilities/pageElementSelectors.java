package utilities;

public class pageElementSelectors {

	public static class JobListingPage {
		public static final String ApplyLinkCssPathSelector = "#skip-to-form > a";
	}

	public static class JobAppPage1 {
		public static final String id4FillAppUsingResumeChkBx = "useAttachedResumeToFillOutApplication";

		public static final String id4ResumePdfOrDocUpload = "btn-resume";
		public static final String id4CoverLetterPdfOrDocUpload = "btn-coverLetter";
		public static final String css4ResumePdfOrDocUploadBtn = "button[data-automationid='btn-resume']";
		public static final String css4CoverLetterPdfOrDocUploadBtn = "button[data-automationid='btn-coverLetter']";

		public static final String id4FirstName = "info.firstName";
		public static final String id4LastName = "info.lastName";
		public static final String id4Email = "info.email";
		public static final String id4CellPhone = "info.cellPhone";
		public static final String id4LinkedInUrl = "info.linkedIn";

		// Add work history is after the additionalFiles upload button. We'll go to one and tab to the next :D
		public static final String css4FirstJumpBtnB4WorkHistoryBtn = "button[data-automationid='btn-additionalFiles']";
		public static final String css4RestOfJumpBtnsB4WorkHistoryBtnWithIdx = "button[data-automationid='btn-delete-workhistory-INDEX_NUM']";

		public static final String id4WorkHistoryCompanyWithIdx = "workHistory.companyName.INDEX_NUM";
		public static final String id4WorkHistoryPositionWithIdx = "workHistory.position.INDEX_NUM";
		public static final String id4WorkHistoryResponsibilitiesTextAreaWithIdx = "workHistory.responsibilities.INDEX_NUM";
		public static final String id4WorkHistoryStartDateWithIdx = "workHistory.startDate.INDEX_NUM.input";
		public static final String id4WorkHistoryEndDateWithIdx = "workHistory.endDate.INDEX_NUM.input";
		public static final String id4WorkHistoryEndReasonWithIdx = "workHistory.reasonForLeaving.INDEX_NUM";
		public static final String id4WorkHistoryCurrentJobChkWithIdx = "workHistory.currentlyWorkingHere.INDEX_NUM";

		public static final String id4JumpBtnB4EducationBtn = "educationHistory.certificationsAndAwards";
		public static final String id4EducationSchoolNameWithIdx = "educationHistory.name.INDEX_NUM";
		public static final String id4EducationAreaOfStudyWithIdx = "educationHistory.areaOfStudy.INDEX_NUM";

		public static final String id4OpenEducationTypeWithIdx = "educationHistory.type.INDEX_NUM";
		public static final String id4SelectEducationTypeUniversityWithIdx = "educationHistory.type.INDEX_NUM__listbox__option__5";

		public static final String id4OpenEducationGraduateDropdownWithIdx = "educationHistory.didYouGraduate.INDEX_NUM";
		public static final String id4SelectEducationGraduateYesWithIdx = "educationHistory.didYouGraduate.INDEX_NUM__listbox__option__1";

		public static final String id4OpenEducationDegreeDropdownWithIdx = "educationHistory.degreeId.INDEX_NUM";
		public static final String id4SelectEducationDegreeBSWithIdx = "educationHistory.degreeId.INDEX_NUM__listbox__option__5";

		public static final String id4EducationGradDateWithIdx = "educationHistory.graduationDate.INDEX_NUM.input";

		public static final String id4NextStepBtn = "btn-submit";
	}

	public static class JobAppPage2 {
		public static final String id4PrevousInterviewRadioWithIdx = "multiQuestionAnswer1025_INDEX_NUM";
		public static final String id4USWorkEligibleRadioWithIdx = "multiQuestionAnswer1026_INDEX_NUM";
		public static final String id4NeedSponsorshipRadioWithIdx = "multiQuestionAnswer1027_INDEX_NUM";
		public static final String id4NonCompeteRadioWithIdx = "multiQuestionAnswer1028_INDEX_NUM";

		public static final String id4SalaryRequirementTextArea = "screener-question-4-textarea";

		// enhancement - find the label based on element text and grab the id field from the "for" attribute
		public static final String id4FoundOneIndeedCheckBx = "multiQuestionAnswer1029_2";

		public static final String id4NextStepBtn = "btn-submit";
	}

	public static class JobAppPage3 {

		// enhancement for the selections... find based on text and click to select - could also just select no-answer __option__0

		public static final String id4OpenGenderDropdown = "acknowledgements.eeoGender";
		public static final String id4SelectMaleGender = "acknowledgements.eeoGender__listbox__option__2";

		public static final String id4OpenEthnicGroupDropdown = "acknowledgements.racialOrEthnicGroup";
		public static final String id4SelectEthnicGroupBlack = "acknowledgements.racialOrEthnicGroup__listbox__option__5";

		public static final String id4OpenMilitaryDropdown = "acknowledgements.militaryService";
		public static final String id4SelectMilitaryNotAVet = "acknowledgements.militaryService__listbox__option__2";

		public static final String id4OpenDisabilityDropdown = "acknowledgements.disability";
		public static final String id4SelectDisabilityNotDisabled = "acknowledgements.disability__listbox__option__3";

		public static final String id4NextStepBtn = "btn-submit";
	}

	public static class JobAppPage4 {
		public static final String id4AcceptSubmission = "applyAcknowledgement";

		public static final String id4NextStepBtn = "btn-submit";
	}
}
