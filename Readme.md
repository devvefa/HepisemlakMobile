#  # Selenium - Page Object Model   With Gauge
This is a sample project to demonstrate the implementation of page object model framework and how it can be used in selenium to automate web application "[https://www.hepsiemlak.com/]" with BDD software development process.
 
### What is the testcase  example:

**First Case**
 -

 1. Go to Main Page  
 2.  Check the main page is opened  
 3.  Click on “Satılık”  
 4.  Check the satılık page is opened.  
 5.  Make a search for satılık:Izmir - Bornova; İş Yeri; Fiyat : 100.000 TL - 2.000.000 TL; Bina Yaşı: Sıfır Bina, 1-5, 6-10;  
 6.  Check for Tags in the filter area

**Second Case**

1.  Go to Main Page  [www.hepsiemlak.com](http://www.hepsiemlak.com/)
2.  Click on "Kiralık”
3.  Make a search: Ankara - Çankaya; Konut; 2+1; Site İçerisinde: Evet
4.  Click on the 3rd listing on the results and go to listing detail page.
5.  WEB: On the Detail page there is a “Telefon Numarasini Goster” link on the right.
6. Validate the phone number that it is a real and valid mobile or landline number. (eg. +905xxxxxxxxx , +90212xxxxxxx)




**Each package represents a different purpose in the following way:**
 


## Frameworks & tools:


-   Java
-   Selenium WebDriver
-   JUnit
-   Guage (BDD) / Gherkin
-   Maven
-   Log4js
 