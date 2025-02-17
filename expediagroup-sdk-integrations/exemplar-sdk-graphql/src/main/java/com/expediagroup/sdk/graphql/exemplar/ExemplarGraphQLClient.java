package com.expediagroup.sdk.graphql.exemplar;

import com.apollographql.apollo.api.Operation;
import com.expediagroup.sdk.graphql.GraphQLClient;
import com.expediagroup.sdk.graphql.GraphQLExecutor;
import com.expediagroup.sdk.graphql.model.RawResponse;
import org.jetbrains.annotations.NotNull;

public class ExemplarGraphQLClient extends GraphQLClient {
    private final String SERVER_URL = "http://localhost:8081/graphql/small/500ms-delay";
    private final GraphQLExecutor graphQLExecutor = new GraphQLExecutor(new RequestExecutor(), SERVER_URL);

    @NotNull
    @Override
    protected GraphQLExecutor getGraphQLExecutor() {
        return graphQLExecutor;
    }

    public <T extends Operation.Data> RawResponse<T> execute(Operation<T> operation) {
        return graphQLExecutor.execute(operation);
    }
}
