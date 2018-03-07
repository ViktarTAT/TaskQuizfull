package by.htp.quizfullTask.domen;

public class AccountFactory {

   private Account account;
   
   private void init() {
       account = new Account("asdf2", "1", "1", "asdf2@mail.ru", true);
   }
   
   public Account getAccount() {
       init();
       return account;
   }
   
   public Account getAccountEmailWithSpace(){
       init();
       String email = account.getEmail();
       email += " ";
       account.setEmail(email);
       return account;
   }
   
   public Account getAccountEmailFirstSymbolSpace(){
       init();
       String email = account.getEmail();
       email = " " + email;
       account.setEmail(email);
       return account;
   }
   
   public Account getAccountLoginFirstSymbolSpace(){
       init();
       String login = account.getLogin();
       login = " " + login;
       account.setLogin(login);
       return account;
   }
   
   public Account getAccountLoginMinSize(){
       init();
       account.setLogin("alu");
       return account;
   }
   
   public Account getAccountLoginMaxSize(){
       init();
       account.setLogin("asdfasdfasdfasd");
       return account;
   }
   
   public Account getAccountLoginMoreMaxSize(){
       init();
       account.setLogin("asdfasdfasdfasdasdf");
       return account;
   }
   
   public Account getAccountWithoutPass() {
       init();
       account.setPassword("");
       return account;
   }
   
   public Account getAccountWithoutRepass() {
       init();
       account.setRepassword("");
       return account;
   }
   
   
}
