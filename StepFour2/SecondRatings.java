import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    public SecondRatings(String moviefile, String ratingsfile) {
        FirstRatings GreatOne=new FirstRatings();
        myMovies=GreatOne.loadMovies(moviefile);  
        myRaters=GreatOne.loadRaters(ratingsfile);
    }
    
    public int getMovieSize(){
        int NrofMoviesInList=0;       
        return NrofMoviesInList=myMovies.size();
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
        for (Movie s : myMovies) {
            //avgRatingOfAll=new ArrayList <Rating>();
            //Rater rater=new Rater(s.getID());
            if (getAverageByID(s.getID(),minimalRaters)==0.0){
             continue;   
            }
            Rating oneMovieArating=new Rating(s.getID(),getAverageByID(s.getID(),minimalRaters));            
            avgRatingOfAll.add(oneMovieArating);
        }         
        return avgRatingOfAll;
    }
    
    public String getTitle(String id){
        String title="the ID was not found";
        for (Movie s : myMovies) {
            if(s.getID()==id){
             title=s.getTitle();   
            }
        }
        return title;
    }
    
    public String getID(String title ){
                String id="NO SUCH TITLE.";
        for (Movie s : myMovies) {
            if(s.getTitle()==title){
             id=s.getID();   
            }
        }
        return id;        
    }
    
}
