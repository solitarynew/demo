package org.example.java;

import graphql.schema.DataFetcher;
import graphql.schema.TypeResolver;

public class StarWarsData {
    public static Droid getArtoo() {
        return new Droid("2000", "Artoo", "Astromech", new Episode[]{Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI});
    }

    public static DataFetcher<Human> getHumanDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return new Human(id, "Luke Skywalker", "Tatooine", new Episode[]{Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI});
        };
    }

    public static DataFetcher<Droid> getDroidDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return new Droid(id, "R2-D2", "Astromech", new Episode[]{Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI});
        };
    }

    public static DataFetcher<Character[]> getFriendsDataFetcher() {
        return dataFetchingEnvironment -> {
            Character character = dataFetchingEnvironment.getSource();
            if (character instanceof Human) {
                return new Character[]{getArtoo()};
            } else {
                return new Character[]{new Human("1000", "Luke Skywalker", "Tatooine", new Episode[]{Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI})};
            }
        };
    }

    public static TypeResolver getCharacterTypeResolver() {
        return dataFetchingEnvironment -> {
            Object o = dataFetchingEnvironment.getObject();
            if (o instanceof Human) {
                return dataFetchingEnvironment.getSchema().getObjectType("Human");
            } else {
                return dataFetchingEnvironment.getSchema().getObjectType("Droid");
            }
        };
    }
}
