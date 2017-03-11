
package playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Album {
private String name;    //Variables
private String artist;
private ArrayList<Song> songs;

   public Album(String name, String artist) 
   {
   this.name = name;
   this.artist = artist;
    this.songs = new ArrayList<Song>();  //Inicializador
    }

    public boolean addSong(String title, double duration)  //Para añadir una canción , se checa que no exista una canción y se añade
    {
    if(findSong(title) == null) {
    this.songs.add(new Song(title, duration));
    return true;
    }
    return false;
    }

    private Song findSong(String title)        //Para encontrar una canción mediante un for se chaecan todas las canciones y se se encuentra el mismo título se devuelve la canción
    {
    for(Song checkedSong: this.songs)
    {
    if(checkedSong.getTitle().equals(title))
    {
    return checkedSong;
    }
    }
    return null;
    }

    public boolean addToPlayList(int trackNumber, List<Song> playList) 
    {
    int index = trackNumber -1;
    if((index >=0) && (index < this.songs.size()))   //Para aladir a la lusta se recibe el el tracj y la playlist
    {
    playList.add(this.songs.get(index));   //Si el index es mayor o igual a cero y menor que que el tamaño del playlist 
    return true;                             //Se añade al playList
    }
    System.out.println("This album does not have a track" + trackNumber);
    return false; //Si no no existe el albúm
    }

    public boolean addToPlayList(String title, List<Song> playList) 
    {
    Song checkedSong = findSong(title);  //Aladiendo recibieno el título
    if(checkedSong != null) {  //Se checa si la canción es nula
    playList.add(checkedSong); //y se añade
    return true;
    }
    System.out.println("The song" + title + "is not in this album"); //Si no se dice que no esta el albúm
    return false;
    }
}
