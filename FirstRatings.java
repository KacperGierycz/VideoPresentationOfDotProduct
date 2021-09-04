import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {

    public ArrayList<Movie> loadMovies(String filename){
        ArrayList<Movie> movieList=new ArrayList<Movie>();
        String source=
        "C:/Users/Dom/Desktop/JavaBJProject/CapstoneProjectRatingMovies/StepOne/data/";
        FileResource fr= new FileResource(filename);
        //CSVParser parser = CSVParser.parse(fr,CSVFormat.RFC4180);
        CSVParser parser=fr.getCSVParser();
        for (CSVRecord currentRow : parser){
           //(String anID, String aTitle, String aYear, String theGenres, String aDirector,String aCountry, String aPoster, int theMinutes) {
           // id,title,year,country,genre,director,minutes,poster
           //Integer testMin=Integer.parseInt(currentRow.get("minutes"));
           String minutesS= currentRow.get("minutes");
           Integer minutes= Integer.parseInt(minutesS.trim());
           Movie record= new Movie (currentRow.get("id"), currentRow.get("title"), currentRow.get("year"), currentRow.get("genre"),currentRow.get("director"),currentRow.get("country"),currentRow.get("poster"),minutes);
           movieList.add(record);
        }
      
        //System.out.println(movieList);
        return movieList;
    }
    
    public ArrayList<Rater> loadRaters (String filename){
        ArrayList<Rater>raterList=new ArrayList<Rater>();
        HashMap<String,Rating> myRatings;     
        String source=        
        "C:/Users/Dom/Desktop/JavaBJProject/CapstoneProjectRatingMovies/StepOne/data/";
         FileResource fr= new FileResource(source+filename);
         CSVParser parser=fr.getCSVParser();
         for (CSVRecord currentRow : parser){              
             if( currentRow==null){
                 continue;
                }
             String iD=currentRow.get("rater_id");
             String movieId=currentRow.get("movie_id");
             double rating=Double.parseDouble(currentRow.get("rating"));
             Rater rater=new EfficientRater(iD);
             if (raterList.size()==0){                 
                 rater.addRating(movieId, rating);
                 raterList.add(rater);
                 continue;
                }             
                  int isIDin=0;
                 for (Rater raterFor : raterList) {   
                     //System.out.println(raterFor.getID());
                    //System.out.println(rater.getID());
                    if(rater.getID().equals(raterFor.getID())){
                        raterFor.addRating(movieId, rating);
                        isIDin=1; 
                        break;
                    }                 
                } 
                if(isIDin==0){   
                    myRatings=new HashMap<String,Rating>();
                    rater.addRating(movieId, rating);
                    raterList.add(rater);                    
                    continue;
                }
            }
        return raterList;
    }
    
        void testloadRaters(){
        //ArrayList<Rater>raterList=new ArrayList<Rater>();
        //loadRaters("ratings.csv");
        ArrayList<Rater>raterList=loadRaters("ratings.csv");
        ArrayList<Rating> myRatings;
        ArrayList<String> MoviesOfRater=new ArrayList<String>();
        ArrayList<String> Movies=new ArrayList<String>();
        int nrOfRates=0;
        String targetRater="193";//////Uzupełnić!!!!!!!!!
        int MaxFreqRater=0;
        String MaxFreqRaterIs="";
        String Movie="1798709";
        int countMovie=0;
        int howManyUniqueM=0;
        for (Rater raterFor : raterList) {
            System.out.println(raterFor.getID()+raterFor.getItemsRated());
            if(raterFor.getID().equals(targetRater)){
                nrOfRates=raterFor.getItemsRated().size();
            }
            if (MaxFreqRater<raterFor.getItemsRated().size()){
                MaxFreqRater=raterFor.getItemsRated().size();
                MaxFreqRaterIs=raterFor.getID();
            }
            if (raterFor.getItemsRated().indexOf(Movie)>-1){
                countMovie=countMovie+1;
            }
            MoviesOfRater=raterFor.getItemsRated();
            for (int i=0; i< MoviesOfRater.size();i++){
                if ((Movies.size()==0)||(!Movies.contains(MoviesOfRater.get(i)))){
                Movies.add(raterFor.getItemsRated().get(i));
                howManyUniqueM=howManyUniqueM+1;
            }
            }            
            //currentRow.get("director"),currentRow.get("country"), currentRow.get("poster"), currentRow.get("minutes")
        }
        System.out.println("MaxFreqRaterIs "+MaxFreqRaterIs+" with " +MaxFreqRater );
        System.out.println("nrOfRatesOf "+targetRater+" is "+nrOfRates);
        System.out.println("countMovie"+Movie+"is " +countMovie);
        System.out.println(Movies.size()+" "+Movies.toString());
        System.out.println("howManyUniqueM "+howManyUniqueM);
    }
    
    void testLoadMovies(){
        ArrayList<Movie> movieList=loadMovies("ratedmoviesfull.csv");
        //System.out.println(movieList.size());
        int comedysNr=0;
        int minutesM150=0;
        HashMap<String, Integer> directors = new HashMap<String, Integer>();
        for (Movie s : movieList){
            if(s.getGenres().indexOf("Comedy")>-1){
                comedysNr=comedysNr+1;
            }
            if(s.getMinutes()>150){
                minutesM150=minutesM150+1;
            }
            String director=s.getDirector();
            int nrOfD=0;
            if( !directors.containsKey(director)){
             directors.put(director,nrOfD=1);
            }
            else{
                nrOfD=directors.get(director);
                directors.put(director,nrOfD+1);
                
            }            
            //System.out.println(s);            
        }

        int currMax=0;   
        String DirectorWhoHasMaxFilms="";
        for (String s : directors.keySet()) {
            System.out.println(s+"nr of movies " +directors.get(s));    
            if (currMax<directors.get(s)){
                currMax=directors.get(s);
                DirectorWhoHasMaxFilms=s;
            }
        }         
        int MaxNrOfMofNr=1;
        int howManyMoviesDirecrorD=0;    
        for(Integer s : directors.values()) {
            if (s==1){                
                howManyMoviesDirecrorD=howManyMoviesDirecrorD+1;
                
            }

        }
        System.out.println("comedysNr: "+comedysNr);
        System.out.println("minutesM150: "+minutesM150);
        System.out.println("howManyMoviesDirecrorD of  "+MaxNrOfMofNr+" cout " +howManyMoviesDirecrorD);
        System.out.println("DirectorWhoHasMaxFilms "+DirectorWhoHasMaxFilms+" made "+currMax);
    }
    
}
