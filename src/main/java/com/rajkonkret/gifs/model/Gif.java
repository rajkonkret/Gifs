package com.rajkonkret.gifs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // gettery settery hascode equals
@AllArgsConstructor // konstruktor ze wszystkimi argumentami
public class Gif {
    private String name;
    private String username;
    private Boolean favorite;
    private int categoryId;


}
