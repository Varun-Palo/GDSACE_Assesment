package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.palo.Factory.DriverFactory;
import org.palo.pages.*;

public class FormSubmission {
    EligibilityPage eligibilityPage = new EligibilityPage(DriverFactory.getPage());
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage(DriverFactory.getPage());
    ProposalPage proposalPage = new ProposalPage(DriverFactory.getPage(),DriverFactory.getApplicationInformation());
    BusinessImpactPage businessImpactPage = new BusinessImpactPage(DriverFactory.getPage());
    CostPage costPage = new CostPage(DriverFactory.getPage());
    DeclarationPage declarationPage = new DeclarationPage(DriverFactory.getPage(),DriverFactory.getApplicationInformation());
    
    @And("User completes and saves all mandatory details on the Eligibility page")
    public void userFillsInAllMandatoryDetailsOnTheEligibilityPage() {
        eligibilityPage.clickYesorNoForAllQuestions("Yes");
        eligibilityPage.clickSaveButton();
    }

    @And("User navigates,fills and saves all mandatory details on the Contact Details page")
    public void userFillsInAllMandatoryDetailsOnTheContactDetailsPage() {
        contactDetailsPage.clickOnContactDetailsMenu();
        contactDetailsPage.inputMainContactPersonDetails();
        contactDetailsPage.enterPostalCode("100050");
        contactDetailsPage.clickSameAsMainContactCheckbox();
        contactDetailsPage.clickSaveButton();
    }

    @When("The user clicks on the Proposal menu")
    public void theUserClicksOnTheProposalMenu() {
        proposalPage.clickProposalMenu();
    }

    @And("User navigates,fills and saves all mandatory details on the Proposal page")
    public void userFillsInAllMandatoryDetailsOnTheProposalPage() {
        proposalPage.clickProposalMenu();
        proposalPage.fillProposalDetails();
        proposalPage.clickSaveButton();
    }

    @And("User clicks the Save button on Proposal Page")
    public void userClicksTheSaveButtonOnProposalPage() {
        proposalPage.clickSaveButton();
    }

    @When("The user clicks on the Business Impact menu")
    public void theUserClicksOnTheBusinessImpactMenu() {
        businessImpactPage.clickBusinessImpactMenu();
    }

    @And("User navigates,fills and saves all mandatory details on the Business Impact page")
    public void userFillsInAllMandatoryDetailsOnTheBusinessImpactPage() {
        businessImpactPage.clickBusinessImpactMenu();
        businessImpactPage.fillBusinessImpactDetails();
        businessImpactPage.clickSaveButton();
    }

    @And("User clicks the Save button on Business Impact page")
    public void userClicksTheSaveButtonOnBusinessImpactPage() {
        businessImpactPage.clickSaveButton();
    }

    @When("The user clicks on the Cost menu")
    public void theUserClicksOnTheCostMenu() {
        costPage.clickCostMenu();
    }

    @And("User navigates,fills and saves all mandatory details on the Cost page")
    public void userFillInAllMandatoryDetailsOnTheCostPage() {
        costPage.clickCostMenu();
        costPage.fillCostDetails();
        costPage.clickSaveButton();
    }

    @And("User click the Save button on Cost page")
    public void userClickTheSaveButtonOnCostPage() {
        costPage.clickSaveButton();
    }

    @When("The user clicks on the declare review menu")
    public void theUserClicksOnTheDeclareReviewMenu() {
        declarationPage.clickDeclareReviewMenu();
    }

    @And("User answers the declaration questions and accepts the acknowledgement")
    public void userAnswersTheDeclarationQuestions() {
        declarationPage.clickDeclareReviewMenu();
        declarationPage.clickYesorNoForAllQuestions("No");
        declarationPage.checkAcknowledgement();
    }

    @And("User checks the acknowledgement")
    public void userChecksTheAcknowledgement() {
        declarationPage.checkAcknowledgement();
    }

    @And("User reviews and submits the declaration")
    public void userClickTheSaveButtonOnDeclareReviewPage() {
        declarationPage.clickSaveButton();
        declarationPage.clickReviewButton();
    }

    @And("User click the Review button on declare review page")
    public void userClickTheReviewButtonOnDeclareReviewPage() {
        declarationPage.clickReviewButton();
    }

    @Then("User verify the read only Summary page and accepts Consent and Acknowledgement checkbox")
    public void readOnlySummaryPageShouldAppear() {
        declarationPage.verifyReadOnlySummaryPage();
        declarationPage.acceptAcknowledgement();
    }

    @Then("Verify the count of actual and expected errors as below")
    public void verifyTheCountOfActualAndExpectedErrorsAsBelow(DataTable dataTable) {
        declarationPage.countErrors(dataTable.asList());
    }

    @And("Verify all the Application details matches in the Review Summary page")
    public void verifyAllTheApplicationDetailsMatchesInTheReviewSummaryPage() {
    }

    @And("User checks Consent and Acknowledgement checkbox is present on Review and Summary page")
    public void userChecksConsentAndAcknowledgementCheckboxIsPresentOnReviewAndSummaryPage() {
        declarationPage.verifyConsentAcknowledgementCheckbox();
    }

    @And("the User checks the Consent and Acknowledgement checkbox")
    public void theUserChecksTheConsentAndAcknowledgementCheckbox() {
        declarationPage.acceptAcknowledgement();
    }

    @When("User submits the Application and verifies the Success message box is displayed")
    public void userSubmitsTheEntireApplication() {
        declarationPage.submitApplication();
        declarationPage.verifySuccessMessage();
        declarationPage.verifyAgencyDetails();
    }

    @Then("User is greeted a Success message box is displayed")
    public void userIsGreetedASuccessMessageBoxIsDisplayed() {
        declarationPage.verifySuccessMessage();
    }

    @And("the Agency details display Enterprise Singapore as the receiving Agency")
    public void theAgencyDetailsDisplayEnterpriseSingaporeAsTheReceivingAgency() {
        declarationPage.verifyAgencyDetails();
    }


    @And("User navigates to My Application table and verifies the Application is Shown in Processing Tab")
    public void navigateToTheProcessingTableFromReviewSummaryPage() {
        declarationPage.navigateToProcessingTable();
        declarationPage.verifyApplicationSubmitted();
    }

    @And("Verify Application Submitted and verify in processing tab")
    public void verifyApplicationSubmittedAndVerifyInProcessingTab() {
        declarationPage.verifyApplicationSubmitted();
    }
}
