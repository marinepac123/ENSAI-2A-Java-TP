package fr.ensai.mediaplayer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String lyrics = "Quand tout s'illumine\n" + //
                        "Dans tout Paris\n" + //
                        "Que les rues se vident\n" + //
                        "Je reste ici\n" + //
                        "\n" + //
                        "J'ai cherché ton amour\n" + //
                        "Dans tous les faubourgs\n" + //
                        "Je chante tous les jours\n" + //
                        "\n" + //
                        "Regarde moi, regarde toi\n" + //
                        "C'est ça l'amour, ça te foudroie\n" + //
                        "Regarde moi, regarde toi\n" + //
                        "C'est ça l'amour\n" + //
                        "Tu ne seras jamais perdu\n" + //
                        "\n" + //
                        "Allez viens, je peux t'emmener\n" + //
                        "Là ou c'est fort, fort de s'aimer\n" + //
                        "Allez viens, tu n'es pas fou\n" + //
                        "Dans ma poitrine, tu rythmes mon pouls\n" + //
                        "\n" + //
                        "Allez viens sous la pluie battante\n" + //
                        "Je dirai aux gens qu'il est présent\n" + //
                        "Je dirai aux femmes, aux hommes, aux enfants\n" + //
                        "Je dirais au monde dans chaque chanson\n" + //
                        "\n" + //
                        "J'ai cherché ton amour\n" + //
                        "Dans tous les faubourgs\n" + //
                        "Je chante tous les jours\n" + //
                        "\n" + //
                        "Regarde moi, regarde toi\n" + //
                        "C'est ça l'amour, ça te foudroie\n" + //
                        "Regarde moi, regarde toi\n" + //
                        "C'est ça l'amour\n" + //
                        "Tu ne seras jamais perdu\n" + //
                        "\n" + //
                        "C'est ça l'amour\n" + //
                        "Il est partout\n" + //
                        "Il est là, là, là\n" + //
                        "\n" + //
                        "Regarde moi, regarde toi\n" + //
                        "C’est ça l'amour, ça te foudroie\n" + //
                        "Regarde moi";
        String title = "Regarde !";
        Artist singer = new Artist("Monroe","","");
        int year = 2026;
        int duration = 180;
        Artist author = new Artist("Monroe","","");
        Artist composer = new Artist("Monroe","","");
        List<Genre> genres = new ArrayList<>();
        
        genres.add(Genre.Pop);
        genres.add(Genre.Classique);


        Song eurovision_2026 = new Song(title = title,
        singer = singer,
        year = year,
        duration = duration,
        lyrics = lyrics,
        author = author,
        composer= composer,
        genres = genres);

        eurovision_2026.play();
    }

}
