import java.util.*;

public class ThirdRatings {
    //private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    public ThirdRatings(String ratingsfile) {
        FirstRatings GreatOne=new FirstRatings();
        //myMovies=GreatOne.loadMovies(moviefile);  
        myRaters=GreatOne.loadRaters(ratingsfile);
    }
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria){
       ArrayList <Rating> avgRatingOfAll=new ArrayList <Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for (String s : movies) {
            if (getAverageByID(s,minimalRaters)==0.0){
             continue;   
            }
            Rating oneMovieArating=new Rating(s,getAverageByID(s,minimalRaters));            
            avgRatingOfAll.add(oneMovieArating);
        }         
        return avgRatingOfAll;
        
    }
    
    
    public int getRaterSize(){
        int NrofRatersInList=0;       
        return NrofRatersInList=myRaters.size();
    }
    
    private double getAverageByID(String id, int minimalRaters){
        double averageRating=0.0;
        int nrOfRates=0;        
        for (Rater s : myRaters) {
            if(s.getItemsRated().contains(id)){
                averageRating=averageRating+s.getRating(id);
                nrOfRates=nrOfRates+1;
            }
        }         
        if (nrOfRates<minimalRaters){
         return 0.0;   
        }
        return averageRating/nrOfRates;
    }
    
    public ArrayList <Rating> MovieWratingList(int minimalRaters){
        ArrayList <Rating> avgRatingOfAll=new ArrayList <Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for (String s : movies) {
            if (getAverageByID(s,minimalRaters)==0.0){
             continue;   
            }
            Rating oneMovieArating=new Rating(s,getAverageByID(s,minimalRaters));            
            avgRatingOfAll.add(oneMovieArating);
        }         
        return avgRatingOfAll;
    }
    
    
    
}
