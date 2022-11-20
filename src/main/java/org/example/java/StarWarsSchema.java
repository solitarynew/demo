package org.example.java;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.io.File;
import java.util.Objects;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

public class StarWarsSchema {

    public static RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()

                // this uses builder function lambda syntax
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("hero", new StaticDataFetcher(StarWarsData.getArtoo()))
                        .dataFetcher("human", StarWarsData.getHumanDataFetcher())
                        .dataFetcher("droid", StarWarsData.getDroidDataFetcher())
                )
                .type("Human", typeWiring -> typeWiring
                        .dataFetcher("friends", StarWarsData.getFriendsDataFetcher())
                )
                // you can use builder syntax if you don't like the lambda syntax
                .type("Droid", typeWiring -> typeWiring
                        .dataFetcher("friends", StarWarsData.getFriendsDataFetcher())
                )
                // or full builder syntax if that takes your fancy
                .type(
                        newTypeWiring("Character")
                                .typeResolver(StarWarsData.getCharacterTypeResolver())
                                .build()
                )
                .build();
    }
    public static void main(String[] args) {
        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();

        File schemaFile = loadSchema("starWarsSchema.graphqls");

        TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, wiring);

        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        String query = "{hero {name appearsIn friends {name}}}";
        Object result = graphQL.execute(query).getData();
        System.out.println(result);
    }

    private static File loadSchema(String s) {
        // 从classpath中加载schema文件
        return new File(Objects.requireNonNull(StarWarsSchema.class.getClassLoader().getResource(s)).getFile());
    }
}
