import java.util.*;
public class MovieRunnerSimilarRatings {
    void printAverageRatings(){
        FourthRatings GreaterOne =new FourthRatings();
        //System.out.println(GreaterOne.getRaterSize());
        ArrayList <Rating> avgRatingOfAll;
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());

        int minimalRaters=35;
        
        avgRatingOfAll=GreaterOne.MovieWratingList(minimalRaters);
        Collections.sort(avgRatingOfAll);
        int howMany=0;
        for (Rating s : avgRatingOfAll){
            System.out.println(MovieDatabase.getTitle(s.getItem())+" "+ s.getValue());        
            howMany=howMany+1;
        }
        System.out.println("howManyratings "+ howMany);
        System.out.println("movies.size() "+movies.size());
        //System.out.println("getRaterSize() "+GreaterOne.getRaterSize());
    }
    void printAverageRatingsByYearAfterAndGenre(){
        FourthRatings GreaterOne =new FourthRatings();
        //System.out.println(GreaterOne.getRaterSize());
        ArrayList <Rating> avgRatingOfAll;
        //ArrayList<String> movies = MovieDatabase.filterBy(new YearAfterFilter(2000));
        int minimalRaters=8;        
        AllFilters maf = new AllFilters();
        maf.addFilter(new YearAfterFilter(1990));
        maf.addFilter(new GenreFilter("Drama"));        
        
        avgRatingOfAll=GreaterOne.getAverageRatingsByFilter(minimalRaters,maf);
        Collections.sort(avgRatingOfAll);
        int howMany=0;
        for (Rating s : avgRatingOfAll){
            System.out.println(MovieDatabase.getTitle(s.getItem())+" "+ s.getValue()+" ");        
            System.out.print(" "+MovieDatabase.getGenres(s.getItem()));
            System.out.print(" "+MovieDatabase.getMinutes(s.getItem()));
            System.out.println(" "+MovieDatabase.getDirector(s.getItem()));
            howMany=howMany+1;
        }
        System.out.println("howManyratings "+ howMany);
        //System.out.println("movies.size() "+movies.size());
        //System.out.println("getRaterSize() "+GreaterOne.getRaterSize());        
    }
    void printSimilarRatings (){
        FourthRatings GreaterOne =new FourthRatings();
        RaterDatabase raters=new RaterDatabase();
       raters.initialize("ratings.csv");
        MovieDatabase movies =new MovieDatabase();
        ArrayList<Rating>similars = GreaterOne.getSimilarRatings("71",5,20);
        for (Rating s:similars){
            System.out.println(s.getItem()+" "+s.getValue());        
        }
    }
    void printSimilarRatingsByGenre (){
        FourthRatings GreaterOne =new FourthRatings();
        RaterDatabase raters=new RaterDatabase();
       raters.initialize("ratings.csv");
        MovieDatabase movies =new MovieDatabase();
        // ArrayList<String> moviesFilter = MovieDatabase.filterBy(new GenreFilter("Action"));
        ArrayList<Rating>similars = GreaterOne.getSimilarRatingsByFilter("964",5,20,new GenreFilter("Mystery"));
        for (Rating s:similars){
            System.out.println(movies.getTitle(s.getItem())+" "+s.getValue());        
            System.out.println(movies.getGenres(s.getItem()));
        }
    }
    void printSimilarRatingsByDirector(){
            FourthRatings GreaterOne =new FourthRatings();
        RaterDatabase raters=new RaterDatabase();
       raters.initialize("ratings.csv");
        MovieDatabase movies =new MovieDatabase();
        // ArrayList<String> moviesFilter = MovieDatabase.filterBy(new GenreFilter("Action"));
        ArrayList<Rating>similars = GreaterOne.getSimilarRatingsByFilter("120",2,10,new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh"));
        for (Rating s:similars){
            System.out.println(movies.getTitle(s.getItem())+" "+s.getValue());        
            //System.out.println(movies.getGenres(s.getItem()));
            System.out.println(movies.getDirector(s.getItem()));
        }
    }
    void printSimilarRatingsByGenreAndMinutes (){
    FourthRatings GreaterOne =new FourthRatings();
        RaterDatabase raters=new RaterDatabase();
       raters.initialize("ratings.csv");
        MovieDatabase movies =new MovieDatabase();
                AllFilters maf = new AllFilters();
        maf.addFilter(new MinutesFilter(80,160));
        maf.addFilter(new GenreFilter("Drama")); 
        // ArrayList<String> moviesFilter = MovieDatabase.filterBy(new GenreFilter("Action"));
        ArrayList<Rating>similars = GreaterOne.getSimilarRatingsByFilter("168",3,10,maf);
        for (Rating s:similars){
            System.out.println(movies.getTitle(s.getItem())+" "+s.getValue()+" "+movies.getMinutes(s.getItem()));        
            System.out.println(movies.getGenres(s.getItem()));
            //System.out.println(movies.getDirector(s.getItem()));
        }
    }
    void printSimilarRatingsByYearAfterAndMinutes (){
            FourthRatings GreaterOne =new FourthRatings();
        RaterDatabase raters=new RaterDatabase();
       raters.initialize("ratings.csv");
        MovieDatabase movies =new MovieDatabase();
                AllFilters maf = new AllFilters();
        maf.addFilter(new MinutesFilter(70,200));
        maf.addFilter(new YearAfterFilter(1975)); 
        // ArrayList<String> moviesFilter = MovieDatabase.filterBy(new GenreFilter("Action"));
        ArrayList<Rating>similars = GreaterOne.getSimilarRatingsByFilter("314",5,10,maf);
        for (Rating s:similars){
            System.out.println(movies.getTitle(s.getItem())+" "+s.getValue()+" "+movies.getMinutes(s.getItem()));        
            //System.out.println(movies.getGenres(s.getItem()));
            //System.out.println(movies.getDirector(s.getItem()));
            System.out.println(movies.getYear(s.getItem()));
        }
    }

    
}
