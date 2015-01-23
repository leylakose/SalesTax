# SalesTax
Basically  user enters quantity, item and price then it calculates taxes then prints receipt. I also tried this 
problem with reading from file, but i gave up. It is too long...
Here is some classes that i've explained:
--class Product : set and get funtions of product's quantity, name, price, itemType etc.
--class Receipt : it prints receipt after the shoping.
--class TaxCalculator : calculates the tax based on conditions(import duty?)
--class TaxClient : includes main() and entry(). So, user can inputs number of items that wants and quantity,
item and price
--class TaxConstants : it contains tax variables and filehandler to writes all messages to file(config.properties)
while i researching,i found out .properties is a file extension that used in Java stuffs. It stores parameters and strings. There for i used it. writing tax percentage and import duty percentage.
--class TaxLogger : tried Logger to catch errors. I know there is debugger and it is perfect for big projects. just for practice...

