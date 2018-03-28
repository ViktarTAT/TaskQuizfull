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
   
   public Account getAccountEmailLastSymbolSpace(){
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
   
   public Account getAccountLoginIsLessMinSize() {
	   init();
	   account.setLogin("ab");
	   return account;
   }
   
   public Account getAccountLoginIsMoreMaxSize() {
	   init();
	   account.setLogin("asdfasdfasdfasdasdfa");
	   return account;
   }
   
   public Account getAccountLoginWithoutLatinLetters() {
	   init();
	   account.setLogin("фывафыва");
	   return account;
   }
   
   public Account getAccountLoginWithNoLatinLetters() {
	   init();
	   account.setLogin("asdfфasdf");
	   return account;
   }
   
   
   public Account getAccountLoginFirstSymbolIsNumber() {
	   init();
	   account.setLogin("2asdfasdf");
	   return account;
   }
   
   public Account getAccountLoginFirstSymbolIsUnderscore() {
	   init();
	   account.setLogin("_asdfasdf");
	   return account;
   }
}
