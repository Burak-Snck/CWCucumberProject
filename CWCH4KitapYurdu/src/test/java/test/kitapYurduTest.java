package test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.AllPages;
import pages.HomePage;
import pages.SearchResultsPage;


public class kitapYurduTest {
    @Epic("Regression Tests")
    @Feature("Login Tests")
    @Test(priority = 1, description = "Login Scenario with  username and password.")
    public void Test() throws InterruptedException {
        AllPages allPages = new AllPages();

allPages.homePage().go_to_url("url");
allPages.homePage().verifyTitle("Kitapyurdu, Kitapla buluşmanın en kolay yolu");
allPages.homePage().searchProduct("roman");
allPages.searchResultsPage().verifySearchResult("roman");
allPages.searchResultsPage().chooseRandomBook(1);
allPages.productDetailsPage().clickSepeteEkleButton();
allPages.productDetailsPage().verifySepetCount("1");
allPages.productDetailsPage().go_to_sepet();
allPages.cartPage().changeSepeteQuantity();
allPages.cartPage().clickRefreshButton();
allPages.cartPage().verifySepetinizGuncelleniyor();
allPages.cartPage().removeCart();
allPages.cartPage().assertCart();

    }
}
