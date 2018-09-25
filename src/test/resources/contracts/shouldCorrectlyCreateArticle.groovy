package contracts

import org.springframework.cloud.contract.spec.Contract

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