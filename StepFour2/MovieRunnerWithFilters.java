import java.util.*;
public class MovieRunnerWithFilters {
    void printAverageRatings(){
        ThirdRatings GreaterOne =new ThirdRatings("ratings.csv");
        System.out.println(GreaterOne.getRaterSize());
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
        System.out.println("getRaterSize() "+GreaterOne.getRaterSize());
    }
    void printAverageRatingsByYear(){
                ThirdRatings GreaterOne =new ThirdRatings("ratings.csv");
        //System.out.println(GreaterOne.getRaterSize());
        ArrayList <Rating> avgRatingOfAll;
        //ArrayList<String> movies = MovieDatabase.filterBy(new YearAfterFilter(2000));
        int minimalRaters=20;        
        avgRatingOfAll=GreaterOne.getAverageRatingsByFilter(minimalRaters,new YearAfterFilter(2000));
        Collections.sort(avgRatingOfAll);
        int howMany=0;
        for (Rating s : avgRatingOfAll){
            System.out.println(MovieDatabase.getTitle(s.getItem())+" "+ s.getValue());        
            howMany=howMany+1;
        }
        System.out.println("howManyratings "+ howMany);
        //System.out.println("movies.size() "+movies.size());
        System.out.println("getRaterSize() "+GreaterOne.getRaterSize());
    }
    void printAverageRatingsByGenre(){
                        ThirdRatings GreaterOne =new ThirdRatings("ratings.csv");
        //System.out.println(GreaterOne.getRaterSize());
        ArrayList <Rating> avgRatingOfAll;
        //ArrayList<String> movies = MovieDatabase.filterBy(new YearAfterFilter(2000));
        int minimalRaters=20;        
        avgRatingOfAll=GreaterOne.getAverageRatingsByFilter(minimalRaters,new GenreFilter("Comedy"));
        Collections.sort(avgRatingOfAll);
        int howMany=0;
        for (Rating s : avgRatingOfAll){
            System.out.println(MovieDatabase.getTitle(s.getItem())+" "+ s.getValue());        
            System.out.println(MovieDatabase.getGenres(s.getItem()));
            howMany=howMany+1;
        }
        System.out.println("howManyratings "+ howMany);
        //System.out.println("movies.size() "+movies.size());
        System.out.println("getRaterSize() "+GreaterOne.getRaterSize());
        
    }
       void printAverageRatingsByMinutes(){
                        ThirdRatings GreaterOne =new ThirdRatings("ratings.csv");
        //System.out.println(GreaterOne.getRaterSize());
        ArrayList <Rating> avgRatingOfAll;
        //ArrayList<String> movies = MovieDatabase.filterBy(new YearAfterFilter(2000));
        int minimalRaters=5;        
        avgRatingOfAll=GreaterOne.getAverageRatingsByFilter(minimalRaters,new MinutesFilter(105,135));
        Collections.sort(avgRatingOfAll);
        int howMany=0;
        for (Rating s : avgRatingOfAll){
            System.out.println(MovieDatabase.getTitle(s.getItem())+" "+ s.getValue()+" ");        
            System.out.print(" "+MovieDatabase.getGenres(s.getItem()));
            System.out.print(" "+MovieDatabase.getMinutes(s.getItem()));
            howMany=howMany+1;
        }
        System.out.println(" howManyratings "+ howMany);
        //System.out.println("movies.size() "+movies.size());
        System.out.println(" getRaterSize() "+GreaterOne.getRaterSize());
        
    }
           void printAverageRatingsByDirectors(){
                        ThirdRatings GreaterOne =new ThirdRatings("ratings.csv");
        //System.out.println(GreaterOne.getRaterSize());
        ArrayList <Rating> avgRatingOfAll;
        //ArrayList<String> movies = MovieDatabase.filterBy(new YearAfterFilter(2000));
        int minimalRaters=4;        
        avgRatingOfAll=GreaterOne.getAverageRatingsByFilter(minimalRaters,new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
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
        System.out.println("getRaterSize() "+GreaterOne.getRaterSize());
        
    }
    void printAverageRatingsByYearAfterAndGenre(){
                                ThirdRatings GreaterOne =new ThirdRatings("ratings.csv");
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
        System.out.println("getRaterSize() "+GreaterOne.getRaterSize());
        
    }
        void printAverageRatingsByDirectorsAndMinutes (){
                                ThirdRatings GreaterOne =new ThirdRatings("ratings.csv");
        //System.out.println(GreaterOne.getRaterSize());
        ArrayList <Rating> avgRatingOfAll;
        //ArrayList<String> movies = MovieDatabase.filterBy(new YearAfterFilter(2000));
        int minimalRaters=3;        
        AllFilters maf = new AllFilters();
        maf.addFilter(new MinutesFilter(90,180));
        maf.addFilter(new DirectorsFilter( "Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        
        
        
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
        System.out.println("getRaterSize() "+GreaterOne.getRaterSize());
        
    }
    
}
