/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.apache.derby.client.am.Blob;


/**
 *
 * @author Administrator
 */
public class Movie {
    
    int mid;
    String movieName;
    String certification;
    String screen;
    String starring;
    String director;
    String timing;
    String poster;

    @Override
    public String toString() {
        return "Movie{" + "mid=" + mid + ", movieName=" + movieName + ", certification=" + certification + ", screen=" + screen + ", starring=" + starring + ", director=" + director + ", timing=" + timing + ", poster=" + poster + '}';
    }
    
    

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
    
    

    public Movie() {
    }
    
    

    public Movie(int mid, String movieName, String certification, String screen, String starring, String director, String timing, String poster) {
        this.mid = mid;
        this.movieName = movieName;
        this.certification = certification;
        this.screen = screen;
        this.starring = starring;
        this.director = director;
        this.timing = timing;
        this.poster = poster;
    }

                           
    
}
