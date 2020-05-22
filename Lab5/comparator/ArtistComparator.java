import java.util.Comparator;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class ArtistComparator implements Comparator<Song>{

    public int compare(Song s1, Song s2){
        if(s1.getArtist().compareTo(s2.getArtist()) > 0) {return 1;}
        else if(s1.getArtist().compareTo(s2.getArtist()) < 0){return -1;}
        return 0;
    }

}