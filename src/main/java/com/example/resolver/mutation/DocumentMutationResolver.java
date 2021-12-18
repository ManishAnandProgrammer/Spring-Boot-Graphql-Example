package com.example.resolver.mutation;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.util.List;

@Component
public class DocumentMutationResolver implements GraphQLMutationResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentMutationResolver.class);
    
    public Integer uploadStudentDocument(DataFetchingEnvironment dataFetchingEnvironment) {
        DefaultGraphQLServletContext context = dataFetchingEnvironment.getContext();
        List<Part> fileParts = context.getFileParts();
        fileParts.forEach(part -> {
            LOGGER.info("file name: {} ,file size: {} ", part.getSubmittedFileName(), part.getSize());
        });
        return 1;
    }
}
