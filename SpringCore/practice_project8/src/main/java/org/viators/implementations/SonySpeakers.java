package org.viators.implementations;

import org.springframework.stereotype.Component;
import org.viators.interfaces.Speakers;
import org.viators.model.Song;

@Component
public class SonySpeakers implements Speakers {

    public String makeSound(Song song){
        return "Playing the song "+ song.getTitle()+ " by "
                + song.getSingerName()+
                " with Sony speakers";
    }

}