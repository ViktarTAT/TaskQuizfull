package by.htp.quizfullTask.domen;

public class AccountFactory {

   private Account account = new Account("asdf2", "1", "1", "asdf2@mail.ru", true);
   
   public Account getAccount() {
       return account;
   }
   
   public Account getAccountEmailWithSpace(){
       String email = account.getEmail();
       email += " ";
       account.setEmail(email);
       return account;
   }
   
   public Account getLoginMinSize(){
       account.setLogin("asd");
       return account;
   }
   
   public Account getLoginMaxSize(){
       account.setLogin("asdfasdfasdfasd");
       return account;
   }
   
   
}
