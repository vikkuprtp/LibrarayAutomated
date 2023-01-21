# LibraryAutomated

Started with the Springboot Application to implement Requirment 
●	Allow a user to borrow a book , this should return a due date
●	A user can only borrow at max 5 books
●	Allow a user to return a book, calculate fine if any
○	Fines should be calculated based on the number of days beyond the due date the customer has returned the book. (ex  Number of Day * Fine per day)

Configuring Springboot Application with Java SDK and Maven jar
setting up application.properties for Database connection with mysql 

Created Models as Users-
  for Users Database Table
  role_id column-To specify either a library-staff or the student (1 for Staff and default=2 for students)
  role_id=1 is only allowed to add books into library
  
Created Library model-
  To hold book details such as author,genre and so on

Created BorrowRecord-
 to hold data of students taken up the books
 have @ManyToOne Relation with users
 have current_date,due_date columns
 Limit of max-5 books issued per student 
 
Created ReturnRecord-
 to hold data of students returning book and fine incurred
 have fine amount mentioned based on differnce in due_date and actual_date

Created Repositories,Service and Controller packages to follow a Model-View-Controller structure

Created Custom Exceptionhandler suitable for handling specific use case 

Created RestApi's to:

 to addBooks(only by Library-staff with role-id=1) ,
 
 to keep BorrowRecord
  -parameter passed= users_id and book_id
  -LocalDateTime.now() for current date and Due_date is customizable with weeks,months etc
  -exception handled accordingly
  -return due_date in response with status_c0ode and messsage
  
 to keep returnRecord
  -parameter passed-users_id ,book_id and fine_amount as default=0
  -compared time of due date and actual_date to find out the difference and charge accordingly
  -used time in Minutes to implement and test the Api's.
  -returns due_date,actual_date,status_code and message
  
  

 
 
  
  
  
  
  
