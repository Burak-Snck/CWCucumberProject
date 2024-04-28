package pages;

public class AllPages {
    public AllPages(){

    }

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;


    public HomePage homePage(){
       if (homePage == null){
           homePage=new HomePage();
       }
       return homePage;
    }

    public SearchResultsPage searchResultsPage(){
        if (searchResultsPage == null){
            searchResultsPage=new SearchResultsPage();
        }
        return searchResultsPage;
    }
    public ProductDetailsPage productDetailsPage(){
        if (productDetailsPage == null){
            productDetailsPage=new ProductDetailsPage();
        }
        return productDetailsPage;
    }
    public CartPage cartPage(){
        if (cartPage == null){
            cartPage=new CartPage();
        }
        return cartPage;
    }





}
