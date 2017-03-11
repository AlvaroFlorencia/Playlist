package playlist;

import java.util.*;


public class playlist {
    private static List<Album> albums = new ArrayList<>();
    
    
    public static void main(String[] args) {
        Album album = new Album("Exitos 90", "Variado"); //Se crea un albúm nuevo para probar
        album.addSong("La cucaracha", 3.5);
        album.addSong("Thriller", 7.5);
        album.addSong("La feria de Cepillin", 6.3);
        album.addSong("Parchis ", 5.6);
        album.addSong("Subete a mi moto", 7.5);
        album.addSong("Tu y yo somos uno mismo", 4.33);
      
        albums.add(album);  //se añade a albúm

        album = new Album("Exitos del ayer y del ahora", "Variado");  
        album.addSong("El triste", 1.54);
        album.addSong("Cuando calienta el sol", 2.45);
        album.addSong("Vamos", 2.55);
        album.addSong("Azul azul", 7.34);
        album.addSong("Abrazame", 2.41);
        
       albums.add(album);

        List<Song> playList = new LinkedList<>(); //Se utiliza LinkedList para no tner que buscarlo en el index
        albums.get(0).addToPlayList("Parchis", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Parchis electronic", playList);  // no existe el track
        albums.get(0).addToPlayList(2, playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(25, playList);  // no hay track 25

        play(playList);
    }
    
    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false; //Se utiliza para ver la dirección
        boolean forward = true; //Se verifica para continuar la ejecución
        ListIterator<Song> listIterator = playList.listIterator();    //Se utiliza un iterator para poder moverse dentro de la lista
        if(playList.isEmpty()) 
        {
            System.out.println("No  exists songs in playlist");  //Si está vacío no exite la canción 
          return;
        } 
        else 
        {
         System.out.println("Now playing:" + listIterator.next().toString()); //Si no se reproduce la canción
         printMenu();
        }

        while(!quit)
        { 
        int action = scanner.nextInt();
        scanner.nextLine();

        switch(action)
        {
         case 0:
        System.out.println("Playlist complete"); //Switch para poder mostrar las acciones
        quit = true;
        break;
        case 1:
        if(!forward) {
        if(listIterator.hasNext()) {  //Checa si hay un continuo en la lista
        listIterator.next(); //Se va  la siguiente
        }
        forward = true;   
        }
        if(listIterator.hasNext()) {  //Checa si hay un isguiente
        System.out.println("Now playing " + listIterator.next().toString());
         }  //Se reproduce la siguiente
        else 
        {
       System.out.println("We have reached the end of the playlist"); //Si no, es que está en le final de la lista
     forward = false;
         }
     break;

     case 2:
       if(forward)
       {
     if(listIterator.hasPrevious()) //Se checa si hay un previo
     {
     listIterator.previous(); //Se va al anterior
        } 
     forward = false;
   }
  if(listIterator.hasPrevious())  //Checa si hay un previo
  {
   System.out.println("Now playing:" + listIterator.previous().toString());//Se reproduce la anterior
   } 
  else 
  {
   System.out.println("We are at the start of the playlist"); //Si no, está en el inicio de la lista
      forward = true;
      }
   break;
   case 3:
  if(forward) {
    if(listIterator.hasPrevious()) { //Checa si hay un previo
   System.out.println("Now re-playing " + listIterator.previous().toString());  //Se vuelve a reprodcuir la siguiente
      forward = false;
      }
    else 
    {
     System.out.println("We are at the start of the list"); //Si no, está en el principio de la lisya
    }
   }
  else
  {
if(listIterator.hasNext()) {
    System.out.println("Now re-playing " + listIterator.next().toString()); //Si no, se vuelve a reproducir la canción
   forward = true;
                        }
else {
 System.out.println("We have reached the end of the list"); //Si no está en el final de la lista
}
}
 break;     
   case 4:
  printList(playList); //Se enlista las canciones
 break;
  case 5:
      printMenu(); //Se imprime el menu
     break;

  case 6:
    if(playList.size() >0) { //Si el tamaño del playList es mayor que 0
      listIterator.remove();   //Se remueve la canción
   if(listIterator.hasNext()) { //Si hay una canción despues se se reproduce la canción siguiente
System.out.println("Now playing:" + listIterator.next());
                        }
   else if(listIterator.hasPrevious())  
   {
     System.out.println("Now playing " + listIterator.previous()); //Si no,si hay uno antes se reproduce el anterior
       }
                    }
     break;

    }
       }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress"); //Se utliza n para que se corra el texto al siguiente
        System.out.println("0 - to quit\n" +
        "1 - to play next song\n" + 
        "2 - to play previous song\n" +
        "3 - to replay the current song\n" +  
        "4 - list songs in the playlist\n" +
        "5 - print available actions.\n" +
        "6 - delete current song from playlist");

    }


    private static void printList(List<Song> playList) {
        Iterator<Song> iterator = playList.iterator();  //Se imprimen todos lo que existe en la lista
        System.out.println("==================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===================");
    }
}