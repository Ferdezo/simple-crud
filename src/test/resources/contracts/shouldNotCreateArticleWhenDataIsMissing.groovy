package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should not create article when data is missing"

    request {
        method POST()
        url("/article")
        headers {
            contentType(applicationJson())
        }
        body([])
    }

    response {
        status 400
    }
}