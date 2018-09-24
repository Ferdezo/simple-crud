package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return article with requested title"

    request {
        method GET()
        url("/article?title=Nowy selekcjoner")
    }

    response {
        status 200
        body(["title": "Nowy selekcjoner"])
        headers {
            contentType(applicationJson())
        }
    }
}