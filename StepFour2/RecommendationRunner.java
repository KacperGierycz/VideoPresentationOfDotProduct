import java.util.*;
public class RecommendationRunner implements Recommender {

    public ArrayList<String> getItemsToRate(){
        FourthRatings GreaterOne =new FourthRatings();
        ArrayList <Rating> avgRatingOfAll;

        int minimalRaters=20;        
        avgRatingOfAll=GreaterOne.getAverageRatingsByFilter(minimalRaters,new YearAfterFilter(2005));
        Collections.sort(avgRatingOfAll,Collections.reverseOrder());       
        ArrayList<String> recomendationsMID=new ArrayList<String>();

        int i=0;
                for (Rating s : avgRatingOfAll){                    
                    if (i==20){break;}
                    recomendationsMID.add(s.getItem());                    
                    i++;
                } 
                return recomendationsMID;
    }
    
    public void printRecommendationsFor(String webRaterID){
        MovieDatabase moviesD = new MovieDatabase();
       
        FourthRatings GreaterOne =new FourthRatings();        
        ArrayList<Rating> moviesWaverage=new ArrayList<Rating>();
        moviesWaverage=GreaterOne.getSimilarRatingsByFilter(webRaterID, 2, 5,new YearAfterFilter(2001));        
        ArrayList<String> recomendationsMID=getItemsToRate();
        ArrayList<String>Mtitlestocros =new ArrayList<String>();
        ArrayList<String>Mtitles =new ArrayList<String>();

        for (String s:recomendationsMID){            
            moviesWaverage.get(1);
            Mtitlestocros.add(moviesD.getTitle(s));
            //System.out.println(s);
        }

        for (Rating toTitle:moviesWaverage){
            Mtitles.add(toTitle.getItem());
            //System.out.println(toTitle);
        }
        for (String title1:recomendationsMID){
            if  (Mtitles.contains(title1)){
             Mtitles.remove(title1);
             //System.out.println(title1+"removing");
            }
        }                

            int i=0;
        System.out.println("<!DOCTYPE html><html>\r<head>\r<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r<style>\r* {\r  box-sizing: border-box;\r"+
            "}.menu {\r  float:left;\r  width:100%;\r  text-align:center;\r}\rimg{ width:48px;\rheight:58px;}\r  .menu a {\r  background-color:tomato;\r  padding:8px;\r  margin-top:7px;\r  display:block;"+
                "  width:100%;\r  color:black;\r}\r@media only screen and (max-width:620px) {\r  /* For mobile phones: */\r  .menu, .main, .right {\r    width:100%;"+
                    "  }\r}\r</style>\r</head>\r<body style=\"ont-family:Verdana;color:black;\">\r<div style=\"background-color:tomato;padding:15px;text-align:center;\">"+
                    "  <h1>Movies recomended for You!!: </h1>\r</div>\r<div style=\"overflow:auto\">\r  <div class=\"menu\">\r");
                        if (Mtitles.size()<=0){
             System.out.println("<a>"+"There is no movie to recommend for your criteria try to check more movies"+"</a>");
            } 
                for (String r:Mtitles){                  
            if (i==15){break;}
            if (r.length()<1){break;}
            System.out.println("<a href=https://www.imdb.com/title/tt"+r+"><img src=http://www.dukelearntoprogram.com/capstone/data/"+moviesD.getPoster(r).substring(6)+"><b>"+"\t"+""+moviesD.getTitle(r)+
            ";\t"+moviesD.getYear(r)+";\t"+moviesD.getGenres(r)+"</b></a>");            
            i++;
        }        
        System.out.println("</div>");
    }
}

