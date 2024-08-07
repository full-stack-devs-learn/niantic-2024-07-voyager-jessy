package com.niantic.arraylists;

import java.util.ArrayList;

public class ArrayListDemos
{
    public static void main(String[] args)
    {
        ArrayList<String> names = new ArrayList<>(100); // this will set initial capacity at 100, can auto adjust if capacity met
        names.add("Thor");
        names.add("Iron Man");
        names.add("Deadpool"); // these will add to the end of the list
        names.add(1, "Captain America"); // because iaspecified the index, it will push CA into second slot


        for(int i = 0; i < names.size(); i++)
        {
            System.out.println(names.get(i));
        }
        for(String name: names)
        {
            System.out.println(names);
        }

    }
}
