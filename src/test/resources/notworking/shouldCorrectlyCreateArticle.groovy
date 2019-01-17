package notworking

import org.springframework.cloud.contract.spec.Contract

/*
 FIXME: Not working :(
.BindException: org.springframework.validation.BeanPropertyBindingResult: 2 errors
Field error in object 'articleWrite' on field 'content': rejected value [null]; codes [NotNull.articleWrite.content,NotNull.content,NotNull.java.lang.String,NotNull]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [articleWrite.content,content]; arguments []; default message [content]]; default message [must not be null]
Field error in object 'articleWrite' on field 'title': rejected value [null]; codes [NotNull.articleWrite.title,NotNull.title,NotNull.java.lang.String,NotNull]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [articleWrite.title,title]; arguments []; default message [title]]; default message [must not be null]]

org.junit.ComparisonFailure:
Expected :200
Actual   :400

 */

Contract.make {
    description "should correctly create article"

    request {
        method POST()
        url("/article")
        headers {
            contentType(applicationJson())
        }
        body(file("articleToCreate.json"))
    }

    response {
        status 200
    }
}