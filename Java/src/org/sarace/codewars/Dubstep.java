package org.sarace.codewars;

public class Dubstep {

    public static String SongDecoder (String song)
    {
        return song.toUpperCase().replaceAll("(WUB)+", " ").trim();
    }
}
