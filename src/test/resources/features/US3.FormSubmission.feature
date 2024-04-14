@FormSubmission
Feature: Application Form Submission

  Background: : Navigate to Business Grants page
    Given User Navigates to My Grants Page
    Then User applies for New Grant
    And User selects sector "IT"
    And User selects I need this grant to "Bring my business overseas or establish a stronger international presence"
    And User selects assistance "Market Readiness Assistance"
    And User proceeds and Applies for grant

  @ac1
  Scenario: AC1 Submit Grant Application
    And User fills in all mandatory details on the Eligibility page
    And User clicks Save button on Eligibility page
    When The user clicks on the Contact Details menu
    And User fills in all mandatory details on the Contact Details page
    And The user clicks the Save button on Contact Details Page
    When The user clicks on the Proposal menu
    And User fills in all mandatory details on the Proposal page
    And User clicks the Save button on Proposal Page
    When The user clicks on the Business Impact menu
    And User fills in all mandatory details on the Business Impact page
    And User clicks the Save button on Business Impact page
    When The user clicks on the Cost menu
    And User fill in all mandatory details on the Cost page
    And User click the Save button on Cost page
    When The user clicks on the declare review menu
    And User answers the declaration questions
    And User checks the acknowledgement
    And User click the Save button on declare review page
    And User click the Review button on declare review page
    Then read only Summary page should appear

  @ac2
  Scenario: AC2 Verify errors on the incomplete application
    When The user clicks on the declare review menu
    And User click the Review button on declare review page
    Then Verify the count of actual and expected errors as below
      | Expected Count |
      | 5              |
      | 8              |
      | 7              |
      | 11             |
      | 1              |
      | 9              |

    #TODO
  @ac3
  Scenario: AC3 Verify the applicants details in the review summary page
    Given User fills in all mandatory details on the Eligibility page
    And User clicks Save button on Eligibility page
    When The user clicks on the Contact Details menu
    And User fills in all mandatory details on the Contact Details page
    And The user clicks the Save button on Contact Details Page
    When The user clicks on the Proposal menu
    And User fills in all mandatory details on the Proposal page
    And User clicks the Save button on Proposal Page
    When The user clicks on the Business Impact menu
    And User fills in all mandatory details on the Business Impact page
    And User clicks the Save button on Business Impact page
    When The user clicks on the Cost menu
    And User fill in all mandatory details on the Cost page
    And User click the Save button on Cost page
    When The user clicks on the declare review menu
    And User answers the declaration questions
    And User checks the acknowledgement
    And User click the Save button on declare review page
    And User click the Review button on declare review page
    Then read only Summary page should appear
    And Verify all the Application details matches in the Review Summary page

  @ac4
  Scenario: AC4 Verify Consent and Acknowledgement checkbox on Review and Summary page
    Given User fills in all mandatory details on the Eligibility page
    And User clicks Save button on Eligibility page
    When The user clicks on the Contact Details menu
    And User fills in all mandatory details on the Contact Details page
    And The user clicks the Save button on Contact Details Page
    When The user clicks on the Proposal menu
    And User fills in all mandatory details on the Proposal page
    And User clicks the Save button on Proposal Page
    When The user clicks on the Business Impact menu
    And User fills in all mandatory details on the Business Impact page
    And User clicks the Save button on Business Impact page
    When The user clicks on the Cost menu
    And User fill in all mandatory details on the Cost page
    And User click the Save button on Cost page
    When The user clicks on the declare review menu
    And User answers the declaration questions
    And User checks the acknowledgement
    And User click the Save button on declare review page
    And User click the Review button on declare review page
    Then read only Summary page should appear
    And User checks Consent and Acknowledgement checkbox is present on Review and Summary page

  @ac5
  Scenario: AC5 Submitting the application successfully
    Given User fills in all mandatory details on the Eligibility page
    And User clicks Save button on Eligibility page
    When The user clicks on the Contact Details menu
    And User fills in all mandatory details on the Contact Details page
    And The user clicks the Save button on Contact Details Page
    When The user clicks on the Proposal menu
    And User fills in all mandatory details on the Proposal page
    And User clicks the Save button on Proposal Page
    When The user clicks on the Business Impact menu
    And User fills in all mandatory details on the Business Impact page
    And User clicks the Save button on Business Impact page
    When The user clicks on the Cost menu
    And User fill in all mandatory details on the Cost page
    And User click the Save button on Cost page
    When The user clicks on the declare review menu
    And User answers the declaration questions
    And User checks the acknowledgement
    And User click the Save button on declare review page
    And User click the Review button on declare review page
    Then read only Summary page should appear
    And the User checks the Consent and Acknowledgement checkbox
    When User submits the entire Application
    Then User is greeted a Success message box is displayed
    And the Agency details display Enterprise Singapore as the receiving Agency

  @ac6
  Scenario: AC6 Verify App ID
    Given User fills in all mandatory details on the Eligibility page
    And User clicks Save button on Eligibility page
    When The user clicks on the Contact Details menu
    And User fills in all mandatory details on the Contact Details page
    And The user clicks the Save button on Contact Details Page
    When The user clicks on the Proposal menu
    And User fills in all mandatory details on the Proposal page
    And User clicks the Save button on Proposal Page
    When The user clicks on the Business Impact menu
    And User fills in all mandatory details on the Business Impact page
    And User clicks the Save button on Business Impact page
    When The user clicks on the Cost menu
    And User fill in all mandatory details on the Cost page
    And User click the Save button on Cost page
    When The user clicks on the declare review menu
    And User answers the declaration questions
    And User checks the acknowledgement
    And User click the Save button on declare review page
    And User click the Review button on declare review page
    Then read only Summary page should appear
    And the User checks the Consent and Acknowledgement checkbox
    And User submits the entire Application
    Then User is greeted a Success message box is displayed
    And the Agency details display Enterprise Singapore as the receiving Agency
    And Navigate to the Processing Table from Review Summary Page
    And Verify Application Submitted and verify in processing tab