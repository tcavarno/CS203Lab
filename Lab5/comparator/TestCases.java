import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

/*
GROUP MEMEBER INVOLVED
*Tristan Cavarno
*Alex Johnson
*Miloh Padgett
*Marcelo Jimenez
*/



public class TestCases
{
   private static final Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Gerry Rafferty", "Baker Street", 1978)
      };

   @Test
   public void testArtistComparator()
   {
      Comparator<Song> artistComparator  = new ArtistComparator();
      assertEquals(-1, artistComparator.compare(songs[0], songs[1]));
      assertEquals(1, artistComparator.compare(songs[1], songs[2]));
      assertEquals(-1, artistComparator.compare(songs[2], songs[3]));
      assertEquals(1, artistComparator.compare(songs[3], songs[4]));
      
   }

   @Test
   public void testLambdaTitleComparator()
   {
      Comparator<Song> titleComparator = (s1, s2) -> s1.getTitle().compareTo(s2.getTitle());
      assertTrue(titleComparator.compare(songs[0], songs[1]) > 0);
      assertTrue(titleComparator.compare(songs[1], songs[2]) < 0); 


   }

   @Test
   public void testYearExtractorComparator()
   {
      Comparator<Song> yearComparator = Comparator.comparing(Song::getYear).reversed();
      assertTrue(yearComparator.compare(songs[1], songs[2]) > 0); 
      assertTrue(yearComparator.compare(songs[7], songs[4]) > 0); 
   }

   @Test
   public void testComposedComparator()
   {
      Comparator<Song> titleComparator = (s1, s2) -> s1.getTitle().compareTo(s2.getTitle());
      Comparator<Song> yearComparator = Comparator.comparing(Song::getYear).reversed();
      Comparator<Song> composedComparator = new ComposedComparator(titleComparator, yearComparator);
      assertTrue(composedComparator.compare(songs[3],songs[7]) < 0);
      assertTrue(composedComparator.compare(songs[4],songs[5]) > 0);
   }

   @Test
   public void testThenComparing()
   {
      Comparator<Song> titleComparator = (Song song1, Song song2) -> song1.getTitle().compareTo(song2.getTitle());
      Comparator<Song> artistComparator = Comparator.comparing(Song::getArtist);
      Comparator<Song> songComparator = titleComparator.thenComparing(artistComparator);
      assertTrue(songComparator.compare(songs[3], songs[5]) > 0); 
   }
   
   @Test
   public void runSort()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Gerry Rafferty", "Baker Street", 1978),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005)
         );
         Comparator<Song> titleComparator = (Song song1, Song song2) -> song1.getTitle().compareTo(song2.getTitle());
         Comparator<Song> artistComparator = Comparator.comparing(Song::getArtist);
         Comparator<Song> yearComparator = Comparator.comparing(Song::getYear);
         Comparator<Song> songComparator = artistComparator.thenComparing(titleComparator).thenComparing(yearComparator);
      songList.sort(songComparator);
      //System.out.println(songList);

      assertEquals(songList, expectedList);
   }
   
}
