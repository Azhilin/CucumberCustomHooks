package test;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
    private static boolean isPrecondition = true;
    private static boolean isPostcondition = false;
    private static int step = 0;

    @Given("^Do the precondition$")
    public void doPrecondition() {
        if(isPrecondition){
            System.out.println("precondition");
        }
        if(++step == 4){
            isPostcondition = !isPostcondition;
        }
    }

    @When("^Do the action$")
    public void doAction() {
        if(isPrecondition){
            System.out.println("action");
            isPrecondition = !isPrecondition;
        }
    }

    @Then("^Do the verification$")
    public void doVerification() {
        System.out.println("verification" + step);
    }

    @After("@Feature1")
    public void doPostcondition(){
        if(isPostcondition){
            System.out.println("postcondition");
        }
    }
}
