package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return article with given id"

    request {
        method GET()
        url("/article/1")
    }

    response {
        status 200
        body(["id": 1])
        headers {
            contentType(applicationJson())
        }
    }
}