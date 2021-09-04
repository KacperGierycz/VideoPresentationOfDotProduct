
public class MinutesFilter implements Filter {
    public int minMin;
    public int minMax;
    	public MinutesFilter(int min, int max) {
		minMin = min;
		minMax = max;
	}
	
	@Override
	public boolean satisfies(String id) {
		 return MovieDatabase.getMinutes(id)>=minMin&&MovieDatabase.getMinutes(id)<=minMax;
	}
}
