
public class DirectorsFilter implements Filter {
    public String Directors;
    public String[] convertD;
        public DirectorsFilter(String dir) {
        Directors = dir;
        convertD =Directors.split(",");
        
    }
    
    @Override
    public boolean satisfies(String id) {
            for (int i=0; i<convertD.length;i++){
                if (MovieDatabase.getDirector(id).indexOf(convertD[i])>=0){
                    return true;
                }
            }
          return false;
    }
}
