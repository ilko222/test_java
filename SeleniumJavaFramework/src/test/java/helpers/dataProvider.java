package helpers;

import org.testng.annotations.DataProvider;
public class dataProvider {
        @DataProvider(name="SearchProvider")
        public static Object[][] getDataFromDataprovider(){
            return new Object[][] {
                { "Iphone", "Iphone" },
                { "MacBook", "MacBook" },
                { "Samsung", "Samsung" }
            };  
}}