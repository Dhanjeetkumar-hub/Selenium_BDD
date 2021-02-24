package stepdefinitions;

import java.util.List;
import java.util.Map;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountsPageSteps {
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
@Given("User has already logged in to application")
public void user_has_already_logged_in_to_application(DataTable credTable) {
	List<Map<String,String>> credList=credTable.asMaps();
	String userName=credList.get(0).get("username");
	String password=credList.get(0).get("password");
	DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	accountsPage=loginPage.doLogin(userName, password);
	
}
	    
@Given("user is on Accounts page")
public void user_is_on_accounts_page() {
	String title=accountsPage.getAccountsPageTitle();
    System.out.println("Accounts page title is: "+title);
}

@Then("user gets accounts section")
public void user_gets_accounts_section(DataTable sectionsTable) {
List<String> expAccountsSectionList=sectionsTable.asList();
System.out.println("Expected accounts section list"+ expAccountsSectionList);
List<String> actualAccountsSectionList=accountsPage.getAccountsSectionList();
//System.out.println(accountsPage.getAccountsSectionCount());
System.out.println("actual accounts section list"+ actualAccountsSectionList);
Assert.assertTrue(expAccountsSectionList.containsAll(actualAccountsSectionList));
}

@Then("accounts section count should be {int}")
public void accounts_section_count_should_be(Integer expectedSectionCount) {
	System.out.println(expectedSectionCount+"---"+accountsPage.getAccountsSectionCount());
	Assert.assertTrue(accountsPage.getAccountsSectionCount()==expectedSectionCount); 
	
}


}
