package org.example.java;

public class Droid implements Character{
//    id: ID!
//    name: String!
//    friends: [Character]
//    appearsIn: [Episode]!
//    homePlanet: String
    private String id;
    private String name;
    private Character[] friends;
    private Episode[] appearsIn;
    private String primaryFunction;

    public Droid(String id, String name, String primaryFunction, Episode[] appearsIn) {
        this.id = id;
        this.name = name;
        this.primaryFunction = primaryFunction;
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

    public String getPrimaryFunction() {
        return primaryFunction;
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

    public void setPrimaryFunction(String primaryFunction) {
        this.primaryFunction = primaryFunction;
    }
}
