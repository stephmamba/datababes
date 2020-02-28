CREATE
  TABLE Author
  (
    AuthorID   VARCHAR2 (11) NOT NULL ,
    Last_Name  VARCHAR2 (50) NOT NULL ,
    First_Name VARCHAR2 (50) NOT NULL
  ) ;

CREATE
  TABLE Book
  (
    ISBN_num                 NUMBER (11) NOT NULL ,
    Title                    VARCHAR2 (50) NOT NULL ,
    Issued_Date              DATE NOT NULL ,
    Category                 VARCHAR2 (50) NOT NULL ,
    Shelf_ShelfID            NUMBER (11) NOT NULL ,
    Current_Status           VARCHAR2 (50) NOT NULL ,
    CopyID                   NUMBER (11) NOT NULL ,
    Date_of_Last_Transaction DATE NOT NULL
  ) ;



CREATE
  TABLE Book_Author
  (
    Book_ISBN_num   NUMBER (11) NOT NULL ,
    Author_AuthorID NUMBER (11) NOT NULL
  ) ;


CREATE
  TABLE Librarian
  (
    UserID      VARCHAR2 (11) NOT NULL ,
    LibrarianID NUMBER (11) NOT NULL ,
    Password    VARCHAR2 (11) NOT NULL ,
    Last_Name   VARCHAR2 (50) NOT NULL ,
    First_Name  VARCHAR2 (50) NOT NULL
  ) ;


CREATE
  TABLE Patron
  (
    UserID       VARCHAR2 (11) NOT NULL ,
    PatronID     NUMBER (11) NOT NULL ,
    Password     VARCHAR2 (11) NOT NULL ,
    Occupation   VARCHAR2 (50) NOT NULL ,
    ISBN         NUMBER (11) NOT NULL ,
    Fines        NUMBER (11) NOT NULL ,
    Unpaid_Fines NUMBER (11) NOT NULL
  ) ;


CREATE
  TABLE Shelf
  (
    ShelfID  NUMBER (11) NOT NULL ,
    Capacity NUMBER (10) NOT NULL
  ) ;


CREATE
  TABLE Transaction
  (
    Patron_UserID       VARCHAR2 (11) NOT NULL ,
    Book_ISBN_num       NUMBER (11) NOT NULL ,
    Date_of_Transaction DATE NOT NULL ,
    Transaction_Code    NUMBER (50) NOT NULL
  ) ;


CREATE
  TABLE "USER"
  (
    UserID       VARCHAR2 (11) NOT NULL ,
    Last_Name    VARCHAR2 (20) NOT NULL ,
    First_Name   VARCHAR2 (20) NOT NULL ,
    HouseNo      VARCHAR2 (50) NOT NULL ,
    Street       VARCHAR2 (50) NOT NULL ,
    CityName     VARCHAR2 (50) NOT NULL ,
    Unpaid_Fines NUMBER (11) NOT NULL ,
    Password     VARCHAR2 (50) NOT NULL
  ) ;
