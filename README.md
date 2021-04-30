# HerffJonesAssessment
Assessment for Employment

The Assessment Project is built in Java Spring Boot with JDBC connecting to an Azure Database that I setup to persist the data.
I used ThymeLeaf and HTML with Bootstrap CSS framework for the front end to create three pages; createOrder.html, getOrder.html, and confirmation.html as per the requirements.
Once the project is downloaded and imported into Eclipse IDE as a Maven project, run the application as a Java Application and the embedded Apache Server will load the front end. Navigate to localhost:8080/createOrder in the browser of choice and it should display the page in which users can enter their information and save it to the database. It will redirect to the confirmation page and display the recently added order. Upon clicking the 'Okay' button it will forward to the get order page. Users can enter their last name and an order id number and click the search button to display results. A message of 'No Orders Available' will display if the last name and order id do not match any data in the database.
