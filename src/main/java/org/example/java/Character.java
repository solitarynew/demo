package org.example.java;

public interface Character {
    //     id: ID!
    //    name: String!
    //    friends: [Character]
    //    appearsIn: [Episode]!
    String getId();
    String getName();
    Character[] getFriends();
    Episode[] getAppearsIn();
}
