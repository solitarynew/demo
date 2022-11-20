package org.example.java;

public class Human implements Character {
    //    id: ID!
    //    name: String!
    //    friends: [Character]
    //    appearsIn: [Episode]!
    //    homePlanet: String
    private String id;
    private String name;
    private Character[] friends;
    private Episode[] appearsIn;
    private String homePlanet;

    public Human(String id, String name, String homePlanet, Episode[] appearsIn) {
        this.id = id;
        this.name = name;
        this.homePlanet = homePlanet;
        this.appearsIn = appearsIn;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character[] getFriends() {
        return friends;
    }

    public Episode[] getAppearsIn() {
        return appearsIn;
    }

    public String getHomePlanet() {
        return homePlanet;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFriends(Character[] friends) {
        this.friends = friends;
    }

    public void setAppearsIn(Episode[] appearsIn) {
        this.appearsIn = appearsIn;
    }

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }
}
