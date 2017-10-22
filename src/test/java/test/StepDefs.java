package test;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
    private static boolean isPrecondition = true;
    private static int step = 0;

    @Given("^Do the precondition")
    public void doPrecondition() {
        if(isPrecondition){
            System.out.println("precondition");
        }
    }

    @When("^Do the action$")
    public void doAction() {
        if(isPrecondition){
            System.out.println("action");
        }
    }

    @And("^Set number of scenarios (\\d+) and finish preconditions$")
    public void finishPreconditions(int numberOfScenarios){
        if(isPrecondition){
            isPrecondition = !isPrecondition;
            step = numberOfScenarios;
        }
    }

    @Then("^Do the verification$")
    public void doVerification() {
        System.out.println("verification" + step);
    }

    @After("@Feature1")
    public void doPostcondition(){
        if(--step == 0){
            System.out.println("postcondition");
        }
    }
}
