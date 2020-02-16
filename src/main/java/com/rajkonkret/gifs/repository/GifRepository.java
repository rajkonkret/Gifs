package com.rajkonkret.gifs.repository;

import com.rajkonkret.gifs.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class GifRepository {
    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion","mols",true, 1),
            new Gif("ben-and-mike","mika",true, 2),
            new Gif("book-dominos","mem",true, 0),
            new Gif("compiler-bot","bot",true, 1),
            new Gif("cowboy-coder","code",true, 1),
            new Gif("infinite-andrew","andrew",false, 2)
    );
    public List<Gif> getAllGifs(){
        return ALL_GIFS;
    }

    public String getGifsNames(){
        return ALL_GIFS.stream().map(s -> s.getName()).collect(Collectors.joining(" , "));
    }

    public List<Gif> getAllFavoritesGifs(){
        return ALL_GIFS.stream()
                //.filter( s -> s.getFavorite()==true).collect(Collectors.toList());}
                .filter( s -> s.getFavorite()).collect(Collectors.toList());
    }

    public Optional<Gif> getGifBYName(String name){
        return ALL_GIFS.stream()
                .filter(s -> s.getName().equals(name))
                .findAny();

    }
}
