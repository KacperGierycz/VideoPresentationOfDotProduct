import java.util.*;
public class MovieRunnerAverage {
    
    void printAverageRatings(){
        ThirdRatings GreaterOne =new ThirdRatings( "ratings.csv");
        ArrayList <Rating> avgRatingOfAll;
        //ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        int minimalRaters=12;
        
        avgRatingOfAll=GreaterOne.MovieWratingList(minimalRaters);
        Collections.sort(avgRatingOfAll);
        int howMany=0;
        for (Rating s : avgRatingOfAll){
            System.out.println(MovieDatabase.getTitle(s.getItem())+" "+ s.getValue());        
            howMany=howMany+1;
        }
        System.out.println(howMany);
    }
    
    void getAverageRatingOneMovie(){
        ThirdRatings GreaterOne =new ThirdRatings("ratings.csv");
        String targetMOvie="Vacation";
        ArrayList <Rating> avgRatingOfAll;
        
        int minimalRaters=3;
        
        avgRatingOfAll=GreaterOne.MovieWratingList(minimalRaters);  
        for (Rating s : avgRatingOfAll){
            if(MovieDatabase.getTitle(s.getItem()).equals(targetMOvie)){
                System.out.println(MovieDatabase.getTitle(s.getItem())+"Rating "+s.getValue());      
            }

              
        }
    }
    
}
