package by.htp.quizfullTask.domen;

public class Account {
    private String login;
    private String password;
    private String repassword;
    private String email;
    private boolean corporate;

    public Account() {

    }

    public Account(String login, String password, String repassword, String email, boolean corporate) {
	super();
	this.login = login;
	this.password = password;
	this.repassword = repassword;
	this.email = email;
	this.corporate = corporate;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getRepassword() {
	return repassword;
    }

    public void setRepassword(String repassword) {
	this.repassword = repassword;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public boolean isCorporate() {
	return corporate;
    }

    public void setCorporate(boolean corporate) {
	this.corporate = corporate;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (corporate ? 1231 : 1237);
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((login == null) ? 0 : login.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((repassword == null) ? 0 : repassword.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Account other = (Account) obj;
	if (corporate != other.corporate)
	    return false;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
	    return false;
	if (login == null) {
	    if (other.login != null)
		return false;
	} else if (!login.equals(other.login))
	    return false;
	if (password == null) {
	    if (other.password != null)
		return false;
	} else if (!password.equals(other.password))
	    return false;
	if (repassword == null) {
	    if (other.repassword != null)
		return false;
	} else if (!repassword.equals(other.repassword))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Account [login=" + login + ", password=" + password + ", repassword=" + repassword + ", email=" + email
		+ ", corporate=" + corporate + "]";
    }
}
