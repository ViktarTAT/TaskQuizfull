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
   
   public Account getAccountEmailFirstSymbolSpace(){
       String email = account.getEmail();
       email = " " + email;
       account.setEmail(email);
       return account;
   }
   
   public Account getAccountLoginFirstSymbolSpace(){
       String login = account.getLogin();
       login = " " + login;
       account.setLogin(login);
       return account;
   }
   
   public Account getAccountLoginMinSize(){
       account.setLogin("alu");
       return account;
   }
   
   public Account getAccountLoginMaxSize(){
       account.setLogin("asdfasdfasdfasd");
       return account;
   }
   
   public Account getAccountLoginMoreMaxSize(){
       account.setLogin("asdfasdfasdfasdasdf");
       return account;
   }
   
   
}
