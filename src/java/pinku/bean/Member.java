/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.bean;

/**
 *
 * @author Administrator
 */
public class Member {
    
    int uid;
    String firstname;
    String lastName;
    String password;
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public Member(int uid, String firstname, String lastName, String password, String email) {
        this.uid = uid;
        this.firstname = firstname;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public Member() {
    }
    
    

    @Override
    public String toString() {
        return "Member{" + "uid=" + uid + ", firstname=" + firstname + ", lastName=" + lastName + ", password=" + password + '}';
    }
    
    

    
    
    

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
