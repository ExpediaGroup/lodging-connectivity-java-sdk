package com.expediagroup.sdk.graphql.exemplar;

import com.expediagroup.sdk.core.logging.LoggerDecorator;
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline;
import com.expediagroup.sdk.core.pipeline.step.RequestHeadersStep;
import com.expediagroup.sdk.core.pipeline.step.RequestLoggingStep;
import com.expediagroup.sdk.core.pipeline.step.ResponseLoggingStep;
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor;
import com.expediagroup.sdk.okhttp.OkHttpTransport;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestExecutor extends AbstractRequestExecutor {
    private final ExecutionPipeline executionPipeline;
    private final static Logger logger = LoggerFactory.getLogger(RequestExecutor.class);

    public RequestExecutor() {
        super(getOkHttpTransport());
        LoggerDecorator loggerDecorator = new LoggerDecorator(logger);

        executionPipeline = new ExecutionPipeline(
                List.of(
                        new RequestHeadersStep(),
                        new RequestLoggingStep(loggerDecorator, null)
                ),
                List.of(
                        new ResponseLoggingStep(loggerDecorator)
                )
        );
    }

    @NotNull
    @Override
    public ExecutionPipeline getExecutionPipeline() {
        return executionPipeline;
    }

    private static OkHttpTransport getOkHttpTransport() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(1000);
        dispatcher.setMaxRequestsPerHost(1000);

        ConnectionPool connectionPool = new ConnectionPool(1000, 5, TimeUnit.MINUTES);

        OkHttpClient client = new OkHttpClient.Builder().dispatcher(dispatcher).connectionPool(connectionPool).build();

        return new OkHttpTransport(client);
    }

}
