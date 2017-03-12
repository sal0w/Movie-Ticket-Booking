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
public class Usermovies {
    int mid;
    int uid;
    String movie;
    String seats;
    int price;
    int noofseats;

    public Usermovies() {
    }

    public Usermovies(int mid, int uid, String movie, String seats, int price, int noofseats) {
        this.mid = mid;
        this.uid = uid;
        this.movie = movie;
        this.seats = seats;
        this.price = price;
        this.noofseats = noofseats;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNoofseats() {
        return noofseats;
    }

    public void setNoofseats(int noofseats) {
        this.noofseats = noofseats;
    }

    @Override
    public String toString() {
        return "Usermovies{" + "mid=" + mid + ", uid=" + uid + ", movie=" + movie + ", seats=" + seats + ", price=" + price + ", noofseats=" + noofseats + '}';
    }
    
    
    
    
}
