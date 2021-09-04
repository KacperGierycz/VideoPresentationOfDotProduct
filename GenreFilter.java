
public class GenreFilter implements Filter {
    public String Genre;
    	public GenreFilter(String genre) {
		Genre = genre;
	}
	
	@Override
	public boolean satisfies(String id) {
		 if (MovieDatabase.getGenres(id).indexOf(Genre)>=0){
		    return true;
		  }
		  return false;
	}
}
