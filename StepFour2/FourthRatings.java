import java.util.*;
public class FourthRatings {
    
    private double getAverageByID(String id, int minimalRaters){
        double averageRating=0.0;
        int nrOfRates=0;        
        RaterDatabase raters=new RaterDatabase();
        raters.initialize("ratings.csv");
        ArrayList<Rater> myRaters= raters.getRaters();

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
        public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria){
       ArrayList <Rating> avgRatingOfAll=new ArrayList <Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);       
       // movies = MovieDatabase.filterBy(new TrueFilter());    
        for (String s : movies) {
            if (getAverageByID(s,minimalRaters)==0.0){
             continue;   
            }
            Rating oneMovieArating=new Rating(s,getAverageByID(s,minimalRaters));            
            avgRatingOfAll.add(oneMovieArating);
        }         
        return avgRatingOfAll;        
    }
    private double dotProduct(Rater me, Rater r){
        double dot=0;
       ArrayList<String> items=me.getItemsRated();       
     for( String s: items){
         if (r.getItemsRated().contains(s)){
             dot=dot+(me.getRating(s)-5)*(r.getRating(s)-5);
            }
        }        
        return dot;
    }
    private ArrayList<Rating> getSimilarities(String id){
       ArrayList<Rating> listRaterIdDotP=new ArrayList<Rating>();
        RaterDatabase raters=new RaterDatabase();
        raters.initialize("ratings.csv");
        ArrayList<Rater> myRaters= raters.getRaters();
        for (Rater s : myRaters) {
           if((!id.equals(s.getID()))&&((dotProduct(raters.getRater(id),s))>0)){
               //System.out.println("dotProduct(raters.getRater(id),s)"+dotProduct(raters.getRater(id),s));
               Rating oneMovieArating=new Rating(s.getID(), dotProduct(raters.getRater(id),s));
               listRaterIdDotP.add(oneMovieArating);
            }
        }
       Collections.sort(listRaterIdDotP,Collections.reverseOrder());
       //System.out.println(listRaterIdDotP);
       return listRaterIdDotP;
    }     
    
     public ArrayList<Rating> getSimilarRatings(String id, int minimalRaters, int numSimilarRaters){
       ArrayList <Rating> moviesWaverage=new ArrayList <Rating>();       
       RaterDatabase raters=new RaterDatabase();
       raters.initialize("ratings.csv");
       ArrayList<Rater> myRaters1= raters.getRaters();       
       ArrayList<Rating> listRaterIdDotP=getSimilarities(id);   
       ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());       
       double averageW=0.0;
       int howManySimilarRaters=0;
       for (String m: movies){
            howManySimilarRaters=0;
            averageW=0.0;
            for (int i=0; i< numSimilarRaters;i++){
                String rId=listRaterIdDotP.get(i).getItem();
                Rater topSimillarOne=raters.getRater(rId);
                ArrayList<String>moviesOfSimilarOne=topSimillarOne.getItemsRated();
                if(moviesOfSimilarOne.contains(m)){
                    howManySimilarRaters=howManySimilarRaters+1;                    
                }                
            }
            if (howManySimilarRaters>=minimalRaters){
                int i=0;       
                int howManySimiliars=0;
                for (i=0; i<numSimilarRaters; i++){
                String rId=listRaterIdDotP.get(i).getItem();
                Rater topSimillarOne=raters.getRater(rId);
                ArrayList<String>moviesOfSimilarOne=topSimillarOne.getItemsRated();
                if(moviesOfSimilarOne.contains(m)){
                    averageW=averageW+(listRaterIdDotP.get(i).getValue())*
                    (RaterDatabase.getRater(listRaterIdDotP.get(i).getItem()).getRating(m)); 
                    howManySimiliars=howManySimiliars+1;
                }   
                }
                averageW=averageW/howManySimiliars;
                Rating oneMovieArating=new Rating(MovieDatabase.getTitle(m), averageW);
                moviesWaverage.add(oneMovieArating);
        }
        }
        Collections.sort(moviesWaverage,Collections.reverseOrder());
        return moviesWaverage;        
    }
    
        public ArrayList<Rating> getSimilarRatingsByFilter(String id, int minimalRaters,
        int numSimilarRaters,Filter filterCriteria ){
       ArrayList <Rating> moviesWaverage=new ArrayList <Rating>();       
       RaterDatabase raters=new RaterDatabase();
       raters.initialize("ratings.csv");
       ArrayList<Rater> myRaters1= raters.getRaters();       
       ArrayList<Rating> listRaterIdDotP=getSimilarities(id);  
       ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());      
       movies=MovieDatabase.filterBy(filterCriteria);
       
       double averageW=0.0;
       int howManySimilarRaters=0;
       for (String m: movies){
            howManySimilarRaters=0;
            averageW=0.0;
            for (int i=0; i< numSimilarRaters;i++){
                String rId=listRaterIdDotP.get(i).getItem();
                Rater topSimillarOne=raters.getRater(rId);
                ArrayList<String>moviesOfSimilarOne=topSimillarOne.getItemsRated();
                if(moviesOfSimilarOne.contains(m)){
                    howManySimilarRaters=howManySimilarRaters+1;                    
                }                
            }
            if (howManySimilarRaters>=minimalRaters){
                int i=0;       
                int howManySimiliars=0;
                for (i=0; i<numSimilarRaters; i++){
                String rId=listRaterIdDotP.get(i).getItem();
                Rater topSimillarOne=raters.getRater(rId);
                ArrayList<String>moviesOfSimilarOne=topSimillarOne.getItemsRated();
                if(moviesOfSimilarOne.contains(m)){
                    averageW=averageW+(listRaterIdDotP.get(i).getValue())*
                    (RaterDatabase.getRater(listRaterIdDotP.get(i).getItem()).getRating(m)); 
                    howManySimiliars=howManySimiliars+1;
                }   
                }
                averageW=averageW/howManySimiliars;
                Rating oneMovieArating=new Rating(m, averageW);
                moviesWaverage.add(oneMovieArating);
        }
        }
        Collections.sort(moviesWaverage,Collections.reverseOrder());
        return moviesWaverage;        
    }
    
    
}