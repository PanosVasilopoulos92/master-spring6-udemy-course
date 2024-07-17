package org.viators.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.viators.interfaces.Speakers;
import org.viators.model.Song;

@Component
@Primary
public class BoseSpeakers implements Speakers {

    public String makeSound(Song song){
        return "Playing the song "+ song.getTitle()+ " by "
                + song.getSingerName()+
                " with Bose speakers";
    }

}
