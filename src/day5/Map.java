package day5;

import java.util.ArrayList;

public class Map {
    private ArrayList<Long> destinationStarts;
    private ArrayList<Long> sourceStarts;
    private ArrayList<Long> ranges;
    
    public Map(ArrayList<Long> d, ArrayList<Long> s, ArrayList<Long> r) {
        destinationStarts = d;
        sourceStarts = s;
        ranges = r;
    }
    
    public long sourceToDestination(long source) {
        for (int i = 0; i < ranges.size(); i++) {
            if (source >= sourceStarts.get(i) && source < sourceStarts.get(i) + ranges.get(i)) {
                return destinationStarts.get(i) + (source - sourceStarts.get(i));
            }
        }
        return source;
    }
}
