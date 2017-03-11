
package playlist;


public class Song {
    private String title;   //Definiendo variables
    private double duration;

    public Song(String title, double duration)  //Constructor
    {
    this.title = title;
    this.duration = duration;
    }

    public String getTitle() //Getter
    {
    return title;
    }

    @Override
    public String toString()  //Tostring regresa el titulo y su duración
    {
    return this.title + ":" + this.duration;
    }
}